import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class DelData extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)  throws IOException{
		PrintWriter pw = res.getWriter();
		try{
			int id = Integer.parseInt(req.getParameter("sid"));
			List<Data> allData = readObjectsFromFile("datafile.txt", id);
			writeObjectsToFile("datafile.txt", allData);
					
		} catch (Exception e){
			pw.write(e.toString()	);
		}
	}
	private static List readObjectsFromFile(String filename, int id) throws IOException, ClassNotFoundException {
		List<Data> allData = new ArrayList<Data>();
		try {
			FileInputStream fs = new FileInputStream(new File(filename));
			ObjectInputStream os = new ObjectInputStream(fs);
			while (true) {
				Data dt = (Data) os.readObject();
				if(dt.sid != id) {
					allData.add(dt);
				}
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		return allData;
	}
	private static void writeObjectsToFile(String filename, List<Data> allData) throws IOException {
		try {
			FileOutputStream fs = new FileOutputStream("datafile.txt", true);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			for (Data dt : allData) {
				os.writeObject(dt);
			}
			fs.close();
			os.close();
		}catch (Exception e) {
			System.out.println(e.toString());
		}
		
	}
}
