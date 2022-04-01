import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class prac_12 extends Frame implements ActionListener{
    
    static String Driver = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost/javadatabase";
    static String username = "root";
    static String password = "";

    public static ResultSet executeQ(String query,Boolean result){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(Driver);
            System.out.println("Connecting Database...");
            conn = DriverManager.getConnection(dbUrl,username,password);
            System.out.println("Database Connected!!");
            stmt = conn.createStatement();
            if(result){
                rs = stmt.executeQuery(query);
                System.out.println("ResultSet Returned!!");
                return rs;
            }
            else{
                stmt.executeUpdate(query);
                System.out.println("Query Executed!!");
            }

        }
        catch(Exception se){
            se.printStackTrace();
        }
        try{conn=null;}
        catch(Exception e){e.printStackTrace();}
        try{stmt=null;}
        catch(Exception e){e.printStackTrace();}

        return rs;
    }

    Choice c;
    Button b1;
    Label l1;
    prac_12(){
        Frame fm = new Frame();
        //fm.setTitle("196330307061");
        fm.setVisible(true);
        fm.setLayout(null);
        fm.setSize(500,500);

        c = new Choice();
        c.setBounds(250,100,80,80);
        fm.add(c);

        b1 = new Button("search");
        b1.setBounds(250,200,50,30);
        fm.add(b1);
        b1.addActionListener(this);

        l1 = new Label("Price: ");
        l1.setBounds(250,150,80,30);
        fm.add(l1);

        String query = "select * from Product;";
        ResultSet res = prac_12.executeQ(query, true);
        try{
            while(res.next()){
                c.addItem(res.getString(1));
            }
        }
        catch(Exception sqe){sqe.printStackTrace();}
        
    }

    public static void main(String[] args) {
        prac_12 obj = new prac_12();
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String pname = c.getSelectedItem();
            String query1 = "select * from Product where ProductName='"+pname+"';";
            ResultSet res1 = prac_12.executeQ(query1,true);
            try{
                while(res1.next()){
                    l1.setText("Price: "+res1.getInt(2));
                }
            }
            catch(Exception e){e.printStackTrace();}
        }
    }
}