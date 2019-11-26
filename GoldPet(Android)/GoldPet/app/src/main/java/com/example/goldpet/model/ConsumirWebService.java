package com.example.goldpet.model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsumirWebService{

    //                                  ---WEB SERVICE PARA PESSOA---
    public static String cadastrar(String pNome, String sNome, String apelido, String cep, String referencia, String cpf, String rg, String tel1, String tel2,
                            String dataNasc, String email, String senha, String confSenha, String genero, String acao, String acaoConta){
        String urlWebService = "http://10.87.202.147:8080/goldpetBackEnd/ProcessaPessoas";

        try{

            String parametros = "pNome=" + pNome + "&sNome=" + sNome + "&apelido=" + apelido +
                    "&cep=" + cep + "&referencia=" + referencia + "&cpf="+ cpf + "&rg=" + rg +
                    "&tel1=" + tel1 + "&tel2=" + tel2 + "&nascimento=" + dataNasc + "&email=" + email +
                    "&senha=" + senha + "&confSenha=" + confSenha + "&genero=" + genero
                    + "&acao=" + acao + "&acaoConta=" + acaoConta;


            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);


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

    public static JSONObject login(String login, String senha, String acao){
        String urlWebService = "http://192.168.56.1:8080/goldpetBackEnd/ProcessaPessoas";

        try{
            String parametros = "login=" + login + "&senha=" + senha + "&acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String apnd = "", linha = "";

            while((linha = br.readLine()) != null) apnd += linha;

            JSONObject obj = new JSONObject(apnd);

            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject perfil(int codeUser){
        String urlWebService = "http://192.168.56.1:8080/goldpetBackEnd/ProcessaPessoas";
        String acao = "mostrarCredencial";
        try{
            String parametros = "codeUser=" + codeUser + "&acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String apnd = "", linha = "";

            while ((linha = br.readLine()) != null)
                apnd += linha;

            JSONObject obj = new JSONObject(apnd);

            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //                                  ---WEB SERVICE PARA ANIMAL---

    public static JSONArray listarAnimaisAdocao(String acao){
        String urlWebService = "http://10.87.202.178:8080/goldpetBackEnd/ProcessaAnimais";

        try {
            String parametros = "acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);


            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String linha = "";
            JSONObject obj = new JSONObject();
            JSONArray arr = new JSONArray();

            while ((linha = br.readLine()) != null) {
                System.out.println("Tô aqui " + linha);
                obj = new JSONObject(linha);
                arr.put(obj);
            }
            return arr;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public static JSONObject perfilAnimal(Integer codAnimal){
        String urlWebService = "http://10.87.202.147:8080/goldpetBackEnd/ProcessaAnimais";
        String acao = "perfil";
        try{
            String parametros = "codeUser=" + codAnimal + "&acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String apnd = "", linha = "";

            while ((linha = br.readLine()) != null)
                apnd += linha;

            JSONObject obj = new JSONObject(apnd);

            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

}