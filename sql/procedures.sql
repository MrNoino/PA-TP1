DROP PROCEDURE IF EXISTS `PA_TP`.`insert_manager` ;
DELIMITER $$
CREATE PROCEDURE insert_manager(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT)
BEGIN
	INSERT INTO users (name, username, password, email, active, role_id)
    VALUES
    (a_name, a_username, a_password, a_email, 1, a_role_id);
    INSERT INTO managers (user_id)
    VALUES
    (LAST_INSERT_ID());
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_reviewer` ;
DELIMITER $$
CREATE PROCEDURE insert_reviewer(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN a_graduation VARCHAR(128), IN  a_specialization VARCHAR(128))
BEGIN
	INSERT INTO users (name, username, password, email, role_id)
    VALUES
    (a_name, a_username, a_password, a_email, a_role_id);
    INSERT INTO reviewers (user_id, nif, phone, address, graduation, specialization)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_graduation, a_specialization);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_author` ;
DELIMITER $$
CREATE PROCEDURE insert_author(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN  a_literary_style_id INT)
BEGIN
	INSERT INTO users (name, username, password, email, role_id)
    VALUES
    (a_name, a_username, a_password, a_email, a_role_id);
    INSERT INTO authors (user_id, nif, phone, address, literary_style_id)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_literary_style_id);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`verify_email` ;
DELIMITER $$
CREATE PROCEDURE verify_email(IN a_email VARCHAR(256)) 
BEGIN
    SELECT COUNT(email)
			FROM users
            WHERE email = a_email;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`verify_username` ;
DELIMITER $$
CREATE PROCEDURE verify_username(IN a_username VARCHAR(128)) 
BEGIN
    SELECT COUNT(username)
			FROM users
            WHERE username = a_username;
END $$
DELIMITER ;