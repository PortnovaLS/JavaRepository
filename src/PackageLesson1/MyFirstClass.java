package PackageLesson1;

public class MyFirstClass {

    public static void main(String[] args) {
        int a = 3, b = 6, c = 8, d = 9;
        System.out.println(myExpression(a, b, c, d));

        a = 11;
        b = 7;
        System.out.println(myBoolean(a, b));

        a = 3;
        checkPositiveOrNegative(a);

        System.out.println(makeGreetings("Lyubov"));

        int year = 2017;
        checkYear(year);

    }
//1) Задание

    public static float myExpression(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }
//2) задание

    public static boolean myBoolean(int a, int b) {
        int summary = a + b;
        if (summary >= 10 && summary <= 20)
            return true;
        else {
            return false;
        }
    }
//    3) задание

    public static void checkPositiveOrNegative(int a) {
        if (a >= 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }
//4) задание

    public static String makeGreetings(String name) {
        return "Hello," + name + "!";

    }
//5) задание

    public static void checkYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}






