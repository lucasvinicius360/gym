package com.devfit.gym.dto;


import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InsertBalanceDTO {
    
    @Id
    private Long idBalance;
    
    
    public Long getIdBalance() {
        return idBalance;
    }



    public void setIdBalance(Long idBalance) {
        this.idBalance = idBalance;
    }

    private Integer userId;


    private Date dtPay;


    private Integer vlPay;

    
    public Integer getVlPay() {
        return vlPay;
    }

    

    public void setVlPay(Integer vlPay) {
        this.vlPay = vlPay;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    

    public Date getDtPay() {
        return dtPay;
    }

    public void setDtPay(Date dtPay) {
        this.dtPay = dtPay;
    }
}
