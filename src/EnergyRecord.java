import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class EnergyRecord {
    String timestamp;
    double usageMW;
    String hour;
    String dayOfWeek;
    String month;

    public EnergyRecord(String timestamp, double usageMW) {
        this.timestamp = timestamp;
        this.usageMW = usageMW;

        // Parse datetime and extract features
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dt = LocalDateTime.parse(timestamp, formatter);

        this.hour = String.format("%02d", dt.getHour());         // e.g. 01, 13
        this.dayOfWeek = dt.getDayOfWeek().toString();           // e.g. MONDAY
        this.month = dt.getMonth().toString();                   // e.g. JANUARY
    }
}
