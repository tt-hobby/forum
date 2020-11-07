package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserBean;

public class H2UserDAO implements UserDAO {
	
	private final String URL = "jdbc:h2:tcp://localhost/~/h2db/forum";
	private final String USER_NAME = "sa";
	private final String PASSWORD = "1234";
	private final String TABLE_NAME = "USERS";
	
	@Override
	public UserBean selectById(String userId) throws SQLException {
		Connection connection = this.createConnection();
		
		String sql = String.format("SELECT * FROM %s WHERE USER_ID = '%s';", TABLE_NAME, userId);
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		
		if (result.next()) {
			String resultUserId = result.getString("USER_ID");
			String resultPassword = result.getString("PASSWORD");
			String resultTimeStamp = result.getString("TIME_STAMP");
			connection.close();
			return new UserBean(resultUserId, resultPassword, resultTimeStamp);
		} else {
			connection.close();
			return null;
		}
	}

	@Override
	public void insert(UserBean user) throws SQLException {
		Connection connection = this.createConnection();

		String sql = String.format("INSERT INTO USERS VALUES ('%s', '%s', '%s');", user.getUserId(), user.getPassword(), user.getTimeStamp());
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		connection.close();
	}

	@Override
	public void deleteById(String userId) throws SQLException{
		Connection connection = this.createConnection();

		String sql = String.format("DELETE FROM %s WHERE USER_ID = '%s';", TABLE_NAME, userId);
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		connection.close();
	}
	
	private Connection createConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		return connection;
	}

}
