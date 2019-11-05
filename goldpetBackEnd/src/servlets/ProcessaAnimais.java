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
		String acaoModal = req.getParameter("acaoModal");
		
		System.out.println("Cheguei no servlet");

		if (acao != null) {
			if (acao.equals("perfil")) {

				Animais a = new Animais();
				int codAnimal = Integer.valueOf(req.getParameter("codAnimal"));
				System.out.println("codAnimal= " + codAnimal);
				System.out.println("CREDENCIAL");

				try {
					a = aDao.perfilDog(codAnimal);
					// desbugando o commit

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

			} else if (acao.equals("listaAdocao")) {

				try {

					List<Animais> list = aDao.listarAnimaisAdocao();
					if (list != null) {
						for (Animais a : list) {

							objMens.put("codAnimal", a.getCodAnimal());
							objMens.put("nome", a.getNome());
							objMens.put("status", a.getStatus());
							objMens.put("raca", a.getRaca());
							objMens.put("especie", a.getEspecie());

							out.print(objMens.toString() + "\n");

						}
					} else {
						objMens.put("Jason deu erro", "Jason deu erro");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} 
		}else if (acaoModal.equals("inserirPet")) {

			String nome = req.getParameter("nome");
			Integer idade = Integer.valueOf(req.getParameter("idade"));
			String raca = req.getParameter("raca");
			String porte = req.getParameter("porte");
			String especie = req.getParameter("especie");
			String genero = req.getParameter("genero");
			String imagem = req.getParameter("imagem");
			String status = req.getParameter("status");

			Animais a = new Animais();

			a.setNome(nome);
			a.setIdade(idade);
			a.setRaca(raca);
			a.setPorte(porte);
			a.setEspecie(especie);
			a.setSexo(genero);
			a.setImgAnimal(imagem);
			a.setStatus(status);

			try {
				if (aDao.inserirAnimal(a)) {
					System.out.println("Animal inserido com sucesso");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
