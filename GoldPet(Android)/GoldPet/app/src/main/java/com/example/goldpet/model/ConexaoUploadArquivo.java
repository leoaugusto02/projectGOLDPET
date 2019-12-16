package com.example.goldpet.model;

import android.graphics.Bitmap;
import android.os.StrictMode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoUploadArquivo {

    private HttpURLConnection conexaoWeb;
    private DataOutputStream wr;
    private final String boundary =  "*****";
    private final String crlf = "\r\n";
    private final String twoHyphens = "--";

    public ConexaoUploadArquivo(String urlRequested) throws IOException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        // creates a unique boundary based on time stamp
        URL url = new URL(urlRequested);
        conexaoWeb = (HttpURLConnection) url.openConnection();
        conexaoWeb.setUseCaches(false);
        conexaoWeb.setDoOutput(true); // indicates POST method
        conexaoWeb.setDoInput(true);
        conexaoWeb.setRequestMethod("POST");
        conexaoWeb.setRequestProperty("Connection", "Keep-Alive");
        conexaoWeb.setRequestProperty("Cache-Control", "no-cache");
        conexaoWeb.setRequestProperty(
                "Content-Type", "multipart/form-data;boundary=" + this.boundary);

        wr = new DataOutputStream(conexaoWeb.getOutputStream());
    }
    public void addFormField(String name, String value) throws  IOException{
        wr.writeBytes(this.twoHyphens + this.boundary + this.crlf);
        wr.writeBytes("Content-Disposition: form-data; name=\"" + name + "\""+ this.crlf);
        wr.writeBytes("Content-Type: text/plain; charset=UTF-8" + this.crlf);
        wr.writeBytes(this.crlf);
        wr.writeBytes(value+ this.crlf);
        wr.flush();
    }

    public void addFilePart(String fieldName, Bitmap img)
            throws IOException {

        String fileName = "tempImg.png";
        wr.writeBytes(this.twoHyphens + this.boundary + this.crlf);
        wr.writeBytes("Content-Disposition: form-data; name=\"" +
                fieldName + "\";filename=\"" +
                fileName + "\"" + this.crlf);
        wr.writeBytes(this.crlf);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        img.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] bytes = stream.toByteArray();
        wr.write(bytes);
    }

    public String finish() throws IOException {
        String response ="";

        wr.writeBytes(this.crlf);
        wr.writeBytes(this.twoHyphens + this.boundary +
                this.twoHyphens + this.crlf);

        wr.flush();
        wr.close();

        // checks server's status code first
        int status = conexaoWeb.getResponseCode();
        if (status == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = new
                    BufferedInputStream(conexaoWeb.getInputStream());

            BufferedReader responseStreamReader =
                    new BufferedReader(new InputStreamReader(responseStream));

            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            responseStreamReader.close();

            response = stringBuilder.toString();
            conexaoWeb.disconnect();
        } else {
            throw new IOException("Server returned non-OK status: " + status);
        }
        return response;
    }

}
