package controller;

import java.util.List;

public interface Controller<T> {
	void create(T t);
	void delete(T t);
	List<T> findAll();
	void edit(T t);
}
