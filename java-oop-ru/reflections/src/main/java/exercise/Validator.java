package exercise;

import javax.management.StringValueExp;
import java.lang.reflect.Field;

// BEGIN
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    public static List<String> validate(Address address) {
        List<String> listOfInvalidFields = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field: fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    listOfInvalidFields.add(field.getName());
                }
            }
            catch (IllegalAccessException e) {
                System.out.println("No access");
            }
        }
        return listOfInvalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> mapOfInvalidFields = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field: fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class) && field.get(address) == null) {
                    mapOfInvalidFields.put(field.getName(), new ArrayList<>());
                    mapOfInvalidFields.get(field.getName()).add("can not be null");
                }

                if (field.isAnnotationPresent(MinLength.class) &&
                        (fieldLength(field, address) < field.getAnnotation(MinLength.class).minLength()) &&
                        mapOfInvalidFields.containsKey(field.getName())
                ) {
                    var helpList = mapOfInvalidFields.get(field.getName());
                    helpList.add("length less than " +
                            field.getAnnotation(MinLength.class).minLength());
                    mapOfInvalidFields.put(field.getName(), helpList);
                }

                if (field.isAnnotationPresent(MinLength.class) &&
                        fieldLength(field, address) < field.getAnnotation(MinLength.class).minLength() &&
                        !mapOfInvalidFields.containsKey(field.getName())
                ) {
                    mapOfInvalidFields.put(field.getName(), new ArrayList<>());
                    mapOfInvalidFields.get(field.getName()).add("length less than " +
                            field.getAnnotation(MinLength.class).minLength());
                }
            }
            catch (IllegalAccessException e) {
                System.out.println("No access");
            }
        }
        return mapOfInvalidFields;
    }

    private static int fieldLength(Field field, Address address) {
        try {
            field.setAccessible(true);
            if (field.get(address) != null) {
                return String.valueOf(field.get(address)).length();
            }
        }
        catch (IllegalAccessException e) {
            System.out.println("No access");
        }
        return 0;
    }
}
// END
