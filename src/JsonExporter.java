import java.io.FileWriter;
import java.util.Map;
import com.google.gson.Gson;

public class JsonExporter {
    public static void exportHourlyAverage(Map<String, Double> data) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("output/avg_by_hour.json");
            gson.toJson(data, writer);
            writer.close();
            System.out.println(" Exported hourly average to output/avg_by_hour.json");
        } catch (Exception e) {
            System.out.println(" Failed to write JSON: " + e.getMessage());
        }
    }
}
