package com.devfit.gym.repositorys;

import java.util.*;     
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devfit.gym.dto.PayDto;
import com.devfit.gym.models.UserOfGym;



@Repository
public interface UserOfGymRepository extends JpaRepository<UserOfGym,Long> {

    UserOfGym findByCpf(Integer cpf);

    UserOfGym findByNameUser(String nameUser);

    @Query(nativeQuery = true, value = "select * from user_of_gym "
            +" where ds_email is not null")
    List<UserOfGym> findByDsEmailIsNotNull();

    @Query(nativeQuery = true, value = "select uog.id_user, uog.name_user, bg.vl_pay, bg.dt_pay from user_of_gym uog left join balence_gym bg on uog.id_user = bg.user_id ")
    List<UserOfGym>balenceGeral();


    @Query(nativeQuery = true,value ="select id_user ,name_user,dt_pay, vl_pay  from user_of_gym uog, balence_gym bg where uog .id_user = bg.user_id ")
    List<PayDto> getBalance();


    
    
}
