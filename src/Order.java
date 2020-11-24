import java.sql.*;
import java.util.*;

public class Order {
    /**
     * @author Younes Karim
     * // returns the current active orders and then sends you to the secondary stage
     **/
    public static void pizzaFinisher(ArrayList<Pizza> Display, ArrayList<Menu> pizza) {
        if (!Display.isEmpty()) {
            System.out.println("The following Active orders were found in the system.\n");
            for (Pizza value : Display) {
                if (value.isActive()) {
                    System.out.println("Order number: " + value.getOrderNumber() +
                            " | Pizza Nr: " + value.getPizzaNrOrdered() +
                            " | Ordered by: " + value.getCustomerName() +
                            " | Ordered on: " + value.getTime() +
                            " | Was ordered: " + value.isOnlineoroffline() +
                            "\n");
                } else {
                    Pizza.activity = false;
                }
            }
            secondStageFinisher(Display,pizza);
        } else {
            System.out.println(Menu.RED+"\nSystem Error! [3]" +
                    "\nCan't finish a non existent order!\n"+Menu.RESET);
        }
    }

    /**
     * @author Younes Karim
     * // secondary stage in which you have to input the ordernumber so that you can archive it
     **/
    public static void secondStageFinisher(ArrayList<Pizza> Display, ArrayList<Menu> pizza) {
        try {
        Class.forName(Menu.DBDRIVER);
        Connection connection;
        connection = DriverManager.getConnection(Main.DBURL, Main.DBUSER, Main.DBPASS);
        Scanner input = new Scanner(System.in);
        int orderNumber;
        do {
            System.out.println("Please input the Order number that you want to mark as finished... and hit enter!");
            orderNumber = input.nextInt();
            if (orderNumber < 1 || orderNumber > Display.size()) {
                System.out.println(Menu.RED+"System Error! [5]\nThe order number: "+orderNumber+" does not exist!\nPress "+Menu.GREEN+"1"+Menu.RED+" to return to Menu\n"+Menu.RESET);
            }
        } while (orderNumber < 1 || orderNumber > Display.size());
        if (Display.get(orderNumber - 1).isActive()) {
            Display.get(orderNumber - 1).setActive(false);
            Display.get(orderNumber - 1).setArchived(true);
            String order = "INSERT INTO orders (pizzaName, pizzaNr, onlineOroffline, customer, pris, orderTime, filling, orderFinished) " +
                    "VALUES ("+
                    "'"+pizza.get(Display.get(orderNumber-1).getPizzaNrOrdered() - 1).getPizzaName()+ "', " +
                    "'"+Display.get(orderNumber-1).getPizzaNrOrdered()+ "', " +
                    "'"+Display.get(orderNumber-1).isOnlineoroffline()+ "', " +
                    "'"+Display.get(orderNumber-1).getCustomerName()+ "', " +
                    "'"+pizza.get(Display.get(orderNumber-1).getPizzaNrOrdered() - 1).getPizzaPrice()+ "', " +
                    "'"+Display.get(orderNumber-1).getTime()+ "', " +
                    "'"+pizza.get(Display.get(orderNumber-1).getPizzaNrOrdered() - 1).getPizzaFilling()+ "', " +
                    "'"+Count.getdate()+ "')";
            Statement stmt = connection.createStatement();
            int count = stmt.executeUpdate(order);
            System.out.println("\nOrderNr: " + Display.get(orderNumber - 1).getOrderNumber() + " is now marked as finished\n "+count+" row was affected in the Database...\n");
        } else {
            System.out.println(Menu.RED+"This order is either already Completed & Archived or Invalid!\n"+Menu.RESET);
        }
        }
        catch(ClassNotFoundException | SQLException classNotFoundException){
            System.out.println(Menu.RED+"\nDatabase Error! [6]\nCritical System Error! - Database structure does not exist therefore the system cant finish a order");
            System.out.println("-----> Please import the provided Database structure into MySQL-Workbench <-----"+Menu.RESET);
        }

    }
}