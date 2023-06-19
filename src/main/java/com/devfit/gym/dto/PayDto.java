package com.devfit.gym.dto;

import java.util.Date;

import com.devfit.gym.projections.PayProjection;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;




@Entity
public class PayDto {


    @Id
    private Long idUser;

    private String  nameUser;

    private Date dtPay;

    private Integer vlPay;

    public PayDto(Long idUser, String nameUser, Date dtPay, Integer vlPay) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.dtPay = dtPay;
        this.vlPay = vlPay;
    }

    public PayDto(PayProjection payProjection) {
        this.idUser = payProjection.getIdUser();
        this.nameUser = payProjection.getNameUser();
        this.dtPay = payProjection.getDtPay();
        this.vlPay = payProjection.getVlPay();
    }

    public PayDto() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public Date getDtPay() {
        return dtPay;
    }

    public void setDtPay(Date dtPay) {
        this.dtPay = dtPay;
    }

    public Integer getVlPay() {
        return vlPay;
    }

    public void setVlPay(Integer vlPay) {
        this.vlPay = vlPay;
    }

}
