package com.devfit.gym.controllers;

import com.devfit.gym.dto.PayDto;
import com.devfit.gym.models.*;

import com.devfit.gym.repositorys.*;


import jakarta.transaction.Transactional;


import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserOfGymController {

    @Autowired
    private UserOfGymRepository userOfGymRepository;

    @Autowired
    private PayRepository payRepository;



    @ResponseBody
    @Transactional
    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<UserOfGym> saveUser(@RequestBody UserOfGym userOfGym) {

        System.out.println(userOfGym);
        
        if (userOfGymRepository.findByCpf(userOfGym.getCpf()) != null) {
            return new ResponseEntity<UserOfGym>(HttpStatus.BAD_REQUEST);
        } else {
            userOfGym.setToken(gerarSenha());
            userOfGymRepository.save(userOfGym);

        }

        UserOfGym resultOfSave = userOfGymRepository.findByCpf(userOfGym.getCpf());
        return new ResponseEntity<>(resultOfSave, HttpStatus.CREATED);

    }  

    @ResponseBody
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public Object getAll(){
        Object result = userOfGymRepository.findAll();
        return result;
    }


    @ResponseBody
    @RequestMapping(path = "/emailNotNull", method = RequestMethod.GET)
    public List<UserOfGym> emailNotNull(){

        List<UserOfGym> resultQuery = userOfGymRepository.findByDsEmailIsNotNull();
        return resultQuery;

    }

    @ResponseBody
    @RequestMapping(path = "/everyBalence",method = RequestMethod.GET)
    public List<PayDto> balenceGeral(){
        List<PayDto> resultQuery = payRepository.Geral();
        return resultQuery;
    }




    

  

// ====================methods ======================
    public  String gerarSenha(){
		int qtdeMaximaCaracteres = 8;
	    String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z"};
	    
		StringBuilder senha = new StringBuilder();

        for (int i = 0; i < qtdeMaximaCaracteres; i++) {
            int posicao = (int) (Math.random() * caracteres.length);
            senha.append(caracteres[posicao]);
        }
        return senha.toString();
        
	}

    

}
