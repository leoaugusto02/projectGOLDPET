package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Usuario;

public class UsuarioDAO {
	
	private Connection con;
	private PreparedStatement ps;
	
	public Integer login(Usuario u) throws SQLException {

		String sql = "SELECT codUser FROM Usuario WHERE email = ? AND senha = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getSenha());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			u.setCodUser(rs.getInt("codUser"));
			return u.getCodUser();
		}
		return null;
	}	
	
	
	public boolean inserir(Usuario u) throws SQLException {

		String sql = "INSERT INTO Usuario VALUES (0,?,?,?,?,?,?)";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, u.getApelido());
		ps.setString(2, u.getP_nome());
		ps.setString(3, u.getTelefone());
		ps.setString(4, u.getSenha());
		ps.setString(5, u.getEmail());
		ps.setString(6, u.getGenero());

		return ps.executeUpdate() > 0;

	}

	
}
