package dao;

import java.sql.SQLException;

import bean.UserBean;

public interface UserDAO {
	
	UserBean selectById(String userId) throws SQLException;
	
	void insert(UserBean user) throws SQLException; 
	
	void deleteById(String userId) throws SQLException;

}
