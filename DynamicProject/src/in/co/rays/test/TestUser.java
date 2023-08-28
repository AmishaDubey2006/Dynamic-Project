package in.co.rays.test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
		public static void main(String[] args) throws Exception {
			 testAdd();
//		testUpdate();
//		testSearch();
		}
		private static void testSearch() throws Exception {
			String dob = "2003-03-20";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			UserBean bean = new UserBean();
			bean.setDob(sdf.parse(dob));
			UserModel model = new UserModel();
			
		    List list = model.search(bean, 1 , 5);
			Iterator it = list.iterator();
			while(it.hasNext()) {
			 bean = (UserBean) it.next();
			
			    System.out.println("\t" + bean.getId());
				System.out.println("\t" + bean.getFirst_name());
				System.out.println("\t" + bean.getLast_name());
				System.out.println("\t" + bean.getLogin_id());
				System.out.println("\t" + bean.getPassword());
				System.out.println("\t" + bean.getDob());
				System.out.println("\t" + bean.getAddress());
				
			}}
		
		private static void testAdd() throws Exception {
			String dob = "1998-02-09";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			UserBean bean = new UserBean();

		//	bean.setId(3);
			bean.setFirst_name("oye");
			bean.setLast_name("hello");
			bean.setLogin_id("porwal112@gmail.com");
			bean.setPassword("shikha1256");
			bean.setDob(sdf.parse(dob));
			bean.setAddress("Indore");

			UserModel model = new UserModel();

			model.add(bean);

		}

		private static void testUpdate() throws Exception {
			UserModel model = new UserModel();
			UserBean bean = model.findByPk(1);
			if (bean != null) {
				bean.setFirst_name("samiksha");
				bean.setLast_name("pandey");
				model.update(bean);
				System.out.println("user exist");
			} else {
				System.out.println("user not exist");

			}

		}
	}



