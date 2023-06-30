import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDOA {
	public static Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Logon", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static int insert(User u) {
		int status = 0;
		try {
			Connection con = UserDOA.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into user(Name,Password,email,mobile) values (?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setLong(4, u.getMobile());
			status = ps.executeUpdate();
			con.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int update(User u) {
		int status = 0;
		try {
			Connection con = UserDOA.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update user set Name=?,Password=?,email=?,mobile=? where Id=?;");
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setLong(4, u.getMobile());
			ps.setInt(5, u.getId());

			status = ps.executeUpdate();
			con.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection con = UserDOA.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			con.close();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public static User getUserbyId(int id) {
		User u = new User();

		try {
			Connection con = UserDOA.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getLong(5));
			}
			con.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	public static List<User> getAllUsers() {
		List<User> list = new ArrayList<User>();
		try {
			Connection con = UserDOA.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setMobile(rs.getLong(5));
				list.add(u);
			}
			con.close();
			ps.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
}