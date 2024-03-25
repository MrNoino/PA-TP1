USE `PA_TP` ;

### SELECTS

DROP PROCEDURE IF EXISTS `PA_TP`.`get_user_by_id` ;
DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN a_id BIGINT) 
BEGIN
    SELECT id, name, username, email, active, deleted, role_id
	FROM users
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_manager_by_id` ;
DELIMITER $$
CREATE PROCEDURE get_manager_by_id(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
			users.name as "name", 
            users.username as "username", 
            users.email as "email",
            users.active as "active", 
            users.deleted as "deleted", 
            users.role_id as "role_id"
	FROM users
    INNER JOIN managers
    ON managers.user_id = users.id
    WHERE users.id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_reviewer_by_id` ;
DELIMITER $$
CREATE PROCEDURE get_reviewer_by_id(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
			users.name "name", 
            users.username as "username", 
            users.email as "email",
            users.active as "active", 
            users.deleted as "deleted", 
            users.role_id as "role_id", 
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

DROP PROCEDURE IF EXISTS `PA_TP`.`get_author_by_id` ;
DELIMITER $$
CREATE PROCEDURE get_author_by_id(IN a_id BIGINT) 
BEGIN
    SELECT users.id as "id", 
		users.name as "name", 
        users.username as "username", 
        users.email as "email",
        users.active as "active", 
        users.deleted as "deleted", 
        users.role_id as "role_id", 
        authors.nif as "nif", 
        authors.phone as "phone", 
        authors.address as "address", 
        authors.activity_begin_date as "activity_begin_date", 
        authors.literary_style_id as "literary_style_id"
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

DROP PROCEDURE IF EXISTS `PA_TP`.`exists_nif` ;
DELIMITER $$
CREATE PROCEDURE exists_nif(IN a_nif VARCHAR(9)) 
BEGIN
	SELECT
    (SELECT COUNT(authors.nif)
	FROM authors
	WHERE authors.nif = a_nif) 
    + 
    (SELECT COUNT(reviewers.nif)
	FROM reviewers
	WHERE reviewers.nif = a_nif) 
    as "exists";
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`is_user_active` ;
DELIMITER $$
CREATE PROCEDURE is_user_active(IN a_id BIGINT) 
BEGIN
    SELECT active
	FROM users
	WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`login` ;
DELIMITER $$
CREATE PROCEDURE login(IN a_username VARCHAR(128), IN a_password VARCHAR(256)) 
BEGIN
    SELECT id, name, username, password, email, active, deleted, role_id
	FROM users
	WHERE username = a_username and password = MD5(a_password) and deleted = 0;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_users_paginated` ;
DELIMITER $$
CREATE PROCEDURE get_users_paginated(IN sort_order VARCHAR(32), IN page INT) 
BEGIN
	DECLARE page_start INT;
	DECLARE page_end INT;
    SET page_start = (page-1)*10;
	SET page_end = page*10;
    
    IF sort_order = 'ASC' THEN
		SELECT id, name, username, password, email, active, deleted, role_id
		FROM users
        ORDER BY name ASC
		LIMIT page_start, page_end;
	ELSE
		SELECT id, name, username, password, email, active, deleted, role_id
		FROM users
        ORDER BY name DESC
		LIMIT page_start, page_end;
    END IF;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_users_by_name` ;
DELIMITER $$
CREATE PROCEDURE get_users_by_name(IN a_name VARCHAR(128)) 
BEGIN
	SELECT id, name, username, password, email, active, deleted, role_id
	FROM users
	WHERE name like CONCAT('%', a_name, '%');
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_users_by_username` ;
DELIMITER $$
CREATE PROCEDURE get_users_by_username(IN a_username VARCHAR(128)) 
BEGIN
	SELECT id, name, username, password, email, active, deleted, role_id
	FROM users
	WHERE username like CONCAT('%', a_username, '%');
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_users_by_role` ;
DELIMITER $$
CREATE PROCEDURE get_users_by_role(IN a_role VARCHAR(128)) 
BEGIN
	SELECT users.id as "id", users.name as "name", users.username as "username", users.password as "password", users.email as "email", users.active as "active", users.deleted as "deleted", users.role_id as "role_id", roles.role as "role"
	FROM users
    INNER JOIN roles
    ON roles.id = users.role_id
	WHERE roles.role like CONCAT('%', a_role, '%');
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_book_by_id` ;
DELIMITER $$
CREATE PROCEDURE get_book_by_id(IN a_id BIGINT) 
BEGIN
	SELECT id, title, subtitle, pages, words, isbn, edition, submission_date, approval_date, literary_style_id, publication_type, author_id
	FROM books
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_by_author` ;
DELIMITER $$
CREATE PROCEDURE get_books_by_author(IN a_author_id BIGINT) 
BEGIN
	SELECT books.id, books.title as "title", books.subtitle as "subtitle", books.pages as "pages", books.words as "words", books.isbn as "isbn", books.edition as "edition", books.submission_date as "submission_date", books.approval_date as "approval_date", books.literary_style_id as "literary_style_id", books.publication_type as "publication_type", books.author_id  as "author_id"
	FROM books
    INNER JOIN authors
    ON authors.id = books.author_id
    WHERE authors.id = a_author_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`exists_title` ;
DELIMITER $$
CREATE PROCEDURE exists_title(IN a_title VARCHAR(256)) 
BEGIN
	SELECT COUNT(title) as "exists"
    FROM books
    WHERE title = a_title;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`exists_isbn` ;
DELIMITER $$
CREATE PROCEDURE exists_isbn(IN a_isbn VARCHAR(13)) 
BEGIN
	SELECT COUNT(isbn) as "exists"
    FROM books
    WHERE isbn = a_isbn;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_ordered_submission_date_paginated` ;
DELIMITER $$
CREATE PROCEDURE get_books_ordered_submission_date_paginated(IN a_author_id BIGINT, IN sort_order VARCHAR(32), IN page INT) 
BEGIN
	DECLARE page_start INT;
	DECLARE page_end INT;
    SET page_start = (page-1)*10;
	SET page_end = page*10;
    
    IF sort_order = 'ASC' THEN
		SELECT books.id as "id", 
        books.title as "title", 
        books.subtitle as "subtitle", 
        books.pages as "pages", 
        books.words as "words", 
        books.isbn as "isbn", 
        books.edition as "edition",
        books.submission_date as "submission_date", 
        books.approval_date as "approval_date", 
        books.literary_style_id as "literary_style_id", 
        books.publication_type as "publication_type", 
        books.author_id as "author_id"
		FROM books
        INNER JOIN authors
        ON authors.user_id = books.author_id
        WHERE authors.user_id = a_author_id
        ORDER BY submission_date ASC
		LIMIT page_start, page_end;
	ELSE
		SELECT books.id as "id", 
        books.title as "title", 
        books.subtitle as "subtitle", 
        books.pages as "pages", 
        books.words as "words", 
        books.isbn as "isbn", 
        books.edition as "edition",
        books.submission_date as "submission_date", 
        books.approval_date as "approval_date", 
        books.literary_style_id as "literary_style_id", 
        books.publication_type as "publication_type", 
        books.author_id as "author_id"
		FROM books
        INNER JOIN authors
        ON authors.user_id = books.author_id
        WHERE authors.user_id = a_author_id
        ORDER BY submission_date DESC
		LIMIT page_start, page_end;
    END IF;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_ordered_title_paginated` ;
DELIMITER $$
CREATE PROCEDURE get_books_ordered_title_paginated(IN a_author_id BIGINT, IN sort_order VARCHAR(32), IN page INT) 
BEGIN
	DECLARE page_start INT;
	DECLARE page_end INT;
    SET page_start = (page-1)*10;
	SET page_end = page*10;
    
    IF sort_order = 'ASC' THEN
		SELECT books.id as "id", 
        books.title as "title", 
        books.subtitle as "subtitle", 
        books.pages as "pages", 
        books.words as "words", 
        books.isbn as "isbn", 
        books.edition as "edition",
        books.submission_date as "submission_date", 
        books.approval_date as "approval_date", 
        books.literary_style_id as "literary_style_id", 
        books.publication_type as "publication_type", 
        books.author_id as "author_id"
		FROM books
        INNER JOIN authors
        ON authors.user_id = books.author_id
        WHERE authors.user_id = a_author_id
        ORDER BY title ASC
		LIMIT page_start, page_end;
	ELSE
		SELECT books.id as "id", 
        books.title as "title", 
        books.subtitle as "subtitle", 
        books.pages as "pages", 
        books.words as "words", 
        books.isbn as "isbn", 
        books.edition as "edition",
        books.submission_date as "submission_date", 
        books.approval_date as "approval_date", 
        books.literary_style_id as "literary_style_id", 
        books.publication_type as "publication_type", 
        books.author_id as "author_id"
		FROM books
        INNER JOIN authors
        ON authors.user_id = books.author_id
        WHERE authors.user_id = a_author_id
        ORDER BY title DESC
		LIMIT page_start, page_end;
    END IF;
END $$
DELIMITER ;

### INSERTS

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_user` ;
DELIMITER $$
CREATE PROCEDURE insert_user(IN a_name VARCHAR(128), IN a_username VARCHAR(128), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_active TINYINT, IN a_role_id INT)
BEGIN
	INSERT INTO users (name, username, password, email, active, role_id)
    VALUES
    (a_name, a_username, MD5(a_password), a_email, a_active, a_role_id);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_manager` ;
DELIMITER $$
CREATE PROCEDURE insert_manager(IN a_name VARCHAR(128), IN a_username VARCHAR(128), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT)
BEGIN
    CALL insert_user(a_name, a_username, a_password, a_email, 1, a_role_id);
    
    INSERT INTO managers (user_id)
    VALUES
    (LAST_INSERT_ID());
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_reviewer` ;
DELIMITER $$
CREATE PROCEDURE insert_reviewer(IN a_name VARCHAR(128), IN a_username VARCHAR(128), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN a_graduation VARCHAR(128), IN  a_specialization VARCHAR(128))
BEGIN
    CALL insert_user(a_name, a_username, a_password, a_email, 0, a_role_id);
    
    INSERT INTO reviewers (user_id, nif, phone, address, graduation, specialization)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_graduation, a_specialization);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_author` ;
DELIMITER $$
CREATE PROCEDURE insert_author(IN a_name VARCHAR(128), IN a_username VARCHAR(128), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN  a_literary_style_id INT)
BEGIN
	CALL insert_user(a_name, a_username, a_password, a_email, 0, a_role_id);
    
    INSERT INTO authors (user_id, nif, phone, address, literary_style_id)
    VALUES
    (LAST_INSERT_ID(), a_nif, a_phone, a_address, a_literary_style_id);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`insert_book` ;
DELIMITER $$
CREATE PROCEDURE insert_book(IN a_title VARCHAR(256), IN a_subtitle VARCHAR(256), IN a_pages INT, IN a_words INT, IN a_isbn VARCHAR(13), IN a_edition VARCHAR(128), IN a_literary_style_id INT, IN a_publication_type VARCHAR(128), IN  a_author_id BIGINT)
BEGIN
	INSERT INTO books(title, subtitle , pages, words, isbn, edition, literary_style_id, publication_type,  author_id)
    VALUES
    (a_title, a_subtitle , a_pages, a_words, a_isbn, a_edition, a_literary_style_id, a_publication_type,  a_author_id);
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
    password = IFNULL(MD5(a_password), password), 
    email = a_email,
    role_id = a_role_id
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`update_reviewer` ;
DELIMITER $$
CREATE PROCEDURE update_reviewer(IN a_id BIGINT,  IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN a_graduation VARCHAR(128), IN  a_specialization VARCHAR(128))
BEGIN
    CALL update_user(a_id, a_name, a_username, a_password, a_email, a_role_id);
    
    UPDATE reviewers
    SET nif= a_nif,
    phone= a_phone,
    address= a_address,
    graduation= a_graduation,
    specialization= a_specialization
	WHERE user_id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`update_author` ;
DELIMITER $$
CREATE PROCEDURE update_author(IN a_id BIGINT, IN a_name VARCHAR(128), IN a_username VARCHAR(100), IN a_password VARCHAR(256), IN a_email VARCHAR(256), IN a_role_id INT, IN a_nif VARCHAR(9), IN a_phone VARCHAR(9), IN a_address VARCHAR(256), IN  a_literary_style_id INT)
BEGIN
    CALL update_user(a_id, a_name, a_username, a_password, a_email, a_role_id);
    
	UPDATE authors
    SET nif= a_nif,
    phone= a_phone,
    address= a_address,
    literary_style_id= a_literary_style_id
    WHERE user_id = a_id;
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

DROP PROCEDURE IF EXISTS `PA_TP`.`change_user_status` ;
DELIMITER $$
CREATE PROCEDURE change_user_status(IN a_id BIGINT, IN a_active TINYINT)
BEGIN
    UPDATE users
    SET 
    active = a_active
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`update_book` ;
DELIMITER $$
CREATE PROCEDURE update_book(IN a_id BIGINT, IN a_title VARCHAR(256), IN a_subtitle VARCHAR(256), IN a_pages INT, IN a_words INT, IN a_isbn VARCHAR(13), IN a_edition VARCHAR(128), IN a_literary_style_id INT, IN a_publication_type VARCHAR(128), IN  a_author_id BIGINT)
BEGIN
	UPDATE books
    SET 
    title= a_title,
    subtitle= a_subtitle,
    pages= a_pages,
    words= a_words,
    isbn= a_isbn,
    edition= a_edition,
    literary_style_id= a_literary_style_id,
    publication_type= a_publication_type,
    author_id= a_author_id
    WHERE id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_logs_paginated`;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_logs_paginated`(IN page INT)
BEGIN
	DECLARE page_start INT;
	DECLARE page_end INT;
    SET page_start = (page-1)*10;
	SET page_end = page*10;
    
    SELECT * 
    FROM logs
    LIMIT page_start, page_end;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_logs_by_user_paginated`;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_logs_by_user_paginated`(IN a_user_id BIGINT, IN page INT)
BEGIN
	DECLARE page_start INT;
	DECLARE page_end INT;
    SET page_start = (page-1)*10;
	SET page_end = page*10;
    
    SELECT *
    FROM logs 
    WHERE user_id = a_user_id
    LIMIT page_start, page_end;
END$$
DELIMITER ;
