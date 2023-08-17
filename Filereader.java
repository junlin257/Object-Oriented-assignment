import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Test2 {
		
	public static void main(String[] args) throws IOException {
        List<TrainSchedule> schedules = TrainScheduleReader.readTrainSchedules("/Users/litjay/Downloads/Tumpat->Gemas.txt");
        for (TrainSchedule schedule : schedules) {
            System.out.println(schedule);
        }
  }
  class TrainSchedule {
    String trainModel;
    List<String> arrivalTimes;

    public TrainSchedule(String trainModel, List<String> arrivalTimes) {
        this.trainModel = trainModel;
        this.arrivalTimes = arrivalTimes;
    }

    public int getStartingStationIndex() {
        for (int i = 0; i < arrivalTimes.size(); i++) {
            if (arrivalTimes.get(i) != null) {
                return i;
            }
        }
        return -1; // should not happen if there's at least one valid station
    }

    @Override
    public String toString() {
        return "TrainSchedule{" +
                "trainModel='" + trainModel + '\'' +
                ", Starting Station No." + getStartingStationIndex() +
                ", ArrivalTimes=" + arrivalTimes +
                '}';
    }
}
class TrainScheduleReader {
    public static List<TrainSchedule> readTrainSchedules(String filename) throws IOException {
        List<TrainSchedule> schedules = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            StringBuilder currentTrainData = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    if (line.endsWith(".")) {
                        currentTrainData.append(line, 0, line.length() - 1);  // Remove the trailing period
                        String[] parts = currentTrainData.toString().split(",");
                        if (parts.length > 1) {
                            List<String> arrivalTimes = new ArrayList<>();
                            for (int i = 1; i < parts.length; i++) {
                                String time = parts[i].trim();
                                if (time.equals("NA") ) {
                                    arrivalTimes.add(null);
                                }
                                else if(time.equals("-"))
                                {
                                	arrivalTimes.add("-");
                                }
                                
                                else {
                                    arrivalTimes.add(time);
                                }
                            }
                            TrainSchedule schedule = new TrainSchedule(parts[0].trim(), arrivalTimes);
                            schedules.add(schedule);
                        }
                        currentTrainData = new StringBuilder();
                    } else {
                        currentTrainData.append(line).append(" ");
                    }
                }
            }
        }
        return schedules;
    }
}
