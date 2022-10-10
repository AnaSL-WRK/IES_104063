package ua.ana;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
 
public class EmbeddedJettyExample {
 
  public static void main(String[] args) throws Exception {
         
    Server server = new Server(8680);       
     
    ServletHandler servletHandler = new ServletHandler();
    server.setHandler(servletHandler);
             
    servletHandler.addServletWithMapping(JettyServlet.class, "/");
     
    server.start();
    server.join();

}
 
public static class JettyServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException 
    {
         
        String username = request.getParameter("username");      
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if(username == null){
            throw new NullPointerException("You need to pass a username as a parameter for this page to work. \n Try adding ?username=yourname at the end of the web address and reload the page!");
        }
        else{
            try{
            // Write some content
            out.println("<html>");
            out.println("<head>");
            out.println("<title>webSniplet</title>");
            out.println("</head>");
            out.println("<body>");
            
                
            out.println("<h2>Hey " + username + "!" +" Welcome to my webServlet!<h2");
            
            
            out.println("");
            out.println("");
            out.println("<h3>Here's the current time:</h3>");
            out.println("<h3>" + new Date() + "</h3>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    }
}
}