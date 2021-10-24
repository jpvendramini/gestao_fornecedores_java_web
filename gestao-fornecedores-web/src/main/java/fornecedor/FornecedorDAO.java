package fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import contato.ContatoDAO;
import dao.DAO;
import dao.FactoryDAO;
import endereco.EnderecoDAO;
import produto.ProdutoDAO;

public class FornecedorDAO implements DAO<Fornecedor>{
	@Override
	public void create(Fornecedor fornecedor) {		
		String fornecedorSql = "INSERT INTO fornecedor(fnc_cnpj, fnc_inscricao_estadual, fnc_inscricao_municipal, fnc_nome_fantasia, fnc_razao_social, cne_id, pdt_id, edc_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {								
			Connection conn = FactoryDAO.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(fornecedorSql, Statement.RETURN_GENERATED_KEYS);
			
			
			long enderecoId = EnderecoDAO.createEndereco(fornecedor.getEndereco());
										
			long cnaeId = CNAEDAO.insertCnae(fornecedor.getCnae());
			
			long produtoId = ProdutoDAO.insertProduto(fornecedor.getProduto());
			
			ResultSet rs = stmt.getGeneratedKeys();
			stmt = conn.prepareStatement(fornecedorSql, Statement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, fornecedor.getCnpj());
			stmt.setString(2, fornecedor.getInscricaoEstadual());
			stmt.setString(3, fornecedor.getInscricaoMunicipal());
			stmt.setString(4, fornecedor.getNomeFantasia());
			stmt.setString(5, fornecedor.getRazaoSocial());
			stmt.setLong(6, cnaeId);
			stmt.setLong(7, produtoId);
			stmt.setLong(8, enderecoId);
			stmt.execute();
			
			rs = stmt.getGeneratedKeys();
			
			long fornecedorId = 0;
			while(rs.next()) {
				fornecedorId = rs.getLong(1); 
			}
						
//			if(fornecedor.getContato().getTelefone() != null) {
//				ContatoDAO.createTelefone(fornecedor.getContato().getTelefone(), fornecedorId);
//			}
//						
//			if(fornecedor.getContato().getEmail() != null) {
//				ContatoDAO.createEmail(fornecedor.getContato().getEmail(), fornecedorId);
//			}	
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
