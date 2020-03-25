DROP DATABASE IF EXISTS sms;
CREATE DATABASE sms;
USE sms;


#管理员表
CREATE TABLE admin(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL,
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;



INSERT INTO admin(num,name,birthday,idcard,sex,password,tel,qq,email,address)
VALUES 
('200301','管理员1','1978-01-01 00:00:00','123456197801010001','男','admin1','13987698765','1010102','1010102@qq.com','青岛市黄岛区前湾港路579号'),
('200302','管理员2','1979-02-01 00:00:00','123456197902010001','男','admin2','13987698766','1010103','1010103@qq.com','青岛市黄岛区前湾港路579号');



#学生表
CREATE TABLE student(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(18) NOT NULL,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL,
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO student(num,name,birthday,idcard,sex,password,tel,qq,email,address)
VALUES
('10001','王亿','1997-01-01 00:00:00','123456199701011234','男','admin','17805412345','10001','wangyi@qq.com','山东科技大学'),
('201516020302','王儿','1997-02-02 00:00:00','123456199702021234','男','wanger','17905412345','10002','wanger@qq.com','山东科技大学'),
('201516020303','王三','1997-03-03 00:00:00','123456199703031234','男','wangsan','13905412345','10003','wangsan@qq.com','山东科技大学'),
('201516020304','王思','1997-04-04 00:00:00','123456199704041234','男','wangsi','13805412345','10004','wangsi@qq.com','山东科技大学'),
('201516020305','王武','1997-05-05 00:00:00','123456199705051234','男','wangwu','15905412345','10005','wangwu@qq.com','山东科技大学');



#课程表
CREATE TABLE course(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL,
	day INT(12) NOT NULL,
	coursetime INT(12) NOT NULL,
	start INT(12) NOT NULL,
	last INT(12) NOT NULL,
	credit INT(12) NOT NULL,
	place VARCHAR(50) NOT NULL,
	name VARCHAR(18) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


INSERT INTO course(num,day,coursetime,start,last,credit,place,name)
VALUES
('1602001','1','2','1','14','3','J5-302','计算机操作系统'),
('1602002','2','3','5','16','3','J5-208','软件构造');





#学生-课程表
CREATE TABLE stucou_item(
student_id INT,
course_id INT,
PRIMARY KEY(student_id,course_id),
FOREIGN KEY (student_id) REFERENCES student(id),
FOREIGN KEY (course_id) REFERENCES course(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO stucou_item(student_id,course_id)
VALUES
('1','1'),
('1','2');


#成绩数据表
CREATE TABLE score(
	id INT(12) NOT NULL AUTO_INCREMENT,
	score INT(5) NOT NULL,
	course_id INT(12) NOT NULL,
	student_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_SCORE_COURSE(course_id),
	KEY FK_SCORE_STUDENT(student_id),
	CONSTRAINT FK_SCORE_COURSE FOREIGN KEY (course_id) REFERENCES course(id),
	CONSTRAINT FK_SCORE_STUDENT FOREIGN KEY (student_id) REFERENCES student(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO score(score,course_id,student_id)
VALUES
('98','1','1'),
('90','2','1');

