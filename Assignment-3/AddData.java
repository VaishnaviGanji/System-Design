import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddData extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws IOException{
		PrintWriter pw = res.getWriter();
		try{
			FileOutputStream fs = new FileOutputStream("datafile.txt", true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			int id = Integer.parseInt(req.getParameter("sid"));
			String name = req.getParameter("sname");
			Data dt = new Data(id, name);
			os.writeObject(dt);
			os.close();
			pw.write("Added Successfully");
		}catch(Exception e){
			pw.write(e.toString());
		}
	}
}
