package com.order.rest.service;

import com.order.rest.model.Order;
import com.order.rest.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepo orderDAO;

    @Override
    public Order save(Order obj) {
        return this.orderDAO.save(obj);
    }

    @Override
    public Set<Order> findAll() {
        return new HashSet<>(this.orderDAO.findAll());
    }

    @Override
    public Order findById(Long id) {
        return this.orderDAO.findById(id)
                .orElseThrow(OrderServiceImpl::invalidOrderId);
    }

    private static IllegalArgumentException invalidOrderId() {
        return new IllegalArgumentException("Invalid Order Id");
    }

    @Override
    public void deleteOrder(Long id) {
        this.orderDAO.deleteById(id);
    }
}
