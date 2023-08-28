package in.co.rays.bean;

import java.util.Date;

public class UserBean {
		
		private int Id;
		private String First_name;
		private String Last_name;
		private String Login_id;
		private String Password;
		private Date Dob;
		private String Address;
		public int getId() {
			return Id;
		}
		public void setId(int id) {
			Id = id;
		}
		public String getFirst_name() {
			return First_name;
		}
		public void setFirst_name(String first_name) {
			First_name = first_name;
		}
		public String getLast_name() {
			return Last_name;
		}
		public void setLast_name(String last_name) {
			Last_name = last_name;
		}
		public String getLogin_id() {
			return Login_id;
		}
		public void setLogin_id(String login_id) {
			Login_id = login_id;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public Date getDob() {
			return Dob;
		}
		public void setDob(Date dOB) {
			Dob = dOB;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
		}
		
		
		
	}


