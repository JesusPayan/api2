package com.N12.api.utils;

import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Utils {
    private static String UPLOADED_FOLDER = "C:/XD_CODE/api2/api/files";

    public List<String> getOrders(MultipartFile file) {
        List<String> lines = new ArrayList<>();
        System.out.println("Entro al metodo");
        if (file.isEmpty()) {
            System.out.println("Falta Archivo");
        } else {
            try {
                InputStream in = file.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lines;
    }

    public Map<String,String>GetRemSku(String remsku){
        Map<String,String> orderNumberMaterialSku = new HashMap<>();
        int comaIndex = 0;
        String key,value;
        comaIndex = remsku.indexOf(",");
        key = remsku.substring(0,remsku.indexOf(","));
        value = remsku.substring(remsku.indexOf(","),remsku.length());
        //orderNumberMaterialSku.put(),remsku.substring(remsku.indexOf(","),remsku.length()));
        key = formatRem(key);
        System.out.println("Remision: "+ key + " sku: "+ value);
        return orderNumberMaterialSku;

    }

    public String formatRem(String rem){
        String newRem ="0";
        if(rem.length()<10|| rem.length()>40){
            System.out.println("Remision menor a 10 o mayor a 40 ");
            System.out.println(10-rem.length());
        }
        return rem;
    }
}