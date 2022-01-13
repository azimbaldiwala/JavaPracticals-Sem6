/* <applet code=Practical2 width=400 height=400 >
 <param name="first_val" value="Hello">
 <param name="sec_val" value="World!">
 </applet>
*/
import java.applet.*;
import java.awt.*;

public class Practical2 extends Applet {
    public void paint(Graphics g)
    {
        String firstVal = this.getParameter("first_val");
        String secVal = this.getParameter("sec_val");
        
        g.drawString(firstVal, 50, 50);
        g.drawString(secVal, 100, 50);

    }
}
