package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void Salvar(Userposjava userposjava) {
		try {
			
			String sql = "insert into userposjava (id,nome,email) values (?,?)";
			/*PreparedStatement faz a operação no banco*/
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();//salva no banco
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public List<Userposjava> listar () throws SQLException {
		List<Userposjava> list = new ArrayList<Userposjava>();
		String sql = "Select * from userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			list.add(userposjava);
		}
		return list;
		
		
	}
	
	public Userposjava buscar (Long id) throws SQLException {
		Userposjava retorno = new Userposjava();
		String sql = "Select * from userposjava where id ="+ id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		}
		return retorno;
		
		
	}

	public void atualizar(Userposjava userposjava) throws SQLException {
		String sql ="update userposjava set email = ? where id ="+userposjava.getId();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userposjava.getEmail());
		statement.execute();
		connection.commit();
		
	}
	
	public void deletar(Long id) {
		try {
			String sql = "delete from userposjava where id="+id;
			PreparedStatement statment = connection.prepareStatement(sql);
			statment.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
