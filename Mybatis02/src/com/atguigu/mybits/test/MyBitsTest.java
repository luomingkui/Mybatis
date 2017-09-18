package com.atguigu.mybits.test;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mybits.beans.Student;
import com.atguigu.mybits.mapper.StudentMapper;

public class MyBitsTest {
	
	private ApplicationContext ctx = null;
	private StudentMapper studentMapper=null;
	
	{
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		studentMapper =ctx.getBean(StudentMapper.class);

	}
	
	
	@Test
	public void testUpdate(){
		Student student = new Student();
		student.setStudentId(2);
		student.setBirth(new Date());
		student.setStudentName("at6");
		studentMapper.update1(student);

	}
	
	@Test
	public void testDelect() throws SQLException{
		studentMapper.delete1(3);	
	}
	
	
	
	@Test
	public void testsave4(){
		Student student = new Student();
		student.setBirth(new Date());
		student.setStudentName("atg111");
		studentMapper.save4(student);

	}
	
	
	@Test
	public void save3(){
		Map<String,Object> params = new HashMap<>();
		params.put("StudentName","afr");
		params.put("birth",new Date());
		studentMapper.save3(params);
	}
	
	@Test
	public void save2(){
		studentMapper.save2("abcd",new Date());
	}
	
	@Test
	public void testSelevt() throws SQLException{
		System.out.println(studentMapper.getClass().getName());
		Student student = studentMapper.selectStudent(1);
		System.out.println(student);	
	}
	

	@Test
	public void testHelloWord() throws SQLException{
		System.out.println(studentMapper.getClass().getName());
		Student student = studentMapper.getStudentById(1);
		System.out.println(student);	
	}
	
	@Test
	public void testDataSource() throws SQLException{
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}
	
}
