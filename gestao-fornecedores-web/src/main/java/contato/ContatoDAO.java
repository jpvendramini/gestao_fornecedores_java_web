package contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.DAO;
import dao.FactoryDAO;

public class ContatoDAO implements DAO<Contato>{
	public static void createTelefone(Telefone telefone, long fornecedorId) {
		String telefoneSql = "INSERT INTO telefone(tlf_codigo, tlf_ddd, tlf_numero, tlf_tipo) VALUES(?, ?, ?, ?)";		
		String telefoneForSql = "INSERT INTO telefone_fornecedor(fnc_id, tlf_id) VALUES(?, ?)";
		long telefoneId = 0;
		try {
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(telefoneSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, telefone.getCodigo());
			stmt.setInt(2, telefone.getDdd());
			stmt.setString(3, telefone.getNumber());
			stmt.setString(4, telefone.getTipo().name());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			telefoneId = 0;
			while(rs.next()) {
				telefoneId = rs.getLong(1); 
			}
			stmt = conn.prepareStatement(telefoneForSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, fornecedorId);
			stmt.setLong(2, telefoneId);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static long createEmail(Email email, long fornecedorId) {
		String emailSql = "INSERT INTO email(eml_email) VALUES(?)";
		String emailForSql = "INSERT INTO email_fornecedor(fnc_id, eml_id) VALUES(?, ?)";
		long emailId = 0;
		try {
			Connection conn = FactoryDAO.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(emailSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, email.getDescricao());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			
			while(rs.next()) {
				emailId = rs.getLong(1); 
				System.out.println(rs.getLong(1));	
			}			
			stmt = conn.prepareStatement(emailForSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, fornecedorId);
			stmt.setLong(2, emailId);
			stmt.execute();
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return emailId;
	}
	
	
	@Override
	public void create(Contato contato) {
		
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Contato> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Contato contato) {
		// TODO Auto-generated method stub
		
	}

}
