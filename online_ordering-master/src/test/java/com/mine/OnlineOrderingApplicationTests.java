package com.mine;

import com.mine.dao.CartMapper;
import com.mine.dao.OrderMapper;
import com.mine.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class OnlineOrderingApplicationTests {

    @Autowired
    CartMapper cartMapper;

    @Autowired
    OrderMapper orderMapper;

    @Test
    void contextLoads() {
        for (Order order : orderMapper.queryAllOrder(2)) {
            System.out.println(order);
        }
    }

}
