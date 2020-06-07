<%
ServletContext context= getServletContext();
RequestDispatcher rd= context.getRequestDispatcher("/booking-history");
rd.forward(request, response);
%>