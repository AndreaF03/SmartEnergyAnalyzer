import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ReportGenerator {

    public static void generateReport(List<EnergyRecord> records)  {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("D:/project/SmartEnergyAnalyzer/SmartEnergyAnalyzer/output/report.txt"));


            writer.println("🔌 SMART ENERGY ANALYZER REPORT");
            writer.println("================================\n");

            double average = Analyzer.calculateAverage(records);
            writer.printf("Overall Average Usage: %.2f MW\n", average);

            double peak = Analyzer.findPeakUsage(records);
            writer.printf(" Peak Usage Observed: %.2f MW\n\n", peak);

            // Average by Hour
            writer.println(" Average Usage by Hour:");
            Map<String, Double> byHour = Analyzer.averageByHour(records);
            byHour.forEach((k, v) -> writer.printf("  Hour %s: %.2f MW\n", k, v));

            // Average by Day of Week
            writer.println("\n Average Usage by Day of Week:");
            Map<String, Double> byDay = Analyzer.averageByDay(records);
            byDay.forEach((k, v) -> writer.printf("  %s: %.2f MW\n", k, v));

            // Average by Month
            writer.println("\n Average Usage by Month:");
            Map<String, Double> byMonth = Analyzer.averageByMonth(records);
            byMonth.forEach((k, v) -> writer.printf("  %s: %.2f MW\n", k, v));

            writer.println("\n Report generated successfully.");
            writer.close();
System.out.println(" Report successfully written to report.txt");


        } catch (Exception e) {
            System.out.println(" Failed to write report: " + e.getMessage());
        }
    }
}
