package test.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(5, 2, 3));
    }

    public static int min(int a, int b, int c) {
        int x = 0;
        if (a < b && a < c) {
            x = a;
        } else if (b < c && b < a) {
            x = b;
        } else if (c < a && c < b) {
            x = c;
        }
        return x;
    }

    @DataProvider(name = "numbers")
    public Object[][] getData() {
        return new Object[][]{
                {1, 2, 3, 1},
                {10, 20, 100, 10},
                {10, 0, 100, 0},
                {-2, 20, 0, -2},
                {100, 200, 1000, 100},
        };
    }

        @Test(dataProvider = "numbers")
        public void testMinNumber ( int number1, int number2, int number3, int expectedMinimum){
            int actualMinimum = min(number1, number2, number3);
            assertEquals(actualMinimum, expectedMinimum, "Expected minimum number is " + expectedMinimum + ", but got " + actualMinimum);
        }
    }

