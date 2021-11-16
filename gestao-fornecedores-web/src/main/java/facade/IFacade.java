package facade;

import java.util.List;

public interface IFacade<T> {
	void create(T t);
	void delete(T t);
	List<T> findAll();
	void edit(T t);
}
