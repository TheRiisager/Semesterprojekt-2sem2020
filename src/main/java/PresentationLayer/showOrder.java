package PresentationLayer;

import FunctionLayer.*;

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
        System.out.println(new Pair(new Material(-1,-1,-1,-1,"error","error",-1), -1));

        System.out.println("is componentList empty? " + order.getComponentList().get(0).getKey());



        HttpSession session = request.getSession();

        session.setAttribute( "oid" , oidString );
        session.setAttribute( "width" , order.getCarportWidth() );
        session.setAttribute( "length" , order.getCarportLength() );
        session.setAttribute( "componentList", order.getComponentList() );

        return "salesorderview";
    }
}
