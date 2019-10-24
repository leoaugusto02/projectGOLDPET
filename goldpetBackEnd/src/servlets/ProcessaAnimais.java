package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.AnimaisDAO;
import vo.Animais;

@WebServlet("/ProcessaAnimais")
public class ProcessaAnimais extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		AnimaisDAO aDao = new AnimaisDAO();
		JSONObject objMens = new JSONObject();

		String acao = req.getParameter("acao");

		
		if (acao != null) {
			if (acao.equals("perfil")) {
				
				Animais a = new Animais();
				
				System.out.println("CREDENCIAL");

				try {
					a = aDao.perfilDog(1);
//desbugando o commit
					objMens.put("especie", a.getEspecie());
					objMens.put("raca", a.getRaca());
					objMens.put("porte", a.getPorte());
					objMens.put("idade", a.getIdade());
					objMens.put("status", a.getStatus());
					objMens.put("sexo", a.getSexo());
					objMens.put("imgAnimal", a.getImgAnimal());
					objMens.put("nomeVet", a.getLaudo().getNomeVeterinario());
					objMens.put("dataDiag", a.getLaudo().getDataDiagnostico());
					objMens.put("diagnostico", a.getLaudo().getDiagnostico());
					objMens.put("imgDiag", a.getLaudo().getImagem());
					
					out.print(objMens.toString());
					System.out.println(objMens.toString());

				} catch (SQLException e) {
					e.printStackTrace();
					objMens.put("mensagem", "erro sql = " + e);
					out.print(objMens.toString());
				}

			}
		}

	}

}
