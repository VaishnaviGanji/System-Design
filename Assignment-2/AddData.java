import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddData extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws IOException{
		
		int id = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		
		PrintWriter pw = res.getWriter();
		
		Data.customers.put(id, name);
		
		pw.write("Added Successfully");
		
	}
}
