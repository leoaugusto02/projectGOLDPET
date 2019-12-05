package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
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
import javax.servlet.http.HttpServletResponse;

import dao.AnimaisDAO;
import dao.PessoaDAO;
import vo.Animais;
import vo.Funcionario;
import vo.Laudo;
import vo.Pessoa;

@MultipartConfig

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/ProcessaAnimais" }, loadOnStartup = 1)
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
		String acaoVerifica = req.getParameter("acaoVerifica");

		Integer usuSessao = Integer.valueOf(req.getParameter("codUser"));
		
		System.out.println("acaoVerifica= " + acaoVerifica);
		
		String codUser = req.getParameter("codUser");
		
		System.out.println("codUser= " + codUser);
		

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

					if (aDao.laudo(codAnimal) != null) {
						Animais ani = new Animais();
						ani = aDao.laudo(codAnimal);
						objMens.put("nomeVet", ani.getLaudo().getNomeVeterinario());
						objMens.put("dataDiag", ani.getLaudo().getDataDiagnostico());
						objMens.put("diagnostico", ani.getLaudo().getDiagnostico());
						objMens.put("imgDiag", ani.getLaudo().getImagem());

						objMens.put("mensagem", "temLaudo");
						
					} else {
						
						objMens.put("mensagem", "semLaudo");
						
					}

					out.print(objMens.toString());
					System.out.println(objMens.toString());

				} catch (SQLException e) {
					e.printStackTrace();
					objMens.put("mensagem", "erro sql = " + e);
					out.print(objMens.toString());
				}

			} else if (acao.equals("listaAdocao")) {

				try {

					if (aDao.listarAnimaisAdocao() != null) {

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
					} else {
						objMens.put("mensagem", "Falta animais");
						out.print(objMens.toString());
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

			
			}	 /*	else if (acao.equals("inserirLaudo")) {
				int codAnimal = Integer.valueOf(req.getParameter("codAnimal"));
				String nomeVet = req.getParameter("nomeVet");
				String dataDiagnostico = req.getParameter("dataDiagnostico");
				String breveDiagnostico = req.getParameter("breveDiagnostico");
				String diagnosticoCompleto = req.getParameter("diagnosticoCompleto");

				Animais a = new Animais();
				Laudo l = new Laudo();

				a.setCodAnimal(codAnimal);
				l.setNomeVeterinario(nomeVet);
				l.setDataDiagnostico(dataDiagnostico);
				l.setDiagnostico(breveDiagnostico);
				l.setImagem(diagnosticoCompleto);
				a.setLaudo(l);

				try {
					if (aDao.inserirLaudo(a)) {
						objMens.put("mensagem", "Laudo realizado com sucesso");
						out.print(objMens.toString());
					} else {
						objMens.put("mensagem", "Algo deu errado");
						out.print(objMens.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
	*/
		} else {
			objMens.put("mensagem", "aguardando requisição");
			out.print(objMens.toString());
		}
		if (acaoVerifica != null && acaoVerifica.equals("verificaSessao")) {


			if (usuSessao != null) {
				PessoaDAO pDao = new PessoaDAO();
				Pessoa p = new Pessoa();

				try {
					if (pDao.verificaTipo(usuSessao) != null) {
						
						p = pDao.verificaTipo(usuSessao);
						
						if (p.getTipo().equals("Guardiao")) {
							objMens.put("mensagem", "guardiao");
							out.print(objMens.toString());
							System.out.println(objMens.toString());
						}else {
							p = pDao.verificaCargo(usuSessao);
							if(p.getCargo().equals("Veterinario")) {
								req.getSession().setAttribute("cargo", "veterinario");
								objMens.put("mensagemFunc", "veterinario");
								System.out.println("mensagem funcionario = " + objMens.toString());
							}else {
								objMens.put("mensagemFunc", "funcionario");
							}
						}
					} else {
						objMens.put("mensagem", "nãoExiste");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else {
				objMens.put("mensagem", "nenhumUsuario");
			}
		}else if (acaoModal!= null && acaoModal.equals("inserirPet")) {

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
				// OutputStream os = new
				// FileOutputStream("D:\\Documentos\\Workspace\\Eclipse\\UpLoad\\WebContent\\images\\"
				// + nome + ext);
				OutputStream os = new FileOutputStream(filePath + "img//" + nome.trim() + ext);

				int data = fileContent.read();

				while (data != -1) {
					os.write(data);
					data = fileContent.read();
				}

				os.close();
				fileContent.close();

			} catch (Exception e) {
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
		}else if (acaoModal!= null && acaoModal.equals("inserirLaudo")) {
			
			String codigoAnimal =req.getParameter("codigoAnimal");
			String breveDiagnostico = req.getParameter("breveDiagnostico");
			String diagnosticoCompleto = req.getParameter("diagnosticoCompleto");
			String filePath = req.getParameter("pathFile");
		
			
			Laudo l = new Laudo();
			Animais a = new Animais();
			Pessoa p = new Pessoa();
			PessoaDAO pDao = new PessoaDAO();
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
			Date dataDiagnostico;

			try {
				dataDiagnostico = format.parse(req.getParameter("dataDiagnostico"));
				l.setDataDiagnostico(dataDiagnostico);
	
				Part file = req.getPart("diagnosticoCompleto");
				String fileName = file.getSubmittedFileName();
				System.out.println("FN - " + fileName);

				int posInicial = fileName.lastIndexOf('.');
				int posFinal = fileName.length();
				ext = fileName.substring(posInicial, posFinal);

				InputStream fileContent = file.getInputStream();
	
				OutputStream os = new FileOutputStream(filePath + "img//" + fileName.trim() + ext);

				int data = fileContent.read();

				while (data != -1) {
				os.write(data);
					data = fileContent.read();
				}

				os.close();
				fileContent.close();
				//p = pDao.verificaFuncionario(usuSessao);
				
				a.setCodAnimal(Integer.valueOf(codigoAnimal));
				l.setNomeVeterinario(p.getP_nome() + p.getS_nome());
				l.setDataDiagnostico(dataDiagnostico);
				l.setDiagnostico(breveDiagnostico);
				l.setImagem(fileName.trim());
				a.setLaudo(l);
				
				if(aDao.inserirLaudo(a)) {
					System.out.println("Laudo inserido com sucesso");
					resp.sendRedirect("http://localhost:8080/goldpetFrontEnd/dataDoguinho.jsp");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
			
		}
	}
}
