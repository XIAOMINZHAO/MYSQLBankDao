package BankApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Set;

public class MYSQL_DAO implements BankDaoInterface{
	final String JDBC_Driver = "com.mysql.jdbc.Driver";
	final String DB_URL = "jdbc:mysql://tesdatabase.cap3qgljnxgj.us-east-2.rds.amazonaws.com:3306/BankDB";
	final String USER = "admin";
	final String PASS = "zHAOQUAN=1";
	
	Connection conn = null;
	Statement stmt;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to database ....");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("creating table in given database ....");
			this.stmt = conn.createStatement();
			
			String sql = "CREATE TABLE BankAccount " +
		              "(AccountId LONG not NULL, " +
				      "UserName VARCHAR(255), " +
				      "Balance Integer, " +
		              "phone VARCHAR(10)," +
				      "email VARCHAR(255), " +
		              "PRIMARY KEY ( UserName ))";
		this.stmt.executeUpdate(sql);
		System.out.println("creating table in given database ....");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	

	@Override
	public void addCustomer(BankAccount a) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO BankAccount (AccountId, UserName, Balance, phone, email)" + 
				"VALUES ('"+a.getAccountNumber() +"', '" + a.getCustomerName() +"', '" + a.getBalance() +"', '" +a.getPhoneNumber() + "', '" + a.getEmail() +"')";
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateName(String accountnum, String newName) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE BankAccount SET UserName = " + newName + 
				"WHERE AccountId = " + accountnum;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmail(String accountnum, String email) {
		// TODO Auto-generated method stub
		String sql = "UPDATE BankAccount SET email = " + email + 
				"WHERE AccountId = " + accountnum;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updatePhoneNumber(String accountnum, String phoneNumber) {
		// TODO Auto-generated method stub
		String sql = "UPDATE BankAccount SET phone = " + phoneNumber + 
				"WHERE AccountId = " + accountnum;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Set<String> getAccount() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM BankAccount" ;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	@Override
	public void getAccount(String accountnum) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM BankAccount WHERE AccountId = " + accountnum ;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deposit(String accountnum, int amount) {
		// TODO Auto-generated method stub
		String sql = "Select Balance FROM BankAccount Where AccountId = " + accountnum + ";";
		
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void withdraw(String username, int amount) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void getBalance(String name) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

	@Override
	public void deleteUser(Long accountnumber) {
		// TODO Auto-generated method stub
		
	}





	public void updateAccountNumber(String username3) {
		// TODO Auto-generated method stub
		Random rand = new Random(); //instance of random class
	      int upperbound = 10000;
	        //generate random values from 0-24
	      int int_random = rand.nextInt(upperbound);
		long hash = ((username3.hashCode() & 0xffffffffL) << 14L) 
		          ^ (username3.hashCode() & 0xffffffffL) + int_random;
		
		String accountnum = String.valueOf(hash);
		System.out.println("Account number set to " + hash);
		
		String sql = "UPDATE BankAccount SET AccountId = " + accountnum + 
				"WHERE userNane = " + username3;
		
		try {
			this.stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
