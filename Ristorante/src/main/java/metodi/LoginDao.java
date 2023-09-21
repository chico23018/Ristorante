package metodi;

import model.Amministratore;
import model.Cameriere;

public class LoginDao {
	private AmministratoreDao aDao = new AmministratoreDao();
	private CameriereDao dao = new CameriereDao();
	public Amministratore amministratore(String user,String password) {
		Amministratore amm = null;
		for(Amministratore me :aDao.lista()) {
			if (me.getUsername().equals(user)&& me.getPassword().equals(password)) {
				amm = me;
			}
		}
		return amm;
				
		
	}
	public Cameriere cameriere(String user,String password) {
		Cameriere cam= null;
		for(Cameriere ca:dao.lista()) {
			if(ca.getUsername().equals(user)&&ca.getPassword().equals(password)) {
				cam=ca;
			}
		}
		return cam;
		
	}

}
