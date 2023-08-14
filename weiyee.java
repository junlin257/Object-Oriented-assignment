
public class SeatsAvailable {
	
	private String[][] trainStandardNumber = {
			{"100N","0800"},{"101N","0900"},{"102N","1000"},{"103N","1100"},{"104N","1200"},
			{"105N","1300"},{"106N","1400"},{"107N","1500"},{"108N","1600"},{"109N","1700"},
			{"110N","1800"},{"111N","1900"},{"112N","2000"},{"113N","2100"},{"114N","2200"}};
	
	private String[][] trainPremiumNumber = 
			{{"100N","0800"},{"100N","0800"},{"100N","0800"},{"100N","0800"},{"100N","0800"},
			{"100N","0800"},{"100N","0800"},{"100N","0800"},{"100N","0800"},{"100N","0800"}};
	
	private int totalSeats;
	private int availableSeats;
	
	
	public String[][] getTrainStandardNumber() {
		return trainStandardNumber;
	}
	
	public int getTotalSeats() {
		return totalSeats;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public SeatsAvailable(int totalSeats){
		this.totalSeats = totalSeats;
		this.availableSeats = totalSeats;
	}
	
	public void displayStandardTrainList() {
		System.out.println("Available Trains: ");
		for(int i = 0 ; i < trainStandardNumber.length; i++) {
			System.out.println((i + 1) + ". Train Number: " + trainStandardNumber[i][0] + ", Time: " + trainStandardNumber[i][1]);
		}
	}
	
	public void displayPremiumTrainList() {
		System.out.println("Available Trains: ");
		for(int i = 0; i < trainPremiumNumber.length; i++) {
			System.out.println((i + 1) + ". Train Number: " + trainPremiumNumber[i][0] + ", Time: " + trainPremiumNumber[i][1]);
		}
	}
	
	public boolean bookSeats(int numSeats) {
		if(numSeats <= 0 || numSeats > availableSeats) {
			return false;
		}
		
		availableSeats -= numSeats;
		return true;
	}
	
	public void cancelSeats(int numSeats) {
		if(numSeats <= 0 || numSeats > availableSeats) {
			System.out.println("Invalid Cancellation Request");
		} else {
			availableSeats += numSeats;
			System.out.println("Seats Cancelled Succefully");
		}
	}
	
	
}


//Main for seatsAvailability

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to WayToHell Train Booking System");
		Scanner scanner = new Scanner (System.in);
		
		
		System.out.println("There Are 300 Seats Available For Each Standard Class Train in Total");
		System.out.println("There Are 150 Seats Available For Each Premium Class Train in Total");
		System.out.println();
		
		int options;
		
		do {
			System.out.print("Enter Number 1 to book Standard Class/Number 2 for Premium Class Train : ");
			options = scanner.nextInt();
			
			if(options != 1 && options != 2) {
				System.out.println("Invalid Options!Please Choose Again");
			}
				
		} while (options != 1 && options != 2);
		
		SeatsAvailable standardSeats = null;
		SeatsAvailable premiumSeats = null;
		
		if(options == 1) {
			
			standardSeats = new SeatsAvailable(300);
			
			int chooseStandardTrain;
			
			do {
				standardSeats.displayStandardTrainList();
				System.out.print("Choose a Train Slot: ");
				chooseStandardTrain = scanner.nextInt();
				
				if(chooseStandardTrain <=0 || chooseStandardTrain > 15) {
					System.out.println("Invalid Slot!Please Choose Again");
				}
				
			} while(chooseStandardTrain <= 0 || chooseStandardTrain > 15);
			
			
			
			System.out.print("Enter the Total Number of Seats: ");
			int numSeats = scanner.nextInt();
			if(standardSeats.bookSeats(numSeats)) {
				System.out.println("Seats Booked Successfully. Enjoy:)");
				System.out.println("Available Seats: " + standardSeats.getAvailableSeats());
			} else {
				System.out.println("Invlid Booking Request!");
			}
			
		}
		else if (options == 2) {
			premiumSeats = new SeatsAvailable(150);
			
			int choosePremiumTrain;
			
			do {
				premiumSeats.displayPremiumTrainList();
				System.out.println("Choose your Train and Time: ");
				choosePremiumTrain = scanner.nextInt();
				
				if(choosePremiumTrain <=0 || choosePremiumTrain >10) {
					System.out.println("Invalid Slot!Please Choose again!");
				}
				
			}while(choosePremiumTrain <=0 || choosePremiumTrain >10);	
				
				
			System.out.println("Enter the Total Number of Seats: ");
			int numSeats = scanner.nextInt();
			if(premiumSeats.bookSeats(numSeats)) {
				System.out.println("Seats Booked Successfully.Enjoy:)");
				System.out.println("Available Seats: " + premiumSeats.getAvailableSeats());
			}
			
		} else {
			System.out.println("Invalid Input!");
		}
		
