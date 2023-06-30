
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Save
 */
@WebServlet("/Save")
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();

		String Name = request.getParameter("name");
		String Password = request.getParameter("password");
		String Email = request.getParameter("email");
		long Mobile = Long.parseLong(request.getParameter("mobile"));

		User u = new User();
		u.setName(Name);
		u.setPassword(Password);
		u.setEmail(Email);
		u.setMobile(Mobile);

		int status = UserDOA.insert(u);
		if (status > 0) {
//			print.println("<p>Record saved</p>");
//			request.getRequestDispatcher("NewUser.html").include(request, response);
			response.sendRedirect("ViewUsers");
		} else {
			print.println("sorry!failed");

		}
		print.close();
	}

}
