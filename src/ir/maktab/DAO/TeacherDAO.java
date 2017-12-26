package ir.maktab.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import ir.maktab.model.Student;
import ir.maktab.model.Teacher;

public class TeacherDAO {
	private ArrayList<Teacher> teachers = new ArrayList<>();
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://localhost/school?useUnicode=yes&characterEncoding=UTF-8";

	// Database credentials
	final String USER = "root";
	final String PASS = "";

	public void add(Teacher t) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query

			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO prof (id,name,dept,address) VALUES " + "('" + t.getId() + "','" + t.getName() + "','"
					+ t.getDept() + "','" + t.getAddress() + "');";
			System.out.println("The Record has added...");

			stmt.executeUpdate(sql);

			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		}
	}

	public ArrayList getAll() {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			// STEP 4: Execute a query

			stmt = conn.createStatement();
			String sql = "SELECT * FROM prof where id;";
			System.out.println("The Records has retrieved...");
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				String address = rs.getString("address");
				Teacher teacher = new Teacher(id, name, dept, address);
				teachers.add(teacher);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return teachers;

	}

	public void delete(int t) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Deleting the Record...");
			stmt = conn.createStatement();

			String sql = "DELETE FROM prof WHERE id = " + t + ";";

			stmt.executeUpdate(sql);
			System.out.println("The Record Has deleted...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public void update(Teacher t) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query

			stmt = conn.createStatement();
			String sql;
			sql = "UPDATE prof SET name='" + t.getName() + "',dept='" + t.getDept() + "',address='" + t.getAddress()
					+ "' where id = '" + t.getId() + "';";

			

			stmt.executeUpdate(sql);
			System.out.println("The Record has Updated...");

			// rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();

		}
	}

	public Teacher get(int i) {
		Teacher t = null;
		// Database credentials
		final String USER = "root";
		final String PASS = "";

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			// STEP 4: Execute a query

			stmt = conn.createStatement();
			String sql = "SELECT * FROM prof where id='" + i + "';";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("The Record has retrived");
			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				String address = rs.getString("address");
				t = new Teacher(id, name, dept, address);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return t;
	}
}
// String sql = "update prof set name='"+t.getName()+ "',dept='" +t.getDept()+
// "',address='"+t.getAddress()+ "' where id = '" +t.getId()+ "'s;";
