package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import dao.UserPosDAO;
import junit.framework.TestCase;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(4L);
		userposjava.setNome("Suzana Frey");
		userposjava.setEmail("sufrey@yaho.com.br");
		
		userPosDAO.Salvar(userposjava);
		
	}
}
