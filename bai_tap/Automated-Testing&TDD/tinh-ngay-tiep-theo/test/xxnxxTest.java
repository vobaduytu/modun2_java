import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class xxnxxTest {

    @Test
    @DisplayName("Testing 31/01/2018 - 01/02/2018 ")
    void testGetNextDay1() {
        String date = "31/01/2018";
        String expected = "01/02/2018";
        assertEquals(expected, xxnxx.getNextDay(date)); }

    @Test
    @DisplayName("Testing 01/01/2018 - 02/01/2018")
    void testGetNextDay2() {
        String date = "01/01/2018";
        String expected = "02/01/2018";
        assertEquals(expected, xxnxx.getNextDay(date)); }
    @Test
    @DisplayName("Testing 30/04/2018 - 01/05/2018")
    void testGetNextDay3() {
        String date = "30/04/2018";
        String expected = "01/05/2018";
        assertEquals(expected, xxnxx.getNextDay(date)); }
    @Test
    @DisplayName("Testing 28/02/2018 - 01/03/2018")
    void testGetNextDay4() {
        String date = "28/02/2018";
        String expected = "01/03/2018";
        assertEquals(expected, xxnxx.getNextDay(date)); }
    @Test
    @DisplayName("Testing 28/02/2020 - 29/02/2020")
    void testGetNextDay5() {
        String date = "28/02/2020";
        String expected = "29/02/2020";
        assertEquals(expected, xxnxx.getNextDay(date)); }
    @Test
    @DisplayName("Testing 31/12/2020 - 01/01/2021")
    void testGetNextDay6() {
        String date = "31/12/2020";
        String expected = "01/01/2021";
        assertEquals(date+"_"+expected, date+"_"+xxnxx.getNextDay(date)); }
}