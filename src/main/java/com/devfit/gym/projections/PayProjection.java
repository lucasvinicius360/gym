package com.devfit.gym.projections;

import java.util.Date;

public interface PayProjection {
    Long getIdUser();
    String getNameUser();
    Date getDtPay();
    Integer getVlPay();
}
