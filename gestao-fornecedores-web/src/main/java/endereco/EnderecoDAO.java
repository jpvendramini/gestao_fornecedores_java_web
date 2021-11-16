package endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.IDAO;
import dao.FactoryDAO;

public class EnderecoDAO implements IDAO<Endereco>{

	public static long createEndereco(Endereco endereco) {
		long enderecoId = 0;
		try {
			String enderecoSql = "INSERT INTO endereco(edc_bairro, edc_numero, edc_cep, edc_descricao) VALUES(?, ?, ?, ?)";
			String cidadeSql =  "INSERT INTO cidade(cdd_descricao, edc_id) VALUES(?, ?)";
			String ufSql = "INSERT INTO uf(uf_descricao, cdd_id) VALUES(?, ?)";
			String paisSql = "INSERT INTO pais(pas_descricao, uf_id) VALUES(?, ?)";
			
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(enderecoSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getBairro());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getCep());
			stmt.setString(4, endereco.getDescricao());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				enderecoId = rs.getLong(1); 
			}
			
			stmt = conn.prepareStatement(cidadeSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getCidade().getDescricao());
			stmt.setLong(2, enderecoId);
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			long cidadeId = 0;
			while(rs.next()) {
				cidadeId = rs.getLong(1); 
			}
			
			stmt = conn.prepareStatement(ufSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getUf().getDescricao());
			stmt.setLong(2, cidadeId);
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			long ufId = 0;
			while(rs.next()) {
				ufId = rs.getLong(1); 
			}
			
			stmt = conn.prepareStatement(paisSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, endereco.getPais().getDescricao());
			stmt.setLong(2, ufId);
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enderecoId;
		
	}
	
	public static void createCidade() {
		
	}
	
	public static void createUF() {
		
	}
	
	public static void createPais() {
		
	}
	
	
	@Override
	public void create(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Endereco> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Endereco endereco) {
		// TODO Auto-generated method stub
		
	}

}
