package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Respostas;

public class RespostasDAO {

	Connection con;
	PreparedStatement ps;
	

	
public List<Respostas> listasRespostas(int codPerg) throws SQLException{
		
		String sql = "SELECT resposta FROM Respostas WHERE codPerg = ?";
		
		con = ConnectionDB.getConnection();
		
		ps = con.prepareStatement(sql);
		ps.setInt(1, codPerg);
		
		ResultSet rs = ps.executeQuery();
		
		List<Respostas> resp = new ArrayList<>();
		
		while(rs.next()) {
			Respostas r = new Respostas();
			
			r.setResposta(rs.getString("resposta"));
			
			resp.add(r);
		}		
		return resp;
	}
	
}
