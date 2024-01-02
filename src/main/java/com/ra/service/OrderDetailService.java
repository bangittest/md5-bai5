package com.ra.service;

import com.ra.model.dto.orders.OrderDetailDTO;
import com.ra.model.entity.OrderDetail;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;

import java.util.List;

public interface OrderDetailService {
    OrderDetail createOrderDetail(Orders order, Product product, Integer quantity);
    List<OrderDetailDTO>findAll();
}
