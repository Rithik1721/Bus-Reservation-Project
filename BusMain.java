package Busresv;

import java.util.Scanner; 
import java.util.ArrayList;

public class BusMain {

	public static void main(String[] args){
		BusDAO busdao=new BusDAO();
		try {
		busdao.displayInfo();
		int userOpt = 1;
		Scanner scanner = new Scanner(System.in);
		
		while(userOpt==1) {
			System.out.println("Enter 1 to Book and 2 to exit");
			userOpt = scanner.nextInt();
			if(userOpt == 1) {
				Booking booking = new Booking();
				if(booking.isAvailable()) {
					BookingDAO bookingdao=new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("Your booking is confirmed");
				}
				else
					System.out.println("Sorry. Bus is full. Try another bus or date.");
			}
			else {
				System.out.print("Thank You!!! Come Again ");
			}
		}
		}
		catch(Exception e) {
			System.out.print("Please give correct input");
		}
	}

}