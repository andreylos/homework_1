package test.Allure_homework;

import java.util.HashSet;
import java.util.Set;

public class randomNumber {
    public static void main(String[] args) {
        int max = 10;
        int min = 1;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = min; i < 1000; i++) {
        int rand = (int) (Math.random() * (max + 1 - min) + min);
            set.add(rand);
        }
        for (Integer el:set) System.out.println(el);
    }
}
