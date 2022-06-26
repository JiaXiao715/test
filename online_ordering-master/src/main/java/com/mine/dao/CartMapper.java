package com.mine.dao;

import com.mine.pojo.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    List<Cart> queryAllCartByUserId(int user_id);

    boolean addCart(Cart cart);

    boolean updateCart(Cart cart); //更新

    boolean deleteCart(int cart_id);
}
