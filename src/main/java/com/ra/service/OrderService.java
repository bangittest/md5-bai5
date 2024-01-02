package com.ra.service;

import com.ra.model.dto.orders.OrderDTO;
import com.ra.model.entity.Orders;

import java.util.List;


public interface OrderService {
    List<Orders> findAll();
    OrderDTO createOrder(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    OrderDTO findById(Long id);
}
