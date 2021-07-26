package com.hamit.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.hamit.util.DatabaseUtil;

public interface IDaoImplements<T> {
	void create(T t);

	void update(T t);

	void delete(long id);

	ArrayList<T> list();

	default Connection dbConnection() {
		DatabaseUtil databaseUtil = new DatabaseUtil();
		return databaseUtil.databaseConnectionDb();
	}
}
