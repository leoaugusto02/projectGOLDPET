package servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.JSONException;
import org.json.JSONObject;

import dao.ResgateDAO;
import vo.Resgate;

@WebServlet("/ProcessaResgate")
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
		
		
		if(acao != null) {
			if(acao.equals("listarAnimaisResgate")) {
				
				try {
					if(rDao.ultimosResgates() != null) {
						List<Resgate> lstResgate = rDao.ultimosResgates();
						for(Resgate r : lstResgate) {
							objMens.put("codeResgate", r.getCodResgate());
							objMens.put("status", r.getStatus());
							objMens.put("nivelUrgencia", r.getNivelUrgencia());
							objMens.put("dogeImagem", r.getDogeImagem());
							
							out.print(objMens.toString() + "\n");
						}
					}else {
						objMens.put("mensagem", "não existe animais para resgate");
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
		
		if(acaoModal != null) {
			if(acaoModal.equals("inserirResgate")) {
				String raca = req.getParameter("raca");
				String porte = req.getParameter("porte");
				String especie = req.getParameter("especie");
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
					System.out.println("NOME - " + raca.trim() +" PORTE - " + porte.trim() + ext);
					// OutputStream os = new
					// FileOutputStream("D:\\Documentos\\Workspace\\Eclipse\\UpLoad\\WebContent\\images\\"
					// + nome + ext);
					OutputStream os = new FileOutputStream(filePath + "img//" + raca.trim() + porte.trim() + ext);

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
				
				r.set
				
			}
		}
    	
    }


	
	
	
	
}
