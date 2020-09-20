import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class GetData extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  throws IOException{
		PrintWriter pw = resp.getWriter();	
		for(Map.Entry<Integer, String> cust : Data.customers.entrySet()){	
			pw.println(cust.getKey() + ": " + cust.getValue());
		}
	}
}
