package model;

import java.sql.SQLException;
import java.util.Date;

import bean.UserBean;
import dao.H2UserDAO;
import dao.UserDAO;
import error.IdUnavailableException;

public class UserLogic {
	
	public void subscribe(String userId, String password) throws IdUnavailableException, SQLException {
		UserDAO userDao = new H2UserDAO();
		
		if (userDao.selectById(userId) != null) {
			throw new IdUnavailableException();
		}
		
		userDao.insert(new UserBean(userId, password, new Date().toString()));
	}

}
