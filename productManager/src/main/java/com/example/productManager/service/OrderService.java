package com.example.productManager.service;

import com.example.productManager.exception.OrderNotFoundException;
import com.example.productManager.model.Orders;
import com.example.productManager.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrdersRepository ordersRepository;

    public Orders getOrderById(int id) {
        return ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with ID: " + id + " not found"));
    }
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders updateOrder(int id, Orders order) {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new RuntimeException("Order with ID: " + id + " not found"));
        if (orders != null) {
            orders.setUserId(order.getUserId());
            orders.setOrderId(order.getOrderId());
            orders.setTotalAmount(order.getTotalAmount());
            orders.setDate(order.getDate());
            return ordersRepository.save(orders);
        }
        return order;
    }
    public boolean deleteOrder(int id) {
        Orders orders = ordersRepository.findById(id).orElse(null);
        if (orders != null) {
            ordersRepository.delete(orders);
            return true;
        }
        return false;
    }
    public void delete(Orders order) {
        ordersRepository.delete(order);
    }
    public void deleteAllOrders() {
        ordersRepository.deleteAll();
    }
    public Orders addOrder(Orders order) {
        return ordersRepository.save(order);
    }

}
