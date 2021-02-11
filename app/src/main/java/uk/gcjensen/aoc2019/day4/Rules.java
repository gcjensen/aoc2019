package uk.gcjensen.aoc2019.day4;

public class Rules {
    public static boolean increasingDigits(Integer num) {
        var digits = num.toString().split("");
        for (var i = 1; i < digits.length; i++) {
            if (Integer.parseInt(digits[i]) < Integer.parseInt(digits[i - 1])) {
                return false;
            }
        }

        return true;
    }

    public static boolean repetition(Integer num) {
        var digits = num.toString().split("");
        for (var i = 1; i < digits.length; i++) {
           if (digits[i].equals(digits[i - 1])) {
               return true;
           }
        }

        return false;
    }

    public static boolean repetition2xOnly(Integer num) {
        final var maxRepetition = 2;

        var repeats = 1;
        var digits = num.toString().split("");

        for (var i = 1; i < digits.length; i++) {
            if (digits[i].equals(digits[i - 1])) {
                repeats++;
                continue;
            }

            if (repeats == maxRepetition) {
                return true;
            }
            repeats = 1;
        }

        return repeats == maxRepetition;
    }
}