		System.out.println();
		
		
		System.out.print("Would You Like to Cancel Your Booking?: ");
		scanner.nextLine();
		String cancelOption = scanner.nextLine();
		
		
			if(cancelOption.equalsIgnoreCase("yes")) {
				String trainClass;
			do {
				System.out.println("Enter Train Class (standard/premium): ");
				trainClass = scanner.nextLine();
				
				if(!trainClass.equalsIgnoreCase("standard") && !trainClass.equalsIgnoreCase("premium")) {
					System.out.println("Invalid Train Class!Please Enter Again");
				}
			}while(!trainClass.equalsIgnoreCase("standard") && !trainClass.equalsIgnoreCase("premium"));
		
			if(trainClass.equalsIgnoreCase("standard")) {
				standardSeats.displayStandardTrainList();
				String optionCancel;
				
				do{
					System.out.println("Choose the Train Slot You have Booked Previously: ");
					int cancelTrain = scanner.nextInt();
					System.out.println("Enter the Number of Seats to Cancel: ");
					int cancelSeats = scanner.nextInt();
					
					System.out.println("Are You Sure to Cancel the Following Train Slot? (Yes/No): ");
					System.out.println("Train Slot: " + cancelTrain);
					System.out.println("Number of Seats: " + cancelSeats);
					optionCancel = scanner.next();
				
				
					if(optionCancel.equalsIgnoreCase("yes")) {
						standardSeats.cancelSeats(cancelSeats);
						System.out.println("Seats Cancelled Successfully");
						System.out.println("Available Seats after cancellation: " + standardSeats.getAvailableSeats());
					}else if(optionCancel.equalsIgnoreCase("no")) {
						System.out.println("Please Choose Again the Train Slot to Cancel");
					}else {
						System.out.println("Invalid Input!");
					}
					
				}while(!optionCancel.equalsIgnoreCase("yes"));
				
				
			} else if (trainClass.equalsIgnoreCase("premium")){
				premiumSeats.displayPremiumTrainList();
				String optionCancel;
				
				do {
					System.out.println("Choose the Train Slot You have Booked Previously: ");
					int cancelTrain = scanner.nextInt();
					System.out.println("Enter the Number of Seats to Cancel: ");
					int cancelSeats = scanner.nextInt();
					
					System.out.println("Are You Sure to Cancel the Following Train Slot? (Yes/No): ");
					System.out.println("Train Slot: " + cancelTrain);
					System.out.println("Number of Seats: " + cancelSeats);
					optionCancel = scanner.next();
					
					if(optionCancel.equalsIgnoreCase("yes")) {
						premiumSeats.cancelSeats(cancelSeats);
						System.out.println("Seats Cancelled Successfully");
						System.out.println("Available Seats after cancellation: " + premiumSeats.getAvailableSeats());
					} else if(optionCancel.equalsIgnoreCase("no")) {
						System.out.println("Please Choose Again the Train Slot to Cancel");
					} else {
						System.out.println("Invalid Input!");
					}
				}while(!optionCancel.equalsIgnoreCase("yes"));
				
			} else {
				return;
			}
			
		} else {
			System.out.println("Invalid Input!");
		}
		
		
		scanner.close();

	}
	
}


