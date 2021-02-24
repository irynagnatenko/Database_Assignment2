import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-23
 * Time 9:33 PM
 * Project Database
*/ public class Menu2 {

    public void Menu2(String inputUserName) {
        Repository r = new Repository();
        int choice;
        Scanner input = new Scanner(System.in);

        System.out.println("Please choose what you want to do:");
        System.out.println("1. See all the items in stock and order");
//        System.out.println("2. See your order");
        System.out.println("0. Exit");

        choice = input.nextInt();
        switch (choice) {
            case 1:

                List<ShoesInStock> allShoes = r.getAllShoes();
                for (int i = 0; i < allShoes.size(); i++) {
                    System.out.println(i+1 + " " + allShoes.get(i).brandName + " " + allShoes.get(i).size + " " +allShoes.get(i).color + " " +allShoes.get(i).amountLeft);
                }

                Scanner sc = new Scanner(System.in);
                int inputOrder;
                System.out.println("Which item do you want to order? Please enter an id number");
                inputOrder = sc.nextInt();
                List<Customer> customers = r.getAllCustomers();
                int custId = 0;
                for(Customer c: customers) {
                    if (c.userName.equals(inputUserName)) {
                        custId = c.id;
                    }
                }

                Integer ordId = null;
                for(Orders o: r.getAllOrders()) {
                    if (o.customerId == custId) {
                        ordId = o.id;
                    }
                }
                // anropa stored procedure så att produkten läggs i beställningen.
                List<ShoesInStock> orderedShoes = new ArrayList<ShoesInStock>();

                if (ordId != null) {
                    r.addToCart_Proc(custId,ordId,allShoes.get(inputOrder-1).shoeId);
                    orderedShoes = r.getAllShoesByOrderId(ordId);
                    System.out.println(ordId);
                }
                else {
                    ordId = r.addToCart_Func(custId, ordId, allShoes.get(inputOrder - 1).shoeId);
                    for(Orders o: r.getAllOrders()) {
                        if (o.id == ordId) {
                            orderedShoes = r.getAllShoesByOrderId(ordId);
                        }
                    }

                    System.out.println(orderedShoes.toString());

                    System.out.println(ordId);

                }
                // användaren får återkoppling om det gick bra eller om ett fel uppstod när produkten lades till
                System.out.println("Your order was added successfully.");
                //användaren ska kunna välja att skriva ut alla produkter som ingår i beställningen
                System.out.println("You have following items in your cart:");
                for (ShoesInStock sh: orderedShoes) {
                    System.out.println("Brand:" + sh.brandName + ", size: " + sh.size + ", color: " + sh.color);
                }




                break;

            case 0:
                System.exit(0);
                break;
        }
    }
}
