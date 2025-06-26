import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Analyzer {

    public static double calculateAverage(List<EnergyRecord> records) {
        double total = 0;
        for (EnergyRecord record : records) {
            total += record.usageMW;
        }
        return total / records.size();
    }

    public static double findPeakUsage(List<EnergyRecord> records) {
        double peak = Double.MIN_VALUE;
    
        for (EnergyRecord r : records) {
            if (r.usageMW > peak) {
                peak = r.usageMW;
            }
        }
        return peak;
    }
    
        public static Map<String, Double> averageByHour(List<EnergyRecord> records) {
        Map<String, Double> total = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (EnergyRecord r : records) {
            total.put(r.hour, total.getOrDefault(r.hour, 0.0) + r.usageMW);
            count.put(r.hour, count.getOrDefault(r.hour, 0) + 1);
        }

        Map<String, Double> avg = new TreeMap<>(); // sorted by hour
        for (String hour : total.keySet()) {
            avg.put(hour, total.get(hour) / count.get(hour));
        }
        return avg;
    }

    public static Map<String, Double> averageByDay(List<EnergyRecord> records) {
        Map<String, Double> total = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (EnergyRecord r : records) {
            total.put(r.dayOfWeek, total.getOrDefault(r.dayOfWeek, 0.0) + r.usageMW);
            count.put(r.dayOfWeek, count.getOrDefault(r.dayOfWeek, 0) + 1);
        }

        Map<String, Double> avg = new TreeMap<>();
        for (String day : total.keySet()) {
            avg.put(day, total.get(day) / count.get(day));
        }
        return avg;
    }

    public static Map<String, Double> averageByMonth(List<EnergyRecord> records) {
        Map<String, Double> total = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (EnergyRecord r : records) {
            total.put(r.month, total.getOrDefault(r.month, 0.0) + r.usageMW);
            count.put(r.month, count.getOrDefault(r.month, 0) + 1);
        }

        Map<String, Double> avg = new TreeMap<>();
        for (String month : total.keySet()) {
            avg.put(month, total.get(month) / count.get(month));
        }
        return avg;
    }
}
