package in.co.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.bean.UserBean;

public class MarksheetModel {
	
	public void add (MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
	PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?,)");
	
//	ps.setInt(1,bean.getId());
//	ps.setString(2,bean.getName());
//	ps.setInt(3,bean.getRollNo());
//	ps.setInt(4,bean.getPhysics());
//	ps.setInt(5,bean.getChemistry());
//	ps.setInt(6,bean.getMaths());

	
//	FOR PK
	
	ps.setInt(1,nextPk());
	ps.setString(2,bean.getName());
	ps.setInt(3,bean.getRollNo());
	ps.setInt(4,bean.getPhysics());
	ps.setInt(5,bean.getChemistry());
	ps.setInt(6,bean.getMaths());
	

	int i = ps.executeUpdate();
	System.out.println("Data inserted"+i);
	}
	
	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root", "root");
		PreparedStatement ps = conn.prepareStatement("Update marksheet set name=?, roll_no=?, physics=?, chemistry=?, maths=?, where id=?");
		
		ps.setString(1,bean.getName());
		ps.setInt(2,bean.getRollNo());
		ps.setInt(3,bean.getPhysics());
		ps.setInt(4,bean.getChemistry());
		ps.setInt(5,bean.getMaths());
		ps.setInt(6, bean.getId());
		
		int i = ps.executeUpdate();
		System.out.println("Data updated"+i);
	}
	
	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");
		
		ps.setInt(1,id);
		 int i = ps.executeUpdate();
		 System.out.println("Data Deleted"+i);
	}
	
	public MarksheetBean findByRoll(int RollNo) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no = ?");
		ps.setInt(1, RollNo);
		ResultSet rs = ps.executeQuery();
		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
						
		}
		return bean;
		
	}
//	public List search() throws Exception {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
//		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
//		ResultSet rs = ps.executeQuery();
//		List list = new ArrayList();
//		while (rs.next()) {
//		MarksheetBean bean = new MarksheetBean();
//		
//		bean.setId(rs.getInt(1));
//		bean.setName(rs.getString(2));
//		bean.setRollNo(rs.getInt(3));
//		bean.setPhysics(rs.getInt(4));
//		bean.setChemistry(rs.getInt(5));
//		bean.setMaths(rs.getInt(6));
//		
//		
//		list.add(bean);
//	}
//		
//	return list;	
//}
	public Integer nextPk() throws Exception {
		int pk =0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		PreparedStatement ps = conn.prepareStatement("select * from marksheet");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk =rs.getInt(1);
		}
		
		return pk + 1;
		
	}
	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
		
		StringBuffer sql = new StringBuffer("Select * from marksheet where 1=1");
		
		if(bean != null) {
			
			if(bean.getName() != null && bean.getName().length()> 0){
			sql.append(" and name like '" + bean.getName() + "%'");
			}
			if(bean.getId()!= 0 && bean.getId()>0) {
				sql.append(" and id=" + bean.getId());
			}
			if(bean.getRollNo()!= 0 && bean.getRollNo()>0) {
				sql.append(" and Roll_no =" + bean.getRollNo());
			}
				
			}
		
		if(pageSize > 0) {
			 pageNo=(pageNo - 1) * pageSize;
			 sql.append(" limit " + pageNo + "," + pageSize);
		}
			System.out.println(sql.toString());
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while (rs.next()) {
	   
		bean = new MarksheetBean();
		
		bean.setId(rs.getInt(1));
		bean.setName(rs.getString(2));
		bean.setRollNo(rs.getInt(3));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(6));
			
		list.add(bean);
	}
		

		return list;
}
	public MarksheetBean findByLogin(String rollno) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where Roll_no = ?");

		ps.setString(1,rollno);

		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
		}
		return bean;

	}

	public MarksheetBean authenticate(String rollNo) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where Roll_no =?");

		ps.setString(1,rollNo);
		
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;

		while (rs.next()) {

			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			

		}
		return bean;

	}

	
	
	
}
		
		
	


