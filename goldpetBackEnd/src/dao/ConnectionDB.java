package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

	// declara as variáveis de conexão
	private static String dns = "jdbc:mysql://localhost:3306/goldpet?useTimezone=true&serverTimezone=UTC";
	private static String usuario = "root";
	private static String senha = "";

	private static Connection con;

	public static Connection getConnection() {		
		try {
			//if(con == null || con.isClosed()){
				Class.forName("com.mysql.cj.jdbc.Driver");
				//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				con = DriverManager.getConnection(dns, usuario, senha);
			//}
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

	}

}
