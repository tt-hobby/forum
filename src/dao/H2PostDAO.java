package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PostBean;

public class H2PostDAO implements PostDAO {
	
	private final String URL = ""/* url of database */;
	private final String USER_NAME = ""/* username of database */;
	private final String PASSWORD = ""/* password of database */;
	private final String TABLE_NAME = "POSTS";

	@Override
	public List<PostBean> selectAll() throws SQLException {
		Connection connection = this.createConnection();
		
		String sql = String.format("SELECT * FROM %s;", TABLE_NAME);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		
		List<PostBean> posts = new ArrayList<PostBean> ();
		while (result.next()) {
			String resultPostId = result.getString("POST_ID");
			String resultUserId = result.getString("USER_ID");
			String resultContent = result.getString("CONTENT");
			String resultTimeStamp = result.getString("TIME_STAMP");
			posts.add(new PostBean(resultPostId, resultUserId, resultContent, resultTimeStamp));
		}
		
		connection.close();
		return posts;
	}

	@Override
	public void insert(PostBean post) throws SQLException {
		Connection connection = this.createConnection();
		
		String sql = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', '%s');", TABLE_NAME, post.getPostId(), post.getUserId(), post.getContent(), post.getTimeStamp());
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		connection.close();
	}
	
	private Connection createConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		return connection;
	}

}
