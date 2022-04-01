//Practical11

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class prac_11 extends Frame implements ActionListener{
    static String Driver = "com.mysql.jdbc.Driver";
    static String dbUrl = "jdbc:mysql://localhost/javadatabase";
    static String username = "root";
    static String password = ""; 

    TextField tf0,tf1,tf2,tf3;
    Button bi,bs,bd,bu;
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox c1,c2;
    static Label l5;
    public prac_11(){
        Frame fm = new Frame();
        fm.setVisible(true);
        fm.setSize(500,500);
        fm.setLayout(null);
        fm.setTitle("196330307106");
       
        
        Label l0 = new Label("Sid:");
        l0.setBounds(100,50,70,20);
        fm.add(l0);

        tf0 = new TextField();
        tf0.setBounds(180,50,100,20);
        fm.add(tf0);
        
        Label l1 = new Label("FirstName:");
        l1.setBounds(100,100,70,20);
        fm.add(l1);

        tf1 = new TextField();
        tf1.setBounds(180,100,100,20);
        fm.add(tf1);

        Label l2 = new Label("LastName:");
        l2.setBounds(100,150,70,20);
        fm.add(l2);

        tf2 = new TextField();
        tf2.setBounds(180,150,100,20);
        fm.add(tf2);

        Label l3 = new Label("Password:");
        l3.setBounds(100,200,70,20);
        fm.add(l3);

        tf3 = new TextField();
        tf3.setBounds(180,200,100,20);
        tf3.setEchoChar('*');
        fm.add(tf3);

        Label l4 = new Label("Gender:");
        l4.setBounds(100,250,70,20);
        fm.add(l4);

        c1 = new Checkbox("Male",cbg,true);
        c1.setBounds(180,246,50,30);
        fm.add(c1);

        c2 = new Checkbox("Female",cbg,false);
        c2.setBounds(230,246,60,30);
        fm.add(c2);

        bi = new Button("Insert");
        bi.setBounds(100,300,80,20);
        fm.add(bi);

        bu = new Button("Update");
        bu.setBounds(190,300,80,20);
        fm.add(bu);

        bd = new Button("Delete");
        bd.setBounds(280,300,80,20);
        fm.add(bd);

        bs = new Button("Search");
        bs.setBounds(370,300,80,20);
        fm.add(bs);

        l5 = new Label("");
        l5.setBounds(100,350,150,20);
        fm.add(l5);

        bi.addActionListener(this);
        bs.addActionListener(this);
        bu.addActionListener(this);
        bd.addActionListener(this);
    }

    public static void main(String[] args) {
        new prac_11();
    }

    public static ResultSet executeQ(String query,Boolean result){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            Class.forName(Driver);
            //System.out.println("Connecting Database...");
            conn = DriverManager.getConnection(dbUrl,username,password);
            //System.out.println("Database Connected!!");
            stmt = conn.createStatement();
            if(result){
                rs = stmt.executeQuery(query);
                //System.out.println("ResultSet Returned!!");
                return rs;
            }
            else{
                stmt.executeUpdate(query);
                System.out.println("Query Executed!!");
            }

        }
        catch(Exception se){
            l5.setText("Sid already exists!");
            //System.out.println("Sid already Exists!!");
        }
        try{conn=null;}
        catch(Exception e){e.printStackTrace();}
        try{stmt=null;}
        catch(Exception e){e.printStackTrace();}

        return rs;
    }

    public void actionPerformed(ActionEvent ae){
        String sid = tf0.getText();
        String fname = tf1.getText();
        String lname = tf2.getText();
        String pass = tf3.getText();
        String gender="";
        if(c1.getState()){
            gender = c1.getLabel();
        }
        else if(c2.getState()){
            gender = c2.getLabel();
        }
        if(ae.getSource()==bi){
            l5.setText("Registered Successfully!");
            String query = "insert into student values('"+sid+"','"+fname+"','"+lname+"','"+gender+"','"+pass+"');";
            prac_12.executeQ(query, false);
        }
        else if(ae.getSource()==bs){
            String query1 = "select * from student where Sid = '"+sid+"';";
            ResultSet rs1 = prac_12.executeQ(query1, true);
            try{
                while(rs1.next()){
                    tf1.setText(rs1.getString("fname"));
                    tf2.setText(rs1.getString("lname"));
                    tf3.setText(rs1.getString("password"));
                    String gen = rs1.getString("gender");
                    if(gen.equals("Male")){
                        cbg.setSelectedCheckbox(c1);
                    }
                    else if(gen.equals("Female")){
                        cbg.setSelectedCheckbox(c2);
                    }    
                }
	l5.setText("Searched Successfully!");
            }
            catch(SQLException se){se.printStackTrace();}
        }
        else if(ae.getSource()==bu){
            String queryU = "UPDATE student set fname='"+fname+"',lname='"+lname+"',gender='"+gender+"' where Sid='"+sid+"';";
            prac_12.executeQ(queryU, false);
            l5.setText("Updated Successfully!");
        }
        else if(ae.getSource()==bd){
            String queryD = "delete from student where Sid='"+sid+"';";
            prac_12.executeQ(queryD, false);
            l5.setText("Deleted Successfully!");
        }
    }
}