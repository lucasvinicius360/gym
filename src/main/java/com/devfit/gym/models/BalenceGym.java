package com.devfit.gym.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "balance_gym")
public class BalenceGym {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_balance")
    private Long idBalance;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserOfGym userId;

    @Column(name = "dt_pay")
    private Date dtPay;

    @Column(name = "vl_pay")
    private Integer vlPay;

    public void setDtPay() {
        this.dtPay = new Date();
    }

    public void setVlPay(Integer vlPay) {
        this.vlPay = vlPay;
    }
    
    @JsonProperty("user_id")
    public void setUserId(UserOfGym userId) {
        this.userId = userId;
    }

    
}
