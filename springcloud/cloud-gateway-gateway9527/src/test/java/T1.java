import java.time.ZonedDateTime;

public class T1 {

    public static void main(String[] args) {
        //默认时区
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
