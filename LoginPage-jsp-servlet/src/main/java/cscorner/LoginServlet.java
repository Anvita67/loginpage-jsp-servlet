package cscorner;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String n=request.getParameter("t1");
		String pwd=request.getParameter("t2");
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		if(n.equals("cscorner") && pwd.equals("secret")) {
			HttpSession hs=request.getSession();
			hs.setAttribute("uname", n);
				response.sendRedirect("sucess.jsp");
				
	    }
		else 
		{
			out.println("<font color=red size=14> sorry! username or password incorrect");
			RequestDispatcher rd= request.getRequestDispatcher("input");
			rd.include(request, response);
			
		}

}
}