//FareCalculation



public class trainFare {
	
	private static final double STANDARD_FARE_PER_RATE = 0.20;
	private static final double STANDARD_FARE_PER_RATE_PEAK = 0.30;
	private static final double PREMIUM_FARE_PER_RATE = 0.50;
	private static final double PREMIUM_FARE_PER_RATE_PEAK = 0.70;
	private static final double DISTANCE_WITHIN = 3;
	private static final double DISTANCE_OUTSIDE = 5;
	
	private double trainFee;
	private int time;
	private String trainType;
	private double distance;
	
	public double getTrainFee() {
		return trainFee;
	}
	
	public int getTime() {
		return time;
	}
	
	public String getTrainType() {
		return trainType;
	}
	
	public double distance() {
		return distance;
	}

	public static boolean peakTime(int time) {
		return (time >= 600 && time <= 900);
	}
	
	public trainFare(String trainType, int time, double distance) {
		this.trainType = trainType;
		this.time = time;
		this.distance = distance;
	}
	
	public void calculateTrainFare() {
		double farePerRate = 0.0;
		
		if(trainType.equalsIgnoreCase("standard")) {
			farePerRate = peakTime(time) ? STANDARD_FARE_PER_RATE_PEAK : STANDARD_FARE_PER_RATE;
		} else if (trainType.equalsIgnoreCase("premium")){
			farePerRate = peakTime(time) ? PREMIUM_FARE_PER_RATE_PEAK : PREMIUM_FARE_PER_RATE;
		} else {
			System.out.println("Invalid Train Class");
		}
		
		double distanceThreshold1 = (trainType.equalsIgnoreCase("standard")) ? DISTANCE_WITHIN : DISTANCE_OUTSIDE;
		double distanceThreshold2 = (trainType.equalsIgnoreCase("premium")) ? DISTANCE_WITHIN : DISTANCE_OUTSIDE;
		
		if(distance <= distanceThreshold1) {
			trainFee = distance * farePerRate;
		} else {
			trainFee = distanceThreshold1 * farePerRate + (distance - distanceThreshold1) * 1.5;
		}
		
		if(distance <= distanceThreshold2) {
			trainFee = distance * farePerRate;
		} else {
			trainFee = distanceThreshold2 * farePerRate + (distance - distanceThreshold2) * 1.5;
		}
		
	}
	
	
	

}


//Main2 for calculateFare()
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main2 {

	public static void main(String[] args) {
		System.out.println("Testing Train Payment");
		Scanner scanner = new Scanner(System.in);
		
		String trainType;
		int time;
		double distance;
		
		do {
			System.out.print("Choose your Train Class: ");
			trainType = scanner.nextLine();
			
			if(!trainType.equalsIgnoreCase("standard") || trainType.equalsIgnoreCase("premium")) {
				System.out.println("Invalid Input. Please Enter only Standard/Premium Train Class");
			}
		}while(!trainType.equalsIgnoreCase("standard") || trainType.equalsIgnoreCase("premium"));
		
		do {
			System.out.print("Choose Departure Time (24-Hour Format): ");
			time = scanner.nextInt();
			
			if(time < 0 || time > 2359 || time % 100 >= 60) {
				System.out.println("Invalid time format.Please Enter in 24-Hour Time Format.");
			}
		}while(time < 0 || time > 2359 || time % 100 >= 60);
		
		do {
			System.out.print("Enter Distance (KM): ");
			distance = scanner.nextDouble();
			
			if(distance <=0 || distance <1) {
				System.out.println("Invalid Distance.Please Enter the Distance at least 1KM or above.");
			}
		}while(distance <=0 || distance <2);
		
		trainFare trainFare = new trainFare(trainType, time, distance);
		trainFare.calculateTrainFare();
		
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String formattedFare = decimalFormat.format(trainFare.getTrainFee());
		
		System.out.println("Total Fare:");
		System.out.println("RM" + formattedFare);
	}

}









