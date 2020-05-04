package lesson1;

/**
 * Реализовать функцию, которая принимает строку и возвращает ее же в обратном виде
 * например "Hello world!!!" -> "!!!dlrow olleH"
 */

    public class Task5 {
        public static void main(String[] args) {
            System.out.println(reverse("Hello world!!!"));
        }

        public static String reverse(String str) {
            char[] x = str.toCharArray();
            for (int i = x.length; i > 0; i--) {
                System.out.print(x[i-1] = str.charAt(i-1));
            }
            return "";
        }
        }
