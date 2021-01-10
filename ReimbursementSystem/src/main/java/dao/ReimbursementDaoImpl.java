package dao;

import java.io.File;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import model.ERSUser;
import model.Reimbursement;

/**
 * This is the Reimbursement DAO that is being used to interact
 *         with the database. This uses various methods to allow access to the
 *         DB, specifically with the reimbursements.
 * @author corbi 
 */
public class ReimbursementDaoImpl implements ReimbursementDao {
	
	final static Logger loggy = Logger.getRootLogger();
	
	
	@Override
	public void insertReimbursement(Reimbursement reimbursement, int reimbAuthor) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "insert into ers_reimbursement (reimb_id,reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)values(default,?,?,?,?,?,?,?,?,?);";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getAmount());
			ps.setTimestamp(2, reimbursement.getSubmitted());
			ps.setNull(3, Types.NULL);
			ps.setString(4, reimbursement.getDescription());
			ps.setNull(5, Types.NULL);
			ps.setInt(6, reimbursement.getAuthorId());
			ps.setNull(7, Types.NULL);
			ps.setInt(8, reimbursement.getStatusId());
			ps.setInt(9, reimbursement.getTypeId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		// TODO Auto-generated method stub
		loggy.info("Getting all reimbursements");
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public Reimbursement selectReimbursementById(int reimbId) {
		// TODO Auto-generated method stub
		Reimbursement reimb = null;

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimb = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByAuthorId(int authorId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_author = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, authorId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByResolverId(int resolverId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_resolver = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolverId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByTypeId(int typeId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_type_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, typeId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectReimbursementsByStatusId(int statusId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_status_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, statusId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectAllUnresolvedReimbursements() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select * from ers_reimbursement where reimb_resolver is null; ";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectFullInfoReimbursements() {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select reimb_id,reimb_amount , reimb_submitted,reimb_resolved,reimb_description,reimb_receipt ,reimb_author ,reimb_resolver,ers_reimbursement.reimb_status_id,ers_reimbursement.reimb_type_id ,ers_reimbursement_type.reimb_type , ers_reimbursement_status.reimb_status,us1.ers_username as author ,us2.ers_username as resolver from ers_reimbursement inner join ers_reimbursement_status on ers_reimbursement_status.reimb_status_id  = ers_reimbursement.reimb_status_id"
					+ "								inner join ers_reimbursement_type on ers_reimbursement_type.reimb_type_id = ers_reimbursement.reimb_type_id"
					+ "								inner join ers_users us1 on us1.ers_users_id = ers_reimbursement.reimb_author"
					+ "								left join ers_users us2 on us2.ers_users_id = ers_reimbursement.reimb_resolver;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getString(13), rs.getString(14), rs.getString(12), rs.getString(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public List<Reimbursement> selectFullInfoReimbursementsByAuthorId(int authorId) {
		// TODO Auto-generated method stub
		List<Reimbursement> reimbs = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "select reimb_id,reimb_amount , reimb_submitted,reimb_resolved,reimb_description,reimb_receipt ,reimb_author ,reimb_resolver,ers_reimbursement.reimb_status_id,ers_reimbursement.reimb_type_id ,ers_reimbursement_type.reimb_type , ers_reimbursement_status.reimb_status,us1.ers_username as author ,us2.ers_username as resolver from ers_reimbursement inner join ers_reimbursement_status on ers_reimbursement_status.reimb_status_id  = ers_reimbursement.reimb_status_id"
					+ "								inner join ers_reimbursement_type on ers_reimbursement_type.reimb_type_id = ers_reimbursement.reimb_type_id"
					+ "								inner join ers_users us1 on us1.ers_users_id = ers_reimbursement.reimb_author"
					+ "								left join ers_users us2 on us2.ers_users_id = ers_reimbursement.reimb_resolver where us1.ers_users_id = ?;";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, authorId);

			ResultSet rs = ps.executeQuery();

			// BE AWARE THIS IS MAKING RECIEPTS NULL
			while (rs.next()) {
				reimbs.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4),
						rs.getString(5), null, rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10),
						rs.getString(13), rs.getString(14), rs.getString(12), rs.getString(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbs;
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "update ers_reimbursement set reimb_amount=?,reimb_submitted=?,reimb_resolved=?,reimb_description=?,reimb_receipt=?,reimb_author=?,reimb_resolver=?,reimb_status_id=?,reimb_type_id=? where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, reimbursement.getAmount());
			ps.setTimestamp(2, reimbursement.getSubmitted());
			ps.setTimestamp(3, reimbursement.getResolved());
			ps.setString(4, reimbursement.getDescription());
			ps.setNull(5, Types.NULL);
			ps.setInt(6, reimbursement.getAuthorId());
			ps.setInt(7, reimbursement.getResolverId());
			ps.setInt(8, reimbursement.getStatusId());
			ps.setInt(9, reimbursement.getTypeId());
			ps.setInt(10, reimbursement.getReimbId());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursement(int reimbId, int userId, int statusId) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "update ers_reimbursement set reimb_resolved=?,reimb_resolver=?,reimb_status_id=? where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
			ps.setInt(2, userId);
			ps.setInt(3, statusId);
			ps.setInt(4, reimbId);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReimbursement(int id) {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {

			String sql = "delete from ers_reimbursement where reimb_id = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
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
					+ "create table ers_reimbursement_status(" + "	reimb_status_id int,"
					+ "	reimb_status varchar(10)," + "	primary key(reimb_status_id)" + ");"
					+ "create table ers_reimbursement_type(" + "	reimb_type_id int," + "	reimb_type varchar(10),"
					+ "	primary key(reimb_type_id)" + ");" + "create table ers_reimbursement (" + "	reimb_id serial,"
					+ "	reimb_amount int not null," + "	reimb_submitted timestamp not null,"
					+ "	reimb_resolved timestamp," + "	reimb_description varchar(250)," + "	reimb_receipt bytea,"
					+ "	reimb_author int not null," + "	reimb_resolver int," + "	reimb_status_id int not null,"
					+ "	reimb_type_id int not null," + "	primary key(reimb_id)," + "	constraint ers_users_fk_auth"
					+ "		foreign key (reimb_author)" + "			references ers_users(ers_users_id),"
					+ "	constraint ers_users_fk_reslvr" + "		foreign key (reimb_resolver)"
					+ "			references ers_users(ers_users_id)," + "	constraint ers_reimbursement_status_fk"
					+ "		foreign key (reimb_status_id)"
					+ "			references ers_reimbursement_status(reimb_status_id),	"
					+ "	constraint ers_reimbursement_type_fk" + "		foreign key (reimb_type_id)"
					+ "			references ers_reimbursement_type(reimb_type_id)" + ");"
					+ "insert into ers_user_roles (ers_user_role_id,user_role)values(1,'Employee');"
					+ "insert into ers_user_roles (ers_user_role_id,user_role)values(2,'Finance Manager');" +

					"insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'splatinum','yare yare daze','Jotoro','Kujo','jkujo@ora.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'hpurple','oh my god','Joseph','Joestar','jojoestar@hamon.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'schariot','they got kakyoin','Jean Pierre','Polnareff','jpp@turtle.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'hgreen','emerald splash','Noriaki','Kakyoin','nkakyoin@donut.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'mred','yes i am','Muhammad','Avdol','mavdol@fortuneteller.com',1);"
					+ "insert into ers_users (ers_users_id,ers_username,ers_password,user_first_name,user_last_name,user_email,user_role_id)values(default,'bubbleboy','the last of my hamon','Caesar','Zeppeli','czeppeli@sw.org',2);"
					+ "insert into public.ers_reimbursement_status (reimb_status_id,reimb_status)values(1,'Pending');"
					+ "insert into public.ers_reimbursement_status (reimb_status_id,reimb_status)values(2,'Approved');"
					+ "insert into public.ers_reimbursement_status (reimb_status_id,reimb_status)values(3,'Denied');" +

					"insert into ers_reimbursement_type (reimb_type_id,reimb_type)values(1,'Lodging');"
					+ "insert into ers_reimbursement_type (reimb_type_id,reimb_type)values(2,'Food');"
					+ "insert into ers_reimbursement_type (reimb_type_id,reimb_type)values(3,'Travel');"
					+ "insert into ers_reimbursement_type (reimb_type_id,reimb_type)values(4,'Other');"
					+ "insert into ers_reimbursement (reimb_id,reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)values(default,100,'2020-12-16 16:59:05',CURRENT_TIMESTAMP,'Test reimb',null,1,6,3,2);"
					+ "insert into ers_reimbursement (reimb_id,reimb_amount,reimb_submitted,reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)values(default,200,'2020-12-15 12:12:12',null,'Test reimb 2 not resolved',null,1,null,1,1);"
					+ "";

			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void h2DestroyDao() {
		// TODO Auto-generated method stub
		try (Connection conn = DriverManager.getConnection(MyConnectionFactory.url, MyConnectionFactory.username,
				MyConnectionFactory.password)) {
			String sql = "DROP TABLE ers_reimbursement_type; " + "DROP TABLE ers_reimbursement_status; "
					+ "DROP TABLE ers_reimbursement; " + "DROP TABLE ers_user_roles; " + "DROP TABLE ers_users; ";
			Statement state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
