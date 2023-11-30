package aula;

public class Carro {
	
//	Construtores
	public Carro(String marca, String modelo, String cor, Vendedor vendedor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.vendedor = vendedor;
	}
	
//	Propriedades ou Atributos
	private String marca;
	private String modelo;
	private String cor;
	private Vendedor vendedor;
	
//	Getters e Setters
	protected String getMarca() {
		return marca;
	}
	protected void setMarca(String marca) {
		this.marca = marca;
	}
	protected String getModelo() {
		return modelo;
	}
	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}
	protected String getCor() {
		return cor;
	}
	protected void setCor(String cor) {
		this.cor = cor;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}


}

