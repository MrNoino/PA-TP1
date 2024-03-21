package tp1.view;

public class ReviewerViews {

    public void showMenu() {
        int option;

        do {
            option = InputReader.readInt("**** MENU DE REVISOR ****\n"
                    + "1. Listar Pedidos De Revisão\n"
                    + "2. Rever uma obra\n"
                    + "0. Voltar\n\n"
                    + "Escolha: ", 0, 2);
            System.out.println();

            switch (option) {
                case 0:
                    break;
                case 1:
                    showReviewRequestsMenu();
                    break;
                case 2:
                    break;
                default:
                    throw new AssertionError();
            }
        } while (option != 0);

        Main.logout();
    }

    private void showReviewRequestsMenu() {

        int input = InputReader.readInt("**** LISTAR PEDIDOS DE REVISÃO ****\n"
                + "1. Listar Por Data De Criação (Recente)\n"
                + "2. Listar Por Data De Criação (Antigo)\n"
                + "3. Listar Por Título (Ascendente)\n"
                + "4. Listar Por Título (Descendente)\n"
                + "5. Pesquisar Por Data De Criação\n"
                + "6. Pesquisar Por Título\n"
                + "7. Pesquisar Por Estado\n"
                + "0. Voltar\n\n"
                + "Escolha: ", 0, 7);

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
}
