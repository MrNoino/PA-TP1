package tp1.view;

public class ManagerViews {

    public void showMenu() {

        int option = InputReader.readInt("**** GESTORIA ****\n"
                + "1. Listar Utilizadores\n"
                + "2. Listar Pedidos De Revisao\n"
                + "0. Terminar Sessao\n\n"
                + "Escolha: ", 0, 2);

        switch (option) {
            case 0:
                break;
            case 1:
                showUsersListMenu();
                break;
            case 2:
                showReviewRequestsMenu();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void showUsersListMenu() {

        int option = InputReader.readInt("**** UTILIZADORES ****\n"
                + "1. Ordenar Por Nome (Ascendente)\n"
                + "2. Ordenar Por Nome (Descendente)\n"
                + "3. Pesquisar Por Nome\n"
                + "4. Pesquisar Por Nome De Utilizador\n"
                + "5. Pesquisar Por Tipo\n"
                + "6. Proxima Pagina\n"
                + "7. Pagina Anterior\n"
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
            case 8:
                break;
            default:
                throw new AssertionError();
        }
    }

    private void showReviewRequestsMenu() {
        int option = InputReader.readInt("**** REVISOES ****\n"
                + "1. Ordenar Por Data De Criacao Mais Recente\n"
                + "2. Ordenar Por Data De Cricao Mais Antiga\n"
                + "3. Ordenar Por Titulo (Ascendente)\n"
                + "4. Ordenar Por Titulo (Descendente)\n"
                + "5. Ordenar Por Autor (Ascendente)\n"
                + "6. Ordenar Por Autor (Descendente)\n"
                + "7. Pesquisar Por ID\n"
                + "8. Pesquisar Por Estado\n"
                + "9. Pesquisar Por Autor\n"
                + "10. Pesquisar Por Data\n"
                + "11. Proxima Pagina\n"
                + "12. Pagina Anterior\n"
                + "13. Listar Processos De Revisao Por Titulo\n"
                + "0. Voltar\n\n"
                + "Escolha:", 0, 13);

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
            case 12:
                break;
            case 13:
                break;
            default:
                throw new AssertionError();
        }
    }
}
