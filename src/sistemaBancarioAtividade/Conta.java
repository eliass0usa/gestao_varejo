package sistemaBancarioAtividade;

public class Conta {
	private int numeroConta;
	private Pessoa titular;
	private double saldo;
	private double limite;

	public Conta(int numeroConta, Pessoa titular, double saldo, double limite) {
		this.numeroConta = numeroConta;
		this.titular = titular;
		this.saldo = saldo;
		this.limite = limite;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public Pessoa getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	// Método para efetuar depósito
	public void depositar(double valor) {
		if (valor > 0) {
			saldo += valor;
			System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
		} else {
			System.out.println("Não foi possível realizar o depósito.");
		}
	}

	// Método para efetuar pagamento
	public boolean pagar(double valor) {
		if (saldo + limite >= valor) {
			saldo -= valor;
			System.out.println("Pagamento de R$" + valor + " realizado com sucesso!");
			return true;
		} else {
			System.out.println("Saldo insuficiente.");
			return false;
		}
	}

	// Método para efetuar transferência
	public boolean transferir(Conta contaDestino, double valor) {
		if (saldo + limite >= valor) {
			saldo -= valor;
			contaDestino.depositar(valor);
			System.out.println("Transferência de R$" + valor + " realizada com sucesso!");
			return true;
		} else {
			System.out.println("Saldo insuficiente para a transferência de R$" + valor);
			return false;
		}
	}

	// Método para mostrar dados da conta
	public void mostrarDadosConta() {
		System.out.println("Número da conta: " + numeroConta);
		System.out.println("Nome do titular: " + titular.getNome());
		System.out.println("Saldo: R$" + saldo);
		System.out.println("Limite: R$" + limite);
	}

	// Método para alterar nome do titular e limite
	public void alterarDadosConta(String novoNome, double novoLimite) {
		titular.setNome(novoNome);
		limite = novoLimite;
		System.out.println("Dados da conta alterados com sucesso.");
	}

	// Método para excluir conta (se desejar implementar)
	public void excluirConta() {
		// Implemente a lógica para excluir a conta, se necessário
		System.out.println("Conta excluída com sucesso.");
	}
}
