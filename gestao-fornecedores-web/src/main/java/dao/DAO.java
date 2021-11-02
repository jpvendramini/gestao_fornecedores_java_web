package dao;

import java.util.List;

public interface DAO<T> {
	void create(T t);
	void delete(T t);
	List<T> findAll();
	void edit(T t);
}