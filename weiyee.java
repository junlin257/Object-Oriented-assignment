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
	private String bookingFilePath = "C:\\Users\\Wei Yeeeeeee\\Desktop\\booking_status.txt"; // File to store booking status

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
			initialiseSeats();
			
			loadBookingStatus();
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

	private void initialiseSeats() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				trainSeats[row][column] = "Available";
			}
		}
	}
	
	public void bookSeat(int row, int column) {
	    if (isValidSeat(row, column) && trainSeats[row - 1][column - 1].equals("Available")) {
	        trainSeats[row - 1][column - 1] = "Booked";
	        System.out.println("Seat in Row " + row + ", Column " + column + " has been booked");

	        // Save the updated booking status to the file
	        try {
	            saveBookingStatus();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.out.println("Invalid seat or seat already booked");
	    }
	}
	
	private boolean isValidSeat(int row,int column) {
		return row >= 1 && row <= 5 && column >= 1 && column <= 10;
	}
	
	public void printSeatStatus() {
		for(int row = 0; row < 5; row++) {
			for(int column = 0; column < 10; column++) {
				System.out.println("Row" + (row + 1) + ", Column " + (column + 1) + ": " + trainSeats[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	// Load booking status from file
    private void loadBookingStatus() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(bookingFilePath))) {
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
    private void saveBookingStatus() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bookingFilePath))) {
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
//MainTest
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
