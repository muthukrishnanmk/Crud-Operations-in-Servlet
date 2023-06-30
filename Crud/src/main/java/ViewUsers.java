
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Servlet implementation class ViewUsers
 */
@WebServlet("/ViewUsers")
public class ViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();

		print.println("<a href='NewUser.html'>Add New Users</a>");
		print.println("<h1>User List</h1>");

		List<User> list = UserDOA.getAllUsers();

		print.print("<table border='1' width='100%'");
		print.print(
				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Mobile</th><th>Update</th><th>Delete</th>");
		
		print.print("<script>\r\n"
				+ "function confirmDelete(id) {"
				+ "  var result = confirm(\"Are you sure you want to delete this user?\");"
				+ "  if (result) {"
				+ "    window.location.href = \"Delete?id=\" + id;"
				+ "  }"
				+ "}"
				+ "</script>");
		for (User u : list) {
			print.print("<tr><td>" + u.getId() + "</td><td>" + u.getName() + "</td><td>" + u.getPassword() + "</td><td>"
					+ u.getEmail() + "</td><td>" + u.getMobile() + "</td><td><a href='Update?id=" + u.getId()
					+ "'>update</a></td> <td><a href='#' onclick='confirmDelete(" + u.getId() + ")'>delete</a></td></tr>");		
		}
		print.print("</table>");
		print.close();
	}

}
