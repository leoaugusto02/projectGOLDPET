package com.example.goldpet.model;
import android.net.Uri;

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
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaPessoas";

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
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaPessoas";

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
    } public static JSONObject perfil(int codeUser){
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaPessoas";
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
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaAnimais";

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
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaAnimais";
        String acao = "perfil";
        try{
            String parametros = "codAnimal=" + codAnimal + "&acao=" + acao;

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

    public static String inserirLaudo(int codAnimal, String nomeVet, String dataDiagnostico, String breveDiagnostico, String diagnosticoCompleto){
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaAnimais";
        String acao = "inserirLaudo";

        try {
            String parametros = "acao=" +  acao + "&codAnimal=" + codAnimal + "&nomeVet=" + nomeVet + "&dataDiagnostico=" + dataDiagnostico
                    + "&breveDiagnostico=" + breveDiagnostico + "&diagnosticoCompleto=" + diagnosticoCompleto;

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

            String mensagem = null;

            if(obj.getString("mensagem").equals("Laudo realizado com sucesso")){
                mensagem = "Laudo concluido com sucesso";
            }else if(obj.getString("mensagem").equals("Algo deu errado")){
                mensagem = "Algo deu errado";
            }

            return mensagem;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //                                  ---WEB SERVICE PARA RESGATE---

    public static JSONArray listarAnimaisResgate(){
        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaResgate";
        String acao = "listarAnimaisResgate";
        try {
            String parametros = "acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String linha;
            JSONObject obj;
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

    public static boolean inserirResgate(String descricao, String endereco, int nivel, byte[] image){

        String urlWebService = "http://192.168.1.40:8080/goldpetBackEnd/ProcessaResgate";
        String acaoModal = "inserirResgate";

        try{
            String twoHyphens = "--";
            String boundary = "*****";
            String lineEnd = "\r\n";

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setDoOutput(true);
            conexaoWeb.setUseCaches(false);
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setRequestProperty("Accept-Encoding", "");
            //conn.setRequestProperty("Connection", "Keep-Alive");
            conexaoWeb.setRequestProperty("ENCTYPE", "multipart/form-data");
            conexaoWeb.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            conexaoWeb.setRequestProperty("uploaded_file", String.valueOf(image));
            conexaoWeb.setRequestProperty("acaoModal", acaoModal);
            conexaoWeb.setRequestProperty("descricao", descricao);
            conexaoWeb.setRequestProperty("endereco", endereco);
            conexaoWeb.setRequestProperty("nivel", String.valueOf(nivel));


            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());

            /*String parametros = "acaoModal=" + acaoModal + "&descricao=" + descricao + "&endereco=" + endereco + "&nivel=" + nivel + "&pathFile=";

            wr.writeBytes(parametros);

            for(int i = 0; i < image.length; i++){
              wr.writeBytes(String.valueOf(image[i]));
            }*/


            //first parameter - acaoModal
            wr.writeBytes(twoHyphens + boundary + lineEnd);
            wr.writeBytes("Content-Disposition: form-data; name=\"descricao\"" + lineEnd + lineEnd
                    + acaoModal + lineEnd);

            //second parameter - descricao
            String testDesc = descricao.getBytes("UTF-8").toString();
            wr.writeBytes(twoHyphens + boundary + lineEnd);
            wr.writeBytes("Content-Disposition: form-data; name=\"descricao\"" + lineEnd + lineEnd
                    + testDesc + lineEnd);

            //third parameter - endereco
            String testEndec  = descricao.getBytes("UTF-8").toString();
            wr.writeBytes(twoHyphens + boundary + lineEnd);
            wr.writeBytes("Content-Disposition: form-data; name=\"endereco\"" + lineEnd + lineEnd
                    + testEndec + lineEnd);

            wr.writeBytes(twoHyphens + boundary + lineEnd);
            wr.writeBytes("Content-Disposition: form-data; name=\"nivel\"" + lineEnd + lineEnd
                    + nivel + lineEnd);

            //forth parameter - filename
            wr.writeBytes(twoHyphens + boundary + lineEnd);
            wr.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
                    + image + "\"" + lineEnd);
            wr.writeBytes(lineEnd);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            String linha = "";

            while ((linha = br.readLine()) != null) {
                System.out.println("Tô aqui " + linha);
            }

            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}