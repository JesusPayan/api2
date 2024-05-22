package com.N12.api.service;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.N12.api.entity.ExtnLogXD;
import com.N12.api.repository.FileLoaderRepository;
import com.N12.api.repository.FlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.*;

@Component
public class FileLoaderServiceImp implements FileLoaderService {

    @Autowired
    private FlRepository flRepository;
    /*FileLoaderServiceImp(FlRepository fl){
        this.flRepository =  fl;
    }*/

    @Override
    public ExtnLogXD getObject(String rem, String sku) {
        List<ExtnLogXD> messages = new ArrayList<>();
        ExtnLogXD tableRow = new ExtnLogXD();//flRepository.findByRemision(rem,sku);
        String xml;
        long repeticiones;
        System.out.println("Remision a buscar "+ rem +" Sku:"+sku);
        System.out.println("------------------");
        try {
            /*
            System.out.println("Elemento encontrado" +
                    flRepository.findAll().stream()
                        .filter(p->p.getRemision().equals(rem.toString()))
                            .filter(p->p.getSku().equals(sku.toString()))
                            //.filter(t->t.getInternalEstatus().equals("ENVIADOWSXD"))
                            .findFirst()
                        .get());*/
            messages=flRepository.findByRemisionAndSku(rem,sku);
            //System.out.println("Elementos:" + messages);

            /*System.out.println("XML"+messages.stream()
                    .filter(p->p.getRemision().equals(rem))
                    .filter(t->t.getSku().equals(sku))
                    .findFirst().get());*/
            for(ExtnLogXD ele:messages){
                System.out.println("----------------------");
                System.out.println("XML:"+ele.getXml());
                System.out.println("----------------------");
                System.out.println("base64:"+Base64.getEncoder().encodeToString(ele.getXml().getBytes(StandardCharsets.UTF_8)));
            }


        }catch (Exception e){
         e.printStackTrace();
        }
        return tableRow;//flRepository.findByRemision(rem,sku);
    }

    //metodo to get rem-sku Sterling xml
    public File findXML(List<String> orders) {
        String xml;
        Map<String, String> orderSku = new HashMap<>();
        String key, value;
        for (String rem_sku : orders) {
            System.out.println("---------");
            key = rem_sku.substring(0, rem_sku.indexOf(","));
            value = rem_sku.substring(rem_sku.indexOf(",")+1, rem_sku.length());
           getObject(key, value);
           //System.out.println(xml);
        }
        System.out.println("--------------------");

        return null;
    }
}

/*
public class FileLoaderRepositoryBeans{
    @Bean
    public FileLoaderRepository(){

    }
}*/