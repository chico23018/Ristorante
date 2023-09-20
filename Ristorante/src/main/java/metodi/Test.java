package metodi;

public class Test {

	public static void main(String[] args) {

		PagamentoDao dao = new PagamentoDao();
		dao.lista().stream().forEach(lis->System.out.println(lis.getData()));
	}

}
