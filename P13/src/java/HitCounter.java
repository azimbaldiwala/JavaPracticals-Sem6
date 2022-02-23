

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "HitCounter", urlPatterns = {"/HitCounter"}, initParams = {
    @WebInitParam(name = "counter", value = "0")})
public class HitCounter extends HttpServlet {

    int counter;
    public void init(ServletConfig sc){
         counter = Integer.parseInt(sc.getInitParameter("counter"));
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
           counter += 1;
           out.println("<h1>Hit Count:" + counter +" </h1>");
            
        } finally {            
            out.close();
        }
    }
}
