
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

