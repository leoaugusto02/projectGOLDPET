package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import org.json.JSONException;
import org.json.JSONObject;

import dao.ResgateDAO;
import vo.Resgate;


@MultipartConfig
@WebServlet("/ProcessaResgate")

//@WebServlet(name = "FileUploadServlet", urlPatterns = { "/ProcessaResgate" }, loadOnStartup = 1)
public class ProcessaResgate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	PrintWriter out = resp.getWriter();
		JSONObject objMens = new JSONObject();
		ResgateDAO rDao = new ResgateDAO();
		
		String acao = req.getParameter("acao");
		String acaoModal = req.getParameter("acaoModal");
		String ext = "";

		int verifica = 0;

		System.out.println("A - " + acao);
		System.out.println("AM - " + acaoModal);
		
		if(acao != null) {
			if(acao.equals("listarAnimaisResgate")) {
				verifica = 1;
				try {
					if(rDao.ultimosResgates() != null) {
						List<Resgate> lstResgate = rDao.ultimosResgates();
						
						for(Resgate r : lstResgate) {
							objMens.put("codeResgate", r.getCodResgate());
							objMens.put("descricao", r.getDescricao());
							objMens.put("endereco", r.getEndereco());
							objMens.put("status", r.getStatus());
							objMens.put("dogeImagem", r.getDogeImagem());
							objMens.put("nivelUrgencia", r.getNivelUrgencia());
							
							out.print(objMens.toString() + "\n");
						}
					
					}else {
						objMens.put("status", "ntem");
					}
				} catch (JSONException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			objMens.put("mensagem", "aguardando requisição");
			out.print(objMens.toString());
		}
		
		if((acaoModal != null) && (verifica == 0)) {
			if(acaoModal.equals("inserirResgate")) {
				System.out.println("ENTREI NO INSERIR RESGATE");
				String descricao = req.getParameter("descricao");
				String endereco = req.getParameter("endereco");
				int nivel = Integer.valueOf(req.getParameter("nivel"));
				String filePath = req.getParameter("uploaded_file");
				
				try {

					Part file = req.getPart("imagem");
					String fileName = file.getSubmittedFileName();
					System.out.println("FN - " + fileName);

					int posInicial = fileName.lastIndexOf('.');
					int posFinal = fileName.length();
					ext = fileName.substring(posInicial, posFinal);

					InputStream fileContent = file.getInputStream();
					System.out.println("Descricao - " + descricao.trim() +" Endereco - " + endereco.trim() + ext);
					// OutputStream os = new
					// FileOutputStream("D:\\Documentos\\Workspace\\Eclipse\\UpLoad\\WebContent\\images\\"
					// + nome + ext);
					OutputStream os = new FileOutputStream(filePath + "img//" + descricao.trim() + endereco.trim() + ext);

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
				
				Resgate r = new Resgate();

				r.setDescricao(descricao);
				r.setEndereco(endereco);
				r.setNivelUrgencia(nivel);
				r.setDogeImagem(descricao.trim() + endereco.trim() + ext);
				
				try {
					if (rDao.inserirResgate(r)) {
						System.out.println("Resgate inserido com sucesso");
						resp.sendRedirect("http://localhost:8080/goldpetFrontEnd/Resgate.jsp");
					}else {
						System.out.println("Algo deu errado");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				System.out.println("FIM NO INSERIR RESGATE");
				
			}
		}else if(verifica == 0){
	    	objMens.put("mensagemModal", "nenhuma requisição ao modal");
			out.print(objMens.toString());
	    }

    	
    }
}
