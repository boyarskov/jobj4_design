package ru.job4j.collection.map;

public class Binary {
    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println("123 in binary code: " + binary(123));
        System.out.println("4 in binary code: " + binary(4));
        System.out.println("1 in binary code: " + binary(1));
        System.out.println("0 in binary code: " + binary(0));
        System.out.println("777 in binary code: " + binary(777));
    }

}
