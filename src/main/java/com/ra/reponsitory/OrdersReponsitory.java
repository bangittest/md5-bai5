package com.ra.reponsitory;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersReponsitory extends JpaRepository<Orders,Long> {
    List<Orders> findAllByUserOrderByCreatedDateDesc(User user);
}
