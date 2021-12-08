package com.product;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Inventory stock = new Inventory();
        boolean quitFlag = true;

        String qId = "Enter the product id: ";
        String qQty = "Enter the product quantity: ";
        String qEuro = "Enter the price in tens: ";
        String qCents = "Enter the price in cents: ";
        String qMany = "How many: ";

        System.out.println("Welcome to inventory app v1.0");

        while (quitFlag) {
            System.out.println("What do you want to do?");
            System.out.println("\n    Enter 1 to add new product.");
            System.out.println("    Enter 2 to add stock for a product.");
            System.out.println("    Enter 3 to reduce stock for a product.");
            System.out.println("    Enter 4 to remove a product from the inventory.");
            System.out.println("    Enter 5 to calculate total value certain product stocks.");
            System.out.println("    Enter 6 to calculate overall value of the inventory ");
            System.out.println("    Enter \"q\" to quit the application.");

            System.out.print(">>");
            String res = reader.nextLine();

            System.out.println();
            switch (res) {
                case "1":
                    int id1 = onlyCheckInt(reader, qId);
                    int qty1 = onlyCheckInt(reader, qQty);
                    System.out.println("Enter the price: ");
                    int euro1 = onlyCheckInt(reader, qEuro);
                    int cent1 = onlyCheckInt(reader, qCents);
                    stock.addProduct(id1, new Money(euro1, cent1), qty1);
                    break;

                case "2":
                    int id2 = onlyCheckInt(reader, qId);
                    int howMany2 = onlyCheckInt(reader, qMany);
                    boolean test2 = stock.addStock(id2, howMany2);
                    checkIdIfOnStock(test2);
                    break;

                case "3":
                    int id3 = onlyCheckInt(reader, qId);
                    int howMany3 = onlyCheckInt(reader, qMany);
                    boolean test3 = stock.reduceStock(id3, howMany3);
                    checkIdIfOnStock(test3);
                    break;

                case "4":
                    int id4 = onlyCheckInt(reader, qId);
                    boolean test4 = stock.removeProduct(id4);
                    checkIdIfOnStock(test4);
                    break;

                case "5":
                    int id5 = onlyCheckInt(reader, qId);
                    stock.printTotalValueProduct(id5);
                    break;

                case "6":
                    stock.printTotalValueStocks();
                    break;

                case "q":
                    quitFlag = false;
                    break;

            }

        }

    }

    public static int onlyCheckInt(Scanner scan, String q) {
        int id;
        System.out.print(q);
        while (true) {
            try {
                id = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Try again! " + q);
            }
        }

        return id;
    }

    public static void checkIdIfOnStock(boolean status){
        if (!status){
            System.out.println("No product found!");
        }
    }

}
