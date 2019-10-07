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
	
public Animais listarAnimal(int codeAnimal) throws SQLException {
		
		String sql = "SELECT especie, raca, porte, idade, sexo, status, nomeVeterinario, dataDiagnostico, diagnostico, imagem "
				+ " FROM Animal a INNER JOIN Laudo l ON a.codeAnimal = l.codeAnimal WHERE a.codeAnimal = ?";
				
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, codeAnimal);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Animais a = new Animais();
			Laudo l = new Laudo();
			
			a.setCodAnimal(rs.getInt("a.codeAnimal"));
			a.setEspecie(rs.getString("especie"));
			a.setRaca(rs.getString("raca"));
			a.setPorte(rs.getString("porte"));
			a.setIdade(rs.getInt("idade"));
			a.setSexo(rs.getString("sexo"));
			a.setStatus(rs.getString("status"));
			
			l.setNomeVeterinario(rs.getString("nomeVeterinario"));
			l.setDataDiagnostico(rs.getString("dataDiagnostico"));
			l.setDiagnostico(rs.getString("diagnostico"));
			l.setImagem(rs.getString("imagem"));
			
			a.setLaudo(l);
			
			return a;
		}
		
		return null;
	}
	
}
