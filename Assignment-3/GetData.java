import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class GetData extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res)  throws IOException{
		PrintWriter pw = res.getWriter();
		StringBuffer sb = new StringBuffer("");
		try{
			FileInputStream fs = new FileInputStream(new File("datafile.txt"));
			ObjectInputStream os = new ObjectInputStream(fs);
			while(true){
				Data dt = (Data) os.readObject();
				if(dt == null){
					break;
				}
				sb.append(dt.toString() + " \n");
			}
			os.close();
			fs.close();		
		}catch(Exception e){
			pw.write(sb.toString()	);
		}
		
	}
}
