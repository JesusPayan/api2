package com.N12.api.repository;

import com.N12.api.entity.ExtnLogXD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileLoaderRepository extends JpaRepository<ExtnLogXD,String> {

    @Query(value = "select remision,sku,tienda,interal_estatus,createts,http_response,xml from extn_log_xd where 1=1 and log_xd_key > :rem and remision = '20062891' and sku = :sku and interal_estatus = 'ENVIADOWSXD'", nativeQuery = true)
    String getXML(@Param("rem") String rem, @Param("sku") String sku);

}
