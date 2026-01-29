import java.util.Date;

public class FineCalculator {

    public static int calculateFine(Date issueDate, Date returnDate) {
        long diffMillis = returnDate.getTime() - issueDate.getTime();
        long days = diffMillis / (1000 * 60 * 60 * 24);

        int allowedDays = 7;
        int finePerDay = 5;

        if (days > allowedDays) {
            return (int) (days - allowedDays) * finePerDay;
        }
        return 0;
    }
}
