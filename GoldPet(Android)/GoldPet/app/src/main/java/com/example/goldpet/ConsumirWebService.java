package com.example.goldpet;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsumirWebService {

    public JSONObject cadastrar(String[] campos){
        String urlWebService = "http://192.168.56.1:8080/goldpetBackEnd/ProcessaPessoas ";

        try{
            URL url = new URL(urlWebService);
            HttpURLConnection conexaoWeb = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexaoWeb.getInputStream()));


        }catch(Exception e){

        }

    }

}
