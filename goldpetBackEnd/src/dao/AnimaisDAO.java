package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Animais;
import vo.Laudo;


public class AnimaisDAO {

	private Connection con;
	private PreparedStatement ps;

	public Animais perfilDog(int codeAnimal) throws SQLException {

		String sql = "SELECT especie, raca, porte, idade, sexo, status, imgAnimal, nomeVeterinario, dataDiagnostico, diagnostico, imagem "
				+ " FROM Animais a INNER JOIN Laudo l ON a.codeAnimal = l.codeAnimal WHERE a.codeAnimal = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codeAnimal);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Animais a = new Animais();
			Laudo l = new Laudo();

			a.setEspecie(rs.getString("especie"));
			a.setRaca(rs.getString("raca"));
			a.setPorte(rs.getString("porte"));
			a.setIdade(rs.getInt("idade"));
			a.setSexo(rs.getString("sexo"));
			a.setStatus(rs.getString("status"));
			a.setImgAnimal(rs.getString("imgAnimal"));

			l.setNomeVeterinario(rs.getString("nomeVeterinario"));
			l.setDataDiagnostico(rs.getString("dataDiagnostico"));
			l.setDiagnostico(rs.getString("diagnostico"));
			l.setImagem(rs.getString("imagem"));

			a.setLaudo(l);

			return a;
		}

		return null;
	}

	public boolean inserirAnimal(Animais a) throws SQLException {
		
		String sql = "INSERT INTO Animais VALUES(NULL, ?, ?, ?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, a.getEspecie());
		ps.setString(2, a.getRaca());
		ps.setString(4, a.getPorte());
		ps.setInt(4, a.getIdade());
		ps.setString(5, a.getStatus());
		ps.setString(6, a.getSexo());
		ps.setString(7, a.getImgAnimal());
		
		return ps.executeUpdate() > 0;
	}
	
	public boolean inserirLaudo(Animais a) throws SQLException {
		
		String sql = "INSERT INTO Laudo VALUES(?, ?, ?, ?, ?)";
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, a.getCodAnimal());
		ps.setString(2, a.getLaudo().getNomeVeterinario());
		ps.setString(3, a.getLaudo().getDataDiagnostico());
		ps.setString(4, a.getLaudo().getDiagnostico());
		ps.setString(5, a.getLaudo().getImagem());
		
		return ps.executeUpdate() > 0;
	}
	
}
