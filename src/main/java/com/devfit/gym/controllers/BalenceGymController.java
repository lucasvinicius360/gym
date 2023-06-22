package com.devfit.gym.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devfit.gym.dto.InsertBalanceDTO;
import com.devfit.gym.models.BalenceGym;
import com.devfit.gym.repositorys.BalenceGymRepository;
import com.devfit.gym.repositorys.InsertBalanceDToRepository;

import jakarta.transaction.Transactional;

@RestController
public class BalenceGymController {
    
    @Autowired
    private BalenceGymRepository balenceGymRepository;


    @Autowired(required=true)
    private InsertBalanceDToRepository insertBalanceDToRepository;

   

    @ResponseBody
    @Transactional
    @RequestMapping(path = "/saveBalance", method = RequestMethod.POST)
    public ResponseEntity<Object> saveBalence(@RequestBody InsertBalanceDTO insertBalanceDTO){
        
        Object balenceGym = new Object();
        System.out.println(insertBalanceDTO.getUserId());
    
        Integer userId = insertBalanceDTO.getUserId();
        Integer vlPay = insertBalanceDTO.getVlPay();

        try {

            insertBalanceDToRepository.insertBalance(userId,vlPay);

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        balenceGym = insertBalanceDToRepository.getInsertPay(userId);

        return new ResponseEntity<>(balenceGym,HttpStatus.CREATED);

    }


    @ResponseBody
    @RequestMapping(path = "/everyBale/",method = RequestMethod.GET)
    public Object balenceGeral(){
        Object resultQuery = balenceGymRepository.findAll();
        return resultQuery;
    }


    @ResponseBody
    @RequestMapping(path = "/balanceById/{userId}",method = RequestMethod.GET)
    public Object balenceById(Integer userId){
        Object resultQuery = balenceGymRepository.findByUserId(userId);
        return resultQuery;
    }
}
