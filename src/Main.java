import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🔌 SmartEnergyAnalyzer started...\n");

        List<EnergyRecord> records = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/AEP_hourly.csv"));
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String timestamp = parts[0];
                double usage = Double.parseDouble(parts[1]);
                records.add(new EnergyRecord(timestamp, usage));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(" Error reading file: " + e.getMessage());
            return;
        }

        System.out.println(" Loaded " + records.size() + " records.\n");

        // Analysis
        double avgUsage = Analyzer.calculateAverage(records);
        double peak = Analyzer.findPeakUsage(records); 


        System.out.printf(" Average Usage: %.2f MW\n", avgUsage);
        System.out.println(" Peak Usage: " + peak);
        // Generate Report
        System.out.println("\n Average Usage by Hour:");
    Map<String, Double> byHour = Analyzer.averageByHour(records);
    byHour.forEach((k, v) -> System.out.printf("Hour %s : %.2f MW\n", k, v));

    System.out.println("\n Average Usage by Day:");
    Map<String, Double> byDay = Analyzer.averageByDay(records);
    JsonExporter.exportHourlyAverage(byHour);
    byDay.forEach((k, v) -> System.out.printf("%s : %.2f MW\n", k, v));

    System.out.println("\n Average Usage by Month:");
    Map<String, Double> byMonth = Analyzer.averageByMonth(records);
    byMonth.forEach((k, v) -> System.out.printf("%s : %.2f MW\n", k, v));

    ReportGenerator.generateReport(records);
    }
}
