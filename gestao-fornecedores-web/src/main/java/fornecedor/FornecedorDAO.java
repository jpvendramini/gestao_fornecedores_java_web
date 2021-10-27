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
import contato.TipoTelefone;
import dao.DAO;
import dao.FactoryDAO;
import endereco.Cidade;
import endereco.Endereco;
import endereco.EnderecoDAO;
import endereco.Pais;
import endereco.UF;
import produto.Produto;
import produto.ProdutoDAO;
import produto.TipoProduto;

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
	
	public Fornecedor findById(Long id) {
		String sql = "SELECT * \r\n"
				+ "FROM fornecedor\r\n"
				+ "JOIN telefone_fornecedor tf ON fornecedor.fnc_id = tf.fnc_id\r\n"
				+ "JOIN telefone t ON tf.tlf_id = t.tlf_id\r\n"
				+ "JOIN email_fornecedor et ON fornecedor.fnc_id = et.fnc_id\r\n"
				+ "JOIN email e ON et.eml_id = e.eml_id\r\n"
				+ "JOIN produto ON produto.pdt_id = fornecedor.pdt_id\r\n"
				+ "JOIN endereco ON endereco.edc_id = fornecedor.edc_id\r\n"
				+ "JOIN cidade ON cidade.edc_id = endereco.edc_id\r\n"
				+ "JOIN uf ON uf.cdd_id = cidade.cdd_id\r\n"
				+ "JOIN pais ON pais.uf_id = uf.uf_id WHERE fornecedor.fnc_id = 20;";
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Connection conn;
		Fornecedor forn = null;
		try {
			conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Email email = new Email();
				email.setDescricao(rs.getString("eml_email"));
				email.setId(rs.getLong("eml_id"));
				Telefone tel = new Telefone(rs.getInt("tlf_codigo"), rs.getInt("tlf_ddd"), rs.getString("tlf_numero"), TipoTelefone.CELULAR);
				tel.setId(rs.getLong("tlf_id"));
				Contato cont = new Contato(email, tel);
				
				Pais pais = new Pais(rs.getString("pas_descricao"));
				pais.setId(rs.getLong("pas_id"));
				
				UF uf = new UF(rs.getString("uf_descricao"));
				uf.setId(rs.getLong("uf_id"));
				
				Cidade cidade = new Cidade(rs.getString("cdd_descricao"));
				cidade.setId(rs.getLong("cdd_id"));
				
				Endereco end = new Endereco(rs.getString("edc_descricao"), rs.getString("edc_bairro"), rs.getString("edc_numero"), rs.getString("edc_cep"), cidade, uf, pais);
				end.setId(rs.getLong("edc_id"));
				
				Produto prod = new Produto(rs.getString("pdt_tipo"), TipoProduto.PRODUTO);
				prod.setId(rs.getLong("pdt_id"));
				
				forn = new Fornecedor(rs.getString("fnc_nome_fantasia"), end, prod, cont);
				forn.setId(rs.getLong("fnc_id"));				
				return forn;						
			}		
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return forn;		
	}
	

	@Override
	public List<Fornecedor> findAll() {
		String sql = "SELECT * \r\n"
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
				email.setId(rs.getLong("eml_id"));
				Telefone tel = new Telefone(rs.getInt("tlf_codigo"), rs.getInt("tlf_ddd"), rs.getString("tlf_numero"), TipoTelefone.CELULAR);
				tel.setId(rs.getLong("tlf_id"));
				Contato cont = new Contato(email, tel);
				
				Pais pais = new Pais(rs.getString("pas_descricao"));
				pais.setId(rs.getLong("pas_id"));
				
				UF uf = new UF(rs.getString("uf_descricao"));
				uf.setId(rs.getLong("uf_id"));
				
				Cidade cidade = new Cidade(rs.getString("cdd_descricao"));
				cidade.setId(rs.getLong("cdd_id"));
				
				Endereco end = new Endereco(rs.getString("edc_descricao"), rs.getString("edc_bairro"), rs.getString("edc_numero"), rs.getString("edc_cep"), cidade, uf, pais);
				end.setId(rs.getLong("edc_id"));
				
				Produto prod = new Produto(rs.getString("pdt_tipo"), TipoProduto.PRODUTO);
				prod.setId(rs.getLong("pdt_id"));
				
				Fornecedor forn = new Fornecedor(rs.getString("fnc_nome_fantasia"), end, prod, cont);
				forn.setId(rs.getLong("fnc_id"));				
				fornecedores.add(forn);							
			}		
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		
		return fornecedores;
	}

	@Override
	public void edit(Fornecedor fornecedor) {
		String atualizarFornecedor = "UPDATE fornecedor\r\n"
				+ "SET fnc_cnpj = ?, fnc_inscricao_estadual = ?, fnc_inscricao_municipal = ?, fnc_nome_fantasia = ?, fnc_razao_social = ?\r\n"
				+ "WHERE fnc_id = ?";
		String atualizaCnae = "UPDATE cnae \r\n"
				+ "SET cne_descricao = ?\r\n"
				+ "WHERE cne_id = ?";
		String atualizaProduto = "UPDATE produto\r\n"
				+ "SET pdt_tipo = ?\r\n"
				+ "WHERE pdt_id = ?";
		String atualizaEndereco = "UPDATE endereco\r\n"
				+ "SET edc_bairro = ?, edc_numero = ?, edc_cep = ?, edc_descricao = ?\r\n"
				+ "WHERE edc_id = ?";
		String atualizaCidade = "UPDATE cidade\r\n"
				+ "SET cdd_descricao = ?\r\n"
				+ "WHERE cdd_id = ?";
		String atualizaUF = "UPDATE uf\r\n"
				+ "SET uf_descricao = ?\r\n"
				+ "WHERE uf_id = ?";
		String atualizaPais = "UPDATE pais\r\n"
				+ "SET pas_descricao = ?\r\n"
				+ "WHERE pas_id = ?";
		String atualizaEmail = "UPDATE email\r\n"
				+ "SET eml_email = ?\r\n"
				+ "WHERE eml_id = ?";
		String atualizaTelefone = "\r\n"
				+ "UPDATE telefone\r\n"
				+ "SET tlf_codigo = ?, tlf_ddd = ?, tlf_numero = ?, tlf_tipo = ?\r\n"
				+ "WHERE tlf_id = ?";
	}

}
