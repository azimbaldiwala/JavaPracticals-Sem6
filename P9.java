
package p9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class P9 extends Frame implements ActionListener{
     MenuBar menuBar;
     Menu file, edit;
     MenuItem saveas, save, font, color;
     TextArea display;
    P9(){
        super("P9");
        setSize(500, 500);
        setVisible(true);
        setLayout(null);
        menuBar = new MenuBar();
        setMenuBar(menuBar);
        file = new Menu("File");
        edit = new Menu("Edit");
        menuBar.add(file);
        menuBar.add(edit);
        save = new MenuItem("save");
        file.add(save);
        save.addActionListener(this);
        saveas = new MenuItem("save as");
        file.add(saveas);
        saveas.addActionListener(this);
        font = new MenuItem("font");
        edit.add(font);
        font.addActionListener(this);
        color = new MenuItem("color");
        edit.add(color);
        color.addActionListener(this);
        display = new TextArea();
        display.setBounds(100,250, 250, 100);
        add(display);
    }
    public static void main(String[] args) {
        new P9();
    }
    public void actionPerformed(ActionEvent e) {
        display.setText("Selected Item: " + e.getActionCommand());
    }
}
