//Practical10

import java.sql.*;

public class prac_10{
    static String Driver = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost/";
    static String username = "root";
    static String password = ""; 

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Database Connected!!");
            stmt = conn.createStatement();
            stmt.executeUpdate("create database JavaDatabase12;");
            System.out.println("Database Created!!");
        }
        catch(Exception se){
            se.printStackTrace();
        }
        try{
            conn.commit();
            conn.close();
        }
        catch(Exception e){}
    }
} 