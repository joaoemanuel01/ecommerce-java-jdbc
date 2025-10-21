package br.com.joaoemanuel.ecommerce.app;

import br.com.joaoemanuel.ecommerce.dao.CategoriaDAO;
import br.com.joaoemanuel.ecommerce.dao.PedidoDAO;
import br.com.joaoemanuel.ecommerce.dao.ProdutoDAO;
import br.com.joaoemanuel.ecommerce.dao.ProdutoPedidoDAO;
import br.com.joaoemanuel.ecommerce.entities.Categoria;
import br.com.joaoemanuel.ecommerce.entities.Pedido;
import br.com.joaoemanuel.ecommerce.entities.Produto;
import br.com.joaoemanuel.ecommerce.entities.ProdutoPedido;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        ProdutoPedidoDAO produtoPedidoDAO = new ProdutoPedidoDAO();

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("========== MENU ECOMMERCE ==========");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Cadastrar Pedido");
            System.out.println("4 - Cadastrar ProdutoPedido");
            System.out.println("0 - Sair");
            System.out.println("Escolha um opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do categoria: ");
                    String nomeCategoria = scanner.nextLine();
                    Categoria c = new Categoria(0, nomeCategoria);
                    categoriaDAO.inserir(c);
                    break;
                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.println("Digite o valor do produto: ");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite o ID da Categoria: ");
                    int categoriaId = scanner.nextInt();
                    Produto p = new Produto(0, nomeProduto, preco, categoriaId);
                    produtoDAO.inserir(p);
                    break;
                case 3:
                    System.out.println("=== Cadastrar Pedido ====");
                    System.out.println("Digite o valor do pedido: ");
                    double valorTotal = scanner.nextDouble();

                    Pedido pedido = new Pedido(0, java.time.LocalDate.now(), valorTotal);

                    pedidoDAO.inserir(pedido);
                    break;

                case 4:
                    System.out.println("==== Cadastrar Produto no Pedido ====");
                    System.out.println("Digite ID do Pedido: ");
                    int pedidoId = scanner.nextInt();

                    System.out.println("Digite o ID do Produto: ");
                    int produtoId = scanner.nextInt();

                    System.out.println("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();

                    ProdutoPedido pp = new ProdutoPedido(pedidoId, produtoId, quantidade);
                    produtoPedidoDAO.inserir(pp);
                    break;

                case 0:
                    System.out.println("Encerrando o Sistema...");
                    break;

                default:
                    System.out.println("Opção Invalida!");
            }

        }
    }
}
