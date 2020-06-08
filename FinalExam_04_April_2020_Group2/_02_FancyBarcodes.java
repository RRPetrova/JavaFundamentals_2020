package FinalExam_04_April_2020_Group2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile("@#+([A-Z][A-Za-z\\d]{4,}[A-Z])@#+");
            Matcher matcher = pattern.matcher(input);

            StringBuilder result = new StringBuilder();
            boolean found = false;
            while (matcher.find()) {
                found = true;
                for (int j = 0; j < matcher.group().length(); j++) {
                    if (Character.isDigit(matcher.group().charAt(j))) {
                        result.append(matcher.group().charAt(j));
                    }
                }
                if (result.length() != 0) {
                    System.out.printf("Product group: %s%n", result);
                } else {
                    System.out.println("Product group: 00");
                }
            }
           if (!found) {
               System.out.println("Invalid barcode");
           }
        }



    }
}
