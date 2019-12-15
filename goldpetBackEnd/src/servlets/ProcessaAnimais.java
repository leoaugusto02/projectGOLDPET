package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
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
import javax.print.attribute.standard.PDLOverrideSupported;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import dao.AnimaisDAO;
import dao.PessoaDAO;
import vo.Agenda;
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
		String codUser = req.getParameter("codUser");

		String cargo = String.valueOf(req.getSession().getAttribute("cargo"));

		System.out.println("acaoVerifica= " + acaoVerifica);

		System.out.println("codUser= " + codUser);

		System.out.println("Cargo= " + cargo);

		System.out.println("acaoModal= " + acaoModal);

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
						objMens.put("dataPost", ani.getLaudo().getDataPostagen());
						objMens.put("diagnostico", ani.getLaudo().getDiagnostico());
						objMens.put("imgDiag", ani.getLaudo().getImagem());

						objMens.put("mensagem", "temLaudo");

					} else {

						objMens.put("mensagem", "semLaudo");

					}

					PessoaDAO pDao = new PessoaDAO();

					if (codUser != null) {
						Pessoa p = pDao.carregaInputs(Integer.valueOf(codUser));

						if (pDao.carregaInputs(Integer.valueOf(codUser)) != null) {

							objMens.put("pNome", p.getP_nome());
							objMens.put("sNome", p.getS_nome());
							objMens.put("cpf", p.getCpf());
							objMens.put("rg", p.getRg());
							objMens.put("telefone", p.getTel1());

							out.print(objMens.toString());
						}
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

			} /*
				 * else if (acao.equals("inserirLaudo")) { int codAnimal =
				 * Integer.valueOf(req.getParameter("codAnimal")); String nomeVet =
				 * req.getParameter("nomeVet"); String dataDiagnostico =
				 * req.getParameter("dataDiagnostico"); String breveDiagnostico =
				 * req.getParameter("breveDiagnostico"); String diagnosticoCompleto =
				 * req.getParameter("diagnosticoCompleto");
				 * 
				 * Animais a = new Animais(); Laudo l = new Laudo();
				 * 
				 * a.setCodAnimal(codAnimal); l.setNomeVeterinario(nomeVet);
				 * l.setDataDiagnostico(dataDiagnostico); l.setDiagnostico(breveDiagnostico);
				 * l.setImagem(diagnosticoCompleto); a.setLaudo(l);
				 * 
				 * try { if (aDao.inserirLaudo(a)) { objMens.put("mensagem",
				 * "Laudo realizado com sucesso"); out.print(objMens.toString()); } else {
				 * objMens.put("mensagem", "Algo deu errado"); out.print(objMens.toString()); }
				 * } catch (SQLException e) { e.printStackTrace(); }
				 * 
				 * }
				 */
		} else {
			objMens.put("mensagem", "aguardando requisição");
			out.print(objMens.toString());
		}
		if (acaoVerifica != null && acaoVerifica.equals("verificaSessao")) {
			Integer usuSessao = Integer.parseInt(codUser);

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
						} else {
							p = pDao.verificaCargo(usuSessao);
							if (p.getCargo().equals("Veterinario")) {
								req.getSession().setAttribute("cargo", "veterinario");
								objMens.put("mensagemFunc", "veterinario");
								System.out.println("mensagem funcionario = " + objMens.toString());
							} else {
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
		} else if (acaoModal != null && acaoModal.equals("inserirPet")) {

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
		} else if (acaoModal != null && acaoModal.equals("inserirLaudo")) {

			// System.out.println("COD USER - " + codUser);

			Integer usuSessao = Integer.parseInt(codUser);

			// System.out.println("COD USER2 - " + usuSessao);

			String codigoAnimal = req.getParameter("codAnimal");
			String breveDiagnostico = req.getParameter("breveDiagnostico");
			String diagnosticoCompleto = req.getParameter("diagnosticoCompleto");
			String filePath = req.getParameter("pathFile");

			Laudo l = new Laudo();
			Animais a = new Animais();
			Pessoa p = new Pessoa();
			PessoaDAO pDao = new PessoaDAO();

			SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
			String dataDiagnostico;

			try {
				// dataDiagnostico = format.parse(req.getParameter("dataDiagnostico"));
				dataDiagnostico = req.getParameter("dataDiagnostico");
				Part file = req.getPart("diagnosticoCompleto");
				String fileName = file.getSubmittedFileName();
				System.out.println("FN - " + fileName);

				int posInicial = fileName.lastIndexOf('.');
				int posFinal = fileName.length();
				ext = fileName.substring(posInicial, posFinal);

				InputStream fileContent = file.getInputStream();
				
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
				Date date = new Date(); 
				String atualSistema = dateFormat.format(date); 
				System.out.println("data atual " + atualSistema);

				OutputStream os = new FileOutputStream(filePath + "img//" + codigoAnimal + atualSistema.trim() + ext);

				int data = fileContent.read();

				while (data != -1) {
					os.write(data);
					data = fileContent.read();
				}

				os.close();
				fileContent.close();

				if (pDao.verificaFuncionario(usuSessao) != null) {

					p = pDao.verificaFuncionario(usuSessao);
					String nomeVeterinario = p.getP_nome() + " " + p.getS_nome();
					l.setNomeVeterinario(nomeVeterinario);
				}

				a.setCodAnimal(Integer.valueOf(codigoAnimal));
				l.setDataDiagnostico(dataDiagnostico);
				l.setDiagnostico(breveDiagnostico);
				l.setImagem(codigoAnimal + atualSistema.trim() + ext);
				a.setLaudo(l);

				if (aDao.inserirLaudo(a)) {
					System.out.println("Laudo inserido com sucesso");
					resp.sendRedirect(
							"http://localhost:8080/goldpetFrontEnd/dataDoguinho.jsp?codAnimal=" + codigoAnimal);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (acaoModal != null && acaoModal.equals("atualizarLaudo")) {

			System.out.println("ATUALIZAR LAUDO");

			Integer usuSessao = Integer.parseInt(codUser);

			// System.out.println("COD USER2 - " + usuSessao);

			String codigoAnimal = req.getParameter("codAnimal");
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
				// dataDiagnostico = format.parse(req.getParameter("dataDiagnostico"));

				String dataa = req.getParameter("dataDiagnostico");

				Part file = req.getPart("diagnosticoCompleto");
				String fileName = file.getSubmittedFileName();
				System.out.println("FN - " + fileName);

				int posInicial = fileName.lastIndexOf('.');
				int posFinal = fileName.length();
				ext = fileName.substring(posInicial, posFinal);

				InputStream fileContent = file.getInputStream();

				OutputStream os = new FileOutputStream(filePath + "img//" + codigoAnimal + "-11122019" + ext); // localDate.now()

				int data = fileContent.read();

				while (data != -1) {
					os.write(data);
					data = fileContent.read();
				}

				os.close();
				fileContent.close();

				if (pDao.verificaFuncionario(usuSessao) != null) {

					p = pDao.verificaFuncionario(usuSessao);
					String nomeVeterinario = p.getP_nome() + " " + p.getS_nome();
					l.setNomeVeterinario(nomeVeterinario);
				}

				a.setCodAnimal(Integer.valueOf(codigoAnimal));
				l.setDataDiagnostico(dataa);
				l.setDiagnostico(breveDiagnostico);
				l.setImagem(codigoAnimal + "-11122019" + ext);
				a.setLaudo(l);

				if (aDao.AtualizarLaudo(Integer.valueOf(codigoAnimal), a)) {
					System.out.println("Laudo inserido com sucesso");
					resp.sendRedirect(
							"http://localhost:8080/goldpetFrontEnd/dataDoguinho.jsp?codAnimal=" + codigoAnimal);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (acaoModal != null && acaoModal.equals("atualizarEagendar")) {

			String codAnimal = req.getParameter("codAnimal");
			Integer codPerson = Integer.valueOf(codUser);
			String horarioMarcado = req.getParameter("horarioMarcado");
			String diaMarcado = req.getParameter("diaMarcado");

			String pNome = req.getParameter("pNome");
			String sNome = req.getParameter("sNome");
			String cpf = req.getParameter("cpf");
			String rg = req.getParameter("rg");
			String telefone = req.getParameter("telefone");

			Agenda ag = new Agenda();
			Animais a = new Animais();

			ag.setCodeAnimal(Integer.valueOf(codAnimal));
			ag.setCodePerson(codPerson);
			ag.setHorario_marcado(horarioMarcado);
			ag.setDia_marcado(diaMarcado);

			a.setAgenda(ag);

			try {
				if (aDao.AgendarVisita(a)) {
					Pessoa p = new Pessoa();
					PessoaDAO pDao = new PessoaDAO();

					p.setP_nome(pNome);
					p.setS_nome(sNome);
					p.setCpf(cpf);
					p.setRg(rg);
					p.setTel1(telefone);
					System.out.println("Pnome " + pNome);
					System.out.println("Snome " + sNome);
					System.out.println("cpf " + cpf);
					System.out.println("rg " + rg);
					System.out.println("telefone " + telefone);

					if (pDao.AtualizarDadosAgenda(p, codPerson)) {
						System.out.println("Agenda inserida com sucesso");
						resp.sendRedirect(
								"http://localhost:8080/goldpetFrontEnd/dataDoguinho.jsp?codAnimal=" + codAnimal);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
