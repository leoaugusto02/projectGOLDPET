package com.example.goldpet;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumirWebService {

    public static String cadastrar(String pNome, String sNome, String apelido, String cep, String referencia, String cpf, String rg, String tel1, String tel2,
                            String dataNasc, String email, String senha, String confSenha, String genero, String acao, String acaoConta){
        String urlWebService = "http://192.168.56.1:8080/goldpetBackEnd/ProcessaPessoas";

        try{

            String parametros = "pNome=" + pNome + "&sNome=" + sNome + "&apelido=" + apelido +
                    "&cep=" + cep + "&referencia=" + referencia + "&cpf="+ cpf + "&rg=" + rg +
                    "&tel1=" + tel1 + "&tel2=" + tel2 + "&nascimento=" + dataNasc + "&email=" + email +
                    "&senha=" + senha + "&confSenha=" + confSenha + "&genero=" + genero
                    + "&acao=" + acao + "&acaoConta=" + acaoConta;


            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));
            String apnd = "", linha = "";

            while((linha = br.readLine()) != null) apnd += linha;

            JSONObject obj = new JSONObject(apnd);

            String mensagem;

            if(obj.getString("mensagem").equals("0")){
                mensagem = "Cadastro concluido com sucesso";
            }else if(obj.getString("mensagem").equals("2")){
                mensagem = "As senhas precisam ser iguais";
            }else if(obj.getString("mensagem").equals("3")){
                mensagem = "Usuario já existe";
            }else{
                mensagem = "OPS! Algo deu errado";
            }

            return mensagem;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }

}