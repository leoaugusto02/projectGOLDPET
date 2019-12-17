package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import vo.Animais;
import vo.Funcionario;
import vo.Guardiao;
import vo.Pessoa;

public class PessoaDAO {

	private Connection con;
	private PreparedStatement ps;

	public String login(Pessoa p) throws SQLException {

		//String sql = "SELECT codePerson FROM Pessoa WHERE email = ? OR nick_name = ? AND senha = ?";

		String sql = "SELECT Pessoa.codePerson, cargo FROM Pessoa LEFT JOIN Funcionario ON Pessoa.codePerson = Funcionario.codePerson " + 
		"WHERE email = ? OR nick_name = ? AND senha = ?";
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, p.getEmail());
		ps.setString(2, p.getApelido());
		ps.setString(3, p.getSenha());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			String ret = rs.getInt("codePerson") + ";" + rs.getString("cargo");
			System.out.print("RET - " + ret);
			return ret;
			//p.setCodePerson(rs.getInt("codePerson"));
			//return p.getCodePerson();
			//return rs.getInt("codePerson");
		}
		return null;
	}
	
	/*public JSONObject login(Pessoa p) throws SQLException {

		String sql = "SELECT * FROM Pessoa WHERE email = ? OR nick_name = ? AND senha = ?";

		con = ConnectionDB.getConnection();

		JSONObject obj = new JSONObject();
		
		ps = con.prepareStatement(sql);
		ps.setString(1, p.getEmail());
		ps.setString(2, p.getApelido());
		ps.setString(3, p.getSenha());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			//p.setCodePerson(rs.getInt("codePerson"));
			obj.put("cod", rs.getInt("codePerson"));
			obj.put("profissao", rs.getObject(columnIndex));
			return obj;
		}
		return null;
	}*/

	public boolean cadastrar(Pessoa p, String acao) throws SQLException {

		String sql, sqlCondicao = null;
		con = ConnectionDB.getConnection();

		sql = "INSERT INTO Pessoa VALUES(NULL, ?, ?, ?, ?,'" + acao + "', ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		if (acao.equals("Guardião")) {
			sqlCondicao = "INSERT INTO Guardiao VALUES(null, "
					+ "(SELECT codePerson FROM Pessoa ORDER BY codePerson DESC LIMIT 1), 0,'Iniciante',0,'ativo')";
		} else {
			sqlCondicao = "INSERT INTO Funcionario VALUES(null, "
					+ "(SELECT codePerson FROM Pessoa ORDER BY codePerson DESC LIMIT 1), 0, ?, 'ativo')";
		}

		con.setAutoCommit(false);
		ps = con.prepareStatement(sql);
		PreparedStatement ps2 = con.prepareStatement(sqlCondicao);

		ps.setString(1, p.getApelido());
		ps.setString(2, p.getP_nome());
		ps.setString(3, p.getS_nome());
		ps.setDate(4, new java.sql.Date(p.getNascimento().getTime()));
		ps.setString(5, p.getSenha());
		ps.setString(6, p.getEmail());
		ps.setString(7, p.getCpf());
		ps.setString(8, p.getGenero());
		ps.setString(9, p.getRg());
		ps.setString(10, p.getCep());
		ps.setString(11, p.getReferencia());
		ps.setString(12, p.getImgPerfil());
		ps.setString(13, p.getTel1());
		ps.setString(14, p.getTel2());

		if (acao.equals("Funcionário")) {
			ps2.setString(1, p.getFuncionario().getCargo());
		}

		if ((ps.executeUpdate() > 0) && (ps2.executeUpdate() > 0)) {
			con.commit();
			return true;
		}

		return false;

	}

	public Pessoa perfil(int codePessoa) throws SQLException {

		String sql = "SELECT nick_name, p_nome, s_nome, nascimento, genero, telefone1, telefone2, email, cep, rank, animais_resgatados,"
				+ " progresso, imgPerfil FROM Pessoa p"
				+ " INNER JOIN Guardiao g ON p.codePerson = g.codePerson WHERE p.codePerson = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codePessoa);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Pessoa p = new Pessoa();

			p.setApelido(rs.getString("nick_name"));
			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			p.setNascimento(rs.getDate("nascimento"));
			p.setGenero(rs.getString("genero"));
			p.setTel1(rs.getString("telefone1"));
			p.setTel2(rs.getString("telefone2"));
			p.setEmail(rs.getString("email"));
			p.setCep(rs.getString("cep"));
			p.setImgPerfil(rs.getString("imgPerfil"));

			Guardiao g = new Guardiao();

			g.setRank(rs.getString("rank"));
			g.setAnimasResgatados(rs.getInt("animais_resgatados"));
			g.setProgresso(rs.getInt("progresso"));

			p.setGuardiao(g);

			return p;
		}

		return null;
	}

	public List<Pessoa> listarPessoasDashBoard() throws SQLException {

		String sql = "SELECT codePerson, p_nome, s_nome, tipo, email, cpf, rg, cep, telefone1, telefone2 FROM Pessoa";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();

		List<Pessoa> lstPessoa = new ArrayList<>();
		while (rs.next()) {
			Pessoa p = new Pessoa();
			
			p.setCodePerson(rs.getInt("codePerson"));
			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			p.setTipo(rs.getString("tipo"));
			p.setEmail(rs.getString("email"));
			p.setCpf(rs.getString("cpf"));
			p.setRg(rs.getString("rg"));
			p.setCep(rs.getString("cep"));
			p.setTel1(rs.getString("telefone1"));
			p.setTel2(rs.getString("telefone2"));

			lstPessoa.add(p);

			
		}
		return lstPessoa;
	}

	public boolean verificarUsuario(Pessoa p) throws SQLException {

		String sql = "SELECT * FROM Pessoa WHERE nick_name = ? OR email = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, p.getApelido());
		ps.setString(2, p.getEmail());

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return false;
		}
		return true;
	}

	public boolean MudarTipoContaDashBoard(int codePerson, String acao, String cargo) throws SQLException {

		// 1 = funcionario
		// else = guardiao

		String sql, sql2;
		con = ConnectionDB.getConnection();

		if (acao.equals("1")) {
			sql = "INSERT INTO Funcionario(codePerson, cargo)" + " SELECT * FROM (SELECT " + codePerson + ",'" + cargo
					+ "') AS func" + " WHERE NOT EXISTS (" + "	SELECT codePerson FROM Funcionario WHERE codePerson ="
					+ codePerson + ") LIMIT 1;";
			sql2 = "UPDATE Pessoa p INNER JOIN Funcionario f ON p.codePerson = f.codePerson INNER JOIN Guardiao g ON p.codePerson = f.codePerson SET p.tipo = 'Funcionário', f.status='ativo', g.status='desativo' WHERE p.codePerson ="
					+ codePerson;
		} else {
			sql = "INSERT INTO Guardiao(codePerson, animais_resgatados, rank, progresso)" + " SELECT * FROM (SELECT "
					+ codePerson + ", 0, 'Iniciante', 0) AS guard" + " WHERE NOT EXISTS ("
					+ "	SELECT codePerson FROM Guardiao WHERE codePerson =" + codePerson + ") LIMIT 1;";
			sql2 = "UPDATE Pessoa p INNER JOIN Funcionario f ON p.codePerson = f.codePerson INNER JOIN Guardiao g ON p.codePerson = f.codePerson SET p.tipo = 'Guardiao', f.status='demetido', g.status='ativo' WHERE p.codePerson ="
					+ codePerson;
		}

		con.setAutoCommit(false);
		ps = con.prepareStatement(sql);
		PreparedStatement ps2 = con.prepareStatement(sql2);

		if ((ps.executeUpdate() > 0) && (ps2.executeUpdate() > 0)) {
			con.commit();
			return true;
		}

		return false;
	}

	public Pessoa verificaTipo(int codigo) throws SQLException {
		String sql = "SELECT tipo FROM Pessoa WHERE codePerson = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codigo);

		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Pessoa p = new Pessoa();
			p.setTipo(rs.getString("tipo"));
			return p;
		}
		return null;
	}

	public Pessoa verificaCargo(int codUsuario) throws SQLException {

		String sql = "SELECT cargo FROM Funcionario, Pessoa p WHERE p.codePerson = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codUsuario);
		
		ResultSet rs = ps.executeQuery();

		if(rs.next()) {
			Pessoa p = new Pessoa();
			p.setCargo(rs.getString("cargo"));
			return p;
		}
		return null;
	}
	
	public Pessoa verificaFuncionario(int codigo) throws SQLException {
		String sql = "SELECT p_nome, s_nome"
				+ " FROM Pessoa WHERE codePerson = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codigo);

		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Pessoa p = new Pessoa();
			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			return p;
		}
		return null;
	}
	
	public Pessoa carregaInputs(int codePessoa) throws SQLException {

		String sql = "SELECT p_nome, s_nome, cpf, rg, telefone1 FROM Pessoa WHERE codePerson = ?";

		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setInt(1, codePessoa);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Pessoa p = new Pessoa();

			p.setP_nome(rs.getString("p_nome"));
			p.setS_nome(rs.getString("s_nome"));
			p.setCpf(rs.getString("cpf"));
			p.setRg(rs.getString("rg"));
			p.setTel1(rs.getString("telefone1"));
	
			return p;
		}
		return null;
	}
	
	public boolean AtualizarDadosAgenda(Pessoa p, int codPerson) throws SQLException {

		String sql = "UPDATE Pessoa SET p_nome = ?, s_nome = ?, cpf = ?, rg = ?, telefone1 = ? WHERE codePerson = ?";
		
		con = ConnectionDB.getConnection();

		ps = con.prepareStatement(sql);
		ps.setString(1, p.getP_nome());
		ps.setString(2, p.getS_nome());
		ps.setString(3, p.getCpf());
		ps.setString(4, p.getRg());
		ps.setString(5, p.getTel1());
		ps.setInt(6, codPerson);

		return ps.executeUpdate() > 0;

	}
}
