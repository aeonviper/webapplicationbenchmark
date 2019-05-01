package plain.servlet;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class HeapSort extends HttpServlet {

	private static final long serialVersionUID = 5063961074930766592L;

	public static final long IM = 139968;
	public static final long IA = 3877;
	public static final long IC = 29573;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(10);
		nf.setMinimumFractionDigits(10);
		nf.setGroupingUsed(false);
		double[] ary = (double[]) Array.newInstance(double.class, n + 1);
		for (int i = 1; i <= n; i++) {
			ary[i] = gen_random(1);
		}
		heapsort(n, ary);

		request.setAttribute("output", "heapsort(" + n + "): " + nf.format(ary[n]));
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}

	public static long last = 42;

	public static double gen_random(double max) {
		return (max * (last = (last * IA + IC) % IM) / IM);
	}

	public static void heapsort(int n, double ra[]) {
		int l, j, ir, i;
		double rra;

		l = (n >> 1) + 1;
		ir = n;
		for (;;) {
			if (l > 1) {
				rra = ra[--l];
			} else {
				rra = ra[ir];
				ra[ir] = ra[1];
				if (--ir == 1) {
					ra[1] = rra;
					return;
				}
			}
			i = l;
			j = l << 1;
			while (j <= ir) {
				if (j < ir && ra[j] < ra[j + 1]) {
					++j;
				}
				if (rra < ra[j]) {
					ra[i] = ra[j];
					j += (i = j);
				} else {
					j = ir + 1;
				}
			}
			ra[i] = rra;
		}
	}
}
