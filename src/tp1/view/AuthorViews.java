package tp1.view;

public class AuthorViews {

    public void showMenu() {
        int option = InputReader.readInt("**** AUTORIA ****\n"
                + "1. Listar Pedidos De Revisao\n"
                + "2. Listar Obras\n"
                + "3. Terminar Sessao\n\n"
                + "Escolha: ", 0, 2);

        switch (option) {
            case 0:
                break;
            case 1:
                showReviewsMenu();
                break;
            case 2:
                showBooksMenu();
                break;
            default:
                throw new AssertionError();
        }
    }

    private void showReviewsMenu() {
        int option = InputReader.readInt("**** PEDIDOS DE REVISAO ****\n"
                + "1. Ordenar Por Data De Criacao (Recente)\n"
                + "2. Ordenar Por Data De Criacao (Antigo)\n"
                + "3. Ordenar Por Numero De Serie (Ascendente)\n"
                + "4. Ordenar Por Numero De Serie (Descendente)\n"
                + "5. Pesquisar Por Data De Criacao\n"
                + "6. Pesquisar Por Titulo\n"
                + "7. Pesquisar Por Estado\n"
                + "8. Proxima Pagina\n"
                + "9. Pagina Anterior\n"
                + "0. Voltar\n\n"
                + "Escolha: ", 0, 9);

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
            default:
                throw new AssertionError();
        }
    }

    private void showBooksMenu() {
        int option = InputReader.readInt("**** OBRAS ****\n"
                + "1. Ordenar Por Data De Submissao (Recente)\n"
                + "2. Ordenar Por Data De Submissao (Antigo)\n"
                + "3. Ordenar Por Titulo (Ascendente)\n"
                + "4. Ordenar Por Titulo (Descendente)\n"
                + "5. Pesquisar Por Data De Registo\n"
                + "6. Pesquisar Por Matricula\n"
                + "7. Proxima Pagina\n"
                + "8. Pagina Anterior\n"
                + "0. Voltar\n\n"
                + "Escolha:  ", 0, 8);
        
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
}
