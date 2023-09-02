//SeatsAvailable
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SeatsAvailable {
	
	private String[][] trainSeatsA = {{"ROW 1","COLUMN 1"},{"ROW 2","COLUMN 1"},{"ROW 3","COLUMN 1"},{"ROW 4","COLUMN 1"},{"ROW 5","COLUMN 1"},
									  {"ROW 1","COLUMN 2"},{"ROW 2","COLUMN 2"},{"ROW 3","COLUMN 2"},{"ROW 4","COLUMN 2"},{"ROW 5","COLUMN 2"},
	                                  {"ROW 1","COLUMN 3"},{"ROW 2","COLUMN 3"},{"ROW 3","COLUMN 3"},{"ROW 4","COLUMN 3"},{"ROW 5","COLUMN 3"},
	                                  {"ROW 1","COLUMN 4"},{"ROW 2","COLUMN 4"},{"ROW 3","COLUMN 4"},{"ROW 4","COLUMN 4"},{"ROW 5","COLUMN 4"},
	                                  {"ROW 1","COLUMN 5"},{"ROW 2","COLUMN 5"},{"ROW 3","COLUMN 5"},{"ROW 4","COLUMN 5"},{"ROW 5","COLUMN 5"},
	                                  {"ROW 1","COLUMN 6"},{"ROW 2","COLUMN 6"},{"ROW 3","COLUMN 6"},{"ROW 4","COLUMN 6"},{"ROW 5","COLUMN 6"},
	                                  {"ROW 1","COLUMN 7"},{"ROW 2","COLUMN 7"},{"ROW 3","COLUMN 7"},{"ROW 4","COLUMN 7"},{"ROW 5","COLUMN 7"},
	                                  {"ROW 1","COLUMN 8"},{"ROW 2","COLUMN 8"},{"ROW 3","COLUMN 8"},{"ROW 4","COLUMN 8"},{"ROW 5","COLUMN 8"},
	                                  {"ROW 1","COLUMN 9"},{"ROW 2","COLUMN 9"},{"ROW 3","COLUMN 9"},{"ROW 4","COLUMN 9"},{"ROW 5","COLUMN 9"},
	                                  {"ROW 1","COLUMN 10"},{"ROW 2","COLUMN 10"},{"ROW 3","COLUMN 10"},{"ROW 4","COLUMN 10"},{"ROW 5","COLUMN 10"}};
	
	private String[][] trainSeatsB = {{"ROW 1","COLUMN 1"},{"ROW 2","COLUMN 1"},{"ROW 3","COLUMN 1"},{"ROW 4","COLUMN 1"},{"ROW 5","COLUMN 1"},
			  						  {"ROW 1","COLUMN 2"},{"ROW 2","COLUMN 2"},{"ROW 3","COLUMN 2"},{"ROW 4","COLUMN 2"},{"ROW 5","COLUMN 2"},
			  						  {"ROW 1","COLUMN 3"},{"ROW 2","COLUMN 3"},{"ROW 3","COLUMN 3"},{"ROW 4","COLUMN 3"},{"ROW 5","COLUMN 3"},
			  						  {"ROW 1","COLUMN 4"},{"ROW 2","COLUMN 4"},{"ROW 3","COLUMN 4"},{"ROW 4","COLUMN 4"},{"ROW 5","COLUMN 4"},
			  						  {"ROW 1","COLUMN 5"},{"ROW 2","COLUMN 5"},{"ROW 3","COLUMN 5"},{"ROW 4","COLUMN 5"},{"ROW 5","COLUMN 5"},
			  						  {"ROW 1","COLUMN 6"},{"ROW 2","COLUMN 6"},{"ROW 3","COLUMN 6"},{"ROW 4","COLUMN 6"},{"ROW 5","COLUMN 6"},
			  						  {"ROW 1","COLUMN 7"},{"ROW 2","COLUMN 7"},{"ROW 3","COLUMN 7"},{"ROW 4","COLUMN 7"},{"ROW 5","COLUMN 7"},
			  						  {"ROW 1","COLUMN 8"},{"ROW 2","COLUMN 8"},{"ROW 3","COLUMN 8"},{"ROW 4","COLUMN 8"},{"ROW 5","COLUMN 8"},
			  						  {"ROW 1","COLUMN 9"},{"ROW 2","COLUMN 9"},{"ROW 3","COLUMN 9"},{"ROW 4","COLUMN 9"},{"ROW 5","COLUMN 9"},
			  						  {"ROW 1","COLUMN 10"},{"ROW 2","COLUMN 10"},{"ROW 3","COLUMN 10"},{"ROW 4","COLUMN 10"},{"ROW 5","COLUMN 10"}};
	
	private String[][] trainSeats;
	private String bookingFilePathA = "C:\\Users\\Wei Yeeeeeee\\Desktop\\booking_statusA.txt"; // File to store booking status
	private String bookingFilePathB = "C:\\Users\\Wei Yeeeeeee\\Desktop\\booking_statusB.txt"; // File to store booking status

	private List<String> stationNamesA;
	private List<TrainScheduleReader.TrainSchedule> trainSchedulesA;
	private List<String> stationNamesB;
	private List<TrainScheduleReader.TrainSchedule> trainSchedulesB;
	private int totalSeats;
	private int availableSeats;
	
	public String[][] getTrainSeatsA(){
		return trainSeatsA;
	}
	
	public String[][] getTrainSeatsB(){
		return trainSeatsB;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	 public SeatsAvailable(int totalSeats) throws IOException {
	        // Perform file reading in the constructor
	        this.stationNamesA = TrainScheduleReader.readStations("C:\\Users\\Wei Yeeeeeee\\Desktop\\StationTumpat-_Gemas.txt");
	        this.trainSchedulesA = TrainScheduleReader.readTrainSchedules("\\C:\\Users\\Wei Yeeeeeee\\Desktop\\Tumpat-_Gemas.txt");
	        this.stationNamesB = TrainScheduleReader.readStations("C:\\Users\\Wei Yeeeeeee\\Desktop\\StationGemas-Tumpat.txt");
	        this.trainSchedulesB = TrainScheduleReader.readTrainSchedules("C:\\Users\\Wei Yeeeeeee\\Desktop\\Gemas-_Tumpat.txt");

	        this.totalSeats = totalSeats;
	        this.availableSeats = totalSeats;
	        
	        trainSeats = new String[5][10];
			initialiseSeatsA();
			initialiseSeatsB();
			
			loadBookingStatusA();
			loadBookingStatusB();
	    }
	
	  public void displayTrainSchedulesA() {
	        for (TrainScheduleReader.TrainSchedule schedule : trainSchedulesA) {
	            System.out.println("Train Model: " + schedule.trainModel);
	            System.out.println("Arrival Times:");
	            for (String time : schedule.arrivalTimes) {
	                System.out.println("  " + time);
	            }
	            System.out.println(); // Separate schedules with a blank line
	        }
	    }
	  
	  public void displayTrainStationA() {
		    for (String station : stationNamesA) {
		        System.out.println("Station Name: " + station);
		    }
		}
	
	 public void displayTrainSchedulesB() {
	        for (TrainScheduleReader.TrainSchedule schedule : trainSchedulesB) {
	            System.out.println("Train Model: " + schedule.trainModel);
	            System.out.println("Arrival Times:");
	            for (String time : schedule.arrivalTimes) {
	                System.out.println("  " + time);
	            }
	            System.out.println(); // Separate schedules with a blank line
	        }
	    }
	  
	public void displayTrainStationB() {
		    for (String station : stationNamesB) {
		        System.out.println("Station Name: " + station);
		    }
		}
	  
	public void displaySeatsTrainA() { 
		for(String[] trainSeatsA : trainSeatsA) {
			System.out.println(trainSeatsA[0] + " " + trainSeatsA[1]);
		}
	}
	
	public void displaySeatsTrainB() { 
		for(String[] trainSeatsA : trainSeatsA) {
			System.out.println(trainSeatsA[0] + " " + trainSeatsA[1]);
		}
	}

	private void initialiseSeatsA() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				trainSeats[row][column] = "Available";
			}
		}
	}
	
	private void initialiseSeatsB() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				trainSeats[row][column] = "Available";
			}
		}
	}
	
	private boolean isValidSeatA(int row,int column) {
		return row >= 1 && row <= 5 && column >= 1 && column <= 10;
	}
	
	private boolean isValidSeatB(int row,int column) {
		return row >= 1 && row <= 5 && column >= 1 && column <= 10;
	}
	
	public boolean isSeatBookedA(int row, int column) {
		if(isValidSeatA(row, column)) {
			return trainSeats[row - 1][column -1].equals("Booked");
		}
		return false;
	}
	
	public boolean isSeatBookedB(int row, int column) {
		if(isValidSeatA(row, column)) {
			return trainSeats[row - 1][column -1].equals("Booked");
		}
		return false;
	}
	
	public void bookSeatA(int row, int column) {
	    if (isValidSeatA(row, column) && trainSeats[row - 1][column - 1].equals("Available")) {
	        trainSeats[row - 1][column - 1] = "Booked";
	        System.out.println("Seat in Row " + row + ", Column " + column + " has been booked");

	        // Save the updated booking status to the file
	        try {
	            saveBookingStatusA();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Invalid seat or seat already booked");
	    }
	}
	
	public void bookSeatB(int row, int column) {
	    if (isValidSeatB(row, column) && trainSeats[row - 1][column - 1].equals("Available")) {
	        trainSeats[row - 1][column - 1] = "Booked";
	        System.out.println("Seat in Row " + row + ", Column " + column + " has been booked");

	        // Save the updated booking status to the file
	        try {
	            saveBookingStatusB();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Invalid seat or seat already booked");
	    }
	}
	
	public void printSeatStatusA() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				System.out.println("Row" + (row + 1) + ", Column " + (column + 1) + ": " + trainSeats[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	public void printSeatStatusB() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				System.out.println("Row" + (row + 1) + ", Column " + (column + 1) + ": " + trainSeats[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	// Load booking status from file
    private void loadBookingStatusA() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(bookingFilePathA))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 5) {
            	
                String[] status = line.split(",");
                for (int col = 0; col < 10 && col < status.length; col++) {
                    trainSeats[row][col] = status[col];
                }
                row++;
            }
        }
    }
    
    private void loadBookingStatusB() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(bookingFilePathB))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null && row < 5) {
            	
                String[] status = line.split(",");
                for (int col = 0; col < 10 && col < status.length; col++) {
                    trainSeats[row][col] = status[col];
                }
                row++;
            }
        }
    }
    

    // Save booking status to a file
    private void saveBookingStatusA() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookingFilePathA))) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 10; col++) {
                    writer.write(trainSeats[row][col]);
                    if (col < 9) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        }
    }

    // Save booking status to a file
    private void saveBookingStatusB() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookingFilePathB))) {
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 10; col++) {
                    writer.write(trainSeats[row][col]);
                    if (col < 9) {
                        writer.write(",");
                    }
                }
                writer.newLine();
            }
        }
    }
}



