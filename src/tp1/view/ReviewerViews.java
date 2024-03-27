package tp1.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import tp1.controller.ManageLogs;
import tp1.controller.ManageManagers;
import tp1.controller.ManageReviewers;
import tp1.controller.ManageReviews;
import tp1.controller.ManageUsers;
import tp1.model.Log;
import tp1.model.Manager;
import tp1.model.Reviewer;

public class ReviewerViews {

    public void showMenu() {
        int option;

        do {
            option = InputReader.readInt("**** MENU DE REVISOR ****\n"
                    + "1. Listar Pedidos De Revisão\n"
                    + "2. Rever uma obra\n"
                    + "3. Atualizar Perfil\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 3);
            System.out.println();

            switch (option) {
                case 1:
                    showReviewRequestsMenu("submission_date");
                    break;
                case 2:
                    break;
                case 3:
                    showUpdateProfileMenu();
                    break;
                case 0:
                    new ManageLogs().insertLog(new Log(Main.getLoggedUser().getId(),
                            new SimpleDateFormat("yyyy-mm-dd").format(new Date()),
                            Main.getLoggedUser().getUsername() + " terminou sessão"));
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);

        Main.logout();
    }

    private void showReviewRequestsMenu(String sortType) {

        String menu = "**** LISTAR PEDIDOS DE REVISÃO ****\n"
                + "1. Listar Por Data De Criação (Recente)\n"
                + "2. Listar Por Data De Criação (Antigo)\n"
                + "3. Listar Por Título (Ascendente)\n"
                + "4. Listar Por Título (Descendente)\n"
                + "5. Pesquisar Por Data De Criação\n"
                + "6. Pesquisar Por Título\n"
                + "7. Pesquisar Por Estado\n"
                + "0. Voltar\n\n"
                + "\n\nEscolha: ";

        int input = InputReader.readInt(menu, 0, 7);

        switch (input) {
            case 0:
                break;
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
            default:
                throw new AssertionError();
        }
    }

    private void showUpdateProfileMenu() {

        System.out.println("Atualizar Perfil\n");

        ManageReviewers manageReviewers = new ManageReviewers();

        Reviewer reviewer = manageReviewers.getReviewer(Main.getLoggedUser().getId());

        if (reviewer == null) {
            System.out.println("Não foi possivel encontrar o revisor\n");
            return;
        }
        ManageUsers manageUsers = new ManageUsers();
        String name = InputReader.readString("Nome: "),
                username = InputReader.readString("Nome de utilizador: ");
        if (!reviewer.getUsername().equals(username) && manageUsers.existsUsername(username)) {
            return;
        }
        String password = InputReader.readString("Palavra passe: "),
                email = InputReader.readString("Email: ", "\nEmail inválido, tente novamente\n", "[\\w._-]{3,}@[\\w_]{3,}.\\w{2,5}");
        if (!reviewer.getEmail().equals(email) && manageUsers.existsEmail(email)) {
            return;
        }
        String nif = InputReader.readString("NIF: ", "\nNIF inválido, tente novamente\n", "\\d{9}");
        if (!reviewer.getNif().equals(nif) && manageUsers.existsNIF(nif)) {
            return;
        }
        String phone = InputReader.readString("Telemóvel: ", "\nTelemóvel inválido, tente novamente\n", "[239]\\d{8}"),
                address = InputReader.readString("Morada: ");
        String graduation = InputReader.readString("Formação Académica: "),
                specialization = InputReader.readString("Área de especialização: ");
        if (manageReviewers.updateReviewer(new Reviewer(Main.getLoggedUser().getId(),
                name,
                username,
                password,
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
    }
}
