package PresentationLayer;

import FunctionLayer.*;
import FunctionLayer.Drawing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class showOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String oidString = request.getParameter("oid");

        int oid = Integer.parseInt( oidString );

        Order order = LogicFacade.getOrder( oid );
        order.setComponentList();

        float totalPrice = 0;

        for(Pair p : order.getComponentList()) {
            totalPrice += p.getKey().getPrice() * p.getValue();
        }
        HttpSession session = request.getSession();

        session.setAttribute( "oid" , oidString );
        session.setAttribute( "width" , order.getCarportWidth() );
        session.setAttribute( "length" , order.getCarportLength() );
        session.setAttribute( "componentList", order.getComponentList() );
        session.setAttribute( "totalPrice" , totalPrice );
        session.setAttribute("svg" , Drawing.draw(order) );

        if (session.getAttribute("role").equals("customer") ) {
            return "userorderview";
        }

        return "salesorderview";
    }
}
