package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.entities.Orders;
import java.util.List;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    Orders selectByPrimaryKey(Integer id);

    List<Orders> selectAll();

    int updateByPrimaryKey(Orders record);
}