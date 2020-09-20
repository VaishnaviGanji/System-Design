import java.io.*;
public class Data implements Serializable{

	int sid;
	String sname;
	
	Data(int id,String name){
		this.sid = id;
		this.sname = name;
	}
	public String toString(){
		return this.sid + "   " + this.sname;
	}
}
