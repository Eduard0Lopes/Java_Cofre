// RU: 4027768 - Luiz Lopes

package Banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CofrinhoDeMoedas {
    private List<Moeda> moedas;

    public CofrinhoDeMoedas() {
        moedas = new ArrayList<>(); // Inicializa a lista de moedas como um "ArrayList" vazio //
    }

    public void adicionarMoeda(Moeda moeda) {
        moedas.add(moeda); // Adiciona uma nova moeda à lista de moedas. //
    }

    public void removerMoeda(int indice) {
        if (indice >= 0 && indice < moedas.size()) {
            Moeda moedaRemover = moedas.get(indice);
            moedas.remove(indice); // Remove a moeda da lista de moedas com base no índice fornecido posteriormente. //
            System.out.println("Moeda removida: " + moedaRemover);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void listarMoedas() {
        if (moedas.isEmpty()) { // Verifica se a lista de moedas está vazia //
            System.out.println("Não há moedas no cofrinho.");
        } else {
            System.out.println("Moedas no cofrinho:");
            for (int i = 0; i < moedas.size(); i++) {
                Moeda moeda = moedas.get(i); // Obtém a moeda atual da lista //
                System.out.println(i + ". " + moeda); // Imprime o índice e a representação da moeda //
            }
        }
    }

    public double calcularValorTotalEmReais() {
        double valorTotal = 0;
        for (Moeda moeda : moedas) {
            valorTotal += moeda.getValorEmReais(); // Calcula o valor total em "Reais" somando o valor de cada moeda adicionada. //
        }
        return valorTotal;
    }

    public static void main(String[] args) {
        CofrinhoDeMoedas cofrinho = new CofrinhoDeMoedas();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        // Menu que será visto pelo usuário // 
        while (opcao != 5) {
            System.out.println("=== Menu ===");
            System.out.println("1. Adicionar moedas");
            System.out.println("2. Remover moedas");
            System.out.println("3. Listar moedas");
            System.out.println("4. Calcular valor total em Reais");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de leitura //

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da moeda: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine(); // Limpar o buffer de leitura //
                    System.out.print("Digite o país da moeda: ");
                    String pais = scanner.nextLine();
                    System.out.print("Digite o tipo de moeda (Real, Dolar ou Euro): ");
                    String tipoMoeda = scanner.nextLine();

                    Moeda novaMoeda;
                    switch (tipoMoeda) {
                        case "Real":
                            novaMoeda = new Real(valor, pais);
                            break;
                        case "Dolar":
                            System.out.print("Digite a taxa de câmbio do Dólar: ");
                            double taxaCambioDolar = scanner.nextDouble();
                            scanner.nextLine(); // Limpar o buffer de leitura //
                            novaMoeda = new Dolar(valor, pais, taxaCambioDolar);
                            break;
                        case "Euro":
                            System.out.print("Digite a taxa de câmbio do Euro: ");
                            double taxaCambioEuro = scanner.nextDouble();
                            scanner.nextLine(); // Limpar o buffer de leitura //
                            novaMoeda = new Euro(valor, pais, taxaCambioEuro);
                            break;
                        default:
                            System.out.println("Tipo de moeda inválido!");
                            continue;
                    }

                    cofrinho.adicionarMoeda(novaMoeda);
                    System.out.println("Moeda adicionada com sucesso!");
                    break;
                case 2:
                	cofrinho.listarMoedas(); // Adiciona no "Display", quais são as moedas, valores e seus respectivos indices. //
                	System.out.print("Digite o índice da moeda a ser removida: ");                    
                    int indiceRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpar o buffer de leitura
                    cofrinho.removerMoeda(indiceRemover);
                    break;
                case 3:
                    cofrinho.listarMoedas(); // Lista apenas as moedas, valores e indices, sem ação de remover. //
                    break;
                case 4:
                    double valorTotal = cofrinho.calcularValorTotalEmReais(); //Cálculo em Reais do valor //
                    System.out.println("Valor total em Reais: R$ " + valorTotal);
                    break;
                case 5:
                    System.out.println("Encerrando o programa..."); // Finaliza o programa //
                    break;
                default:
                    System.out.println("Opção inválida!"); // Mensagem de erro quando o usuário seleciona alguma opção incorreta //
                    break;
            }
            System.out.println();
        }

        scanner.close(); // Fechar o Scanner ao final //
    }
}
