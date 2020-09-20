import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DelData extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws IOException{
		
		int id = Integer.parseInt(req.getParameter("sid"));
		
		PrintWriter pw = resp.getWriter();
		
		Data.customers.remove(id);
		
		pw.write("Deleted Successfully");
		
		
	}
}
