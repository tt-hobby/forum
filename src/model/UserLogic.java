package model;

import java.sql.SQLException;
import java.util.Date;

import bean.UserBean;
import dao.H2UserDAO;
import dao.UserDAO;
import error.IdUnavailableException;
import error.UserUnfoundException;

public class UserLogic {
	
	public UserBean authenticate(String userId, String password) throws SQLException {
		UserDAO userDao = new H2UserDAO();
		UserBean user = userDao.selectById(userId);
		
		if (user != null) {
			if (userId.equals(user.getUserId()) && password.equals(user.getPassword())) {
				StringBuilder hiddenPassword = new StringBuilder();
				for (int i = 0; i < user.getPassword().length(); i++) {
					hiddenPassword.append("*");
				}
				user.setPassword(hiddenPassword.toString());
				return user;
			}
		}
		
		return null;
	}
	
	public void subscribe(String userId, String password) throws IdUnavailableException, SQLException {
		UserDAO userDao = new H2UserDAO();
		
		if (userDao.selectById(userId) != null) {
			throw new IdUnavailableException();
		}
		
		userDao.insert(new UserBean(userId, password, new Date().toString()));
	}
	
	public void unsubscribe(UserBean user) throws UserUnfoundException, SQLException {
		UserDAO userDao = new H2UserDAO();
		
		if (userDao.selectById(user.getUserId()) == null) {
			throw new UserUnfoundException();
		}
		
		userDao.deleteById(user.getUserId());
	}

}
