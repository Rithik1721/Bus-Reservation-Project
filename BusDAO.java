package Busresv;
import java.sql.*;
public class BusDAO {
	public void displayInfo()throws Exception {
		Connection con=DbConnection.getConnection();
		String query="(select * from bus)";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			System.out.println("Bus No: "+rs.getInt(1));
			if(rs.getInt(2)==1) {
				System.out.println("AC: Yes");
			}
			else {
				System.out.println("AC: No");
			}
			System.out.println("Capacity: "+rs.getInt(3));
		}
		System.out.println("----------------------------");
	}
	public int getCapacity(int id)throws Exception {
		Connection con=DbConnection.getConnection();
		String query="select capacity from bus where id="+id;
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
}
