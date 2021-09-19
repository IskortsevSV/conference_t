create DATABASE conference;
use conference;

CREATE TABLE IF NOT EXISTS users
(
 id int AUTO_INCREMENT,
 username VARCHAR(15),
 password VARCHAR(150),
 authority VARCHAR(15),
 PRIMARY KEY (id)
);

INSERT INTO users (username,password,enabled)
VALUES('mike','mike','admin'),('john','john','speaker'),('liza','liza','listner');

INSERT INTO users (username,password,enabled)
VALUES('gleb','gleb','speaker'),('dima','dima','listner');

CREATE TABLE IF NOT EXISTS talks
(
 id int AUTO_INCREMENT PRIMARY KEY,
 report VARCHAR(20) not null,
 speaker int,
 FOREIGN KEY (speaker) REFERENCES users (id)
);

INSERT INTO talks (report,speaker) 
VALUES('JAVA Core',2),('OOP',4);

drop TABLE schedules;
CREATE TABLE IF NOT EXISTS schedules
(
 id int AUTO_INCREMENT PRIMARY KEY,
 audience int not null,
 date_time_start DATETIME not null,
 report int not null,
 FOREIGN KEY (report) REFERENCES talks (id),
 FOREIGN KEY (audience) REFERENCES rooms (id)
);

INSERT INTO schedules (audience,date_time_start,report)
VALUES (1,'2021-09-15 13:00',1);


INSERT INTO schedules (audience,date_time_start,report)
VALUES (2,'2021-09-15 14:00',2);



CREATE TABLE IF NOT EXISTS rooms
(
 id int AUTO_INCREMENT PRIMARY KEY,
 audience VARCHAR(20) not null
);

INSERT INTO rooms (audience) VALUES ('134'),('109'),('205');

SELECT sch.id,t.report,date_time_start,r.audience, u.username
FROM conference.schedules sch
    JOIN rooms r ON (sch.audience=r.id)
    JOIN talks t ON (sch.report = t.id)
    JOIN users u ON (t.speaker=u.id)
    ORDER BY date_time_start;

SELECT t.id,t.report,u.userName FROM talks t LEFT JOIN  users u ON (t.speaker=u.id);

CREATE TABLE authorities (
                             id int auto_increment,
                             username varchar(15),
                             authority varchar(25),
                             FOREIGN KEY (id) references users(id)
);

ALTER TABLE authorities AUTO_INCREMENT = 5;
ALTER TABLE users AUTO_INCREMENT = 5;