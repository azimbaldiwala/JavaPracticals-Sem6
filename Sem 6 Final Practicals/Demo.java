//<applet code="Demo" width="500" height="300"></applet>
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Demo extends Applet implements ActionListener{
    TextField tf;
    Button b;
    Label l;
    public void init(){
        tf = new TextField();
        add(tf);
        b = new Button("Reverse");
        add(b);
        b.addActionListener(this);
        l = new Label("ans: ");
        add(l);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b){
            String value = tf.getText().toString();
            StringBuffer str = new StringBuffer(value);
            str.reverse();
            l.setText(str.toString());
        }
    }
}
