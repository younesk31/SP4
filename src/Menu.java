import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int pizzaNr;
    private String pizzaName;
    private String pizzaFilling;
    private int pizzaPrice;
    public static final String RED = "\033[0;31m";     // Red
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String RESET = "\033[0m";      // Reset
    static final String DBDRIVER = "com.mysql.cj.jdbc.Driver";

    public Menu(int pizzaNr, String pizzaName, String pizzaFilling, int pizzaPrice) {
        this.pizzaNr = pizzaNr;
        this.pizzaName = pizzaName;
        this.pizzaFilling = pizzaFilling;
        this.pizzaPrice = pizzaPrice;
    }

    /**
     * @author Younes Karim
     * // Welcome page
     **/
    public static void startPage() {

        System.out.println(
                "////////////////////////////////////////////////////////////////////////////////////////////////\n" +
                        Menu.GREEN+
                        "███╗   ███╗ █████╗ ██████╗ ██╗ ██████╗     ██████╗ ██╗███████╗███████╗ █████╗ \n" +
                        "████╗ ████║██╔══██╗██╔══██╗██║██╔═══██╗    ██╔══██╗██║╚══███╔╝╚══███╔╝██╔══██╗\n" +
                        "██╔████╔██║███████║██████╔╝██║██║   ██║    ██████╔╝██║  ███╔╝   ███╔╝ ███████║\n" +
                        "██║╚██╔╝██║██╔══██║██╔══██╗██║██║   ██║    ██╔═══╝ ██║ ███╔╝   ███╔╝  ██╔══██║\n" +
                        "██║ ╚═╝ ██║██║  ██║██║  ██║██║╚██████╔╝    ██║     ██║███████╗███████╗██║  ██║\n" +
                        "╚═╝     ╚═╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝ ╚═════╝     ╚═╝     ╚═╝╚══════╝╚══════╝╚═╝  ╚═╝\n" +
                        Menu.RESET+
                        "Press 1 --> Menu Card\n" +
                        "Press 2 --> Start new Order\n" +
                        "Press 3 --> All active Orders\n" +
                        "Press 4 --> Finalize an order\n" +
                        "Press 5 --> Pizza revenue\n" + "\n" +
                        "Extra Added Functionality\n" +
                        "Press 6 --> Display the current time & date\n" +
                        "////////////////////////////////////////////////////////////////////////////////////////////////"+"\n");
    }

    /**
     * @author Younes Karim & Ruimin Huang
     * // input for the welcome page
     **/
    public static void start(Scanner input, ArrayList<Menu> pizza, ArrayList<Pizza> customer, ArrayList<String> stats) throws SQLException, ClassNotFoundException {
        while (true) {
            //show the main page
            Menu.startPage();
            //scanner
            int num = input.nextInt();
            //String text = input.nextLine();
            switch (num) {
                case 1:
                    // open the menu view of all the pizzas
                    getMenu(pizza);
                    break;
                case 2:
                    // order a pizza with attributes name,pizzaNr, (location).
                    Pizza.createPizza(customer);
                    break;
                case 3:
                    // See all current orders
                    Pizza.pizzaOrders(customer,pizza);
                    break;
                case 4:
                    // Finish a order
                    Order.pizzaFinisher(customer,pizza);
                    break;
                case 5:
                    // view all the sale of all pizzas
                    Count.countTheStats(stats);
                    break;
                case 6:
                    // pizza statistic
                    System.out.println("Current time and date: "+Count.getdate()+"\n");
                    break;
                default:
                    System.out.println(RED+"...Shutting down..."+RESET);
                    return;
            }
        }
    }

    /**
     * @author Younes Karim
     * // display all the pizzas for Mario
     **/
    public static void getMenu(ArrayList<Menu> showMenu) {
        for (int i = 0; i < showMenu.size(); ++i) {
            if (i < 9) {
                System.out.println("[" + showMenu.get(i).getPizzaNr() + "].  " +
                        "Pizza: [" + showMenu.get(i).getPizzaName() + "]: " +
                        showMenu.get(i).getPizzaFilling() + "..... [" + showMenu.get(i).getPizzaPrice() + "],-");
            } else {
                System.out.println("[" + showMenu.get(i).getPizzaNr() + "]. " +
                        "Pizza: [" + showMenu.get(i).getPizzaName() + "]: " +
                        showMenu.get(i).getPizzaFilling() + "..... [" + showMenu.get(i).getPizzaPrice() + "],-");
            }
        }
        System.out.println("\nThe Menu is ready for you Mario ;)\n\n");
    }

    public int getPizzaNr() {
        return pizzaNr;
    }
    public String getPizzaName() {
        return pizzaName;
    }
    public String getPizzaFilling() {
        return pizzaFilling;
    }
    public int getPizzaPrice() {
        return pizzaPrice;
    }

}