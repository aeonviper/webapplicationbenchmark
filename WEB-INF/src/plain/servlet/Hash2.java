package plain.servlet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class Hash2 extends HttpServlet {

	private static final long serialVersionUID = -153841564948917454L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));
		HashMap<String, Val> hash1 = new HashMap<String, Val>(10000);
		HashMap<String, Val> hash2 = new HashMap<String, Val>(n);

		for (int i = 0; i < 10000; i++)
			hash1.put("foo_" + Integer.toString(i, 10), new Val(i));
		for (int i = 0; i < n; i++) {
			Iterator<Map.Entry<String, Val>> it = hash1.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Val> h1 = it.next();
				String key = (String) h1.getKey();
				int v1 = ((Val) h1.getValue()).val;
				if (hash2.containsKey(key))
					((Val) hash2.get(key)).val += v1;
				else
					hash2.put(key, new Val(v1));
			}
		}

		request.setAttribute("output", "hash2(" + n + "): " + ((Val) hash1.get("foo_1")).val + " " + ((Val) hash1.get("foo_9999")).val + " " + ((Val) hash2.get("foo_1")).val + " " + ((Val) hash2.get("foo_9999")).val);
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}
}

class Val {
	int val;

	Val(int init) {
		val = init;
	}
}