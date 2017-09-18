package com.atguigu.mybits.test;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mybits.beans.Customer;
import com.atguigu.mybits.beans.Order;
import com.atguigu.mybits.mapper.OrderMapper;

public class MybitsTest {
	
	private ApplicationContext ctx=null;
	private OrderMapper orderMapper = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		orderMapper = ctx.getBean(OrderMapper.class);
	}
	
	
	@Test
	public void testForEach(){
		List<Integer> ids = Arrays.asList(1,2,4,5);
		List<Order> orders = orderMapper.testForEach(ids);
		System.out.println(orders.size());
	}
	
	
	
	@Test
	public void testIf(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("minId", 2);
		params.put("maxId", 12);
		
		List<Order> orders = orderMapper.testIf(params);
		
		System.out.println(orders.size());
	}
	
	
	
	@Test
	public void testCollection2(){
		Customer customer = orderMapper.selectCustomer3(1);
		System.out.println(customer);
		System.out.println("---------------------------------------");
		for(Order order: customer.getOrders()){
			System.out.println(order);
		}
	}
	
	
	@Test
	public void testCollection1(){
		Customer customer = orderMapper.selectCustomer2(1);
		System.out.println(customer);
		for(Order order: customer.getOrders()){
			System.out.println(order);
		}
	}
	
	//对于这个起别名的方式：为什么使用两次查询，有一些不能理解？？？
	@Test
	public void testAssociation3(){
		Order order = orderMapper.testAssociation3(3);
		System.out.println(order.getOrderId() + "," + order.getOrderName());
		System.out.println(order.getCustomer());
	}
	
	
	@Test
	public void testAssociation2(){
		Order order=orderMapper.testAssociation2(2);
		System.out.println(order.getOrderId() + "," + order.getOrderName());
		System.out.println("--------------------------------------");
		System.out.println(order.getCustomer());
	}
	
	
	@Test
	public void testResultMap(){
		Order order= orderMapper.testAssociation(2);
		System.out.println(order);
		System.out.println(order.getCustomer());
	}
	
	
	@Test
	public void testAssociation(){
		Order order = orderMapper.testAssociation(2);
		System.out.println(order);
		System.out.println(order.getCustomer());
	}
	
	@Test
	public void testsave(){
		Order order = new Order();
		order.setOrderName("新订单123");
		Customer customer = new Customer();
		customer.setCustomerId(7);
		order.setCustomer(customer);
		orderMapper.save(order);
	}
	
	
	@Test
	public void testselect(){
		List<Order> orders = orderMapper.getAll();
		for(Order order: orders){
			System.out.println(order.getOrderId() + "," + order.getOrderName());
		}
	}
	
	
	@Test
	public void testDataSource() throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

	
	
	
}
