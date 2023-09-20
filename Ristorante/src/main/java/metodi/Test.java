package metodi;

import model.Amministratore;

public class Test {
	
	public static void main(String[] args) {
		AmministratoreDao amm = new AmministratoreDao();
		Amministratore amminis = new Amministratore();
		amminis.setId_ammi(1);
		amminis.setNome("Javier");
		amminis.setCognome("acosta");
		amminis.setUsername("chico230");
		amminis.setPassword("1234");
		
		amm.inserire(amminis);
		//amm.modifica(amminis);
		amm.lista().stream().forEach(li-> System.out.println(li.getNome()));
		
	}

}
