package com.dao;

import java.util.List;

import com.dto.Student2;
import com.exception.ClassnotFound;
import com.exception.SomeThingWentWrong;

public interface Interface {

	public void AddStudent(Student2 s) throws SomeThingWentWrong;

	public void UpdateStudent(Student2 a) throws SomeThingWentWrong;

	public int Delete(int roll) throws SomeThingWentWrong;

	public Student2 SerchByid(int roll) throws ClassnotFound, SomeThingWentWrong;

	public List<Student2> View() throws ClassnotFound, SomeThingWentWrong;

}
