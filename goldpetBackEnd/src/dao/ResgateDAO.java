package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Resgate;

public class ResgateDAO {

	private Connection con;
	private PreparedStatement ps;

	public boolean inserirResgate(Resgate r) throws SQLException {
		//nivel de urgência vai de 4 ate 1
		//4-pouco urgente
		//3-urgente
		//2-muito urgente
		//1-perigo
		String sql = "INSERT INTO Resgate VALUES(NULL, ?, ?, ?, ?, 'Em resgate')";
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, r.getDescricao());
		ps.setString(2, r.getEndereco());
		ps.setString(3, r.getDogeImagem());
		ps.setInt(4, r.getNivelUrgencia());

		return ps.executeUpdate() > 0;
	}

	public List<Resgate> ultimosResgates() throws SQLException {

		String sql = "SELECT codeResgate ,status, dogeImagem, nivelUrgencia FROM Resgate ORDER BY nivelUrgencia DESC";
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Resgate> lstResg = new ArrayList<>();
		while (rs.next()) {
			
			Resgate r = new Resgate();
			
			r.setCodResgate(rs.getInt("codeResgate"));
			r.setStatus(rs.getString("status"));
			r.setDogeImagem(rs.getString("dogeImagem"));
			r.setNivelUrgencia(rs.getInt("nivelUrgencia"));
			lstResg.add(r);

			return lstResg;
		}
		return null;
	}
	
	public boolean confirmarResgate() throws SQLException {
		
		String sql = "UPDATE Resgate SET status = 'resgatado'";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		
		return ps.executeUpdate() > 0;
	}
}
