import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainScheduleReader {

    public static class TrainSchedule {
        String trainModel;
        List<String> arrivalTimes;

        public TrainSchedule(String trainModel, List<String> arrivalTimes) {
            this.trainModel = trainModel;
            this.arrivalTimes = arrivalTimes;
        }
    }

    public static List<TrainSchedule> readTrainSchedules(String timetableFile) throws IOException {
        List<TrainSchedule> schedules = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(timetableFile))) {
            String line;
            StringBuilder currentTrainData = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    if (line.endsWith(".")) {
                        currentTrainData.append(line, 0, line.length() - 1);
                        String[] parts = currentTrainData.toString().split(",");
                        if (parts.length > 1) {
                            String trainModel = parts[0].trim();
                            List<String> arrivalTimes = new ArrayList<>();
                            for (int i = 1; i < parts.length; i++) {
                                String time = parts[i].trim();
                                arrivalTimes.add(time);
                            }
                            TrainSchedule schedule = new TrainSchedule(trainModel, arrivalTimes);
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



    public static List<String> readStations(String filename) throws IOException {
        List<String> stations = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stationNames = line.split(",");
                for (String stationName : stationNames) {
                    stations.add(stationName.trim());
                }
            }
        }
        return stations;
    }
}


//callout method example
 public void getInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("From: ");
        from = input.nextLine();
        System.out.println("To: ");
        to = input.nextLine();
    }
 public void fetchAndDisplayTrainSchedules() {
	
List<String> stationNames = TrainScheduleReader.ScheduleReader.readStations("/Users/litjay/Downloads/StationTumpat->Gemas.txt");
List<TrainScheduleReader.TrainSchedule> trainSchedules = TrainScheduleReader.ScheduleReader.readTrainSchedules("/Users/litjay/Downloads/Tumpat->Gemas.txt");
   for (int i = 0; i < stationNames.size(); i++) {
                    if (from.equals(stationNames.get(i))) {
                        startStationIndex = i;
                    } else if (to.equals(stationNames.get(i))) {
                        endStationIndex = i;
                    }
	 
for (TrainScheduleReader.TrainSchedule schedule : trainSchedules) {
	   System.out.println(schedule.trainModel);
	   System.out.println(stationNames.get(startStationIndex));
 
 
 
 }

 List<String> stationNamesA=  TrainScheduleReader.readStations("/Users/litjay/Downloads/StationTumpat->Gemas.txt");
            List<TrainScheduleReader.TrainSchedule> trainSchedulesA = TrainScheduleReader.readTrainSchedules("/Users/litjay/Downloads/Tumpat->Gemas.txt");
            List<String> stationNamesB = TrainScheduleReader.readStations("/Users/litjay/Downloads/StationGemas-Tumpat.txt");
            List<TrainScheduleReader.TrainSchedule> trainSchedulesB = TrainScheduleReader.readTrainSchedules("/Users/litjay/Downloads/Gemas->Tumpat.txt");












