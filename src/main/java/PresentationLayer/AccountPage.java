package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AccountPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        session.getAttribute("name");
        session.getAttribute("adress");
        session.getAttribute("phonenumber");

        User user = (User) session.getAttribute("user");

        ArrayList ordersList = LogicFacade.getOrders(user);

        session.setAttribute( "orderslist", ordersList);



        return "accountpage";
    }
}
