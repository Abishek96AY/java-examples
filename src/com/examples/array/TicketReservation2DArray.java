package com.examples.array;

import java.util.HashMap;
import java.util.Scanner;

public class TicketReservation2DArray {
	static HashMap<String, String> hashMapObj = new HashMap<String, String>();
	boolean[][] seats;

	public TicketReservation2DArray(int rows, int columns) {
		seats = new boolean[rows][columns]; // Initialize the 2D array with the given dimensions
		// By default, all seats are initialized as false, indicating they are available
	}

	public boolean bookTickets(String userName, int row, int column, boolean status, String choice) {
		if (row >= 0 && row < seats.length && column >= 0 && column < seats[0].length) {
			if (!seats[row][column] && choice.equalsIgnoreCase("Book")) {
				System.out.println("Hey " + userName + ", Booked Seat. Row No :: " + row + ", Column No :: " + column);
				seats[row][column] = status;
				return true;
			} else if (seats[row][column] && choice.equalsIgnoreCase("Cancel")) {
				System.out.println(
						"Hey " + userName + ", Cancelled Booked Seat. Row No :: " + row + ", Column No :: " + column);
				seats[row][column] = status;
				return true;
			} else {
				System.out.println(
						"Hey " + userName + ", Seat Already Booked. Row No :: " + row + ", Column No :: " + column);
				return false;
			}
		} else {
			System.out.println("Invalid seat selection." + " Seat at row " + row + ", column " + column);
			return false;
		}
	}

	public void showAllBookedTickets() {
		System.out.println("Seating Layout !!!");
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (seats[i][j]) {
					System.out.print("X ");
				} else {
					System.out.print("O ");
				}
			}
			System.out.println();
		}
	}

	public void showBookedTicketsStatus(int row, int col) {
		if (seats[row][col]) {
			System.out.print("Ticket Booked !!!" + " Row No :: " + row + ", Col No :: " + col);
		} else {
			System.out.print("Ticket Not Booked !!!");
		}
	}

	public void showTicketsStatus(boolean status) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[0].length; j++) {
				if (status) {
					if (seats[i][j]) {
						System.out.println("Row :: " + i + ", Col :: " + j + ", status :: " + seats[i][j]);
					}
				} else {
					if (!seats[i][j]) {
						System.out.println("Row :: " + i + ", Col :: " + j + ", status :: " + seats[i][j]);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		TicketReservation2DArray obj = new TicketReservation2DArray(5, 10);
		for (;;) {
			Scanner scannerObj = new Scanner(System.in);
			System.out.print("Enter Your Option :: ");
			String userOption = scannerObj.nextLine();
			if (userOption.equalsIgnoreCase("Show")) {
				System.out.print("Enter Your UserName :: ");
				String userName = scannerObj.nextLine();
				String rowColumn = hashMapObj.get(userName);
				if (rowColumn != null) {
					String rowColumnArray[] = rowColumn.split(",");
					String row = rowColumnArray[0];
					String col = rowColumnArray[1];
					obj.showBookedTicketsStatus(Integer.parseInt(row), Integer.parseInt(col));
				} else {
					System.out.println("No records found !!!");
				}
			} else if (userOption.equalsIgnoreCase("ShowAll")) {
				obj.showAllBookedTickets();
			} else if (userOption.equalsIgnoreCase("ShowUserDefined")) {
				System.out.print("Do you want to show booked tickets :: ");
				boolean status = scannerObj.nextBoolean();
				obj.showTicketsStatus(status);
			} else if (userOption.equalsIgnoreCase("Book")) {
				System.out.print("Enter Your UserName :: ");
				String userName = scannerObj.nextLine();
				System.out.println("Enter the number of row : ");
				int row = scannerObj.nextInt();
				System.out.print("Enter the number of column : ");
				int col = scannerObj.nextInt();
				if (obj.bookTickets(userName, row, col, true, userOption)) {
					hashMapObj.put(userName, row + "," + col);
				}
			} else if (userOption.equalsIgnoreCase("Cancel")) {
				System.out.print("Enter Your UserName :: ");
				String userName = scannerObj.nextLine();
				String rowColumn = hashMapObj.get(userName);
				if (rowColumn != null) {
					String rowColumnArray[] = rowColumn.split(",");
					String row = rowColumnArray[0];
					String col = rowColumnArray[1];
					System.out.print("Row :: " + row + ", Column :: " + col);
					obj.bookTickets(userName, Integer.parseInt(row), Integer.parseInt(col), false, userOption);
				} else {
					System.out.println("Record Not Found To Update !!!");
				}
			} else {
				System.out.println("Invalid Option !!!");
			}
		}
	}
}