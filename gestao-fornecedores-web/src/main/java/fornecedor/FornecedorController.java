package fornecedor;

import java.util.List;

import controller.Controller;
import dao.DAO;

public class FornecedorController implements Controller<Fornecedor>{

	DAO<Fornecedor> fornecedorDAO = new FornecedorDAO();
	
	@Override
	public void create(Fornecedor fornecedor) {		
		fornecedorDAO.create(fornecedor);
		System.out.println(fornecedorDAO.findAll());		
	}

	@Override
	public void delete(Fornecedor object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Fornecedor> findAll() {		
		return fornecedorDAO.findAll();
	}

	@Override
	public void edit(Fornecedor object) {
		// TODO Auto-generated method stub
		
	}

}
