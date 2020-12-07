import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
//System Errors
/*
//System Error! [1] --> No orders - makePizza()
//System Error! [2] --> Pizza creation error - pizzaOrders()
//System Error! [3] --> Empty array - pizzaFinisher()
//System Error! [4] --> IOException error, empty file or file did not load error
//System Error! [5] --> Order number is out of bounds
//Database Error! [6] --> Database is empty
*/

public class Main {
    static final String DBURL = "jdbc:mysql://localhost:3306/mariospizzabar?serverTimezone=UTC";
    static final String DBUSER = "root";
    static final String DBPASS = "1234";

    /**
     * @author Younes Karim
     **/
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Pizza factory
        ArrayList<Menu> pizzaMenu = new ArrayList<>();
        ArrayList<Pizza> customer = new ArrayList<>();
        ArrayList<String> stats = new ArrayList<>();
        Database.connectionToDatabase(pizzaMenu);
        Scanner cmd = new Scanner(System.in);
        Menu.start(cmd, pizzaMenu, customer,stats);
    }
}