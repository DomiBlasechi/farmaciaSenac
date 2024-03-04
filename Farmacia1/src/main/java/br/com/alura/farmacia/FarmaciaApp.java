package br.com.alura.farmacia;
import br.com.alura.farmacia.modelo.Produto;
import br.com.alura.farmacia.service.ProdutoService;
import br.com.alura.farmacia.modelo.RegraDeNegocioException;
import java.util.Scanner;
import java.util.Set;

public class FarmaciaApp {
        private static Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        private static ProdutoService service = new ProdutoService();


        public static void main (String[]args){
            int opcao = exibirMenu();
            while (opcao != 5) {
                try {
                    switch (opcao) {
                        case 1:
                            cadastrarProduto();
                            break;
                        case 2:
                            listarProduto();
                            break;
                        case 3:
                            editarProduto();
                            break;
                        case 4:
                            excluirProduto();
                            break;
                    }
                } catch (RegraDeNegocioException e) {
                    System.out.println("Erro: " + e.getMessage());
                    System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
                    teclado.next();
                }
                opcao = exibirMenu();
            }
            System.out.println("Finalizando a aplicação.");


        }

        private static int exibirMenu () {
            System.out.println(""" 
                    *** ----- FARMÁCIA - ESCOLHA UMA OPÇÃO:
                    1 - Cadastrar produto.
                    2 - Listar produto.
                    3 - Editar produto.
                    4 - Apagar produto.
                    5 - Sair. 
                    *** ------------------------------- ***
                    """);
            return teclado.nextInt();
        }
        private static void cadastrarProduto () {
            System.out.println("Digite o id do produto:");
            var id = teclado.nextInt();

            System.out.println("Digite o nome do produto:");
            var nome = teclado.next();

            System.out.println("Digite a descrição do produto:");
            var descricao = teclado.next();

            System.out.println("Digite o preço unitário do produto:");
            var preco = Integer.parseInt(teclado.next());

            service.cadastrar(new Produto(id, nome, descricao, preco));

            System.out.println("Produto cadastrado com sucesso!");
            System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
            teclado.next();

        }

        private static void listarProduto () {
            System.out.println("Listando produtos cadastrados:");
            Set<Produto> produtos = service.listar();
            produtos.stream().forEach(System.out::println);

            System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
        }

        private static void editarProduto () {
            System.out.println("Edite o nome desejado:");
            var nome = teclado.next();
            System.out.println("Edite o preço desejado:");
            var preco = teclado.nextDouble();

            service.editar(nome, preco);
            System.out.println("Produto atualizado com sucesso.");
            System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
            teclado.next();
        }

        private static void excluirProduto () {
            System.out.println("Digite o nome do produto:");
            var nome = teclado.next();
            service.excluir(nome);
            System.out.println("Produto excluído com sucesso.");
            System.out.println("Pressione qualquer tecla e dê ENTER para voltar ao menu principal.");
            teclado.next();
        }
}