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

		String sql = "SELECT nome, especie, raca, porte, idade, sexo, status, imgAnimal FROM Animais WHERE codeAnimal = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codeAnimal);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			Animais a = new Animais();

			a.setNome(rs.getString("nome"));
			a.setEspecie(rs.getString("especie"));
			a.setRaca(rs.getString("raca"));
			a.setPorte(rs.getString("porte"));
			a.setIdade(rs.getInt("idade"));
			a.setSexo(rs.getString("sexo"));
			a.setStatus(rs.getString("status"));
			a.setImgAnimal(rs.getString("imgAnimal"));

			return a;

		}

		return null;
	}

	public Animais laudo(int codeAnimal) throws SQLException {
		String sql = "SELECT nomeVeterinario, dataDiagnostico,  dataPostagen ,diagnostico, imagem FROM Laudo WHERE codeAnimal = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codeAnimal);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Laudo l = new Laudo();
			Animais a = new Animais();

			l.setNomeVeterinario(rs.getString("nomeVeterinario"));
			l.setDataDiagnostico(rs.getString("dataDiagnostico"));
			l.setDataPostagen(rs.getDate("dataPostagen"));
			l.setDiagnostico(rs.getString("diagnostico"));
			l.setImagem(rs.getString("imagem"));
			
			a.setLaudo(l);

			return a;
		}

		return null;
	}

	public boolean inserirAnimal(Animais a) throws SQLException {

		String sql = "INSERT INTO Animais VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?)";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, a.getNome());
		ps.setString(2, a.getEspecie());
		ps.setString(3, a.getRaca());
		ps.setString(4, a.getPorte());
		ps.setInt(5, a.getIdade());
		ps.setString(6, a.getStatus());
		ps.setString(7, a.getSexo());
		ps.setString(8, a.getImgAnimal());

		return ps.executeUpdate() > 0;
	}

	public boolean inserirLaudo(Animais a) throws SQLException {

		String sql = "INSERT INTO Laudo VALUES(?, ?, ?,CURDATE(), ?, ?)";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, a.getCodAnimal());
		ps.setString(2, a.getLaudo().getNomeVeterinario().toString());
		ps.setString(3, a.getLaudo().getDataDiagnostico());//new java.sql.Date(a.getLaudo().getDataDiagnostico().getTime()));
		ps.setString(4, a.getLaudo().getDiagnostico().toString());
		ps.setString(5, a.getLaudo().getImagem().toString());

		return ps.executeUpdate() > 0;
	}

	public List<Animais> listarAnimaisAdocao() throws SQLException {
		String sql = "SELECT codeAnimal ,nome, status, raca, especie, imgAnimal FROM Animais a WHERE status NOT LIKE 'Adotado'";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Animais> lstAnimais = new ArrayList<>();
		while (rs.next()) {
			Animais a = new Animais();

			a.setCodAnimal(rs.getInt("codeAnimal"));
			a.setNome(rs.getString("nome"));
			a.setStatus(rs.getString("status"));
			a.setRaca(rs.getString("raca"));
			a.setEspecie(rs.getString("especie"));
			a.setImgAnimal(rs.getString("imgAnimal"));

			lstAnimais.add(a);
		}

		return lstAnimais;
	}

	public List<Animais> ListarAnimaisDashBoard() throws SQLException {
		String sql = "SELECT an.nome, porte, raca, p_nome, s_nome, p.email, p.telefone1, p.telefone2 FROM Animais an INNER JOIN Pessoa p INNER JOIN Agenda ag ON an.codeAnimal = ag.codeAnimal";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Animais> lstAnimais = new ArrayList<>();
		while (rs.next()) {
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

	public boolean ConfirmarAutorizacao(int codeAnimal) throws SQLException {
		String sql = "UPDATE Agenda SET confirmar = 'autorizado' SET entregar = 'em adocao' WHERE codeAnimal = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codeAnimal);

		return ps.executeUpdate() > 0;
	}

	public boolean AtualizarLaudo(int codAnimal, Animais a) throws SQLException {

		String sql = "UPDATE Laudo SET nomeVeterinario = ?, dataDiagnostico = ?, diagnostico = ?, imagem = ?, dataPostagen = CURDATE() WHERE codeAnimal = ?";
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, a.getLaudo().getNomeVeterinario());
		ps.setString(2, a.getLaudo().getDataDiagnostico());//new java.sql.Date(a.getLaudo().getDataDiagnostico().getTime()));
		ps.setString(3, a.getLaudo().getDiagnostico());
		ps.setString(4, a.getLaudo().getImagem());
		ps.setInt(5, codAnimal);
		

		return ps.executeUpdate() > 0;

	}
	
	public boolean AgendarVisita(Animais a) throws SQLException {

		String sql = "INSERT INTO Agenda VALUES(0, ?, ?, ?, ?)";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, a.getAgenda().getCodeAnimal());
		ps.setInt(2, a.getAgenda().getCodePerson());
		ps.setString(3, a.getAgenda().getHorario_marcado());
		ps.setString(4, a.getAgenda().getDia_marcado());

		return ps.executeUpdate() > 0;
	}
	
	public List<Animais> listarUltimosAdotados() throws SQLException{
		String sql = "select nome, imgAnimal FROM Animais WHERE status = 'Adotado' ORDER BY codeAnimal DESC LIMIT 6";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Animais> lstUltimosAdotados = new ArrayList<>();
		while(rs.next()) {
			Animais a = new Animais();
			
			a.setNome(rs.getString("nome"));
			a.setImgAnimal(rs.getString("imgAnimal"));
			
			lstUltimosAdotados.add(a);
		}
		
		return lstUltimosAdotados;
		
	}

}
