public class xxnxx {
    public static String getNextDay(String thisDate) throws NumberFormatException {
        String[] dateParts = thisDate.split("/");

        if (dateParts.length != 3) {
            throw new NumberFormatException("Invalid date format");
        }

        int day = parseDay(dateParts[0]);
        int month = parseMonth(dateParts[1]);
        int year = parseYear(dateParts[2]);

        int maxDaysInMonth = getMaximumDaysInMonth(month, year);
        if (day > maxDaysInMonth) throw new NumberFormatException("Day exceeds max of month");

        if (++day > maxDaysInMonth) {
            day = 1;
            if (++month > 12) {
                month = 1;
                year++;
            }
        }

        return String.format("%s/%s/%d", formatNumber(day), formatNumber(month), year);
    }

    private static int parseDay(String day) throws NumberFormatException {
        return parseDatePartWithLimit(day, 1, 31);
    }

    private static int parseMonth(String month) throws NumberFormatException {
        return parseDatePartWithLimit(month, 1, 12);
    }

    private static int parseYear(String year) throws NumberFormatException {
        return parseDatePartWithLimit(year, 0, 9999);
    }

    private static int parseDatePartWithLimit(String datePart, int from, int to) throws NumberFormatException {
        int result = Integer.parseInt(datePart);
        if (result >= from && result <= to) {
            return result;
        } else {
            throw new NumberFormatException("Date invalid");
        }
    }

    private static int getMaximumDaysInMonth(int month, int year) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            default -> -1;
        };
    }


    private static boolean isLeapYear(int year) {
        return year % 100 == 0 ? year % 400 == 0 : year % 4 == 0;
    }

    private static String formatNumber(int num) {
        return num < 10 ? "0" + num : String.valueOf(num);
    }
}
