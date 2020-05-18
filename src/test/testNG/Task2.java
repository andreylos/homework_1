package test.testNG;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом for
*/

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Task2 {

    public static void main(String[] args) {
        System.out.println(printName("Serg"));
    }

    public static String printName(String name) {
        String matrix = "";
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                matrix += name + " ";
            }
            matrix += "\n";
        }
        return matrix;
    }

    @Parameters({"myName"})
    @Test
    public void verifyNumberOfNames(String name){
        int expectedNamesCount = 50;
        String temp = printName(name);
        temp = temp.replaceAll("\n", "");
        String[] names = temp.split("\\s+");
        //System.out.println(Arrays.toString(names));
        Assert.assertTrue(expectedNamesCount == names.length,
                "There should be " + expectedNamesCount + " names, but got " + names.length);
    }
}