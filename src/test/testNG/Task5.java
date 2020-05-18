package test.testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */

    public class Task5 {
    public static void main(String[] args) {
        System.out.println(reverse("Hello world!!!"));
    }

    public static String reverse(String str) {
        char[] in = str.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }

    @DataProvider(name = "words")
    public Object[][] getData() {
        return new Object[][]{
                {"People", "elpoeP"},
                {"Hi everyone!", "!enoyreve iH"},
                {"2 dollars", "srallod 2"},

        };
    }

    @Test(dataProvider = "words")
    public void testRevertedString(String normalString, String revertedString) {
        String actualResult = reverse(normalString);
        assertEquals(actualResult.toString(), revertedString, "Expected reverted string is " + revertedString + ", but got " + actualResult);
    }
}


