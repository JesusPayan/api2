package com.N12.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


import java.util.Date;

@Entity
@Table(name = "EXTN_LOG_XD")
@Data
public class ExtnLogXD {
    @Id
    @Column(name = "log_xd_key")
    private String log_xd_key;
    @Column(name ="REMISION")
    private String remision;
    @Column(name ="SKU")
    private String sku;
    @Column(name ="TIENDA")
    private String tienda;
    @Column(name ="INTERAL_ESTATUS")
    private String internalEstatus;
    @Column(name ="INTERAL_MENSAJE")
    private String INTERAL_MENSAJE;
    @Column(name ="HTTP_RESPONSE")
    private String httpResponse;
    @Column(name ="HTTP_STATUS")
    private String HTTP_STATUS;
    @Column(name ="SERVICE_CODE")
    private String SERVICE_CODE;
    @Column(name ="XML")
    private String xml;
    @Column(name ="CREATETS")
    private Date createTs;
    @Column(name ="MODIFYTS")
    private Date MODIFYTS;
    @Column(name ="CREATEUSERID")
    private String CREATEUSERID;
    @Column(name ="MODIFYUSERID")
    private String MODIFYUSERID;
    @Column(name ="CREATEPROGID")
    private String CREATEPROGID;
    @Column(name ="MODIFYPROGID")
    private String MODIFYPROGID;
    @Column(name ="LOCKID")
    private String LOCKID;
}
