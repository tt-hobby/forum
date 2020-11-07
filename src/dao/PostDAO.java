package dao;

import java.sql.SQLException;
import java.util.List;

import bean.PostBean;

public interface PostDAO {
	
	List<PostBean> selectAll() throws SQLException;
	
	void insert(PostBean post) throws SQLException;

}
