USE `PA_TP` ;

SET AUTOCOMMIT=0;

INSERT INTO roles (role)
VALUES
('Gestor'),
('Revisor'),
('Autor');

INSERT INTO literarystyles (literary_style)
VALUES
('Drama'),
('Acção'),
('Ficção Científica'),
('Romance'),
('Comédia'),
('Artigo Científico');

/*CALL insert_manager('Nuno Lopes', 'nuno', 'pass', 'nuno@gmail.com', 1);

CALL insert_reviewer('Afonso Fonseca', 'afonso', 'pass', 'afonso@gmail.com', 2, '123456789', '912345678', 'OHP', 'Doutoramento em Português', 'Literatura');

CALL insert_author('Joana Marques', 'joana', 'pass', 'joana@gmail.com', 3, '987654321', '918765432', 'Seia', 4);*/

COMMIT;

SET AUTOCOMMIT=1;