package Busresv;
import java.sql.*;
import java.util.Date;
public class BookingDAO {
	public int getBooked(int busno,Date date)throws Exception{ 
		Connection con=DbConnection.getConnection();
		String query="select count(Passenger_name) from booking where bus_no=? and travel_date=?";
		PreparedStatement pst=con.prepareStatement(query);
		pst.setInt(1,busno);
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		pst.setDate(2, sqldate);
		ResultSet rs=pst.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
	public void addBooking(Booking booking)throws Exception{
		Connection con=DbConnection.getConnection();
		String query="insert into booking values(?,?,?)";
		java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
		PreparedStatement pst=con.prepareStatement(query);
		pst.setString(1, booking.passengerName);
		pst.setInt(2, booking.busNo);
		pst.setDate(3, sqldate);
		pst.executeUpdate();
	}
}
