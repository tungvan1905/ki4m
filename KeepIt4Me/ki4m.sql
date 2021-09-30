DROP DATABASE IF EXISTS ideal;
CREATE DATABASE ideal;
USE ideal;

DROP TABLE IF EXISTS account;
CREATE TABLE IF NOT EXISTS account ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	username	 	CHAR(50) NOT NULL UNIQUE KEY CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	email			CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
    fullName		NVARCHAR(50) NOT NULL,
    `role`			ENUM('Admin','User') NOT NULL DEFAULT 'User',
    `status`		TINYINT DEFAULT 0, -- 0: Not Active, 1: Active
    create_date		DATETIME DEFAULT NOW()
);

-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	account_id		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL,
    FOREIGN KEY (`account_id`) REFERENCES account(id)
);
-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	account_id 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL,
    FOREIGN KEY (`account_id`) REFERENCES account(id)
);
-- Create table Target
DROP TABLE IF EXISTS target;
CREATE TABLE target( 
	
	id						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name_target				VARCHAR(100) NOT NULL UNIQUE KEY,
    completion_rate			VARCHAR(100) NOT NULL UNIQUE KEY,
    image					VARCHAR(200) ,
    target_date_completed	DATE,
    account_id				SMALLINT UNSIGNED NOT NULL,
    Create_date				DATETIME DEFAULT NOW(),
    FOREIGN KEY (account_id) REFERENCES account(id)
);
-- Create table small_leg
DROP TABLE IF EXISTS small_leg;
CREATE TABLE small_leg( 
	id						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    small_leg				VARCHAR(100) NOT NULL UNIQUE KEY,
    start_day				DATETIME DEFAULT NOW(),
    target_id				TINYINT UNSIGNED NOT NULL,
    finish_day				DATETIME NOT NULL,
    FOREIGN KEY (target_id) REFERENCES target(id)
);
-- Add data Account
INSERT INTO account (username, email, `password`, fullName, `role`, `status`)
VALUE ('admin123', 'admin@gmail.com', 'Admin123', 'Nguyễn Văn A', 'Admin', '1');

                   

                    

