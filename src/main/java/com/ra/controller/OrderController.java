package com.ra.controller;
import com.ra.model.dto.orders.OrderDTO;
import com.ra.model.entity.Orders;
import com.ra.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Orders>>findAll(){
        List<Orders> orders=orderService.findAll();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @PostMapping("/order")
    public ResponseEntity<?> create(@RequestBody OrderDTO orderDTO){
        if (orderDTO==null){
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
        OrderDTO orders1=orderService.createOrder(orderDTO);
        return new ResponseEntity<>(orders1,HttpStatus.CREATED);
    }
    @PatchMapping("/order/{id}")
    public ResponseEntity<?>changeStatus(@PathVariable("id") Long id){
        OrderDTO orderDTO=orderService.findById(id);
        if (orderDTO==null){
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        if (orderDTO.getStatus()==1){
            orderDTO.setStatus(1);
            orderService.update(orderDTO);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else if (orderDTO.getStatus()==2){
            orderDTO.setStatus(1);
            orderService.update(orderDTO);
            return new ResponseEntity<>("success",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
    }
}
