package com.devfit.gym.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.devfit.gym.models.BalenceGym;
import com.devfit.gym.models.UserOfGym;

@Repository
public interface BalenceGymRepository extends JpaRepository<BalenceGym,Long> {
    
    @Query(nativeQuery = true, value = "select * from "
            +"user_of_gym uog ,balance_gym bg where uog.id_user = bg.user_id")
    List<BalenceGym>balenceGeral();

    

    @Query(nativeQuery = true, value = "select * from balance_gym where user_id = :userId")
    List<Object>balenceId(@Param("userId") Integer userId);

    
}
