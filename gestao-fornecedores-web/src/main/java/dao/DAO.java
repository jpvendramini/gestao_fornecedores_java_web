package dao;

import java.util.List;

public interface DAO<T> {
	void create(T t);
	void delete();
	List<T> findAll();
	void edit(T t);
}