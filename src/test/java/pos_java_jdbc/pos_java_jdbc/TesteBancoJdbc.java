package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@Test//esta notação é para poder executar o método diretamente
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
	
	@Test
	public void testInsertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("(13) 9821-3509");
		telefone.setTipo("Celular");
		telefone.setUsuario(2L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void testeCarregaFoneUser() {
		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUseFones = dao.listaUserFone(1L);
		for (BeanUserFone beanUserFone : beanUseFones) {
			System.out.println(beanUserFone);
			System.out.println("-------------------------------");
		}
	}
}
