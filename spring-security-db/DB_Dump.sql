
    
CREATE TABLE sys.`record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ;



INSERT INTO sys.`record` ( `name`, `description`)
VALUES
	('name1','description1'),
	('name2','description2');
    
    select * from sys.record;

create table if not exists SYS.USER
(
ID INT NOT NULL AUTO_INCREMENT,
USER_NAME varchar(50), 
PASSWORD varchar(50),
PRIMARY KEY ( ID )
) ;

select * from sys.user;
select * from sys.role;
select * from sys.user_role;

INSERT INTO SYS.USER (USER_NAME, PASSWORD) VALUES ("mmsr","mmsr");


CREATE TABLE sys.`role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ;
INSERT INTO sys.`role` (`role_id`, `role`)
VALUES
	(1,'ADMIN');
    
    CREATE TABLE sys.`user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ;

INSERT INTO sys.`user` (`user_id`, `active`, `email`, `last_name`, `name`, `password`)
VALUES
	(1,1,'admin@gmail.com','s','Sam','sam'),
	(2,1,'admin@gmail.com','s','youtube','youtube');
    
    CREATE TABLE sys.`user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  UNIQUE KEY `UK_userrole` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ;

INSERT INTO sys.`user_role` (`user_id`, `role_id`)
VALUES
	(1,1);
    
    
