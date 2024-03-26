USE `PA_TP` ;

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
CREATE PROCEDURE get_book_by_id(IN a_author_id BIGINT, IN a_id BIGINT) 
BEGIN
	SELECT id, title, subtitle, pages, words, isbn, edition, submission_date, approval_date, literary_style_id, publication_type, author_id
	FROM books
    WHERE author_id = a_author_id AND id = a_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_by_submission_date` ;
DELIMITER $$
CREATE PROCEDURE get_books_by_submission_date(IN a_author_id BIGINT, IN a_submission_date DATE) 
BEGIN
	SELECT books.id, books.title as "title", books.subtitle as "subtitle", books.pages as "pages", books.words as "words", books.isbn as "isbn", books.edition as "edition", books.submission_date as "submission_date", books.approval_date as "approval_date", books.literary_style_id as "literary_style_id", books.publication_type as "publication_type", books.author_id  as "author_id"
	FROM books
    INNER JOIN authors
    ON authors.id = books.author_id
    WHERE authors.id = a_author_id and books.submission_date = a_submission_date;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_by_submission_date` ;
DELIMITER $$
CREATE PROCEDURE get_books_by_submission_date(IN a_author_id BIGINT, IN a_submission_date DATE) 
BEGIN
	SELECT books.id, books.title as "title", books.subtitle as "subtitle", books.pages as "pages", books.words as "words", books.isbn as "isbn", books.edition as "edition", books.submission_date as "submission_date", books.approval_date as "approval_date", books.literary_style_id as "literary_style_id", books.publication_type as "publication_type", books.author_id  as "author_id"
	FROM books
    INNER JOIN authors
    ON authors.user_id = books.author_id
    WHERE authors.user_id = a_author_id and books.submission_date = a_submission_date;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS `PA_TP`.`get_books_by_isbn` ;
DELIMITER $$
CREATE PROCEDURE get_books_by_isbn(IN a_author_id BIGINT, IN a_isbn VARCHAR(13)) 
BEGIN
	SELECT books.id, books.title as "title", books.subtitle as "subtitle", books.pages as "pages", books.words as "words", books.isbn as "isbn", books.edition as "edition", books.submission_date as "submission_date", books.approval_date as "approval_date", books.literary_style_id as "literary_style_id", books.publication_type as "publication_type", books.author_id  as "author_id"
	FROM books
    INNER JOIN authors
    ON authors.user_id = books.author_id
    WHERE authors.user_id = a_author_id and books.isbn like CONCAT ('%', a_isbn, '%');
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

DROP PROCEDURE IF EXISTS `PA_TP`.`get_logs_paginated`;
DELIMITER $$
CREATE PROCEDURE get_logs_paginated(IN page INT)
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

DROP PROCEDURE IF EXISTS `PA_TP`.`get_logs_by_user`;
DELIMITER $$
CREATE PROCEDURE get_logs_by_user(IN a_user_id BIGINT)
BEGIN
    SELECT *
    FROM logs 
    WHERE user_id = a_user_id;
END$$
DELIMITER ;