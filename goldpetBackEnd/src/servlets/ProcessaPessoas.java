package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RespostasDAO;
import dao.PessoaDAO;
import vo.Guardiao;
import vo.Perguntas;
import vo.Respostas;
import vo.Pessoa;

@WebServlet("/ProcessaPessoas")
public class ProcessaPessoas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ext = "";
		PrintWriter out = resp.getWriter();
		Respostas r = new Respostas();
		RespostasDAO rDao = new RespostasDAO();
		PessoaDAO pDao = new PessoaDAO();
		JSONObject objMens = new JSONObject(); 

		String acao = req.getParameter("acao");
		String acaoConta = req.getParameter("acaoConta");
		/*
		 * 0 = funcionou 1 = erro servlet 2 = não há perguntas
		 */
		System.out.println("chegou aqui no servlet");

		if (acao != null) {
			if (acao.equals("listarPerguntas")) {
				/*
				 * try { System.out.println("listar");
				 * 
				 * if (pDao.listarPerguntaUser() != null) { List<Pessoa> lstPergUser =
				 * pDao.listarPerguntaUser(); for (Pessoa p : lstPergUser) { objMens.put("Nome",
				 * p.getNome()); objMens.put("codePerguntas", p.getPerguntas().getCodPerg());
				 * objMens.put("pergunta", p.getPerguntas().getPergunta()); objMens.put("tema",
				 * p.getPerguntas().getTema());
				 * 
				 * out.print(objMens.toString() + "\n"); } } else { objMens.put("mensagem",
				 * "2"); out.print(objMens.toString()); }
				 * 
				 * } catch (SQLException e) { e.printStackTrace(); objMens.put("mensagem",
				 * "Erro sql = " + e); out.print(objMens.toString()); }
				 * 
				 * } else if (acao.equals("perguntas-respostas")) {
				 * 
				 * System.out.println("perguntar");
				 * 
				 * int codePerg = Integer.valueOf(req.getParameter("codigoPergunta"));
				 * 
				 * try { if (pDao.perguntaUser(codePerg) != null) { Pessoa p = new Pessoa();
				 * 
				 * p = pDao.perguntaUser(codePerg);
				 * 
				 * objMens.put("codeUser", p.getCodeUser()); objMens.put("Nome", p.getNome());
				 * objMens.put("Pergunta",p.getPerguntas().getPergunta());
				 * objMens.put("Descricao",p.getPerguntas().getDescricao());
				 * objMens.put("Tema",p.getPerguntas().getTema());
				 * out.print(objMens.toString()); //out.println(objMens.toString());
				 * System.out.println(objMens.toString() + "\n"); }else {
				 * objMens.put("mensagem", "2"); out.print(objMens.toString()); }
				 * 
				 * 
				 * if(pDao.listarRespostas(codePerg) != null) { List<Pessoa> lstRespUser =
				 * pDao.listarRespostas(codePerg);
				 * 
				 * for(Pessoa p: lstRespUser) { objMens.put("NomeResp", p.getNome());
				 * objMens.put("Resposta", p.getRespostas().getResposta());
				 * out.print(objMens.toString() + "\n"); System.out.println(objMens.toString() +
				 * "\n"); } }else { objMens.put("mensagem", "2"); out.print(objMens.toString());
				 * } } catch (SQLException e) { e.printStackTrace(); objMens.put("mensagem",
				 * "Erro sql = " + e); out.print(objMens.toString()); }
				 * 
				 * }else if(acao.equals("postar")) {
				 * 
				 * 
				 * String titulo = req.getParameter("titulo"); String temas =
				 * req.getParameter("temas"); String descricao = req.getParameter("descricao");
				 * String codePerson = req.getParameter("codePerson");
				 * 
				 * Perguntas perg = new Perguntas(); Pessoa p = new Pessoa();
				 * 
				 * /*HttpSession session = (HttpSession) req.getSession(); Pessoa codUser =
				 * (Pessoa) session.getAttribute("codigoPessoa");
				 * 
				 * p.setCodePerson(Integer.valueOf(codePerson)); perg.setPessoa(p);
				 * perg.setPergunta(titulo); perg.setTema(temas); perg.setDescricao(descricao);
				 * 
				 * 
				 * System.out.println("quase funcionou"); try { if(pDao.realizarPergunta(perg))
				 * { objMens.put("mensagem", "0"); out.print(objMens.toString());
				 * System.out.println("certo");
				 * 
				 * }else if(pDao.realizarPergunta(perg) == false){ objMens.put("mensagem", "1");
				 * out.print(objMens.toString()); System.out.println("errado");
				 * 
				 * }else{ System.out.println("outro erro"); }
				 * 
				 * } catch (SQLException e) { e.printStackTrace(); objMens.put("mensagem",
				 * "erro sql = " + e); out.print(objMens.toString()); }
				 * 
				 * }
				 */

			} else if (acao.equals("cadastrar")) {
				Pessoa p = new Pessoa();

				String apelido, p_nome, s_nome, senha, confSenha, email, cep, cpf, rg, genero, referencia, tel1,
						tel2;

				apelido = req.getParameter("apelido");
				p_nome = req.getParameter("pNome");
				s_nome = req.getParameter("sNome");
				senha = req.getParameter("senha");
				confSenha = req.getParameter("confSenha");
				email = req.getParameter("email");
				cep = req.getParameter("cep");
				cpf = req.getParameter("cpf");
				rg = req.getParameter("rg");
				tel1 = req.getParameter("tel1");
				tel2 = req.getParameter("tel2");
				referencia = req.getParameter("referencia");
				genero = req.getParameter("genero");
				
				String filePath = req.getParameter("pathFile");

				try {

					SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
					Date dataNasc;
			
					dataNasc = format.parse(req.getParameter("nascimento"));
					p.setNascimento(dataNasc);

					Part file = req.getPart("imagem");
					String fileName = file.getSubmittedFileName();
					System.out.println("FN - " + fileName);

					int posInicial = fileName.lastIndexOf('.');
					int posFinal = fileName.length();
					ext = fileName.substring(posInicial, posFinal);

					InputStream fileContent = file.getInputStream();
					System.out.println("NOME - " + p_nome.trim() + ext);
					
					OutputStream os = new FileOutputStream(filePath + "img//" + p_nome.trim() + ext);
					
					int data = fileContent.read();

					while (data != -1) {
						os.write(data);
						data = fileContent.read();
					}

					os.close();
					fileContent.close();

					}catch (Exception e) {
					// TODO: handle exception
				}

				p.setApelido(apelido);
				p.setP_nome(p_nome);
				p.setS_nome(s_nome);
				p.setSenha(senha);
				p.setEmail(email);
				p.setCep(cep);
				p.setCpf(cpf);
				p.setTel1(tel1);
				p.setTel2(tel2);
				p.setReferencia(referencia);
				p.setGenero(genero);
				p.setRg(rg);
				
				p.setImgPerfil(rg + p_nome.trim());

				try {
					if (pDao.verificarUsuario(p)) {
						if (senha.equals(confSenha)) {
							if (pDao.cadastrar(p, acaoConta)) {
								objMens.put("mensagem", "0");
								out.print(objMens.toString());
								System.out.println("certo");

							} else {
								objMens.put("mensagem", "1");
								out.print(objMens.toString());
								System.out.println("errado");
							}
						} else {
							objMens.put("mensagem", "2");
							out.print(objMens.toString());
							System.out.println("erradi2");
						}
					} else {
						objMens.put("mensagem", "3");
						out.print(objMens.toString());
						System.out.println("Conta ja existe");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} else if (acao.equals("login")) {
				Pessoa p = new Pessoa();
				try {
					System.out.println("Chegou aqui");

					String login = req.getParameter("login");
					String senha = req.getParameter("senha");

					p.setApelido(login);
					p.setEmail(login);
					p.setSenha(senha);

					if (pDao.login(p) != null) {

						//Integer CodeUser = pDao.login(p);
						String[] recebe = pDao.login(p).split(";");

						objMens.put("codeUser", recebe[0]);
						objMens.put("mensagem", "0");
						objMens.put("cargo", recebe[1]);
						out.print(objMens.toString());
						System.out.println(objMens.toString());
						//resp.sendRedirect("/goldpetFrontEnd/perfil.jsp");
						
					} else {
						objMens.put("mensagem", "1");
						out.print(objMens.toString());
						System.out.println("Senha e/ou incorretos!");
					}
				} catch (SQLException e) {
					e.printStackTrace();
					objMens.put("mensagem", "erro sql = " + e);
					out.print(objMens.toString());
				}

			} else if (acao.equals("mostrarCredencial")) {

				Pessoa p = new Pessoa();
				
				System.out.println("CREDENCIAL");

				String codigo = req.getParameter("codeUser");
				try {
					p = pDao.perfil(Integer.valueOf(codigo));
					System.out.println("codigoUser= " + codigo);

					objMens.put("apelido", p.getApelido());
					objMens.put("nome", p.getP_nome() + " " + p.getS_nome());
					objMens.put("nascimento", p.getNascimento());
					objMens.put("genero", p.getGenero());
					objMens.put("tel1", p.getTel1());
					objMens.put("tel2", p.getTel2());
					objMens.put("email", p.getEmail());
					objMens.put("endereco", p.getCep());
					objMens.put("rank", p.getGuardiao().getRank());
					objMens.put("aniResgatados", p.getGuardiao().getAnimasResgatados());
					objMens.put("progresso", p.getGuardiao().getProgresso());
					
					out.print(objMens.toString());
					System.out.println(objMens.toString());

				} catch (SQLException e) {
					e.printStackTrace();
					objMens.put("mensagem", "erro sql = " + e);
					out.print(objMens.toString());
				}
			}
		} else {
			objMens.put("mensagem", "aguardando requisição");
			out.print(objMens.toString());
		}

	}
}
