package comt.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getContextPath();
		String indexPath = req.getScheme() + "://" + req.getServerName() + ":"
				+ req.getServerPort() + path + "/back/login.jsp";
		if (req.getRequestURI().endsWith("login.jsp")) {
			chain.doFilter(request, response);
			return;
		}
		Object loginuser = req.getSession().getAttribute("adminphone");
		//adminInfo adminInfo=(comt.model.adminInfo) req.getSession().getAttribute("admin");
		if (null==loginuser) {
			res.sendRedirect(indexPath);
			return;
		}
		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
