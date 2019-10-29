package com.example.goldpet;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumirWebService {

    public JSONObject cadastrar(String pNome, String sNome){
        String urlWebService = "http://192.160.56.1:8080/goldpetBackEnd/ProcessaPessoas ";

        try{
            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp = "";


        }catch(Exception e){

        }

    }

}
