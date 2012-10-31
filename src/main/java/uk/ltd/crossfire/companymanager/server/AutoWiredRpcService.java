package uk.ltd.crossfire.companymanager.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public abstract class AutoWiredRpcService extends RemoteServiceServlet {

	private static final long serialVersionUID = -7227235094732740123L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(config.getServletContext());
		AutowireCapableBeanFactory beanFactory = ctx
				.getAutowireCapableBeanFactory();
		beanFactory.autowireBean(this);
	}

}
