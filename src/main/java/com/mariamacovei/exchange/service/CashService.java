package com.mariamacovei.exchange.service;

import com.mariamacovei.exchange.dto.CashRequest;

public interface CashService {

    Long changeAmount(CashRequest request);
}
