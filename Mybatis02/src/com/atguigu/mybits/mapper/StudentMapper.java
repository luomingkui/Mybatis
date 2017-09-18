package com.atguigu.mybits.mapper;
import java.util.Date;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



import com.atguigu.mybits.beans.Student;

public interface StudentMapper {	
	
	void update1(Student student);
	
	void delete1(Integer StudentId);
	
	void save4(Student student);
	
	void save3(Map<String, Object> params);
	
	void save2(@Param("StudentName") String lastName,@Param("birth") Date birth);
	
	void save(Student student);
	
	
	Student selectStudent(@Param("id") Integer StudentId);	
	
	@Select("SELECT StudentId,Student_Name,birth FROM students where StudentId=#{id}")
	Student getStudentById(Integer StudentId);	
}
