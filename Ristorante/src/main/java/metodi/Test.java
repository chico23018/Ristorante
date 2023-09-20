package metodi;

public class Test {

	public static void main(String[] args) {
		
		TavoloDao tavoloDao = new TavoloDao();
		tavoloDao.lista().stream().forEach(lis-> System.out.println(lis.getId_camerie()));
	}

}
