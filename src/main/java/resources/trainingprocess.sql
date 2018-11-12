Schema Name- trainingprocess

CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) DEFAULT NULL,
  `role` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `trainee` (
  `employee_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `project` varchar(45) DEFAULT NULL,
  `training_id` int(11) DEFAULT NULL,
  KEY `training_id` (`training_id`),
  CONSTRAINT `trainee_ibfk_1` FOREIGN KEY (`training_id`) REFERENCES `training` (`training_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE `trainer` (
  `trainer_id` int(11) NOT NULL AUTO_INCREMENT,
  `trainer_name` varchar(50) DEFAULT NULL,
  `training_subject` varchar(50) DEFAULT NULL,
  `toc` longblob,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `state` varchar(25) DEFAULT NULL,
  `pincode` int(10) DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `trainercol` varchar(45) DEFAULT NULL,
  `profile` longblob,
  `toc_filename` varchar(45) DEFAULT NULL,
  `profile_filename` varchar(45) DEFAULT NULL,
  `created_by` varchar(45) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `modified_by` varchar(45) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  PRIMARY KEY (`trainer_id`),
  KEY `vendor_id` (`vendor_id`),
  CONSTRAINT `trainer_ibfk_1` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8


CREATE TABLE `training` (
  `training_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `topic` varchar(50) DEFAULT NULL,
  `nop` int(100) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(50) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(50) DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `training_start_date` varchar(20) DEFAULT NULL,
  `training_end_date` varchar(20) DEFAULT NULL,
  `tentative_start_date` varchar(20) DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `training_status_id` int(11) DEFAULT NULL,
  `training_toc` longblob,
  `training_toc_filename` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`training_id`),
  KEY `category_id` (`category_id`),
  KEY `vendor_id` (`vendor_id`),
  KEY `trainer_id` (`trainer_id`),
  KEY `training_status_id` (`training_status_id`),
  CONSTRAINT `training_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `training_category` (`category_id`),
  CONSTRAINT `training_ibfk_2` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`),
  CONSTRAINT `training_ibfk_3` FOREIGN KEY (`trainer_id`) REFERENCES `trainer` (`trainer_id`),
  CONSTRAINT `training_ibfk_4` FOREIGN KEY (`training_status_id`) REFERENCES `training_status` (`training_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8


CREATE TABLE `training_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8


CREATE TABLE `training_status` (
  `training_status_id` int(15) NOT NULL AUTO_INCREMENT,
  `training_status` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`training_status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8


CREATE TABLE `vendor` (
  `vendor_id` int(11) NOT NULL AUTO_INCREMENT,
  `vendor_name` varchar(50) DEFAULT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(25) DEFAULT NULL,
  `state` varchar(15) DEFAULT NULL,
  `pincode` int(10) DEFAULT NULL,
  `phone1` varchar(15) DEFAULT NULL,
  `phone2` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `altemail` varchar(45) DEFAULT NULL,
  `name1` varchar(45) DEFAULT NULL,
  `email1` varchar(45) DEFAULT NULL,
  `mobile1` varchar(15) DEFAULT NULL,
  `name2` varchar(45) DEFAULT NULL,
  `email2` varchar(45) DEFAULT NULL,
  `mobile2` varchar(15) DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` varchar(25) DEFAULT NULL,
  `modified_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `modified_by` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`),
  UNIQUE KEY `vendor_name_UNIQUE` (`vendor_name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8