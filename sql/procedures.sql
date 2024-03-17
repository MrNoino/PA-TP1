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

DROP PROCEDURE IF EXISTS `PA_TP`.`login` ;
DELIMITER $$
CREATE PROCEDURE login(IN a_username VARCHAR(128), IN a_password VARCHAR(256)) 
BEGIN
    SELECT id, name, username, password, email, active, deleted, role_id
	FROM users
	WHERE username = a_username and password = MD5(a_password) and active = 1 and deleted = 0;
END $$
DELIMITER ;

### INSERTS

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_user` ;
DELIMITER $$
CREATE PROCEDURE insert_user(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_active TINYINT, IN a_role_id INT)
BEGIN
	INSERT INTO users (name, username, password, email, active, role_id)
    VALUES
    (a_name, a_username, MD5(a_password), a_email, a_active, a_role_id);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_manager` ;
DELIMITER $$
CREATE PROCEDURE insert_manager(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT)
BEGIN
    CALL insert_user(a_name, a_username, a_password, a_email, 1, a_role_id);
    
    INSERT INTO managers (user_id)
    VALUES
    (LAST_INSERT_ID());
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_reviewer` ;
DELIMITER $$
CREATE PROCEDURE insert_reviewer(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN a_graduation VARCHAR(128), IN  a_specialization VARCHAR(128))
BEGIN
    CALL insert_user(a_name, a_username, a_password, a_email, 0, a_role_id);
    
    INSERT INTO reviewers (user_id, nif, phone, address, graduation, specialization)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_graduation, a_specialization);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_author` ;
DELIMITER $$
CREATE PROCEDURE insert_author(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN  a_literary_style_id INT)
BEGIN
	CALL insert_user(a_name, a_username, a_password, a_email, 0, a_role_id);
    
    INSERT INTO authors (user_id, nif, phone, address, literary_style_id)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_literary_style_id);
END $$
DELIMITER ;

### UPDATES

DROP PROCEDURE IF EXISTS `PA_TP`.`update_user` ;
DELIMITER $$
CREATE PROCEDURE update_user(IN a_id BIGINT, IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT)
BEGIN
	UPDATE users 
    SET 
    name = a_name,
    username = a_username,
    password = a_password, 
    email = a_email,
    active = a_active,
    role_id = a_role_id
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`update_reviewer` ;
DELIMITER $$
CREATE PROCEDURE update_reviewer(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_active TINYINT, IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN a_graduation VARCHAR(128), IN  a_specialization VARCHAR(128))
BEGIN
    CALL update_user(a_name, a_username, a_password, a_email, a_active, a_role_id);
    
    INSERT INTO reviewers (user_id, nif, phone, address, graduation, specialization)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_graduation, a_specialization);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`update_author` ;
DELIMITER $$
CREATE PROCEDURE update_author(IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_active TINYINT, IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN  a_literary_style_id INT)
BEGIN
    CALL update_user(a_name, a_username, a_password, a_email, a_active, a_role_id);
    
    INSERT INTO authors (user_id, nif, phone, address, literary_style_id)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_literary_style_id);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`change_deleted_user` ;
DELIMITER $$
CREATE PROCEDURE change_deleted_user(IN a_id BIGINT, IN a_deleted TINYINT)
BEGIN
    UPDATE users
    SET 
    deleted = a_deleted
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`change_active_user` ;
DELIMITER $$
CREATE PROCEDURE change_active_user(IN a_id BIGINT, IN a_active TINYINT)
BEGIN
    UPDATE users
    SET 
    active = a_active
    WHERE id = a_id;
END $$
DELIMITER ;
