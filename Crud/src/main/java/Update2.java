
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update2
 */
@WebServlet("/Update2")
public class Update2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printw = response.getWriter();

		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);
		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Email = request.getParameter("email");
		long Mobile = Long.parseLong(request.getParameter("mobile"));

		User u = new User();
		u.setId(id);
		u.setName(Name);
		u.setPassword(Password);
		u.setEmail(Email);
		u.setMobile(Mobile);

		int status = UserDOA.update(u);
		if (status > 0) {
			response.sendRedirect("ViewUsers");
		} else {
			printw.println("sorry!Unable to update");

		}
		printw.close();
	}

}
