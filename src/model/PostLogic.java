package model;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import bean.PostBean;
import dao.H2PostDAO;
import dao.H2UserDAO;
import dao.PostDAO;
import dao.UserDAO;
import error.UserUnfoundException;

public class PostLogic {
	
	public List<PostBean> getAll() throws SQLException {
		PostDAO postDao = new H2PostDAO();
		return postDao.selectAll();
	}
	
	public void post(String userId, String content) throws UserUnfoundException, SQLException {
		PostDAO postDao = new H2PostDAO();
		UserDAO userDao = new H2UserDAO();
		
		if (userDao.selectById(userId) == null) {
			throw new UserUnfoundException();
		}
		
		postDao.insert(new PostBean(UUID.randomUUID().toString(), userId, content, new Date().toString()));
	}

}
