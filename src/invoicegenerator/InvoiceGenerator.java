
package invoicegenerator;

import java.util.Scanner;

public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String customerAddress = scanner.nextLine();

        
        int maxItems = 10;
        String itemNames[] = new String[maxItems];
        int itemQuantities[] = new int[maxItems];
        double itemPrices[] = new double[maxItems];
        int itemCount = 0;

        
        boolean moreItems = true;
        while (moreItems && itemCount < maxItems) {
            System.out.print("Enter item name: ");
            itemNames[itemCount] = scanner.nextLine();

            System.out.print("Enter item quantity: ");
            itemQuantities[itemCount] = scanner.nextInt();

            System.out.print("Enter item price: ");
            itemPrices[itemCount] = scanner.nextDouble();
            scanner.nextLine(); 

            itemCount++;


            if (itemCount < maxItems) {
                System.out.print("Add another item? (yes/no): ");
                String response = scanner.nextLine();
                moreItems = response.equalsIgnoreCase("yes");
            }
        }

       
        double taxRate = 0.10; 

       
        double totalAmount = 0;
        for (int i = 0; i < itemCount; i++) {
            totalAmount += itemQuantities[i] * itemPrices[i];
        }
        double taxAmount = totalAmount * taxRate;
        double finalAmount = totalAmount + taxAmount;

        
        System.out.println("\n\n\t\t\t------- INVOICE -------\n");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Customer Address: " + customerAddress);
        System.out.println("\n");
        System.out.println("Item\t\tQuantity\t\tPrice per Item\t\tTotal for Item");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(itemNames[i]+"\t\t"+itemQuantities[i]+"\t\t\t"+itemPrices[i]+"\t\t\t"+(itemQuantities[i] * itemPrices[i])+"\n");
        
        }
        System.out.println("Total Amount: $" + totalAmount);
        System.out.println("Tax (10%): $" + taxAmount);
        System.out.println("Final Amount: $" + finalAmount);

       
        
    }
}