//MainTest for testing booking_statusA
import java.io.IOException;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		SeatsAvailable seatsA = new SeatsAvailable(50);
		SeatsAvailable seatsB = new SeatsAvailable(50);
		
		System.out.println("Welcome to WonderTrain Booking System!");
		System.out.println("WE ARE PLEASANT TO SERVE OUR VALUABLE CUSTOMERS!");
		
			
		System.out.println("Train Schedule of Tumpat-Gemas");
		seatsA.displayTrainSchedulesA();
				
		System.out.println("Select A Train Model: ");
		String trainModel = scanner.nextLine();
				
		System.out.println("Select departure Time: ");
		String time = scanner.nextLine();
				
		System.out.println();
				
		System.out.println("The List Below shows the Available and Booked Seats:");
		seatsA.displaySeatsTrainA();
		System.out.print("Choose a Row : ");
		int seatRow = scanner.nextInt();
						
		System.out.print("Choose a Column: ");
		int seatColumn = scanner.nextInt();
				
				
		System.out.println("Seat in Row " + seatRow + ", Column " + seatColumn + " is already booked. Please Choose Anohter Seat");
				
		System.out.println("Choose your Starting Station: ");
		int beginStation = scanner.nextInt();
					
		System.out.println("Choose your Drop-off Station: ");
		int dropStation = scanner.nextInt();
					
		int stationInterval = dropStation - beginStation;
					
		TrainFare fare = new TrainFare(stationInterval);
		System.out.println("Total Fare:RM " + fare.computeFare());
					
		seatsA.bookSeatA(seatRow, seatColumn);
		seatsA.printSeatStatusA();			
	
		
	}

}




