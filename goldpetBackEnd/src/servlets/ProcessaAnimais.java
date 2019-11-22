package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnimaisDAO;
import vo.Animais;

@MultipartConfig

@WebServlet(
		name = "FileUploadServlet",
        urlPatterns = {"/ProcessaAnimais"},
        loadOnStartup = 1
		)
public class ProcessaAnimais extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String ext = "";
		PrintWriter out = resp.getWriter();
		AnimaisDAO aDao = new AnimaisDAO();
		JSONObject objMens = new JSONObject();

		String acao = req.getParameter("acao");
		String acaoModal = req.getParameter("acaoModal");
		
		System.out.println("ACAO MODAL" + acaoModal);

		if (acao != null) {
			if (acao.equals("perfil")) {

				Animais a = new Animais();
				int codAnimal = Integer.valueOf(req.getParameter("codAnimal"));
				System.out.println("codAnimal= " + codAnimal);
				System.out.println("CREDENCIAL");

				try {
					a = aDao.perfilDog(codAnimal);

					objMens.put("nome", a.getNome());
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

					for (Animais a : list) {

						objMens.put("codAnimal", a.getCodAnimal());
						objMens.put("nome", a.getNome());
						objMens.put("status", a.getStatus());
						objMens.put("raca", a.getRaca());
						objMens.put("especie", a.getEspecie());
						objMens.put("imgAnimal", a.getImgAnimal());

						out.print(objMens.toString() + "\n");

					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		} else if (acaoModal.equals("inserirPet")) {

			String nome = req.getParameter("nome");
			Integer idade = Integer.valueOf(req.getParameter("idade"));
			String raca = req.getParameter("raca");
			String porte = req.getParameter("porte");
			String especie = req.getParameter("especie");
			String genero = req.getParameter("genero");
			String status = req.getParameter("status");
			String filePath = req.getParameter("pathFile");
			
			try {

				Part file = req.getPart("imagem");
				String fileName = file.getSubmittedFileName();
				System.out.println("FN - " + fileName);

				int posInicial = fileName.lastIndexOf('.');
				int posFinal = fileName.length();
				ext = fileName.substring(posInicial, posFinal);
								
				InputStream fileContent = file.getInputStream();
				System.out.println("NOME - " + nome.trim() + ext);
				//OutputStream os = new FileOutputStream("D:\\Documentos\\Workspace\\Eclipse\\UpLoad\\WebContent\\images\\" + nome + ext);
				OutputStream os = new FileOutputStream(filePath + "img//" + nome.trim() + ext);
				
				int data = fileContent.read();
				
				while(data != -1) {
					os.write(data);
					data = fileContent.read();
				}
				
				os.close();
				fileContent.close();
			
			}catch(Exception e) {
				System.out.println("E - " + e);
			}

			Animais a = new Animais();

			a.setNome(nome);
			a.setIdade(idade);
			a.setRaca(raca);
			a.setPorte(porte);
			a.setEspecie(especie);
			a.setSexo(genero);
			a.setImgAnimal(nome.trim() + ext);
			a.setStatus(status);

			try {
				if (aDao.inserirAnimal(a)) {
					System.out.println("Animal inserido com sucesso");
					resp.sendRedirect("http://localhost:8080/goldpetFrontEnd/adocao.jsp");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
