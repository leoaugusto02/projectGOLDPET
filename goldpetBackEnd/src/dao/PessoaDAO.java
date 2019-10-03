package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Animais;
import vo.Guardiao;
import vo.Pessoa;

public class PessoaDAO {

	private Connection con;
	private PreparedStatement ps;
	
	
	public Integer login(Pessoa p) throws SQLException {

		String sql = "SELECT * FROM Pessoa WHERE email = ? OR nick_name = ? AND senha = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, p.getEmail());
		ps.setString(2, p.getApelido());
		ps.setString(3, p.getSenha());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			 p.setCodePerson(rs.getInt("codePerson"));
			 return p.getCodePerson();
		}
		return null;
	}
	
	public boolean inserir(Pessoa p) throws SQLException {

		String sql = "START TRANSACTION;\r\n" + 
				"INSERT INTO Pessoa VALUES(NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\r\n" + 
				"INSERT INTO Guardiao VALUES(null, LAST_INSERT_ID(), 0, \"Iniciante\", 0);\r\n" + 
				"COMMIT";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(sql);
		ps.setString(1, p.getApelido());
		ps.setString(2, p.getP_nome());
		ps.setString(3, p.getS_nome());
		ps.setDate(4, new java.sql.Date(p.getNascimento().getTime()));
		ps.setString(5, p.getTipo());
		ps.setString(6, p.getSenha());
		ps.setString(7, p.getEmail());
		ps.setString(8, p.getCpf());
		ps.setString(9, p.getGenero());
		ps.setString(10, p.getRg());
		ps.setString(11, p.getReferencia());
		ps.setString(12, p.getImgPerfil());
		ps.setString(13, p.getTel1());
		ps.setString(14, p.getTel2());
		
		return ps.executeUpdate() > 0;
	}
	
	public Pessoa listarPessoa(int codePessoa) throws SQLException {
		
		String sql = "SELECT nick_name, p_nome, s_nome, nascimento, genero, telefone1, telefone2, email, rank, animais_resgatados,"
				+ " progresso, imgPerfil FROM Pessoa p"
				+ " INNER JOIN Guardiao g ON p.codePessoa = g.codePessoa WHERE p.codePessoa = ?";

		
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codePessoa);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Guardiao g = new Guardiao();			
			
			p.setCodePerson(rs.getInt("p.codePerson"));
			p.setApelido(rs.getString("nick_name"));
			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			p.setNascimento(rs.getDate("nascimento"));
			p.setGenero(rs.getString("genero"));
			p.setTel1(rs.getString("telefone1"));
			p.setTel2(rs.getString("telefone2"));
			p.setEmail(rs.getString("email"));
			p.setImgPerfil(rs.getString("imgPerfil"));
			
			
			g.setRank(rs.getString("rank"));
			g.setAnimasResgatados(rs.getInt("animaisResgatados"));
			g.setProgresso(rs.getInt("progresso"));
			
			p.setGuardiao(g);
			
			return p;
		}

		return null;
	}
	
	public Animais listarAnimal(int codeAnimal) {
		
		String sql = "SELECT especie, raca, porte, idade, sexo, status, nomeVeterinario, dataDiagnostico, diagnostico, imagem "
				+ " FROM Animal a INNER JOIN Laudo l ON a.codeAnimal = l.codeAnimal";
				
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.set
		
	}
	
}
