import parser.AbstractParser;
import parser.ManagerParser;
import parser.XML_STYLE;
import pattern.builder.Director;
import pattern.composite.Item;
import pattern.composite.Product;
import pattern.visitor.Visitor;
import pattern.visitor.VisitorCreatesList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/LoadDataServlet")
public class LoadDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("fileName");

        if(fileName != null) {
            AbstractParser parser = (AbstractParser) ManagerParser.manage(fileName, XML_STYLE.STAX);
            try {
                Item store = parser.itemReturn("/"+fileName);
                VisitorCreatesList v = new VisitorCreatesList();
                store.accept(v);
                List<Product> products = v.getList();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/admin/table.jsp").forward(req, resp);

            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("error", "No such file.");
                req.getRequestDispatcher("/admin/error.jsp").forward(req, resp);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);

    }
}
