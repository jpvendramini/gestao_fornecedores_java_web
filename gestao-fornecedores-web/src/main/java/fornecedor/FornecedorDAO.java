package fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import contato.Contato;
import contato.ContatoDAO;
import contato.Email;
import contato.Telefone;
import dao.DAO;
import dao.FactoryDAO;
import endereco.Cidade;
import endereco.Endereco;
import endereco.EnderecoDAO;
import endereco.Pais;
import endereco.UF;
import produto.Produto;
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
						
			if(fornecedor.getContato().getTelefone() != null) {
				ContatoDAO.createTelefone(fornecedor.getContato().getTelefone(), fornecedorId);
			}
						
			if(fornecedor.getContato().getEmail() != null) {
				ContatoDAO.createEmail(fornecedor.getContato().getEmail(), fornecedorId);
			}	
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
		String sql = "SELECT fnc_nome_fantasia, t.tlf_numero, e.eml_email, pdt_tipo, edc_descricao, edc_bairro, cdd_descricao, uf_descricao, pas_descricao \r\n"
				+ "FROM fornecedor\r\n"
				+ "JOIN telefone_fornecedor tf ON fornecedor.fnc_id = tf.fnc_id\r\n"
				+ "JOIN telefone t ON tf.tlf_id = t.tlf_id\r\n"
				+ "JOIN email_fornecedor et ON fornecedor.fnc_id = et.fnc_id\r\n"
				+ "JOIN email e ON et.eml_id = e.eml_id\r\n"
				+ "JOIN produto ON produto.pdt_id = fornecedor.pdt_id\r\n"
				+ "JOIN endereco ON endereco.edc_id = fornecedor.edc_id\r\n"
				+ "JOIN cidade ON cidade.edc_id = endereco.edc_id\r\n"
				+ "JOIN uf ON uf.cdd_id = cidade.cdd_id\r\n"
				+ "JOIN pais ON pais.uf_id = uf.uf_id;";
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Connection conn;
		try {
			conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Email email = new Email();
				email.setDescricao(rs.getString("eml_email"));
				Endereco end = new Endereco(rs.getString("edc_descricao"), rs.getString("edc_bairro"),new Cidade(rs.getString("cdd_descricao")), new UF(rs.getString("uf_descricao")), new Pais(rs.getString("pas_descricao")));
				Produto prod = new Produto(rs.getString("pdt_tipo"), null);
				Contato cont = new Contato(email, new Telefone(rs.getString("tlf_numero")));
				
				fornecedores.add(new Fornecedor(rs.getString("fnc_nome_fantasia"), end, prod, cont));							
			}		
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		
		return fornecedores;
	}

	@Override
	public void edit(Fornecedor fornecedor) {
		// TODO Auto-generated method stub
		
	}

}
