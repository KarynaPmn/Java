package org.example;

import java.util.Set;

public class Validator {
    private static final Set<Double> AveragesList = Set.of(2.0, 3.0, 3.5, 4.0, 4.5, 5.0);

    public static boolean isValidId(String id) {
        return id.matches("\\d+");
    }

    public static boolean isValidName(String name) {
        return name.matches("[A-Z][a-zA-Z]*");
    }

    public static boolean isValidAverage(String avg) {
        return AveragesList.contains(Double.parseDouble(avg));
    }
}
