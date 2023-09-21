package metodi;

import model.Amministratore;
import model.Cameriere;

public class Test {

	public static void main(String[] args) {

		LoginDao dao = new LoginDao();

		if (dao.amministratore("m.rossi", "m.rossi") != null) {
			Amministratore m = dao.amministratore("m.rossi", "m.rossi");
			System.out.println("Ammi "+m.getNome());
		} else if (dao.cameriere("m.rossi", "m.rossi") != null) {
			Cameriere cam = dao.cameriere("m.rossi", "m.rossi");
			System.out.println("cam "+cam.getNome());
		}
	}

}
