package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SaveDesign extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        Order order = new Order(width, length);


        HttpSession session = request.getSession();

        if( session.getAttribute("user") == null ){
            request.setAttribute("nousererror" , "Du ser ikke ud til at være logget ind!");
            request.setAttribute("nousererror2" , "Login eller opret en bruger for at bruge designeren.");
            return "index";
        }

        User user = (User) session.getAttribute("user");




        order.setUserID(user.getId());

        LogicFacade.createOrder(order);

        return user.getRole() + "page";
    }
}
