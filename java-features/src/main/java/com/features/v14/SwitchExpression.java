package com.features.v14;

public class SwitchExpression {

    private static String findDayOfWeek(int day){
        var name = switch (day){
            case 0 -> "Sunday";
            case 1 -> {
                System.out.println(day);
                yield "Monday";
            }
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> throw new IllegalArgumentException("Not valid day");
        };
        return name;
    }
    public static void main(String[] args) {
        var dayOfWeek = findDayOfWeek(2);
        System.out.println(dayOfWeek);
    }
}
