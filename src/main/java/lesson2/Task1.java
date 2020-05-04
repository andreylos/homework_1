package lesson2;

/**
 /* Реализовать у класса Task1 переменные age (тип int),  name (тип String), ageGroup(тип String)
 * реализовать методы геттеры и сеттеры для каждой переменной.
 /* Должны быть выполненны следующие условия:
 /*  - не должно быть возможности напрямую устанваливать или читать значение age/name
 /*  - нельзя установить значение age меньше нуля
 /*  - максимальныое значение для возраста - 100
 /*  - значение name не может быть короче чем 3 символа и длиннее чем 50 символов
 *  - name не может состоять из одних только пробелов
 /*  - не зависимо от того ввел пользователь имя с большой или с маленькой буквы,
 *      оно должно быть записано в переменную name с большой буквы
 *  - ageGroup должен устанавливаться автоматически при установке возраста
 *      - child если age до 15 лет
 *      - student  - если age от 15 до 25 лет
 *      - worker - если age от 26 до 65 лет
 *      - pensioner - если age старше 66 лет
 *  - ageGroup можно только прочитать с помощью геттера, сеттер должен быть приватным и недоступным для других классов
 */

public class Task1 {

    public static void main(String[] args) {
        Task1 Task = new Task1();
        Task.setName("Maxim");
        System.out.println(Task.getName());
    }

    private int age;
    private String name;
    String ageGroup;

    public void setAge(int age) {
        if (age > 0 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Age should be more than 0 and less than 100");
            this.age = 1;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name.length() >= 3 && name.length() <= 50) {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            System.out.println("Name cannot be less than 3 and more than 50 characters");
            this.name = "";
        }
    }

    public String getName() {
        return this.name;
    }
}

//public class Cat {
//    private static int counter = 0;
//    private int age;
//    String name;
//    public final String COLOR_OF_CAT = "red";
//
//    public Cat() {//constructor
//        this("not defined");
//    }
//
//    public Cat(String name) { //constructor
//        System.out.println("Cat was created");
//        counter++;
//        this.name = name;
//        this.age = 10;
//    }

//    public void setAge(int age) {
//        if (age > 1) { //CTRL+ALT+L
//            this.age = age;
//        } else {
//            System.out.println("You can't set age " + age);
//            this.age = 0;
//        }
//    }

//    public int getAge() {
//        return this.age;
//    }
//
//    void greet(String userName) {
//        System.out.println("Hello user " + userName + ". My name is " + this.name);
//    }
//
//    public void meov() {
//        System.out.println("MEOV");
//    }
//
//    public static void printCount() {
//        System.out.println("Was created " + counter + " cats");
//    }
//}
