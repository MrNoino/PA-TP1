package tp1.view;

public class ReviewerViews {

    public void showMenu() {
        int input = InputReader.readInt("**** REVISOES ****\n"
                + "1. Listar Pedidos De Revisão\n"
                + "2. Rever uma obra\n"
                + "0. Terminar Sessao\n\n"
                + "Escolha: ", 0, 2);

        switch (input) {
            case 0:
                break;
            case 1:
                showReviewRequestsMenu();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void showReviewRequestsMenu() {

        int input = InputReader.readInt("**** PEDIDOS DE REVISAO ****\n"
                + "1. Ordenar Por Data De Criacao (Recente)\n"
                + "2. Ordenar Por Data De Criacao (Antigo)\n"
                + "3. Ordenar Por Titulo (Ascendente)\n"
                + "4. Ordenar Por Titulo (Descendente)\n"
                + "5. Pesquisar Por Data De Criacao\n"
                + "6. Pesquisar Por Titulo\n"
                + "7. Pesquisar Por Estado\n"
                + "8. Proxima Pagina\n"
                + "9. Pagina Anterior\n"
                + "0. Voltar\n\n"
                + "Escolha: ", 0, 9);

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
            case 8:
                break;
            case 9:
                break;
            default:
                throw new AssertionError();
        }
    }
}
