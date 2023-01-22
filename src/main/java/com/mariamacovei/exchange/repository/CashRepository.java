package com.mariamacovei.exchange.repository;

import com.mariamacovei.exchange.entity.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRepository extends JpaRepository<Cash, Long> {
}
