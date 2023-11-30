package sistemaBancarioAtividade;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias = new ArrayList<>();

	public static void main(String[] args) {
		operacoes();
	}

	public static void operacoes() {
		boolean sair = false;

		while (!sair) {
			System.out.println("-------------- Agência Bancária --------------");
			System.out.println("---------------------------------------------");
			System.out.println("************ Selecione uma opção ************");
			System.out.println();
			System.out.println("| Opção 1 - Criar Conta Corrente            |");
			System.out.println("| Opção 2 - Mostrar dados da Conta Corrente |");
			System.out.println("| Opção 3 - Alterar dados da Conta Corrente |");
			System.out.println("| Opção 4 - Excluir Conta Corrente          |");
			System.out.println("| Opção 5 - Efetuar depósito                |");
			System.out.println("| Opção 6 - Efetuar pagamento               |");
			System.out.println("| Opção 7 - Efetuar transferência           |");
			System.out.println("| Opção 8 - Mostrar todas as Contas         |");
			System.out.println("| Opção 9 - Finalizar Sistema               |");

			System.out.println();
			System.out.println("Opção: ");
			int operacao = input.nextInt();

			switch (operacao) {
			case 1:
				criarContaCorrente();
				break;
			case 2:
				System.out.println("Número da conta: ");
				int numeroConta = input.nextInt();
				mostrarDadosConta(numeroConta);
				break;
			case 3:
				System.out.println("Número da conta: ");
				int numeroContaAlterar = input.nextInt();
				
				input.nextLine();
				System.out.println("Novo nome do titular: ");
				String novoNome = input.nextLine();
				
				System.out.println("Novo limite: ");
				double novoLimite = input.nextDouble();
				alterarDadosConta(numeroContaAlterar, novoNome, novoLimite);
				break;
			case 4:
				System.out.println("Número da conta: ");
				int numeroContaExcluir = input.nextInt();
				excluirConta(numeroContaExcluir);
				break;
			case 5:
				System.out.println("Número da conta: ");
				int numeroContaDeposito = input.nextInt();
				
				System.out.println("Valor do depósito: ");
				double valorDeposito = input.nextDouble();
				realizarDeposito(numeroContaDeposito, valorDeposito);
				break;
			case 6:
				System.out.println("Número da conta: ");
				int numeroContaPagamento = input.nextInt();
				
				System.out.println("Valor do pagamento: ");
				double valorPagamento = input.nextDouble();
				realizarPagamento(numeroContaPagamento, valorPagamento);
				break;
			case 7:
				System.out.println("Número da conta de origem: ");
				int numeroContaOrigem = input.nextInt();

				System.out.println("Número da conta de destino: ");
				int numeroContaDestino = input.nextInt();

				System.out.println("Valor da transferência: ");
				double valorTransferencia = input.nextDouble();
				realizarTransferencia(numeroContaOrigem, numeroContaDestino, valorTransferencia);
				break;
			case 8:
				mostrarTodasContas();
				break;
			case 9:
				System.out.println("Sistema Finalizado");
				input.close();
				sair = true;
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		}
	}

	public static void criarContaCorrente() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		input.nextLine();

		System.out.println("Nome do titular: ");
		String nomeTitular = input.nextLine();

		System.out.println("Saldo inicial: ");
		double saldoInicial = input.nextDouble();

		System.out.println("Limite: ");
		double limite = input.nextDouble();

		Pessoa titular = new Pessoa(nomeTitular);
		Conta conta = new Conta(numeroConta, titular, saldoInicial, limite);

		contasBancarias.add(conta);
		System.out.println("Conta criada com sucesso!");
	}

	public static void mostrarDadosConta(int numeroConta) {
		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				conta.mostrarDadosConta();
				return;
			}
		}
		System.out.println("Conta não encontrada.");
	}

	public static void alterarDadosConta(int numeroConta, String novoNome, double novoLimite) {
		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				conta.alterarDadosConta(novoNome, novoLimite);
				return;
			}
		}
		System.out.println("Conta não encontrada.");
	}

	public static void excluirConta(int numeroConta) {
		Conta contaRemover = null;
		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				contaRemover = conta;
				break;
			}
		}
		if (contaRemover != null) {
			contasBancarias.remove(contaRemover);
			System.out.println("Conta excluída com sucesso.");
		} else {
			System.out.println("Conta não encontrada.");
		}
	}

	public static void realizarDeposito(int numeroConta, double valorDeposito) {
		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				conta.depositar(valorDeposito);
				return;
			}
		}
		System.out.println("Conta não encontrada.");
	}

	public static void realizarPagamento(int numeroConta, double valorPagamento) {
		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroConta) {
				if (conta.pagar(valorPagamento)) {
					return;
				} else {
					System.out.println("Pagamento não realizado.");
					return;
				}
			}
		}
		System.out.println("Conta não encontrada.");
	}

	public static void realizarTransferencia(int numeroContaOrigem, int numeroContaDestino, double valorTransferencia) {
		Conta contaOrigem = null;
		Conta contaDestino = null;

		for (Conta conta : contasBancarias) {
			if (conta.getNumeroConta() == numeroContaOrigem) {
				contaOrigem = conta;
			}
			if (conta.getNumeroConta() == numeroContaDestino) {
				contaDestino = conta;
			}
		}

		if (contaOrigem != null && contaDestino != null) {
			if (contaOrigem.transferir(contaDestino, valorTransferencia)) {
				return;
			}
		}

		System.out.println("Transferência não realizada.");
	}

	public static void mostrarTodasContas() {
		System.out.println("************ Todas as Contas ************");
		for (Conta conta : contasBancarias) {
			conta.mostrarDadosConta();
			System.out.println("---------------------------------------");
		}
		System.out.println("Total de Contas: " + contasBancarias.size());
	}
}
