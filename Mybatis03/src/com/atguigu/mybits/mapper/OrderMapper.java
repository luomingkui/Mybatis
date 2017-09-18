package com.atguigu.mybits.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.atguigu.mybits.beans.Customer;
import com.atguigu.mybits.beans.Order;

public interface OrderMapper {
	
	
	List<Order> testForEach(@Param("ids") List<Integer> ids);
	
	//使用动态SQL
	List<Order> testIf(Map<String, Object> params);

	//使用customer中完成自己以及关联表的属性
	Customer selectCustomer3(@Param("customerId") Integer customerId);
	
	//在customer中使用迫切左外连接的方式并且以别名的方式完成对于级联属性的查询
	Customer selectCustomer2(@Param("customerId") Integer customerId);
	
	//在order中使用迫切左外连接的方式并且以别名的方式完成对于级联属性的查询
	Order testAssociation3(@Param("orderId") Integer orderId);

	//使用懒加载的方式来查询自己和对端的属性，其实和关联映射查询出来的效果是一样的，
	//但是这样是在用户用到哪些数据加载哪些数据，可以节省内存。
	Order testAssociation2(@Param("orderId") Integer orderId);
	
	//用两条SQL语句去数据库查询对象的属性
	Order testResultMap(@Param("orderId") Integer orderId);
	
	//去数据库查询自己的属性和对端的属性
	Order testAssociation(@Param("orderId") Integer orderId);
	
	//向数据库保存order订单的相关信息
	void save(Order order);
	
	//查询所有的order订单
	public List<Order> getAll();

}
