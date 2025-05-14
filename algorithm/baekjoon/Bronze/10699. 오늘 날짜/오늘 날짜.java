import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }
}