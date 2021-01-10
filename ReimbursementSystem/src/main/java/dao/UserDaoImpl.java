package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ERSUser;

/**
 * This is the User DAO that is being used to interact with the
 *         database. This uses various methods to allow access to the DB,
 *         specifically with the users.
 * @author corbi 
 *  
 */
public class UserDaoImpl implements UserDao {

	public void insertUser(ERSUser user) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,?,?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getUserRoleId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ERSUser> selectAllUsers() {
		// TODO Auto-generated method stub
		List<ERSUser> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_users";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				users.add(new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public ERSUser selectUserById(int userId) {
		// TODO Auto-generated method stub
		ERSUser user = null;
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_users where ers_users_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				user = new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public ERSUser selectUserByUsername(String ERSusername) {
		// TODO Auto-generated method stub
		ERSUser user = null;
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_users where ers_username = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, ERSusername);

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				user = new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public ERSUser selectUserByEmail(String email) {
		// TODO Auto-generated method stub
		ERSUser user = null;
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_users where user_email = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				user = new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<ERSUser> selectUsersByRoleID(int roleId) {
		// TODO Auto-generated method stub
		List<ERSUser> users = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "SELECT * FROM ers_users where user_role_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);

			ResultSet rs = ps.executeQuery(); // <--query not update

			while (rs.next()) {
				users.add(new ERSUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void updateUser(ERSUser user) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "update ers_users set ers_users_id = ?,ers_username =?, ers_password=?,user_first_name=?,user_last_name=?,user_email=?,user_role_id=? where ers_users_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getEmail());
			ps.setInt(7, user.getUserRoleId());
			ps.setInt(8, user.getUserId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "delete from ers_users where ers_users_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void h2InitDao() {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "create table ers_user_roles (" + "	ers_user_role_id int," + "	user_role varchar(15),"
					+ "	primary key(ers_user_role_id)" + ");" + "create table ers_users (" + "	ers_users_id serial,"
					+ "	ers_username varchar(50) not null unique," + "	ers_password varchar(50) not null,"
					+ "	user_first_name varchar(100) not null," + "	user_last_name varchar(100) not null,"
					+ "	user_email varchar(150) not null unique," + "	user_role_id int not null,"
					+ "	primary key(ers_users_id)," + "	constraint ers_roles_fk" + "		foreign key (user_role_id)"
					+ "			references ers_user_roles(ers_user_role_id)" + ");"
					+ "insert into ers_user_roles (ers_user_role_id,user_role)values(1,'Employee');"
					+ "insert into ers_user_roles (ers_user_role_id,user_role)values(2,'Finance Manager');" + ""
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'splatinum','yare yare daze','Jotoro','Kujo','jkujo@ora.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'hpurple','oh my god','Joseph','Joestar','jojoestar@hamon.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'schariot','they got kakyoin','Jean Pierre','Polnareff','jpp@turtle.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'hgreen','emerald splash','Noriaki','Kakyoin','nkakyoin@donut.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'mred','yes i am','Muhammad','Avdol','mavdol@fortuneteller.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'bubbleboy','the last of my hamon','Caesar','Zeppeli','czeppeli@sw.org',2);"
					+ "" + "";

			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void h2DestroyDao() {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "DROP TABLE ers_user_roles; " + "DROP TABLE ers_users; ";

			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
