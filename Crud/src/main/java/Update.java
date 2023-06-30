
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printw = response.getWriter();

		printw.print("<h1>Update Users</h1>");
		String uid = request.getParameter("id");
		int id = Integer.parseInt(uid);

		User u = UserDOA.getUserbyId(id);

		printw.print("<form action='Update2' method='post'>");
		printw.print("<table>");
		printw.print("<tr><td></td><td><input type='hidden' name='id' value='" + u.getId() + "'/></td></tr>");
		printw.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + u.getName() + "'/></td></tr>");
		printw.print("<tr><td>Password:</td><td><input type='password' name='password' value='" + u.getPassword()
				+ "'/></td></tr>");
		printw.print(
				"<tr><td>Email:</td><td><input type='email' name='email' value='" + u.getEmail() + "'/></td></tr>");
		printw.print(
				"<tr><td>Mobile:</td><td><input type='tel' name='mobile' value='" + u.getMobile() + "'/></td></tr>");
		printw.print("<tr><td colspan='2'><input type='submit' value='Update '/></td></tr>");
		printw.print("</table>");
		printw.print("</form>");

		printw.close();
	}
}
