package plain.servlet;

import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Hash extends HttpServlet {

	private static final long serialVersionUID = -7629710835038535025L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		int i, c;
		HashMap<String, Integer> ht = new HashMap<String, Integer>();

		c = 0;
		for (i = 1; i <= n; i++)
			ht.put(Integer.toString(i, 16), new Integer(i));
		for (i = 1; i <= n; i++)
			// The original code converted to decimal string this way:
			// if (ht.containsKey(i+""))
			if (ht.containsKey(Integer.toString(i, 10)))
				c++;

		request.setAttribute("output", "hash(" + n + "): " + c);
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}
}
