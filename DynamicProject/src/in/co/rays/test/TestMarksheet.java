package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {

	public static void main(String[] args) throws Exception {
	//	testAdd();
	//	testUpdate();
	//	testDelete();
	//	testfindByRoll();
		testSearch();
	}

//	private static void testSearch() throws Exception {
//		MarksheetModel model = new MarksheetModel();
//		List list = model.search();
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//		MarksheetBean bean = (MarksheetBean) it.next();
//		
//		System.out.print("\t" + bean.getId());
//		System.out.print("\t" + bean.getName());
//		System.out.print("\t" + bean.getRollNo());
//		System.out.print("\t" + bean.getPhysics();
//		bean = (MarksheetBean) it.next();));
//		System.out.print("\t" + bean.getChemistry());
//		System.out.print("\t" + bean.getMaths());	
//	}
//		}
	
	
	private static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setName("d");
	//	bean.setId(1);
	//	bean.setRollNo(14506);
		
		MarksheetModel model = new MarksheetModel();
		List list = model.search(bean,1,5);
		Iterator it = list.iterator();
		while(it.hasNext()) {
		 bean = (MarksheetBean) it.next();
		
		    System.out.println("\t" + bean.getId());
			System.out.println("\t" + bean.getName());
			System.out.println("\t" + bean.getRollNo());
			System.out.println("\t" + bean.getPhysics());
			System.out.println("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
							
		}}


	private static void testfindByRoll() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = model.findByRoll(145201);
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
				
		}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();
		model.delete(7);
	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(7);
		bean.setName("Deepak");
		bean.setRollNo(107);
		bean.setPhysics(98);
		bean.setChemistry(85);
		bean.setMaths(90);
		
		MarksheetModel model = new MarksheetModel();

		model.update(bean);
	}

	public static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();

		bean.setId(7);
		bean.setName("Siya");
		bean.setRollNo(201);
		bean.setPhysics(98);
		bean.setChemistry(85);
		bean.setMaths(90);
		
		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}

}


