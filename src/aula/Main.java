package aula;

public class Main {

	public static void main(String[] args) {
		
		Vendedor vendedor1 = new Vendedor("Maria Silva", "111.111.111-1");
		Vendedor vendedor2 = new Vendedor("Paulo Rocha", "222.222.222-2");
		
		Carro carro1 = new Carro("VW","Fox","Preto",vendedor1);
		Carro carro2 = new Carro("Chevrolet", "Onix", "Prata", vendedor2);
		Carro carro3 = new Carro("Fiat", "Palio", "Azul", vendedor1);
		
		
		System.out.println("Marca: " + carro1.getMarca());
		System.out.println("Modelo: " + carro1.getModelo());
		System.out.println("Cor: " + carro1.getCor());
		System.out.println("Vendedor: " + carro1.getVendedor().getNome());
		System.out.println("RG: " + carro1.getVendedor().getRg());
		System.out.println();
		
		System.out.println("Marca: " + carro2.getMarca());
		System.out.println("Modelo:" + carro2.getModelo());
		System.out.println("Cor: " + carro2.getCor());
		System.out.println("Vendedor: " +carro2.getVendedor().getNome());
		System.out.println("RG: " +carro2.getVendedor().getRg());
		System.out.println();
		
		System.out.println("Marca: " + carro3.getMarca());
		System.out.println("Modelo:" + carro3.getModelo());
		System.out.println("Cor: " + carro3.getCor());
		System.out.println("Vendedor: " +carro3.getVendedor().getNome());
		System.out.println("RG: " +carro3.getVendedor().getRg());

		
	}

}
