package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


public interface ShoppingCartService {
    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);
}
