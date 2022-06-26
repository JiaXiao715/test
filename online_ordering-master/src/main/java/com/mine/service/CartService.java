package com.mine.service;

import com.mine.dao.CartMapper;
import com.mine.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    public boolean addCart(Cart cart){
        return cartMapper.addCart(cart);
    }

    public boolean updateCart(Cart cart){
        return cartMapper.updateCart(cart);
    }

    public boolean deleteCart(int cart_id){
        return cartMapper.deleteCart(cart_id);
    }

    public List<Cart> queryAllCartByUserId(int user_id){
        return cartMapper.queryAllCartByUserId(user_id);
    }

}
