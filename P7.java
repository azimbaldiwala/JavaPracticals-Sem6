import java.awt.*;
import java.awt.event.*;

public class P7 extends Frame implements ActionListener{
    public P7(){
        Button btn = new Button("Hello World");
        add(btn);
        setSize(500,300);
        setTitle("P7");
        setLayout(new FlowLayout());
        setVisible(true);
        setBackground(Color.red);
        btn.addActionListener(this);
    }
    public static void main(String[] args) {
       new P7();
    }

    public void actionPerformed(ActionEvent e) {
        if(getBackground() == Color.red){
            setBackground(Color.green);
            return;
        }
        if(getBackground() == Color.green){
            setBackground(Color.blue);
            return;
        }
        if(getBackground() == Color.blue){
            setBackground(Color.red);
            return;
        }   
    }
}