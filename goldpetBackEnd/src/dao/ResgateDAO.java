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

		String sql = "INSERT INTO Resgate VALUES(NULL, ?, ?, ?, ?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, r.getDescricao());
		ps.setString(2, r.getEndereco());
		ps.setString(3, r.getDogeImagem());
		ps.setInt(4, r.getNivelUrgencia());

		return ps.executeUpdate() > 0;
	}

	public List<Resgate> ultimosResgates(Resgate r) throws SQLException {

		String sql = "SELECT descricao, endereco, dogeImagem, nivelUrgencia FROM Resgate ORDER BY nivelUrgencia DESC";

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Resgate> lstResg = new ArrayList<>();
		while (rs.next()) {

			r.setDescricao(rs.getString("descricao"));
			r.setEndereco(rs.getString("endereco"));
			r.setDogeImagem(rs.getString("dogeImagem"));
			r.setNivelUrgencia(rs.getInt("nivelUrgencia"));
			lstResg.add(r);

			return lstResg;
		}
		return null;
	}
}