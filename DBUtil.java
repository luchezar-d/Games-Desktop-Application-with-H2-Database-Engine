
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn = null;

	public static Connection getConnected() {

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/CarDB", "sa", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	public static MyModel getAllModel() {

		conn = getConnected();
		String sql = "SELECT GAME_ID,TITLE,NAME,YEAR,FNAME,LNAME FROM GAMEZ G JOIN CREATOR C ON G.CREATOR_ID = C.Creator_ID JOIN TYPE T ON G.TYPE_ID = T.TYPE_ID";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}
	public static MyModel getAll() {

		conn = getConnected();
		String sql = "Select * from type;";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static MyModel getAllCreator() {

		conn = getConnected();
		String sql = "select * from creator;";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static MyModel getAllType() {

		conn = getConnected();
		String sql = "select * from type;";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static MyModel getAllVisible() {

		conn = getConnected();
		String sql = "SELECT GAME_ID,TITLE,YEAR,FNAME,LNAME FROM GAMEZ G JOIN CREATOR C ON G.CREATOR_ID = C.CREATOR_ID JOIN TYPE T ON G.TYPE_ID = T.TYPE_ID";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;

	}

	public static MyModel getComplexSorting(int year,String type) {

		conn = getConnected();
		
		

		String sql = "SELECT  TITLE,YEAR, NAME FROM TYPE T JOIN GAMEZ G ON T.TYPE_ID = G.TYPE_ID WHERE YEAR=" + year
				+ "AND NAME='" + type + "';";
		ResultSet result = null;
		MyModel model = null;

		try {
			PreparedStatement state = conn.prepareStatement(sql);
			result = state.executeQuery();
			model = new MyModel(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return model;
	}

}


