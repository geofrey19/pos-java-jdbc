package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import junit.framework.TestCase;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test//essa notação é para poder executar o método diretamente
	public void initBanco() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("Suzana Frey");
		userposjava.setEmail("sufrey@yaho.com.br");
		
		userPosDAO.Salvar(userposjava);
		
	}
	
	@Test
	public void initListar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			
			Userposjava userposjava = dao.buscar(3L);
			System.out.println(userposjava);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava objetoBanco = dao.buscar(4L);
			objetoBanco.setEmail("sufrey@yahoo.com.br");
			dao.atualizar(objetoBanco);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(3L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
