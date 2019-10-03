package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Pessoa;

public class PessoaDAO {

	private Connection con;
	private PreparedStatement ps;
	
	
	public Integer login(Pessoa u) throws SQLException {

		String sql = "SELECT CodeUser FROM Usuario WHERE email = ? AND senha = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getSenha());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			 u.setCodePerson(rs.getInt("codePerson"));
			 return u.getCodePerson();
		}
		return null;
	}
	
}
