package plain.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Fibo extends HttpServlet {

	private static final long serialVersionUID = 1170740291777665243L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		request.setAttribute("output", "fib(" + n + "): " + fib(n));
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}

	public static int fib(int n) {
		if (n < 2)
			return (1);
		return (fib(n - 2) + fib(n - 1));
	}
}
