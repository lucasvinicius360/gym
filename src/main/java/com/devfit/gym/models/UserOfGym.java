package com.devfit.gym.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "user_of_gym")
public class UserOfGym {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name_user")
    private String  nameUser;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "height")
    private Float height;

    @Column(name = "token")
    private String token;

    @Column(name = "ds_email")
    private String dsEmail;

    
    
    

    public void setToken( String token) {
        this.token = token;
    }


    
}
