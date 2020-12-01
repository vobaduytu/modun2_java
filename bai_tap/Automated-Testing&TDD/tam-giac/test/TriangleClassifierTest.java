import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {
    @Test
    @DisplayName("Test 2-2-2")
    void triangleTest() {
        int a = 2;
        int b = 2;
        int c = 2;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.EQUILATERAL_TRIANGLE;
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test 2-2-3")
    void triangleTest1() {
        int a = 2;
        int b = 2;
        int c = 3;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.IS_AN_ISOSOCELES_TRIANGLE ;
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 3-4-5")
    void triangleTest2() {
        int a = 3;
        int b = 4;
        int c = 5;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.A_TRIANGLE ;
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 8-2-3")
    void triangleTest3() {
        int a = 8;
        int b = 2;
        int c = 3;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE ;
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test -1-2-1")
    void triangleTest4() {
        int a = -1;
        int b = 2;
        int c = 1;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE ;
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test 0-1-1")
    void triangleTest5() {
        int a = 0;
        int b = 1;
        int c = 1;
        String result = TriangleClassifier.triangleTest(a, b, c);

        String expected = TriangleClassifier.NOT_A_TRIANGLE ;
        assertEquals(expected, result);
    }
}