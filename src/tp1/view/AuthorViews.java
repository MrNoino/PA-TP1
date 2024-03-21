package tp1.view;

public class AuthorViews {

    public void showMenu() {

        int option;

        do {
            option = InputReader.readInt("**** MENU DE AUTOR ****\n"
                    + "1. Obras\n"
                    + "2. Pedidos de Revisão\n"
                    + "0. Terminar Sessão\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();

            switch (option) {
                case 0:
                    break;
                case 1:
                    showBooksMenu();
                    break;
                case 2:
                    showReviewRequestsMenu();
                    break;
                default:
                    throw new AssertionError();
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
                    + "0. Terminar Sessão\n\n"
                    + "Escolha: ", 0, 3);

            switch (option) {
                case 0:
                    break;
                case 1:
                    showListBooksMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    throw new AssertionError();
            }

        } while (option != 0);
    }

    private void showListBooksMenu() {
        int option;

        do {
            option = InputReader.readInt("**** OBRAS ****\n"
                    + "1. Ordenar Por Data De Submissao (Recente)\n"
                    + "2. Ordenar Por Data De Submissao (Antigo)\n"
                    + "3. Ordenar Por Titulo (Ascendente)\n"
                    + "4. Ordenar Por Titulo (Descendente)\n"
                    + "5. Pesquisar Por Data De Registo\n"
                    + "6. Pesquisar Por Matricula\n"
                    + "0. Voltar\n\n"
                    + "Escolha:  ", 0, 6);

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
                default:
                    throw new AssertionError();
            }
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

            switch (option) {
                case 0:
                    break;
                case 1:
                    showReviewRequestsListMenu();
                    break;
                case 2:
                    break;
                default:
                    throw new AssertionError();
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
                default:
                    throw new AssertionError();
            }
        } while (option != 0);
    }
}
