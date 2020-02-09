import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Surname list
        List<String> surnames = new ArrayList<>();
        System.out.println("Populate list");
        populate(surnames);
        System.out.println("Print list");
        print(surnames);
        System.out.println("Find");
        List<String> surnamesToFind = new ArrayList<>(Arrays.asList("Koshtrevski", "Markovski", ""));
        for (String surname : surnamesToFind) {
            try {
                boolean exists = find(surnames, surname);
                if (exists) {
                    System.out.println("Surname " + surname + " exists");
                } else {
                    System.out.println("Surname " + surname + " does not exist");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        System.out.println("End of the programm");
    }

    public static void populate(List<String> values) {
        System.out.println("Add surnames");
        System.out.println("For end press 0");
        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if ("0".equals(line)) {
                    break;
                }
                values.add(line);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong ... ");
        }
    }

    public static void print(List<String> values) {
        for (String value : values) {
            System.out.println(value);
        }
    }

    public static boolean find(List<String> values, String valueToFind) throws CustomException {
        if(valueToFind.equals("")) {
            throw new CustomException("Prazen string");
        }

       return values.contains(valueToFind);
    }
}
