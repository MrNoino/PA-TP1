### SELECTS

DROP PROCEDURE IF EXISTS `PA_TP`.`get_user_by_email` ;
DELIMITER $$
CREATE PROCEDURE get_user_by_email(IN a_email VARCHAR(256)) 
BEGIN
    SELECT users.id as "id"
	FROM users
    INNER JOIN managers
    ON managers.user_id = users.id
    WHERE users.id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_manager` ;
DELIMITER $$
CREATE PROCEDURE get_manager(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
			users.name as "name", 
            users.username as "username", 
            users.active as "active", 
            users.deleted as "deleted", 
            users.role_id as "roleId"
	FROM users
    INNER JOIN managers
    ON managers.user_id = users.id
    WHERE users.id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_reviewer` ;
DELIMITER $$
CREATE PROCEDURE get_reviewer(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
			users.name "name", 
            users.username as "username", 
            users.active as "active", 
            users.deleted as "deleted", 
            users.role_id as "roleId", 
            reviewers.nif as "nif", 
            reviewers.phone as "phone", 
            reviewers.address as "address", 
            reviewers.graduation as "graduation", 
            reviewers.specialization as "specialization"
	FROM users
    INNER JOIN reviewers
    ON reviewers.user_id = users.id
    WHERE users.id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_author` ;
DELIMITER $$
CREATE PROCEDURE get_author(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
		users.name as "name", 
        users.username as "username", 
        users.active as "active", 
        users.deleted as "deleted", 
        users.role_id as "roleId", 
        authors.nif as "nif", 
        authors.phone as "phone", 
        authors.address as "address", 
        authors.activity_begin_date as "activityBeginDate", 
        authors.literary_style_id as "literaryStyleId"
	FROM users
    INNER JOIN authors
    ON authors.user_id = users.id
    WHERE users.id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`exists_email` ;
DELIMITER $$
CREATE PROCEDURE exists_email(IN a_email VARCHAR(256)) 
BEGIN
    SELECT COUNT(email) as "exists"
	FROM users
	WHERE email = a_email;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`exists_username` ;
DELIMITER $$
CREATE PROCEDURE exists_username(IN a_username VARCHAR(128)) 
BEGIN
    SELECT COUNT(username) as "exists"
	FROM users
	WHERE username = a_username;
END $$
DELIMITER ;

### INSERTS

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

### UPDATES
