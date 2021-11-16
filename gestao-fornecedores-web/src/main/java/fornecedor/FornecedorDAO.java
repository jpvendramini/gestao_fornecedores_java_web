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
import dao.IDAO;
import dao.FactoryDAO;
import endereco.Cidade;
import endereco.Endereco;
import endereco.EnderecoDAO;
import endereco.Pais;
import endereco.UF;
import produto.Produto;
import produto.ProdutoDAO;
import produto.TipoProduto;

public class FornecedorDAO implements IDAO<Fornecedor>{
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
			stmt.setString(1, fornecedor.getCnpj());
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
	public void delete(Fornecedor f) {
		Connection conn;
		String deleteCnae = "DELETE FROM cnae WHERE cne_id = ?";
		String deleteProduto= "DELETE FROM produto WHERE pdt_id = ?";
		String deletePais = "DELETE FROM pais WHERE pas_id = ?";
		String deleteUf = "DELETE FROM uf WHERE uf_id = ?";
		String deleteCidade = "DELETE FROM cidade WHERE cdd_id = ?";
		String deleteEndereco= "DELETE FROM endereco WHERE edc_id = ?";
		String deleteTeleF= "DELETE FROM telefone_fornecedor WHERE tlf_id = ?";
		String deleteTelefone= "DELETE FROM telefone WHERE tlf_id= ?";
		String deleteEmailF= "DELETE FROM email_fornecedor WHERE eml_id = ?";
		String deleteEmail= "DELETE FROM email WHERE eml_id = ?";		
		String deleteFornecedor= "DELETE FROM fornecedor WHERE fnc_id = ?";
		try {
			conn = FactoryDAO.getConnection();
			PreparedStatement stmt = null;
			
			stmt = conn.prepareStatement(deletePais);
			stmt.setLong(1, f.getEndereco().getPais().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteUf);
			stmt.setLong(1, f.getEndereco().getUf().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteCidade);
			stmt.setLong(1, f.getEndereco().getCidade().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteTeleF);
			stmt.setLong(1, f.getContato().getTelefone().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteTelefone);
			stmt.setLong(1, f.getContato().getTelefone().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteEmailF);
			stmt.setLong(1, f.getContato().getEmail().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteEmail);
			stmt.setLong(1, f.getContato().getEmail().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteFornecedor);
			stmt.setLong(1, f.getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteCnae);
			stmt.setLong(1, f.getCnae().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteProduto);
			stmt.setLong(1, f.getProduto().getId());
			stmt.execute();
			
			stmt = conn.prepareStatement(deleteEndereco);
			stmt.setLong(1, f.getEndereco().getId());
			stmt.execute();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				+ "JOIN cnae ON cnae.cne_id = fornecedor.cne_id\r\n"
				+ "JOIN pais ON pais.uf_id = uf.uf_id WHERE fornecedor.fnc_id = ?;";
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		Connection conn;
		Fornecedor forn = null;
		try {
			conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Email email = new Email();
				email.setDescricao(rs.getString("eml_email"));
				email.setId(rs.getLong("eml_id"));
				Telefone tel = new Telefone(rs.getString("tlf_codigo"), rs.getString("tlf_ddd"), rs.getString("tlf_numero"), TipoTelefone.CELULAR);
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
				
				CNAE cnae = new CNAE(rs.getString("cne_descricao"));				
				cnae.setId(rs.getLong("cne_id"));
				
				forn = new Fornecedor(rs.getString("fnc_cnpj"),rs.getString("fnc_inscricao_estadual"),rs.getString("fnc_inscricao_municipal"),rs.getString("fnc_nome_fantasia"),rs.getString("fnc_razao_social"), end, cont, cnae, Status.RASCUNHO, prod);
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
				Telefone tel = new Telefone(rs.getString("tlf_codigo"), rs.getString("tlf_ddd"), rs.getString("tlf_numero"), TipoTelefone.CELULAR);
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
	public void edit(Fornecedor f) {
		try {
			String atualizarFornecedor = "UPDATE fornecedor\r\n"
					+ "SET fnc_cnpj = ?, fnc_inscricao_estadual = ?, fnc_inscricao_municipal = ?, fnc_nome_fantasia = ?, fnc_razao_social = ?\r\n"
					+ "WHERE fnc_id = ?";
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(atualizarFornecedor);
			stmt.setString(1, f.getCnpj());
			stmt.setString(2, f.getInscricaoEstadual());
			stmt.setString(3, f.getInscricaoMunicipal());
			stmt.setString(4, f.getNomeFantasia());
			stmt.setString(5, f.getRazaoSocial());
			stmt.setLong(6, f.getId());
			stmt.execute();
			stmt.close();
			
			String atualizaCnae = "UPDATE cnae \r\n"
					+ "SET cne_descricao = ?\r\n"
					+ "WHERE cne_id = ?";
			stmt = conn.prepareStatement(atualizaCnae);
			stmt.setString(1, f.getCnae().getDescricao());
			stmt.setLong(2, f.getCnae().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaProduto = "UPDATE produto\r\n"
					+ "SET pdt_tipo = ?\r\n"
					+ "WHERE pdt_id = ?";
			stmt = conn.prepareStatement(atualizaProduto);
			stmt.setString(1, f.getProduto().getDescricao());
			stmt.setLong(2, f.getProduto().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaEndereco = "UPDATE endereco\r\n"
					+ "SET edc_bairro = ?, edc_numero = ?, edc_cep = ?, edc_descricao = ?\r\n"
					+ "WHERE edc_id = ?";
			stmt = conn.prepareStatement(atualizaEndereco);
			stmt.setString(1, f.getEndereco().getBairro());
			stmt.setString(2, f.getEndereco().getNumero());
			stmt.setString(3, f.getEndereco().getCep());
			stmt.setString(4, f.getEndereco().getDescricao());
			stmt.setLong(5, f.getEndereco().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaCidade = "UPDATE cidade\r\n"
					+ "SET cdd_descricao = ?\r\n"
					+ "WHERE cdd_id = ?";
			stmt = conn.prepareStatement(atualizaCidade);
			stmt.setString(1, f.getEndereco().getCidade().getDescricao());
			stmt.setLong(2, f.getEndereco().getCidade().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaUF = "UPDATE uf\r\n"
					+ "SET uf_descricao = ?\r\n"
					+ "WHERE uf_id = ?";
			stmt = conn.prepareStatement(atualizaUF);
			stmt.setString(1, f.getEndereco().getUf().getDescricao());
			stmt.setLong(2, f.getEndereco().getUf().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaPais = "UPDATE pais\r\n"
					+ "SET pas_descricao = ?\r\n"
					+ "WHERE pas_id = ?";
			stmt = conn.prepareStatement(atualizaPais);
			stmt.setString(1, f.getEndereco().getPais().getDescricao());
			stmt.setLong(2, f.getEndereco().getPais().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaEmail = "UPDATE email\r\n"
					+ "SET eml_email = ?\r\n"
					+ "WHERE eml_id = ?";
			stmt = conn.prepareStatement(atualizaEmail);
			stmt.setString(1, f.getContato().getEmail().getDescricao());
			stmt.setLong(2, f.getContato().getEmail().getId());
			stmt.execute();
			stmt.close();
			
			String atualizaTelefone = "\r\n"
					+ "UPDATE telefone\r\n"
					+ "SET tlf_codigo = ?, tlf_ddd = ?, tlf_numero = ?, tlf_tipo = ?\r\n"
					+ "WHERE tlf_id = ?";
			stmt = conn.prepareStatement(atualizaTelefone);
			stmt.setString(1, f.getContato().getTelefone().getCodigo());
			stmt.setString(2, f.getContato().getTelefone().getDdd());
			stmt.setString(3, f.getContato().getTelefone().getNumber());
			stmt.setString(4, f.getContato().getTelefone().getTipo().name());
			stmt.setLong(5, f.getContato().getTelefone().getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Fornecedor atualizado com sucesso!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
