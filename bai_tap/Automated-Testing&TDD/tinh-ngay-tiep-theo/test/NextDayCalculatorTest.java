import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @Test
    @DisplayName("Testing 10/10/2010")
    void testGetNextDay1() {
        String date = "10/10/2010";
        String expected = "11/10/2010";
        assertEquals(expected, NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 10/10/20/10")
    void testGetNextDay2() {
        String date = "10/10/20/10";
        assertThrows(NumberFormatException.class, () -> NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 10/10/")
    void testGetNextDay3() {
        String date = "10/10/";
        assertThrows(NumberFormatException.class, () -> NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 10/10/")
    void testGetNextDay4() {
        String date = "10/10/";
        assertThrows(NumberFormatException.class, () -> NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 01/01/2018")
    void testGetNextDay5() {
        String date = "01/01/2018";
        String expected = "02/01/2018";
        assertEquals(expected, NextDayCalculator.getNextDay(date));    }

    @Test
    @DisplayName("Testing 31/01/2018")
    void testGetNextDay6() {
        String date = "31/01/2018";
        String expected = "01/02/2018";
        assertEquals(expected, NextDayCalculator.getNextDay(date));    }

    @Test
    @DisplayName("Testing 30/04/2018")
    void testGetNextDay7() {
        String date = "30/04/2018";
        String expected = "01/05/2018";
        assertEquals(expected, NextDayCalculator.getNextDay(date));    }

    @Test
    @DisplayName("Testing 28/02/2018")
    void testGetNextDay8() {
        String date = "28/02/2018";
        String expected = "01/03/2018";
        assertEquals(expected, NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 29/02/2020")
    void testGetNextDay9() {
        String date = "29/02/2020";
        String expected = "01/03/2020";
        assertEquals(expected, NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing 31/12/2018")
    void testGetNextDay10() {
        String date = "31/12/2018";
        String expected = "01/01/2019";
        assertEquals(expected, NextDayCalculator.getNextDay(date));
    }

    @Test
    @DisplayName("Testing empty")
    void testGetNextDay11() {
        String date = "";
        assertThrows(NumberFormatException.class, () -> NextDayCalculator.getNextDay(date));
    }
}