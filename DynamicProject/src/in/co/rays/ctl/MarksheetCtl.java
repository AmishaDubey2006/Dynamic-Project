package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.bean.UserBean;
import in.co.rays.model.MarksheetModel;
import in.co.rays.model.UserModel;

@WebServlet("/MarksheetCtl")
public class MarksheetCtl extends HttpServlet { 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.sendRedirect("MarksheetRegistration.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op.equals("SignUp")) {
			String name = req.getParameter("name");
			int rollNo = Integer.parseInt(req.getParameter("rollNo"));
			int physics =Integer.parseInt (req.getParameter("physics"));
			int chemistry = Integer.parseInt(req.getParameter("chemistry"));
			int maths =Integer.parseInt(req.getParameter("maths"));
						

			MarksheetBean bean = new MarksheetBean();
			bean.setName(name);
			bean.setRollNo(rollNo);
			bean.setPhysics(physics);
			bean.setChemistry(chemistry);
			bean.setMaths(maths);

			MarksheetModel model = new MarksheetModel();

			try {
				bean = model.findByLogin("rollNo");

				if (bean != null) {

					req.setAttribute("msg", "Marksheet Already exist");

				} else {

					model.add(bean);

					req.setAttribute("msg", "Marksheet Register Successfully......!!!");

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			RequestDispatcher rd = req.getRequestDispatcher("MarksheetRegistration.jsp");

			rd.forward(req, resp);
		}

		if (op.equals("Reset")) {

			resp.sendRedirect("MarksheetRegistration.jsp");

		}

	}

}