//MainTest for testing booking_statusB
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		SeatsAvailable seats = new SeatsAvailable(30);
		
		System.out.println("Welcome to WayToHell Train Booking System!");
		System.out.println("The List Below Shows The Available Seats");
		seats.displaySeatsTrainA();
		
		System.out.println("Choose a Row : ");
		int seatRow = scanner.nextInt();
		
		System.out.println("Choose a Column: ");
		int seatColumn = scanner.nextInt();
		
		seats.bookSeat(seatRow, seatColumn);
		seats.printSeatStatus();
	}







import java.util.Scanner;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main2 {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		SeatsAvailable seatsB = new SeatsAvailable(50);
		
		System.out.println("Welcome to WonderTrain Booking System!");
		System.out.println("WE ARE PLEASANT TO SERVE OUR VALUABLE CUSTOMERS!");
		System.out.println();
		
		System.out.println("The List Below shows the Available and Booked Seats");
		seatsB.displaySeatsTrainB();
		System.out.print("Choose a Row : ");
		int seatRow = scanner.nextInt();
				
		System.out.print("Choose a Column: ");
		int seatColumn = scanner.nextInt();
		
		seatsB.isSeatBookedB(seatRow, seatColumn);
		System.out.println("Seat in Row " + seatRow + ", Column " + seatColumn + " is already booked. Please Choose Anohter Seat");
		
		seatsB.bookSeatB(seatRow, seatColumn);
		seatsB.printSeatStatusB();
		
		
	}

}

//TrainFare

public class TrainFare {
	
	private int stations;
	private double price;
	
	public int getStations() {
		return stations;
	}
	
	public TrainFare(int stations) {
		this.stations = stations;
	}
	
	public double computeFare() {
		price = stations * 1.50;
		return price;
	}
	
}

