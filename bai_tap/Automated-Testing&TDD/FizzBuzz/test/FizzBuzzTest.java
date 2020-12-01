import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {
@Test
    @DisplayName(" test 6" )
    void check1(){
    int number = 6;
    String result = FizzBuzz.checkOut(number);
    String expected = FizzBuzz.Fizz;
    assertEquals(expected,result);
}
    @Test
    @DisplayName(" test 5" )
    void check2(){
        int number = 5;
        String result = FizzBuzz.checkOut(number);
        String expected = FizzBuzz.Buzz;
        assertEquals(expected,result);
    }
    @Test
    @DisplayName(" test 15" )
    void check3(){
        int number = 15;
        String result = FizzBuzz.checkOut(number);
        String expected = FizzBuzz.FizzBuzz;
        assertEquals(expected,result);
    }
    @Test
    @DisplayName(" test 11" )
    void check4(){
        int number = 11;
        String result = FizzBuzz.checkOut(number);
        String expected = FizzBuzz.AAAA;
        assertEquals(expected,result);
    }
    @Test
    @DisplayName(" test 30" )
    void check45(){
        int number = 30;
        String result = FizzBuzz.Write(number);
        String expected = "ba mươi";
        assertEquals(expected,result);
    }
}