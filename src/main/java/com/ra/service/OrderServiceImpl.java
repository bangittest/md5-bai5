package com.ra.service;
import com.ra.model.dto.orders.OrderDTO;

import com.ra.model.entity.Orders;

import com.ra.model.entity.User;
import com.ra.reponsitory.OrdersReponsitory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrdersReponsitory ordersReponsitory;
    @Autowired
    private UserService userService;


    @Override
    public List<Orders> findAll() {
        return ordersReponsitory.findAll();
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Orders orders=new Orders();
       orders.setTotalPrice(orders.calculateTotalPrice());
       orders.setCreatedDate(new Date());
       orders.setNote(orderDTO.getNote());
       orders.setAddress(orderDTO.getAddress());
       User user=userService.findById(orderDTO.getUserId());
       orders.setUser(user);
       orders.setPhone(orderDTO.getPhone());
       orders.setStatus(0);
       ordersReponsitory.save(orders);
       orders.setId(orderDTO.getId());
//       List<OrderDetailDTO> orderDetailDTOS=orderDetailService.findAll();
//        for (OrderDetailDTO orderDetailDTO:orderDetailDTOS) {
//
//        }
       return orderDTO;
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Optional<Orders> ordersUpdate = ordersReponsitory.findById(orderDTO.getId());

        if (ordersUpdate!=null) {
            Orders orders=ordersUpdate.get();
            orders.setId(orderDTO.getId());
            orders.setStatus(orderDTO.getStatus());
            orders.setPhone(orderDTO.getPhone());
            User user=userService.findById(orderDTO.getUserId());
            orders.setUser(user);
            orders.setTotalPrice(orderDTO.getTotalPrice());
            orders.setCreatedDate(orderDTO.getCreatedDate());
            ordersReponsitory.save(orders);
            return orderDTO;
        } else {
            return null;
        }
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Orders> orderDTO=ordersReponsitory.findById(id);
        if (orderDTO.isPresent()){
            Orders orders=orderDTO.get();
            OrderDTO orderDTO1=new OrderDTO();
            orderDTO1.setUserId(orders.getUser().getId());
            orderDTO1.setNote(orders.getNote());
            orderDTO1.setStatus(orders.getStatus());
            orderDTO1.setPhone(orders.getPhone());
            orderDTO1.setCreatedDate(orders.getCreatedDate());
            orderDTO1.setTotalPrice(orders.getTotalPrice());
            orderDTO1.setAddress(orders.getAddress());
            return orderDTO1;
        }
        throw new EntityNotFoundException("Order with ID " + id + " not found");
    }
}
