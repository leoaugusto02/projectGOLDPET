package com.example.goldpet.model;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConsumirWebService{

    //                                  ---WEB SERVICE PARA PESSOA---
    public static String cadastrar(String pNome, String sNome, String apelido, String cep, String referencia, String cpf, String rg, String tel1, String tel2,
                            String dataNasc, String email, String senha, String confSenha, String genero, String acao, String acaoConta){
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaPessoas";

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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaPessoas";

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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaPessoas";
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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaAnimais";

        try {
            String parametros = "acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);


            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream(), "ISO-8859-1"));

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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaAnimais";
        String acao = "perfil";
        try{
            String parametros = "codAnimal=" + codAnimal + "&acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream(), "ISO-8859-1"));

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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaAnimais";
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

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream(), "ISO-8859-1"));

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
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaResgate";
        String acao = "listarAnimaisResgate";
        try {
            String parametros = "acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream(), "ISO-8859-1"));

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

    public static String inserirResgate(String descricao, String endereco, int nivel, Bitmap img){

        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaResgate";
        String acaoModal = "inserirResgate";

        try{
            ConexaoUploadArquivo cnua = new ConexaoUploadArquivo(urlWebService);
            cnua.addFormField("acaoModal", acaoModal);
            cnua.addFormField("descricao", descricao);
            cnua.addFormField("endereco", endereco);
            cnua.addFormField("nivel", String.valueOf(nivel));
            cnua.addFilePart("img", img);

            return cnua.finish();
        }catch (Exception e){
            Log.e("errorIO", String.valueOf(e));
            return null;
        }

    }

    public static String inserirAdocao(String nome, Integer idade, String raca, String porte, String especie, String genero, String status, Bitmap image){
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaAnimais";
        String acaoModal = "inserirPet";

        try{
            ConexaoUploadArquivo cnua = new ConexaoUploadArquivo(urlWebService);
            cnua.addFormField("acaoModal", acaoModal);
            cnua.addFormField("nome", nome);
            cnua.addFormField("idade", String.valueOf(idade));
            cnua.addFormField("porte", porte);
            cnua.addFormField("raca",raca);
            cnua.addFormField("especie",especie);
            cnua.addFormField("genero",genero);
            cnua.addFormField("status", status);

            cnua.addFilePart("imagem", image);

            return cnua.finish();
        }catch (Exception e){
            Log.e("ErrorSql", String.valueOf(e));
        }
        return null;
    }


    public static JSONArray listarUltimosAdotados(){
        String urlWebService = "http://192.168.1.5:8080/goldpetBackEnd/ProcessaAnimais";
        String acao = "homeListas";

        try{
            String parametros = "acao=" + acao;

            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();
            conexaoWeb.setRequestMethod("POST");
            conexaoWeb.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(conexaoWeb.getOutputStream());
            wr.writeBytes(parametros);

            BufferedReader br = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream(), "ISO-8859-1"));

            String linha;
            JSONObject obj;
            JSONArray arr = new JSONArray();

            while ((linha = br.readLine()) != null) {
                System.out.println("Tô aqui " + linha);
                obj = new JSONObject(linha);
                arr.put(obj);
            }

            return arr;
        }catch (Exception e){
            Log.e("ErrorSQL", "listarUltimosAdotados --" + e);
            return null;
        }



    }
}