package fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import contato.Telefone;
import dao.DAO;
import dao.FactoryDAO;
import endereco.Cidade;

public class FornecedorDAO implements DAO<Fornecedor>{
	@Override
	public void create(Fornecedor fornecedor) {
		String emailSql = "INSERT INTO email(eml_email) VALUES(?)";
		String emailForSql = "INSERT INTO email_fornecedor(fnc_id, eml_id) VALUES(?, ?)";
		String telefoneSql = "INSERT INTO telefone(tlf_codigo, tlf_ddd, tlf_numero, tlf_tipo) VALUES(?, ?, ?, ?)";
		String telefoneForSql = "INSERT INTO telefone_fornecedor(fnc_id, tlf_id) VALUES(?, ?)";
		String cnaeSql = "INSERT INTO cnae(cne_descricao) VALUES(?)";
		String produtoSql = "INSERT INTO produto(descricao, pdt_tipo) VALUES(?, ?)";
		
		String enderecoSql = "INSERT INTO endereco(edc_bairro, edc_numero, edc_cep, edc_descricao) VALUES(?, ?, ?, ?)";
		String cidadeSql =  "INSERT INTO cidade(cdd_descricao, edc_id) VALUES(?, ?)";
		String ufSql = "INSERT INTO uf(uf_descricao, cdd_id) VALUES(?, ?)";
		String paisSql = "INSERT INTO pais(pas_descricao, uf_id) VALUES(?, ?)";
		
		String fornecedorSql = "INSERT INTO fornecedor(fnc_cnpj, fnc_inscricao_estadual, fnc_inscricao_municipal, fnc_nome_fantasia, fnc_razao_social) VALUES(?, ?, ?, ?, ?)";
		
		try {
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(emailSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, "amanda@gmail.com");
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			long emailId = 0;
			while(rs.next()) {
				emailId = rs.getLong(1); 
				System.out.println(rs.getLong(1));	
			}
			
			stmt = conn.prepareStatement(telefoneSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, 55);
			stmt.setString(2, "11");
			stmt.setString(3, "9918718712");
			stmt.setString(4, "CELULAR");
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			long telefoneId = 0;
			while(rs.next()) {
				telefoneId = rs.getLong(1); 
			}
			
			stmt = conn.prepareStatement(fornecedorSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, 12312312);
			stmt.setString(2, "2131231231");
			stmt.setString(3, "4134343433");
			stmt.setString(4, "Dunder Mifflin");
			stmt.setString(5, "Dunder mifflin lta");
//			stmt.setLong(6, Null);
//			stmt.setLong(7, null);
//			stmt.setLong(8, null);
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			long fornecedorId = 0;
			while(rs.next()) {
				fornecedorId = rs.getLong(1); 
			}
			
			stmt = conn.prepareStatement(emailForSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, fornecedorId);
			stmt.setLong(2, emailId);
			stmt.execute();
			
			stmt = conn.prepareStatement(telefoneForSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, fornecedorId);
			stmt.setLong(2, telefoneId);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

}
