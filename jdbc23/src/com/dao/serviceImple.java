package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.dto.Student2;
import com.exception.ClassnotFound;
import com.exception.SomeThingWentWrong;


public class serviceImple implements Interface{

	@Override
	public void AddStudent(Student2 s) throws SomeThingWentWrong {
		
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String q="create table if not exists student2(roll int primary key,name varchar(10), address varchar(10))";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.executeUpdate();
			
			
			String Qw="insert into student2 values(?,?,?)";
			
			PreparedStatement p=c.prepareStatement(Qw);
			
			p.setInt(1,s.getRoll());
			p.setString(2, s.getName());
			p.setString(3, s.getAddress());
			
			p.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			 throw new   SomeThingWentWrong("Some thing went wrong"); 
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void UpdateStudent(Student2 s) throws SomeThingWentWrong {
		
Connection c=null;
		
		try {
			c=Connect.getco();
			
		
			
			
			String Qw="Update Student2 set name=?,address=? where roll=?";
			
			PreparedStatement p=c.prepareStatement(Qw);
			
			
			p.setString(1, s.getName());
			p.setString(2, s.getAddress());
			p.setInt(3,s.getRoll());
			
			p.executeUpdate();
			
			
			
		} catch (SQLException e) {
			
			 throw new   SomeThingWentWrong("Some thing went wrong"); 
		}finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public int Delete(int roll) throws SomeThingWentWrong {
		// TODO Auto-generated method stub
		Connection c=null;
		
		try {
			c=Connect.getco();
			
			String Q="Delete from student2 where roll=?";
		
			PreparedStatement p=c.prepareStatement(Q);
			p.setInt(1, roll);
			
		return p.executeUpdate();
		
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
	        throw new SomeThingWentWrong("ID not Found");
		}
		finally {
			try {
				Connect.closeco(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public Student2 SerchByid(int roll) throws ClassnotFound, SomeThingWentWrong {
		// TODO Auto-generated method stub
		Connection c=null;
		Student2 st=null;
		
		
		try {
			c=Connect.getco();
			
			String q="select roll,name,address from Student2 where roll=?";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ps.setInt(1, roll);
			ResultSet rs=ps.executeQuery();
			
			if(isResultSetEmpty(rs)) {
				throw new ClassnotFound("No Student Found");
			}else {
				//you are here means student found
				rs.next();
				st = new Student2(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomeThingWentWrong("Not able to fetch the data");
		}
		
		
		return st;
	}

	static boolean isResultSetEmpty(ResultSet rs) throws SQLException  {
		
		return (!rs.isBeforeFirst() && rs.getRow() == 0);
	}

	@Override
	public List<Student2> View() throws ClassnotFound, SomeThingWentWrong {
		// TODO Auto-generated method stub
		Connection c=null;
		
		List<Student2> stu=new ArrayList<>();
		
		try {
			c=Connect.getco();
			
			String q="select * from student2 ";
			
			PreparedStatement ps=c.prepareStatement(q);
			
			ResultSet rs=ps.executeQuery();
			if(isResultSetEmpty(rs)) {
				throw new ClassnotFound("No Student Found");
			}else {
				//you are here means student found
				while(rs.next()) {
				
				stu.add(new Student2(rs.getInt(1), rs.getString(2), rs.getString(3) ));
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SomeThingWentWrong("some thing wrong");
		}
		
		return stu;
	}

}
