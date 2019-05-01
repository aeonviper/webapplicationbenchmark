package plain.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Ackermann extends HttpServlet {
	private static final long serialVersionUID = -7101465525956645678L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		request.setAttribute("output", "Ack(3," + n + "): " + Ack(3, n));
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}

	public static int Ack(int m, int n) {
		return (m == 0) ? (n + 1) : ((n == 0) ? Ack(m - 1, 1) : Ack(m - 1, Ack(m, n - 1)));
	}
}
