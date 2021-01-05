import java.util.Calendar;

public class DateTime {
    public static void main(String[] args) {
        Calendar rightNow = Calendar.getInstance();
        int h = rightNow.get(Calendar.HOUR_OF_DAY);
        int m = rightNow.get(Calendar.MINUTE);
        int s = rightNow.get(Calendar.SECOND);
        int mo = rightNow.get(Calendar.MONTH);
        int d = rightNow.get(Calendar.DAY_OF_MONTH);
        int y = rightNow.get(Calendar.YEAR);

        System.out.println("bay gio la: " + h + " gio " + m + " phut " + s + " giay.Ngay " + d + " thang " + mo + " nam " + y);

    }
}
