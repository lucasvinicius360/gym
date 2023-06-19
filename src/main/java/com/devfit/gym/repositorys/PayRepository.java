package com.devfit.gym.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devfit.gym.dto.PayDto;

@Repository
public interface PayRepository extends JpaRepository<PayDto,Long>{

    @Query(nativeQuery = true, value = "select uog.id_user, uog.name_user, bg.vl_pay, bg.dt_pay from user_of_gym uog left join balence_gym bg on uog.id_user = bg.user_id ")
    List<PayDto>Geral();

}
