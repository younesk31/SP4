import java.sql.*;
import java.util.ArrayList;

public class Database {
    public static double pizzaSale;

    /**
     * @author Younes Karim
     * // Creation of the archive with placeholder for a correct read later on
     **/
    public static void connectionToDatabase(ArrayList<Menu> pizzaMenu) {
        String[] parts = Main.DBURL.split("6/|\\?");
        try {
        Class.forName(Menu.DBDRIVER);
        Connection connection;
        connection = DriverManager.getConnection(Main.DBURL, Main.DBUSER, Main.DBPASS);
        System.out.println(Menu.GREEN+"Connection to Database: ["+String.join("",parts[1])+"] established.."+Menu.RESET);
        addPizzas(pizzaMenu);
        }
        catch(ClassNotFoundException | SQLException classNotFoundException){
            System.out.println(Menu.RED+"Database Error! [6]\nCritical System Error! - Database "+Menu.GREEN+String.join("",parts[1])+Menu.RED+" does not exist");
            System.out.println("Please import the provided Database for "+Menu.GREEN+String.join("",parts[1])+Menu.RED+" into MySQL-Workbench"+Menu.RESET);
        }
    }

    /**
     * @author Younes Karim
     * // calcualte the sale of pizzas by reading the file
     **/
    public static void calculateSale() throws SQLException, ClassNotFoundException {
        Class.forName(Menu.DBDRIVER);
        Connection connection;
        connection = DriverManager.getConnection(Main.DBURL, Main.DBUSER, Main.DBPASS);
        PreparedStatement pstmt = null;
        String sql = "SELECT SUM(pris) AS TotalMoneyEarned FROM orders";
        pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            pizzaSale = Double.parseDouble((rs.getString(1)));
        } else {
            System.out.println(Menu.RED+"Database Error! [6] - Empty row!"+Menu.RESET);
        }
    }

    /**
     * @author Younes Karim
     * Reads the file and outputs Strings with the name into an String array so that it later
     * can be added to a collection and the frequency of how many times it occours can be counted
     **/
    public static void pizzaList(ArrayList<String> stats) {
        try {
        stats.removeAll(stats);
        Class.forName(Menu.DBDRIVER);
        Connection connection;
        connection = DriverManager.getConnection(Main.DBURL, Main.DBUSER, Main.DBPASS);
        PreparedStatement pstmt = null;
        String sql = "SELECT pizzaName FROM mariospizzabar.orders";
        pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            stats.add(rs.getString("pizzaName"));
        }
        rs.close();
        pstmt.close();
    }
        catch(ClassNotFoundException | SQLException classNotFoundException){
        System.out.println(Menu.RED+"\nDatabase Error! [6]\nCritical System Error! - Database does not exist");
        System.out.println("Please import the provided Database structure into MySQL-Workbench"+Menu.RESET);
    }
    }

    /**
     * @author Younes Karim
     * // All the pizzas we are adding to our menu from our designated database mariopizza
     **/
    public static void addPizzas(ArrayList<Menu> pizzaMenu) {
        try{
            Class.forName(Menu.DBDRIVER);
            Connection connection;
            connection = DriverManager.getConnection(Main.DBURL, Main.DBUSER, Main.DBPASS);
            PreparedStatement pstmt = null;
            String sql = "SELECT * FROM mariospizzabar.menucard";
            int menuOrder = 0;
            pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                pizzaMenu.add(menuOrder, new Menu(rs.getInt("mid"), rs.getString("navn"), rs.getString("fyld"), rs.getInt("pris")));
                if(menuOrder < pizzaMenu.size()) {
                    menuOrder++;
                }else{
                    menuOrder = 0;
                }
            }
            rs.close();
            pstmt.close();
        }
        catch(ClassNotFoundException | SQLException classNotFoundException){
            System.out.println(Menu.RED+"\nDatabase Error! [6] - Pizzas could not be added to the database\n");
        }
    }

    public static double getPizzaSale() {
        return pizzaSale;
    }
}