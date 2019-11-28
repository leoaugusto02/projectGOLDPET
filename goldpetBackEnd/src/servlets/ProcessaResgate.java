package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    	
    }


	
	
	
	
}
