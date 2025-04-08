import Entities.Cliente;
import Entities.Conta;
import Entities.ContaCorrente;
import Entities.ContaPoupanca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Conta> contas = new ArrayList<>();
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("""
                    1 - Criar conta corrente
                    2 - Criar conta poupança
                    3 - Depositar
                    4 - Sacar
                    5 - Transferir
                    6 - Ver extrato
                    0 - Sair
                    """);
            System.out.println("Escolha uma opção!");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);

                    Conta novaConta = new ContaCorrente(cliente);
                    contas.add(novaConta);
                    System.out.println("Conta corrente criada com sucesso!");
                    System.out.println("Número da conta: " + novaConta.getNumero());
                }
                case 2 -> {
                    System.out.println("Nome do cliente: ");
                    String nome = sc.nextLine();
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);

                    Conta novaConta = new ContaPoupanca(cliente);
                    contas.add(novaConta);
                    System.out.println("Conta poupança criada com sucesso!");
                    System.out.println("Número da conta: " + novaConta.getNumero());
                }
                case 3 -> {
                    Conta conta = buscarConta(contas, sc);
                    if (conta != null) {
                        System.out.println("Digite o valor para depósito: ");
                        double valor = sc.nextDouble();
                        conta.depositar(valor);
                    }
                }
                case 4 -> {
                    Conta conta = buscarConta(contas, sc);
                    if (conta != null) {
                        System.out.println("Digite o valor para saque: ");
                        double valor = sc.nextDouble();
                        conta.sacar(valor);
                    }
                }
                case 5 -> {
                    System.out.println("Digite a conta de origem da transferência: ");
                    Conta contaOrigem = buscarConta(contas, sc);
                    System.out.println("Digite a conta destino da transferência: ");
                    Conta contaDestino = buscarConta(contas, sc);

                    if (contaOrigem != null && contaDestino != null) {
                        System.out.println("Valor da transferência: ");
                        double valor = sc.nextDouble();

                        contaOrigem.transferir(valor, contaDestino);
                    }
                }
                case 6 -> {
                    Conta conta = buscarConta(contas, sc);
                    if (conta != null) {
                        conta.imprimirExtrato();
                    }
                }
                case 0 -> System.out.println("Encerrando programa");

            }
        }

    }


    public static Conta buscarConta(List<Conta> contas, Scanner sc) {
        System.out.println("Digite o número da conta: ");
        int numero = sc.nextInt();

        for (Conta c : contas) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        System.out.println("Conta não encontrada");
        return null;
    }

}