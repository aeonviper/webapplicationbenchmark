package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Holder;

public class Timing implements Filter {

	public static final String FILTER_TIMING_ATTRIBUTE_DELTA = "timing-filter-delta";

	public void init(FilterConfig filterConfig) throws ServletException {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Holder<Long> delta = new Holder<Long>(-1L);
		request.setAttribute(FILTER_TIMING_ATTRIBUTE_DELTA, delta);
		long start = System.nanoTime();
		chain.doFilter(httpRequest, httpResponse);
		long measurement = System.nanoTime() - start;
		measurement = measurement / 1000000;
		delta.setValue(measurement);
	}

}