package fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.DAO;
import dao.FactoryDAO;

public class CNAEDAO implements DAO<CNAE>{
	
	public static long insertCnae(CNAE cnae) {
		String cnaeSql = "INSERT INTO cnae(cne_descricao) VALUES(?)";
		long cnaeId = 0;
		try {
			Connection conn = FactoryDAO.getConnection();
			PreparedStatement stmt = conn.prepareStatement(cnaeSql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, cnae.getDescricao());
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			
			rs = stmt.getGeneratedKeys();
			
			while(rs.next()) {
				cnaeId = rs.getLong(1); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnaeId;
	}

	@Override
	public void create(CNAE cnae) {
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CNAE> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(CNAE t) {
		// TODO Auto-generated method stub
		
	}
	

}
