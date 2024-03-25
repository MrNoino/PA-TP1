package tp1.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tp1.controller.ManageAuthors;
import tp1.controller.ManageBooks;
import tp1.controller.ManageLiteracyStyles;
import tp1.controller.ManageUsers;
import tp1.model.Author;
import tp1.model.Book;
import tp1.model.LiteraryStyle;

public class AuthorViews {

    public void showMenu() {

        int option;

        do {
            option = InputReader.readInt("**** MENU DE AUTOR ****\n"
                    + "1. Obras\n"
                    + "2. Pedidos de Revisão\n"
                    + "3. Atualizar Perfil\n"
                    + "0. Terminar Sessão\n\n"
                    + "Escolha: ", 0, 3);
            System.out.println();

            switch (option) {
                case 1:
                    showBooksMenu();
                    break;
                case 2:
                    showReviewRequestsMenu();
                    break;
                case 3:
                    showUpdateProfileMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);

        Main.logout();
    }

    private void showBooksMenu() {
        int option;

        do {
            option = InputReader.readInt("**** OBRAS ****\n"
                    + "1. Listar Obras\n"
                    + "2. Inserir Obra\n"
                    + "3. Atualizar Obra\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 3);
            System.out.println();
            ManageBooks manageBooks = new ManageBooks();
            String title, subtitle, isbn, edition, msg, publicationType;
            int pages, words, literaryStyleId;
            ManageLiteracyStyles manageLiteracyStyles = new ManageLiteracyStyles();
            ArrayList<LiteraryStyle> literaryStyles;
            switch (option) {
                case 1:
                    showListBooksMenu();
                    break;
                case 2:
                    
                    title = InputReader.readString("Título: ");
                    if (manageBooks.existsTitle(title)) {
                        continue;
                    }

                    subtitle = InputReader.readString("Subtítulo: ");

                    pages = InputReader.readInt("Número de páginas: ");
                    words = InputReader.readInt("Número de palavras: ");

                    isbn = InputReader.readString("ISBN: ");
                    if (manageBooks.existsIsbn(isbn)) {
                        continue;
                    }

                    edition = InputReader.readString("Edição: ");

                    literaryStyles = manageLiteracyStyles.getLiteracyStyles();
                    if (literaryStyles == null) {
                        System.out.println("\nEstilos literários inixestentes\n");
                        return;
                    }
                    msg = "Estilos Literários\n";
                    for (int i = 0; i < literaryStyles.size(); i++) {
                        msg += (i + 1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
                    }
                    msg += "Escolha: ";

                    literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();
                    publicationType = InputReader.readString("Tipo de publicação: ");

                    if (manageBooks.insertBook(new Book(-1,
                            title,
                            subtitle,
                            pages,
                            words,
                            isbn,
                            edition,
                            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                            literaryStyleId,
                            publicationType,
                            Main.getLoggedUser().getId()))) {
                        System.out.println("\nInserido com sucesso\n");
                    } else {
                        System.out.println("\nNão inserido\n");
                    }
                    break;
                case 3:
                    long id = InputReader.readLong("ID da obra: ");
                    Book book = manageBooks.getBookById(Main.getLoggedUser().getId(), id);
                    title = InputReader.readString("Título: ");
                    if (!book.getTitle().equals(title) && manageBooks.existsTitle(title)) {
                        continue;
                    }

                    subtitle = InputReader.readString("Subtítulo: ");

                    pages = InputReader.readInt("Número de páginas: ");
                    words = InputReader.readInt("Número de palavras: ");

                    isbn = InputReader.readString("ISBN: ");
                    if (!book.getIsbn().equals(isbn) && manageBooks.existsIsbn(isbn)) {
                        continue;
                    }

                    edition = InputReader.readString("Edição: ");

                    literaryStyles = manageLiteracyStyles.getLiteracyStyles();
                    if (literaryStyles == null) {
                        System.out.println("\nEstilos literários inixestentes\n");
                        return;
                    }
                    msg = "Estilos Literários\n";
                    for (int i = 0; i < literaryStyles.size(); i++) {
                        msg += (i + 1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
                    }
                    msg += "Escolha: ";

                    literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();
                    publicationType = InputReader.readString("Tipo de publicação: ");

                    if (manageBooks.updateBook(new Book(id,
                            title,
                            subtitle,
                            pages,
                            words,
                            isbn,
                            edition,
                            new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                            literaryStyleId,
                            publicationType,
                            Main.getLoggedUser().getId()))) {
                        System.out.println("\nAtualizado com sucesso\n");
                    } else {
                        System.out.println("\nNão atualizado\n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
            }

        } while (option != 0);
    }

    private void showListBooksMenu() {
        int option;

        do {
            option = InputReader.readInt("**** OBRAS ****\n"
                    + "1. Listar Por Data De Submissão (Recente)\n"
                    + "2. Listar Por Data De Submissão (Antigo)\n"
                    + "3. Listar Por Título (Ascendente)\n"
                    + "4. Listar Por Título (Descendente)\n"
                    + "5. Pesquisar Por Data De Submissão\n"
                    + "6. Pesquisar Por ISBN\n"
                    + "0. Voltar\n\n"
                    + "Escolha:  ", 0, 6);
            System.out.println();

            ManageBooks manageBooks = new ManageBooks();
            ArrayList<Book> books = null;
            switch (option) {
                case 1:
                    books = manageBooks.getBooks(Main.getLoggedUser().getId(), "submission_date", "DESC", 1);
                    break;
                case 2:
                    books = manageBooks.getBooks(Main.getLoggedUser().getId(), "submission_date", "ASC", 1);
                    break;
                case 3:
                    books = manageBooks.getBooks(Main.getLoggedUser().getId(), "title", "ASC", 1);
                    break;
                case 4:
                    books = manageBooks.getBooks(Main.getLoggedUser().getId(), "title", "DESC", 1);
                    break;
                case 5:
                    String date = InputReader.readString("Data de submisssão a pesquisar: ");
                    date = date.replace("\\", "-");
                
                    try {
                        new SimpleDateFormat("dd-mm-yyyy").parse(date);
                    } catch (ParseException e) {
                        System.out.println("\nData inválida\n");
                        continue;
                    }
                    books = manageBooks.getBooksBySubmissionDate(Main.getLoggedUser().getId(), date);
                    break;

                case 6:
                    books = manageBooks.getBooksByIsbn(Main.getLoggedUser().getId(), InputReader.readString("ISBN a pesquisar: "));
                    break;
                case 0:
                    continue;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
            }

            if(books.size() == 0){
                System.out.println("\nNenhuma obra encontrada\n");
                continue;
            }
            
            System.out.println("| ID | Título | Subtítulo | Nº Páginas | Nº Palavras | ISBN | Edição | Data de Submissão |"
                    + " Data de aprovação | Id estilo literário | Tipo de publicação | Id author |");
            for (Book book : books) {
                System.out.println("| " + book.getId() + " | "
                        + book.getTitle() + " | "
                        + book.getSubtitle() + " | "
                        + book.getPages() + " | "
                        + book.getWords() + " | "
                        + book.getIsbn() + " | "
                        + book.getEdition() + " | "
                        + book.getSubmissionDate() + " | "
                        + book.getApprovalDate() + " | "
                        + book.getLiteracyStyleId() + " | "
                        + book.getPublicationType() + " | "
                        + book.getAuthorId() + " | ");
            }
            System.out.println();
        } while (option != 0);
    }

    private void showReviewRequestsMenu() {
        int option;

        do {
            option = InputReader.readInt("**** PEDIDOS DE REVISÃO ****\n"
                    + "1. Listar Pedidos de Revisão\n"
                    + "2. Solicitar uma Revisão\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();

            switch (option) {
                case 1:
                    showReviewRequestsListMenu();
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
            }
        } while (option != 0);
    }

    private void showReviewRequestsListMenu() {
        int option;

        do {
            option = InputReader.readInt("**** LISTAR PEDIDOS DE REVISÃO ****\n"
                    + "1. Listar Por Data De Criação (Recente)\n"
                    + "2. Listar Por Data De Criação (Antigo)\n"
                    + "3. Listar Por Número De Série (Ascendente)\n"
                    + "4. Listar Por Número De Série (Descendente)\n"
                    + "5. Pesquisar Por Data De Criação\n"
                    + "6. Pesquisar Por Título\n"
                    + "7. Pesquisar Por Estado\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 7);
            System.out.println();

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
            }
        } while (option != 0);
    }

    private void showUpdateProfileMenu() {

        System.out.println("Atualizar Perfil\n");

        ManageAuthors manageAuthors = new ManageAuthors();
        Author author = manageAuthors.getAuthor(Main.getLoggedUser().getId());

        if (author == null) {
            System.out.println("Não foi possivel encontrar o revisor\n");
            return;
        }
        ManageUsers manageUsers = new ManageUsers();
        String name = InputReader.readString("Nome: "),
                username = InputReader.readString("Nome de utilizador: ");
        if (!author.getUsername().equals(username) && manageUsers.existsUsername(username)) {
            return;
        }
        String password = InputReader.readString("Palavra passe: "),
                email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
        if (!author.getEmail().equals(email) && manageUsers.existsEmail(email)) {
            return;
        }
        String nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
        if (!author.getNif().equals(nif) && manageUsers.existsNIF(nif)) {
            return;
        }
        String phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}"),
                address = InputReader.readString("Morada: ");

        ManageLiteracyStyles manageLiteracyStyles = new ManageLiteracyStyles();
        ArrayList<LiteraryStyle> literaryStyles = manageLiteracyStyles.getLiteracyStyles();
        if (literaryStyles == null) {
            System.out.println("\nEstilos literários inixestentes.\n");
            return;
        }
        String msg = "Estilos Literários\n";
        for (int i = 0; i < literaryStyles.size(); i++) {
            msg += (i + 1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
        }
        msg += "Escolha: ";

        int literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();
        if (manageAuthors.updateAuthor(new Author(Main.getLoggedUser().getId(),
                name,
                username,
                password,
                email,
                true,
                false,
                3,
                nif,
                phone,
                address,
                null,
                literaryStyleId))) {
            System.out.println("\nAtualizado com sucesso\n");
        } else {
            System.out.println("\nErro ao atualizar\n");
        }
    }
}
