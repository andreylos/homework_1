package lesson2;

/**
 * Реализовать у класса Task1 переменные age (тип int),  name (тип String), ageGroup(тип String)
 * реализовать методы геттеры и сеттеры для каждой переменной.
 * Должны быть выполненны следующие условия:
 *  - не должно быть возможности напрямую устанваливать или читать значение age/name
 *  - нельзя установить значение age меньше нуля
 *  - максимальныое значение для возраста - 100
 *  - значение name не может быть короче чем 3 символа и длиннее чем 50 символов
 *  - name не может состоять из одних только пробелов
 *  - не зависимо от того ввел пользователь имя с большой или с маленькой буквы,
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
        Task.setName("max");
        Task.setAge(90);
        System.out.println(Task.getName() + " " + Task.getAgeGroup() + " " + Task.getAge());
        System.out.println(Task.getAge());
    }

    private int age;
    private String name;
    String ageGroup;

    public void setAge(int age) {
        if (age > 0 && age < 15) {
            this.age = age;
            ageGroup = "child";
        } else if (age >= 15 && age <= 25) {
            this.age = age;
            ageGroup = "student";
        } else if (age >= 26 && age <= 65) {
            this.age = age;
            ageGroup = "worker";
        } else if (age > 65 && age <= 100) {
            this.age = age;
            ageGroup = "pensioner";
        } else {
            System.out.println("Age should be more than 0 and less than 101");
            this.age = 1;
        }
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        if (name.length() >= 3 && name.length() <= 50 && !name.trim().equals("")) {
            this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            System.out.println("Name cannot be empty, less than 3 and more than 50 characters");
            this.name = "";
        }
    }

    public String getName() {
        return this.name;
    }

    public String getAgeGroup() {
        return this.ageGroup;
    }

    private void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
}
