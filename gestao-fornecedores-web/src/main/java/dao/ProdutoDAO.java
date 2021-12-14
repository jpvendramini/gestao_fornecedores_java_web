package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import application.Dominio;
import dominio.Produto;

public class ProdutoDAO implements IDAO{
	
	
	public static long insertProduto(Produto produto) {
		String produtoSql = "INSERT INTO produto(pdt_tipo) VALUES(?)";
		long produtoId = 0;
		try {
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(produtoSql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, produto.getDescricao());
//			stmt.setString(2, produto.getTipoProduto().name());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				produtoId = rs.getLong(1); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produtoId;
	}

	@Override
	public void create(Dominio dominio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Dominio dominio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Dominio> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Dominio dominio) {
		// TODO Auto-generated method stub
		
	}

}
