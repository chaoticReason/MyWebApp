import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String user=request.getParameter("username");
        String pass=request.getParameter("password");

        //not for multithreading now
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8", "root", "root");
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("SELECT * FROM user WHERE nickname='" + user + "' AND password='" + pass + "'");
            if (rs.next()) {
                //get the old session and invalidate
                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }
                //generate a new session
                HttpSession newSession = request.getSession(true);

                //setting session to expiry in 5 mins
                newSession.setMaxInactiveInterval(5*60);

                //setting session user
                newSession.setAttribute("user", user);

                Cookie message = new Cookie("message", "Welcome");
                response.addCookie(message);
                response.sendRedirect("admin/table.jsp");
            } else {
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
                PrintWriter out = response.getWriter();
                out.println("<font color=red>Either user or password wrong..</font>");
                rd.include(request, response);
            }
        }catch(SQLException e){
            e.printStackTrace();
            request.setAttribute("error", "SQL error");
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
            request.setAttribute("error", "MySQL Driver error");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

}
}
