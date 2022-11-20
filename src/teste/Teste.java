package teste;

import database.DBQuery;

public class Teste {

	public static void main(String[] args) {
		String[] fields = new String[]{"usuario", "senha"};
		DBQuery query = new DBQuery("teste","usuario,senha","1");
		query.insert(fields);
		
		query.update(fields);
	}
	
}