package com.ra.service;

import com.ra.model.dto.orders.OrderDetailDTO;
import com.ra.model.entity.OrderDetail;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import com.ra.reponsitory.OrderDetailReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailReponsitory orderDetailReponsitory;
    @Autowired
    OrderService orderService;
    @Override
    public OrderDetail createOrderDetail(Orders order, Product product, Integer quantity) {
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setOrders(order);
        orderDetail.setProduct(product);
        orderDetail.setQty(quantity);
        return orderDetail;
    }

    @Override
    public List<OrderDetailDTO> findAll() {
        List<OrderDetail> orderDetailList=orderDetailReponsitory.findAll();
        List<OrderDetailDTO> orderDetailDTOS=new ArrayList<>();
        for (OrderDetail orderDetail:orderDetailList) {
            OrderDetailDTO orderDetailDTO=new OrderDetailDTO();
            orderDetailDTO.setOrderId(orderDetail.getOrders().getId());
            orderDetailDTO.setPrice(orderDetail.getPrice());
            orderDetailDTO.setId(orderDetail.getId());
            orderDetailDTO.setQty(orderDetail.getQty());
            orderDetailDTO.setCreatedDate(orderDetail.getCreatedDate());
            orderDetailDTOS.add(orderDetailDTO);
        }
        return orderDetailDTOS ;
    }
}
