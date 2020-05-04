package lesson1;

public class Task1 {
    /* Минимум трех чисел
    Написать функцию, которая вычисляет минимум из трёх чисел.
    */
    public static void main(String[] args) {
        System.out.println(min(5,2,3));
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
}
