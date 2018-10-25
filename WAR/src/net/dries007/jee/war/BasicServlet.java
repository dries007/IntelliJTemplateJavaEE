package net.dries007.jee.war;

import net.dries007.jee.interfaces.IStatelessBeanRemote;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dries007
 */
public class BasicServlet extends HttpServlet
{
    @EJB
    private IStatelessBeanRemote statelessBeanRemote;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        req.setAttribute("random_number", statelessBeanRemote.getRandomNumber());
        req.setAttribute("cats", statelessBeanRemote.getCatsOwnedBy(1));

        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        view.forward(req, resp);
    }
}
