package tp1.view;

public class ManagerViews {

    public void showMenu() {

        int option;
        do {
            option = InputReader.readInt("**** MENU DE GESTOR ****\n"
                    + "1. Utilizadores\n"
                    + "2. Pedidos De Revisão\n"
                    + "0. Terminar Sessão\n\n"
                    + "Escolha: ", 0, 2);

            switch (option) {
                case 0:
                    showUsersMenu();
                    break;
                case 1:
                    showReviewRequestsMenu();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);

        if (Main.getLoggedUser() != null) {
            System.out.println("\nAdeus " + Main.getLoggedUser().getUsername() + "\n");
        }
        Main.setLoggedUserId(null);

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

            switch (option) {
                case 0:
                    break;
                case 1:
                    showListUsersMenu();
                    break;
                case 2:
                    showInsertUserMenu();
                    break;
                case 3:
                    showUpdateUserMenu();
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);
    }

    private void showListUsersMenu() {
        int option;

        do {
            option = InputReader.readInt("**** LISTAR UTILIZADORES ****\n"
                    + "1. Listar Por Nome (Ascendente)\n"
                    + "2. LIstar Por Nome (Descendente)\n"
                    + "3. Pesquisar Por Nome\n"
                    + "4. Pesquisar Por Nome De Utilizador\n"
                    + "5. Pesquisar Por Tipo\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 5);

            switch (option) {
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
                default:
                    throw new AssertionError();
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

            switch (option) {
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
                default:
                    throw new AssertionError();
            }

        } while (option != 0);
    }

    private void showUpdateUserMenu() {
        int option;

        do {
            option = InputReader.readInt("**** ATUALIZAR UTILIZADORES ****\n"
                    + "1. Autor\n"
                    + "2. Revisor\n"
                    + "3. Gestor\n"
                    + "4. Ativar/Desativar conta\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 4);

            switch (option) {
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
                default:
                    throw new AssertionError();
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
}
