package FinalExam_04_April_2020_Group2;

import java.util.Scanner;

public class _01_PasswordReset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String cmd = scanner.nextLine();

        StringBuilder pass = new StringBuilder();

        while (!cmd.equals("Done")) {
            String[] tokens = cmd.split(" ");
            if (tokens[0].equals("TakeOdd")) {
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 != 0) {
                        pass.append(input.charAt(i));
                    }
                }
                System.out.println(pass.toString());
                input = pass.toString();
            } else if (tokens[0].equals("Cut")) {
             //   String toRemove = input.substring(Integer.parseInt(tokens[1]),
             //           Integer.parseInt(tokens[2]) + Integer.parseInt(tokens[1]));
                //pass = new StringBuilder();
                //pass.append(input);
                //input = input.replace(toRemove, "");

                input = input.substring(0, Integer.parseInt(tokens[1])) +
                        input.substring( Integer.parseInt(tokens[2]) + Integer.parseInt(tokens[1]));
                System.out.println(input);
            } else if (tokens[0].equals("Substitute")) {
                if (input.contains(tokens[1])) {
                    input = input.replaceAll(tokens[1], tokens[2]);
                    System.out.println(input);
                } else {
                    System.out.println("Nothing to replace!");
                }
            }
            cmd = scanner.nextLine();
        }
        if (input.length() != 0) {
            System.out.printf("Your password is: %s", input);
        }
    }
}
