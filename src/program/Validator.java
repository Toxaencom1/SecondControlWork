package program;


import program.model.Commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Validator {
    Scanner scanner;

    public Validator() {
        this.scanner = ScannerS.getScanner();
    }

    public Integer valMenuChoice(String numberFromScanner, int till) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Integer.parseInt(numberFromScanner) > 0 && Integer.parseInt(numberFromScanner) <= till) {//
                    return Integer.parseInt(numberFromScanner);
                } else {
                    System.out.printf("Enter number from 1 till %s: ", till);
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.printf("Enter number from 1 till %s: ", till);
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public Integer valInt(String numberFromScanner) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Integer.parseInt(numberFromScanner) > -2_147_483_648 && Integer.parseInt(numberFromScanner) < 2_147_483_647) {//
                    return Integer.parseInt(numberFromScanner);
                } else {
                    System.out.print("Enter number: ");
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.print("Enter number: ");
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public double valDouble(String numberFromScanner) {
        while (true) {
            try {
                emergency_exit(numberFromScanner);
                if (Double.parseDouble(numberFromScanner) > -2_147_483_648.0 && Double.parseDouble(numberFromScanner) < 2_147_483_647.0) {//
                    return Double.parseDouble(numberFromScanner);
                } else {
                    System.out.print("Enter real number: ");
                    numberFromScanner = scanner.nextLine();
                }
            } catch (Exception ex) {
                System.out.print("Enter real number: ");
                numberFromScanner = scanner.nextLine();
            }
        }
    }

    public String validateCommandsString(String commandsList) throws ThereIsNoSuchCommand {
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(commandsList.trim().split(";")));
        for (String command : temp) {
            if (!checkIfCommandExists(command)) {
                throw new ThereIsNoSuchCommand("There is no such command");
            }
        }
        return commandsList;
    }

    private static boolean checkIfCommandExists(String command) {
        for (Commands c : Commands.values()) {
            if (c.name().equals(command.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public String emergency_exit(String string) {
        if (string.equals("exit")) {
            System.out.println("\nEmergency exit\n");
            System.exit(0);
        }
        return string;
    }
}
