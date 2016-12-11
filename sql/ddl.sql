create database NursNars default character set utf8;

CREATE USER 'mediaproject'@'localhost' IDENTIFIED BY 'mppw';
CREATE USER 'mediaproject'@'%' IDENTIFIED BY 'mppw';

GRANT ALL PRIVILEGES ON *.* TO 'mediaproject'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'mediaproject'@'%';


create table NursNars.member (
    memberid varchar(50) primary key,
    name varchar(50) not null,
    password varchar(10) not null,
    regdate datetime not null
) engine=InnoDB default character set = utf8;

create table NursNars.article (
    article_no int auto_increment primary key,
    writer_id varchar(50) not null,
    writer_name varchar(50) not null,
    title varchar(255) not null,
    regdate datetime not null,
    moddate datetime not null,
    read_cnt int
) engine=InnoDB default character set = utf8;

create table NursNars.article_content (
    article_no int primary key,
    content text
) engine=InnoDB default character set = utf8;

-----------------
//데이터베이스 생성
create database NursNars default character set utf8;

//계정 생성
CREATE USER 'mediaproject'@'localhost' IDENTIFIED BY 'mppw';
CREATE USER 'mediaproject'@'%' IDENTIFIED BY 'mppw';

GRANT ALL PRIVILEGES ON *.* TO 'mediaproject'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'mediaproject'@'%';

create table NursNars.member (
    m_id varchar(50) primary key,
    m_name varchar(50) not null,
    m_pic blob,
    m_email varchar(150) not null,
    m_ph_num varchar(100) not null,
    m_grade double    
) engine=InnoDB default character set = utf8;

//이미지 어떻게 설정할지

create table NursNars.viewInfo (
	viewer_id varchar(50),
	broadcast_id varchar(50),
	FOREIGN KEY ('viwer_id') REFERENCES 'member' ('m_id')
	FOREIGN KEY ('broadcast_id') REFERENCES 'member' ('')
) engine=InnoDB default character set = utf8;

//FK 참조값 재설정, VARCHAR 값 설정


crate table NursNars.comment (
	c_id varchar(50) primary key,
	writer varchar(50),
	subject varchar(150),
	content varchar(500)
) engine=InnoDB default character set = utf8;

//FK 참조값 재설정, VARCHAR 값 설정

create table NursNars.broadcase (
	b_id varchar(50) primary key,
	b_name varchar(50),
	b_pic blob,
	b_date varchar(50),
	b_broadcaster varchar(50),
	product_nm varchar(50),
	low_price varchar(100),
	ctg_num varchar(50)
) engine=InnoDB default character set = utf8;
//이미지 어떻게 설정할지

create table NursNars.category(
	ctg_id varchar(50),
	ctg_nm varchar(50)
) engine=InnoDB default character set = utf8;
----------------------------------------------------------------------

CREATE TABLE `member` (
	`m_id` VARCHAR(50) NOT NULL,
	`m_name` VARCHAR(50) NOT NULL,
	`m_pic` VARCHAR(100) NULL DEFAULT NULL,
	`m_email` VARCHAR(150) NOT NULL,
	`m_ph_num` VARCHAR(100) NOT NULL,
	`m_grade` DOUBLE NULL DEFAULT '0',
	`m_password` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`m_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `category` (
	`ctg_id` INT(11) NOT NULL,
	`ctg_nm` VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (`ctg_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `broadcast` (
	`b_id` int auto_increment,
	`b_name` VARCHAR(50) NULL DEFAULT NULL,
	`b_pic` VARCHAR(100) NULL DEFAULT NULL,
	`b_date` datetime NOT NULL,
	`b_broadcaster` VARCHAR(50) NULL DEFAULT NULL,
	`product_nm` VARCHAR(50) NULL DEFAULT NULL,
	`low_price` INT(11) NULL DEFAULT NULL,
	`ctg_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`b_id`),
	INDEX `b_broadcaster` (`b_broadcaster`),
	INDEX `ctg_id` (`ctg_id`),
	CONSTRAINT `broadcast_ibfk_1` FOREIGN KEY (`b_broadcaster`) REFERENCES `member` (`m_id`),
	CONSTRAINT `broadcast_ibfk_2` FOREIGN KEY (`ctg_id`) REFERENCES `category` (`ctg_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


CREATE TABLE `comment` (
	`c_id` INT(11) NOT NULL,
	`writer` VARCHAR(50) NULL DEFAULT NULL,
	`subject` VARCHAR(50) NULL DEFAULT NULL,
	`content` VARCHAR(500) NULL DEFAULT NULL,
	PRIMARY KEY (`c_id`),
	INDEX `writer` (`writer`),
	INDEX `subject` (`subject`),
	CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`writer`) REFERENCES `member` (`m_id`),
	CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`subject`) REFERENCES `member` (`m_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `viewinfo` (
	`viewer_id` VARCHAR(50) NULL DEFAULT NULL,
	`broadcast_id` INT(11) NULL DEFAULT NULL,
	INDEX `FK_viewinfo_member` (`viewer_id`),
	INDEX `FK_viewinfo_broadcast` (`broadcast_id`),
	CONSTRAINT `FK_viewinfo_broadcast` FOREIGN KEY (`broadcast_id`) REFERENCES `broadcast` (`b_id`),
	CONSTRAINT `FK_viewinfo_member` FOREIGN KEY (`viewer_id`) REFERENCES `member` (`m_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


insert into category values('1','패션의류');
insert into category values('2','잡화/명품');
insert into category values('3','화장품');
insert into category values('4','유아동/문화');
insert into category values('5','스포츠/여행');
insert into category values('6','식품/주방');
insert into category values('7','가구/생활');
insert into category values('8','가전/컴퓨터');
