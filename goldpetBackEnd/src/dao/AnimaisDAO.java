package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Animais;
import vo.Laudo;
import vo.Pessoa;


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
		
		con = ConnectionDB.getConnection();
		
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
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, a.getCodAnimal());
		ps.setString(2, a.getLaudo().getNomeVeterinario());
		ps.setString(3, a.getLaudo().getDataDiagnostico());
		ps.setString(4, a.getLaudo().getDiagnostico());
		ps.setString(5, a.getLaudo().getImagem());
		
		return ps.executeUpdate() > 0;
	}
	
	public List<Animais> listarAnimaisAdocao() throws SQLException{
		String sql="SELECT codeAnimal ,nome, status, raca, especie FROM Animais a";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Animais> lstAnimais = new ArrayList<>();
		while(rs.next()) {
			Animais a = new Animais();
			
			a.setCodAnimal(rs.getInt("codeAnimal"));
			a.setNome(rs.getString("nome"));
			a.setStatus(rs.getString("status"));
			a.setRaca(rs.getString("raca"));
			a.setEspecie(rs.getString("especie"));
			
			lstAnimais.add(a);
		}
		
		return lstAnimais;
	}
	
	public List<Animais> ListarAnimaisDashBoard() throws SQLException{
		String sql = "SELECT an.nome, porte, raca, p_nome, s_nome, p.email, p.telefone1, p.telefone2 FROM Animais an INNER JOIN Pessoa p INNER JOIN Agenda ag ON an.codeAnimal = ag.codeAnimal";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Animais> lstAnimais = new ArrayList<>();
		while(rs.next()) {
			Animais a = new Animais();
			Pessoa p = new Pessoa();
			
			a.setNome(rs.getString("an.nome"));
			a.setPorte(rs.getString("porte"));
			a.setRaca(rs.getString("raca"));
			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			p.setEmail(rs.getString("p.email"));
			p.setTel1(rs.getString("p.telefone1"));
			p.setTel2(rs.getString("p.telefone2"));
			
			a.setPessoa(p);
			lstAnimais.add(a);

		}
		
		return lstAnimais;
	}
	
}
