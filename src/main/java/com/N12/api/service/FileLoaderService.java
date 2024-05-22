package com.N12.api.service;


import com.N12.api.entity.ExtnLogXD;
import org.springframework.stereotype.Service;

import java.io.File;

import java.util.List;

@Service
public interface FileLoaderService {

   //@Query(value = "select remision,sku,tienda,interal_estatus,createts,http_response,xml from extn_log_xd where 1=1 and log_xd_key > :rem and remision = '20062891' and sku = :sku and interal_estatus = 'ENVIADOWSXD'", nativeQuery = true)
   ExtnLogXD getObject(String rem, String sku);

    public File findXML(List<String> orders);
}
