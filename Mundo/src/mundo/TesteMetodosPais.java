package mundo;

import java.util.ArrayList;

public class TesteMetodosPais {

	public static void main(String[] args) {
				
		MetodosPais metodosPais = new MetodosPais();
		Pais pais = new Pais();
		ArrayList<Pais> vet = new ArrayList<Pais>();
						
		pais = metodosPais.maiorPop();
		System.out.println("O pais com maior populacao eh: " + pais);
		
		pais = metodosPais.menorArea();
		System.out.println("O pais com menor area eh: " + pais);
		
		vet = metodosPais.vetPais();
		
		for(Pais p:vet) {
			System.out.println(p);
		}
		
	}
}
