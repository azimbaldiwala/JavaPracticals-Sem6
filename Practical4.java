// <applet code=Practical4 width=500 height=500></applet>

import java.awt.*;
import java.applet.*;
import java.awt.event.*;

import javafx.scene.control.Label;


public class Practical4 extends Applet implements MouseMotionListener{
    
    int mouseX = 0, mouseY = 0;
    String show_;
    Label x;

    public void init()
    {
        addMouseMotionListener(this);
    }
    
    public void mouseClicked(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public void mouseMoved(MouseEvent e){
        mouseX =  e.getX();
        mouseY = e.getX();
        show_ = "Mouse Moved: ";
       
        repaint();
    }

    public void mouseDragged(MouseEvent e)
    {
        mouseX = e.getX();
        mouseY = e.getY();
        show_ = "Mouse Dragged: ";
        
        repaint();
    }

    public void paint(Graphics g)
    {
        g.fillRect(mouseX, mouseY, 10, 10);
        x.setText(show_ + mouseX + ", " + mouseY);
    
    }
}
