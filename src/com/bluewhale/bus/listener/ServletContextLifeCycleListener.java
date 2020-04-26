package com.bluewhale.bus.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bluewhale.bus.dao.DbUtil;

@WebListener
public class ServletContextLifeCycleListener implements ServletContextListener {

	public ServletContextLifeCycleListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		String schemaCreate = sce.getServletContext().getInitParameter("schemaCreate");
		if (schemaCreate != null && schemaCreate.equalsIgnoreCase("Yes")) {
			System.out.println(">> schemaCreate");
			DbUtil dbUtil = new DbUtil();
			dbUtil.dropTable();
			dbUtil.createTable();
			dbUtil.insertBaseData();
			System.out.println("<< schemaCreate");
		}
	}

}
