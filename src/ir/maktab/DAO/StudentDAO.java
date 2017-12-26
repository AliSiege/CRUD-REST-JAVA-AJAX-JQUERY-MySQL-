package ir.maktab.DAO;

import ir.maktab.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// JDBC driver name and database URL
	private ArrayList<Student> students = new ArrayList<>();
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/school";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "";

	public static void addStudent() {

	}

	public void add(Student S) {

		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "INSERT INTO student(id,name,dept,prof_id) VALUES('"+S.getId()+"','" + S.getName() + "','" + S.getDept() + "','"
					+ S.getprof_id() + "');";
			System.out.println("The record has added");
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
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM student";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				int supervisor_id = rs.getInt("prof_id");
				Student s = new Student(id, name, dept, supervisor_id);
				students.add(s);
			}
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return students;

	}

	public void delete(int S) {
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

			String sql = "DELETE FROM student WHERE id = '" + S + "';";
			stmt.executeUpdate(sql);
			System.out.println("The Opration has been Completed");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public void update(Student S) {
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

			String sql = "update student set name='" + S.getName() + "',dept='"+S.getDept()+"',prof_id='"+S.getprof_id()+"' WHERE id = '" + S.getId() + "';";
			stmt.executeUpdate(sql);
			System.out.println("The Record has updated");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
	}

	public Student get(int i) {
		Student s = null;

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
			String sql = "SELECT * FROM student where id='" + i + "';";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("The Record has retrived");
			while (rs.next()) {

				// Retrieve by column name
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dept = rs.getString("dept");
				int supervisor_id = rs.getInt("prof_id");
				s = new Student(id, name, dept, supervisor_id);

			}

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		return s;
	}
}
