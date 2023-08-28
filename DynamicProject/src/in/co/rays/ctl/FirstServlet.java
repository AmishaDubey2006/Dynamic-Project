package in.co.rays.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.setContentType("text / html");
//		PrintWriter out = resp.getWriter();
//		out.println("<h1>Dynamic Web Project .....!!!</h1>");
//		out.close();
		System.out.println("in FirstServlet do get");
		
		

		resp.sendRedirect("Second");

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");

		System.out.println("in First Servlet do post "+name);
		
		req.setAttribute("surname", " Sharma");

		RequestDispatcher rd = req.getRequestDispatcher("Second");

		rd.forward(req, resp);

		
	}
}
