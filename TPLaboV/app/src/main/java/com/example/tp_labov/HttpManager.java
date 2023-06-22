package com.example.tp_labov;

import android.util.AndroidException;
import android.view.WindowManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;

public class HttpManager {
    public String getData(String urlLink) throws IOException {
        URL url=new URL(urlLink);
        //open conexion
        HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
        // send
        urlConnection.connect();
        int response= urlConnection.getResponseCode();
        if( response==200){
            //enlace a la conexion
            InputStream is =urlConnection.getInputStream();
            //traigo los datos de a porciones
            ByteArrayOutputStream bos =new ByteArrayOutputStream();
            //recorro el string por un buffer
            byte[] buffer= new byte[1024];
            int legth=0;
            while ((legth=is.read(buffer))!=-1){
                bos.write(buffer,0,legth);
            }
            is.close();
            return  new String(bos.toByteArray());

        }else{
            throw  new RuntimeException("error");
        }
    }
}

