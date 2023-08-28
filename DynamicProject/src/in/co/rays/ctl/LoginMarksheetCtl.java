package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.MarksheetBean;

import in.co.rays.model.MarksheetModel;

@WebServlet("/LoginMarksheetCtl")
public class LoginMarksheetCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String op = req.getParameter("operation");
	
	if(op !=null) {
		
		HttpSession session = req.getSession();
		session.invalidate();
	}
	resp.sendRedirect("MarksheetLoginview.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");

		if (op.equals("SignIn")) {

			String rollNo = req.getParameter("rollNo");
			

			MarksheetModel model = new MarksheetModel();

			try {
				MarksheetBean bean = model.authenticate(rollNo);

				if (bean != null) {
						
					HttpSession session = req.getSession();
					session.setAttribute("marksheet", bean);
					resp.sendRedirect("WelcomeCtlMarksheet");
					

				} else {

					req.setAttribute("msg", "RollNo is invalid...!!");

					RequestDispatcher rd = req.getRequestDispatcher("MarksheetLoginView.jsp");

					rd.forward(req, resp);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (op.equals("SignUp")) {

			resp.sendRedirect("MarksheetCtl");

		}

	}

}
