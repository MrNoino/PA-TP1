package tp1.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import tp1.controller.ManageAuthors;
import tp1.controller.ManageLiteracyStyles;
import tp1.controller.ManageLogs;
import tp1.controller.ManageManagers;
import tp1.controller.ManageReviewers;
import tp1.controller.ManageUsers;
import tp1.model.Author;
import tp1.model.LiteraryStyle;
import tp1.model.Log;
import tp1.model.Manager;
import tp1.model.Reviewer;
import tp1.model.User;

public class ManagerViews {

    public void showMenu() {

        int option;
        do {
            option = InputReader.readInt("**** MENU DE GESTOR ****\n"
                    + "1. Utilizadores\n"
                    + "2. Pedidos De Revisão\n"
                    + "3. Licensas\n"
                    + "4. Auditioria\n"
                    + "5. Perfil\n"
                    + "0. Terminar Sessão\n\n"
                    + "Escolha: ", 0, 5);
            System.out.println();

            switch (option) {
                case 1:
                    showUsersMenu();
                    break;
                case 2:
                    showReviewRequestsMenu();
                    break;
                case 3:
                    showLicensesMenu();
                    break;
                case 4:
                    showAuditMenu();
                    break;
                case 5:
                    showProfileMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);

        Main.logout();
    }

    private void showUsersMenu() {

        int option;

        do {
            option = InputReader.readInt("**** UTILIZADORES ****\n"
                    + "1. Listar Utilizadores\n"
                    + "2. Inserir Utilizador\n"
                    + "3. Atualizar Utilizador\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 3);
            System.out.println();

            switch (option) {
                case 1:
                    showListUsersMenu();
                    break;
                case 2:
                    showInsertUserMenu();
                    break;
                case 3:
                    showUpdateUserMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);
    }

    private void showListUsersMenu() {
        int option;

        do {
            option = InputReader.readInt("**** LISTAR UTILIZADORES ****\n"
                    + "1. Listar Por Nome (Ascendente)\n"
                    + "2. Listar Por Nome (Descendente)\n"
                    + "3. Pesquisar Por Nome\n"
                    + "4. Pesquisar Por Nome De Utilizador\n"
                    + "5. Pesquisar Por Tipo\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 5);
            System.out.println();
            ManageUsers manageUsers = new ManageUsers();
            ArrayList<User> users;
            switch (option) {
                case 1:
                    users = manageUsers.getUsers("ASC", 1);

                    if (users == null) {
                        continue;
                    } else if (users.isEmpty()) {
                        System.out.println("\nNenhum utilizador encontrado\n");
                        continue;
                    }
                    System.out.println("| ID | Nome | Nome de Utilizador | Email | Ativo | Eliminado | ID de Cargo |");
                    for (User user : users) {
                        System.out.println("| " + user.getId() + " | "
                                + user.getName() + " | "
                                + user.getUsername() + " | "
                                + user.getEmail() + " | "
                                + (user.isActive() ? "Sim" : "Não") + " | "
                                + (user.isDeleted() ? "Sim" : "Não" + " | ")
                                + user.getRoleId() + " |");
                    }
                    System.out.println();
                    break;
                case 2:
                    users = manageUsers.getUsers("DESC", 1);

                    if (users == null) {
                        continue;
                    } else if (users.isEmpty()) {
                        System.out.println("\nNenhum utilizador encontrado\n");
                        continue;
                    }
                    System.out.println("| ID | Nome | Nome de Utilizador | Email | Ativo | Eliminado | ID de Cargo |");
                    for (User user : users) {
                        System.out.println("| " + user.getId() + " | "
                                + user.getName() + " | "
                                + user.getUsername() + " | "
                                + user.getEmail() + " | "
                                + (user.isActive() ? "Sim" : "Não") + " | "
                                + (user.isDeleted() ? "Sim" : "Não" + " | ")
                                + user.getRoleId() + " |");
                    }
                    System.out.println();
                    break;
                case 3:
                    users = manageUsers.getUsersByName(InputReader.readString("Nome a pesquisar: "));

                    if (users == null) {
                        continue;
                    } else if (users.isEmpty()) {
                        System.out.println("\nNenhum utilizador encontrado\n");
                        continue;
                    }
                    System.out.println("| ID | Nome | Nome de Utilizador | Email | Ativo | Eliminado | ID de Cargo |");
                    for (User user : users) {
                        System.out.println("| " + user.getId() + " | "
                                + user.getName() + " | "
                                + user.getUsername() + " | "
                                + user.getEmail() + " | "
                                + (user.isActive() ? "Sim" : "Não") + " | "
                                + (user.isDeleted() ? "Sim" : "Não" + " | ")
                                + user.getRoleId() + " |");
                    }
                    System.out.println();
                    break;
                case 4:
                    users = manageUsers.getUsersByUsername(InputReader.readString("Nome de utilizador a pesquisar: "));

                    if (users == null) {
                        continue;
                    } else if (users.isEmpty()) {
                        System.out.println("\nNenhum utilizador encontrado\n");
                        continue;
                    }
                    System.out.println("| ID | Nome | Nome de Utilizador | Email | Ativo | Eliminado | ID de Cargo |");
                    for (User user : users) {
                        System.out.println("| " + user.getId() + " | "
                                + user.getName() + " | "
                                + user.getUsername() + " | "
                                + user.getEmail() + " | "
                                + (user.isActive() ? "Sim" : "Não") + " | "
                                + (user.isDeleted() ? "Sim" : "Não" + " | ")
                                + user.getRoleId() + " |");
                    }
                    System.out.println();
                    break;
                case 5:
                    users = manageUsers.getUsersByRole(InputReader.readString("Tipo de utilizador a pesquisar: "));

                    if (users == null) {
                        continue;
                    } else if (users.isEmpty()) {
                        System.out.println("\nNenhum utilizador encontrado\n");
                        continue;
                    }
                    System.out.println("| ID | Nome | Nome de Utilizador | Email | Ativo | Eliminado | ID de Cargo |");
                    for (User user : users) {
                        System.out.println("| " + user.getId() + " | "
                                + user.getName() + " | "
                                + user.getUsername() + " | "
                                + user.getEmail() + " | "
                                + (user.isActive() ? "Sim" : "Não") + " | "
                                + (user.isDeleted() ? "Sim" : "Não" + " | ")
                                + user.getRoleId() + " |");
                    }
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);
    }

    private void showInsertUserMenu() {
        int option;
        do {
            option = InputReader.readInt("**** CRIAR UTILIZADORES ****\n"
                    + "1. Autor\n"
                    + "2. Revisor\n"
                    + "3. Gestor\n"
                    + "0. Voltar\n\n"
                    + "Escolha:", 0, 4);
            System.out.println();

            String name = InputReader.readString("Nome: "),
                    username = InputReader.readString("Nome de utilizador: ");
            ManageUsers manageUsers = new ManageUsers();
            if (manageUsers.existsUsername(username)) {
                return;
            }
            String password = InputReader.readString("Palavra Passe: "),
                    email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
            if (manageUsers.existsEmail(email)) {
                return;
            }

            if (option == 1 || option == 2) {
                String nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
                if (manageUsers.existsNIF(nif)) {
                    return;
                }
                String phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}"),
                        address = InputReader.readString("Morada: ");

                switch (option) {
                    case 1:
                        ManageLiteracyStyles manageLiteracyStyles = new ManageLiteracyStyles();
                        ArrayList<LiteraryStyle> literaryStyles = manageLiteracyStyles.getLiteracyStyles();
                        if (literaryStyles == null) {
                            System.out.println("\nEstilos literários inixestentes\n");
                            return;
                        }
                        String msg = "Estilos Literários\n";
                        for (int i = 0; i < literaryStyles.size(); i++) {
                            msg += (i + 1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
                        }
                        msg += "Escolha: ";

                        int literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();

                        ManageAuthors manageAuthors = new ManageAuthors();
                        if (manageAuthors.insertAuthor(new Author(-1,
                                name,
                                username,
                                password,
                                email,
                                false,
                                false,
                                3,
                                nif,
                                phone,
                                address,
                                new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                                literaryStyleId))) {
                            System.out.println("\nRegistado com sucesso\n");
                        } else {
                            System.out.println("\nErro ao registar\n");
                        }
                        break;
                    case 2:
                        String graduation = InputReader.readString("Formação Académica: "),
                         specialization = InputReader.readString("Área de especialização: ");

                        ManageReviewers manageReviewers = new ManageReviewers();
                        if (manageReviewers.insertReviewer(new Reviewer(-1,
                                name,
                                username,
                                password,
                                email,
                                false,
                                false,
                                2,
                                nif,
                                phone,
                                address,
                                graduation,
                                specialization))) {
                            System.out.println("\nRegistado com sucesso\n");
                        } else {
                            System.out.println("\nErro ao registar\n");
                        }
                        break;
                    default:
                        break;
                }

            } else if (option == 3) {
                ManageManagers manageManagers = new ManageManagers();
                if (manageManagers.insertManager(new Manager(-1,
                        name,
                        username,
                        password,
                        email,
                        false,
                        false,
                        1))) {
                    System.out.println("\nRegistado com sucesso\n");
                } else {
                    System.out.println("\nErro ao registar\n");
                }
            } else {
                System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);
    }

    private void showUpdateUserMenu() {
        int option;

        do {
            option = InputReader.readInt("**** ATUALIZAR UTILIZADORES ****\n"
                    + "1. Atualizar Tudo\n"
                    + "2. Ativar/Desativar conta\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 4);
            System.out.println();

            if (option == 0) {
                continue;
            }

            long id = InputReader.readLong("ID: ");

            User user = new ManageUsers().getUser(id);

            if (user == null) {
                System.out.println("\nNão foi possivel encontrar o utlizador\n");
                break;
            }
            ManageUsers manageUsers = new ManageUsers();
            switch (option) {
                case 1:
                    String name = InputReader.readString("Nome: "),
                     username = InputReader.readString("Nome de utilizador: ");
                    if (!user.getUsername().equals(username) && manageUsers.existsUsername(username)) {
                        continue;
                    }
                    String email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
                    if (!user.getEmail().equals(email) && manageUsers.existsEmail(email)) {
                        continue;
                    }
                    String nif,
                     phone,
                     address;
                    switch (user.getRoleId()) {
                        case 1:
                            ManageManagers manageManagers = new ManageManagers();
                            if (manageManagers.updateManager(new Manager(id,
                                    name,
                                    username,
                                    email,
                                    true,
                                    false,
                                    1))) {
                                System.out.println("\nAtualizado com sucesso\n");
                            } else {
                                System.out.println("\nErro ao atualizar\n");
                            }
                            break;
                        case 2:
                            ManageReviewers manageReviewers = new ManageReviewers();
                            Reviewer reviewer = manageReviewers.getReviewer(id);
                            nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
                            if (!reviewer.getNif().equals(nif) && manageUsers.existsNIF(nif)) {
                                continue;
                            }
                            phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}");
                            address = InputReader.readString("Morada: ");
                            String graduation = InputReader.readString("Formação Académica: "),
                             specialization = InputReader.readString("Área de especialização: ");

                            manageReviewers = new ManageReviewers();
                            if (manageReviewers.updateReviewer(new Reviewer(id,
                                    name,
                                    username,
                                    email,
                                    true,
                                    false,
                                    2,
                                    nif,
                                    phone,
                                    address,
                                    graduation,
                                    specialization))) {
                                System.out.println("\nAtualizado com sucesso\n");
                            } else {
                                System.out.println("\nErro ao atualizar\n");
                            }
                            break;
                        case 3:
                            ManageAuthors manageAuthors = new ManageAuthors();
                            Author author = manageAuthors.getAuthor(id);
                            nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
                            if (!author.getNif().equals(nif) && manageUsers.existsNIF(nif)) {
                                continue;
                            }
                            phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}");
                            address = InputReader.readString("Morada: ");
                            ManageLiteracyStyles manageLiteracyStyles = new ManageLiteracyStyles();
                            ArrayList<LiteraryStyle> literaryStyles = manageLiteracyStyles.getLiteracyStyles();
                            if (literaryStyles == null) {
                                System.out.println("\nEstilos literários inixestentes.\n");
                                break;
                            }
                            String msg = "Estilos Literários\n";
                            for (int i = 0; i < literaryStyles.size(); i++) {
                                msg += (i + 1) + ". " + literaryStyles.get(i).getLiteraryStyle() + "\n";
                            }
                            msg += "Escolha: ";

                            int literaryStyleId = literaryStyles.get(InputReader.readInt(msg, 1, literaryStyles.size()) - 1).getId();

                            manageAuthors = new ManageAuthors();
                            if (manageAuthors.updateAuthor(new Author(id,
                                    name,
                                    username,
                                    email,
                                    true,
                                    false,
                                    3,
                                    nif,
                                    phone,
                                    address,
                                    new SimpleDateFormat("yyyy-MM-dd").format(new Date()),
                                    literaryStyleId))) {
                                System.out.println("\nAtualizado com sucesso\n");
                            } else {
                                System.out.println("\nErro ao atualizar\n");
                            }
                            break;
                        default:
                            System.out.println("\nOpção inválida, tente novamente\n");
                            break;
                    }
                    break;
                case 2:
                    int active = InputReader.readInt("\n1. Ativar\n2. Desativar\n0. Voltar\n\nEscolha: ", 0, 2);
                    System.out.println();
                    switch (active) {
                        case 1:
                            if (manageUsers.updateUserStatus(id, true)) {
                                System.out.println("\nEstado do utilizador alterado\n");
                            } else {
                                System.out.println("\nEstado não alterado\n");
                            }
                            break;
                        case 2:
                            if (manageUsers.updateUserStatus(id, false)) {
                                System.out.println("\nEstado do utilizador alterado\n");
                            } else {
                                System.out.println("\nEstado não alterado\n");
                            }
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("\nOpção inválida\n");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }

        } while (option != 0);
    }

    private void showReviewRequestsMenu() {

    }

    private void showListReviewsMenu() {
        int option;

        do {
            option = InputReader.readInt("**** LISTAR REVISÕES ****\n"
                    + "1. Listar Por Data Submissão Mais Recente\n"
                    + "2. Listar Por Data De Submissão Mais Antiga\n"
                    + "3. Listar Por Título (Ascendente)\n"
                    + "4. Listar Por Título (Descendente)\n"
                    + "5. Listar Por Autor (Ascendente)\n"
                    + "6. Listar Por Autor (Descendente)\n"
                    + "7. Pesquisar Por ID\n"
                    + "8. Pesquisar Por Estado\n"
                    + "9. Pesquisar Por Autor\n"
                    + "10. Pesquisar Por Intervalo de Datas\n"
                    + "11. Listar Processos De Revisão Por Título\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 11);
            System.out.println();

            switch (option) {
                case 0:
                    showMenu();
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
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);
    }

    private void showLicensesMenu(){
        int option;
        do {
            option = InputReader.readInt("**** LICENSAS ****\n"
                    + "1. Inserir Licensa\n"
                    + "2. Autalizar Quantidade de Licensas\n"
                    + "0. Sair\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();

            switch (option) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);
    }
    
    private void showAuditMenu() {
        int option;

        do {
            option = InputReader.readInt("**** AUDITORIA ****\n"
                    + "1. Listar Logs\n"
                    + "2. Listar Logs por utilizador\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();
            
            if (option == 0) {
                continue;
            }

            ManageLogs manageLogs = new ManageLogs();
            ArrayList<Log> logs;

            switch (option) {
                case 1:

                    logs = manageLogs.getLogs(1);
                    if(logs.isEmpty()){
                        System.out.println("Nenhum log encontrado\n");
                        continue;
                    }
                    
                    System.out.println("ID Utilizador\t\tData\t\tAção\n");
                    for (Log log : logs) {
                        System.out.println(log.getUserId() + "\t\t" + log.getDatetime() + "\t\t" + log.getAction());
                    }
                    System.out.println();
                    break;
                case 2:

                    int userId = InputReader.readInt("Insira o id de utilizador: ");
                    logs = manageLogs.getLogsByUser(userId);
                    
                    if(logs.isEmpty()){
                        System.out.println("Nenhum log encontrado\n");
                        continue;
                    }
                    
                    System.out.println("Data\t\tAção\n");
                    for (Log log : logs) {
                        System.out.println(log.getDatetime() + "\t\t" + log.getAction());
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
            }

        } while (option != 0);
    }

    private void showProfileMenu(){
        int option;
        do {
            option = InputReader.readInt("**** PERFIL ****\n"
                    + "1. Atualizar\n"
                    + "2. Eliminar\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();

            switch (option) {
                case 1:
                    this.showUpdateProfileMenu();
                    break;
                case 2:
                    this.showDeleteProfileMenu();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nOpção inválida, tente novamente\n");
            }
        } while (option != 0);
    }
    
    private void showUpdateProfileMenu() {

        System.out.println("Atualizar Perfil\n");

        ManageManagers manageManagers = new ManageManagers();

        Manager manager = manageManagers.getManager(Main.getLoggedUser().getId());

        if (manager == null) {
            System.out.println("Não foi possivel encontrar o gestor\n");
            return;
        }
        ManageUsers manageUsers = new ManageUsers();
        String name = InputReader.readString("Nome: "),
                username = InputReader.readString("Nome de utilizador: ");
        if (!manager.getUsername().equals(username) && manageUsers.existsUsername(username)) {
            return;
        }
        String password = InputReader.readString("Palavra passe: "),
                email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
        if (!manager.getEmail().equals(email) && manageUsers.existsEmail(email)) {
            return;
        }
        if (manageManagers.updateManager(new Manager(Main.getLoggedUser().getId(),
                name,
                username,
                password,
                email,
                true,
                false,
                1))) {
            System.out.println("\nAtualizado com sucesso\n");
        } else {
            System.out.println("\nErro ao atualizar\n");
        }
    }
    
    private void showDeleteProfileMenu(){
        System.out.println("Eliminar Perfil\n");

        int option = InputReader.readInt("Deseja mesmo eliminar o perfil?\n1. Sim\n0. Não\n\nEscolha: ", 0, 1);
        
        switch (option) {
            case 1:
                break;
            case 0:
                break;
            default:
                System.out.println("\nOpção inválida\n");
        }
    }
}
