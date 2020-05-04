package lesson1;

/* Мое имя
Вывести на экран свое имя 5 строк по 10 раз (через пробел).
System.out.println, System.out.print можно использовать только по одному разу
для этого нужно воспользоваться циклом while
*/

public class Task3 {

    public static void main(String[] args) {
        String s = "Andrey";
        int i = 4;
        while (i >= 0) {
            int b = 9;
            while (b >= 0) {
                b--;
                System.out.print(s + " ");
            }
            i--;
            System.out.println();
        }
    }
}