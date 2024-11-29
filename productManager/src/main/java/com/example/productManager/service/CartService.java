package com.example.productManager.service;

import com.example.productManager.model.Cart;
import com.example.productManager.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public List<Cart> getCart() {
        return cartRepository.findAll();
    }
    public Cart getCartById(int id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart with ID: " + id + " not found"));
    }

    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }
    public Cart updateCart(int id, Cart cart) {
        Cart oldCart = cartRepository.findById(id).orElse(null);
        if (oldCart != null) {
            oldCart.setCartId(cart.getCartId());
            oldCart.setQuantity(cart.getQuantity());
            oldCart.setProductId(cart.getProductId());
            return cartRepository.save(oldCart);
        }
        return null;
    }

    public boolean deleteCart(int id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart != null) {
            cartRepository.delete(cart);
            return true;
        }
        return false;
    }
    public void delete(Cart cart) {
        cartRepository.delete(cart);
    }
    public void deleteAllCarts() {
        cartRepository.deleteAll();
    }

}
