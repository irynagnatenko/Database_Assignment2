import java.util.List;
import java.util.Scanner;

/**
 * Created by Iryna Gnatenko
 * Date 2021-02-20
 * Time 11:11 PM
 * Project Database
 */
public class Menu {


    public void Menu() {
        Repository r = new Repository();
        Menu2 m = new Menu2();
        String inputUserName;
        String inputPassword;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Shoes Webshop! \nPlease login.");
        System.out.println();
        System.out.println("Please enter your user name:");
        inputUserName = scan.next().trim();
        System.out.println("Please enter your password:");
        inputPassword = scan.next().trim();

        if ( r.UserExists(inputUserName, inputPassword)) {
            System.out.println("Login Success");
            // call the next menu
            m.Menu2(inputUserName);

        }else {
            System.out.println("Login Failed. Please try again.");
            this.Menu();
        }
    }

    public static void main(String[] args) {
        Menu m = new Menu();
        m.Menu();
    }
}


