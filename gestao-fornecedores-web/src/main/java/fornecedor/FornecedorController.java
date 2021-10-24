package fornecedor;

import java.util.List;

import controller.Controller;
import dao.DAO;

public class FornecedorController implements Controller<Fornecedor>{

	@Override
	public void create(Fornecedor fornecedor) {
		DAO<Fornecedor> fornecedorDAO = new FornecedorDAO();
		fornecedorDAO.create(fornecedor);		
	}

	@Override
	public void delete(Fornecedor object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit(Fornecedor object) {
		// TODO Auto-generated method stub
		
	}

}
