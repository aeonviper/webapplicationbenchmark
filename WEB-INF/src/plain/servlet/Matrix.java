package plain.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Matrix extends HttpServlet {

	private static final long serialVersionUID = -7650452400770137112L;

	static int SIZE = 30;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
		int n = Integer.parseInt(request.getParameter("n"));

		int m1[][] = mkmatrix(SIZE, SIZE);
		int m2[][] = mkmatrix(SIZE, SIZE);
		int mm[][] = new int[SIZE][SIZE];
		for (int i = 0; i < n; i++) {
			mmult(SIZE, SIZE, m1, m2, mm);
		}
		
		request.setAttribute("output", "matrix(" + n + "): " + (mm[0][0] + " " + mm[2][3] + " " + mm[3][2] + " " + mm[4][4]));
		this.getServletContext().getRequestDispatcher("/WEB-INF/plain/view/result.jsp").forward(request, response);
	}

	public static int[][] mkmatrix(int rows, int cols) {
		int count = 1;
		int m[][] = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				m[i][j] = count++;
			}
		}
		return (m);
	}

	public static void mmult(int rows, int cols, int[][] m1, int[][] m2, int[][] m3) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int val = 0;
				for (int k = 0; k < cols; k++) {
					val += m1[i][k] * m2[k][j];
				}
				m3[i][j] = val;
			}
		}
	}
}
