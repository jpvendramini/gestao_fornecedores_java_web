package fornecedor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.IDAO;
import facade.IFacade;
import strategy.IStrategy;

public class FornecedorFacade implements IFacade<Fornecedor>{

	FornecedorDAO fornecedorDAO = new FornecedorDAO();
	
	public Fornecedor getById(Long id) {
		return fornecedorDAO.findById(id);
	}
	
	@Override
	public void create(Fornecedor fornecedor) {
		Map<String, List<IStrategy>> strategies = new HashMap<String, List<IStrategy>>();
		fornecedorDAO.create(fornecedor);
		System.out.println(fornecedorDAO.findAll());		
	}

	@Override
	public void delete(Fornecedor f) {
		fornecedorDAO.delete(f);		
	}

	@Override
	public List<Fornecedor> findAll() {		
		return fornecedorDAO.findAll();
	}

	@Override
	public void edit(Fornecedor f) {
		fornecedorDAO.edit(f);
	}

}
