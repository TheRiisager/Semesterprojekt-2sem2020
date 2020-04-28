package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("update order initiated");

        int length = Integer.parseInt( request.getParameter("length" ) );

        int width = Integer.parseInt( request.getParameter("width" ) );

        int height = Integer.parseInt( request.getParameter("height" ) );

        System.out.println("parsing dimensions complete");

        HttpSession session = request.getSession();

        String oidString = ( String ) session.getAttribute( "oid" );

        System.out.println(oidString);

        int orderID = Integer.parseInt( oidString );

        LogicFacade.updateOrder( orderID, length, width, height );

        Order order = LogicFacade.getOrder( orderID );
        session.setAttribute( "oid" , oidString );
        session.setAttribute("width" , order.getCarportWidth() );
        session.setAttribute( "length" , order.getCarportLength() );

        return "salesorderview";
    }
}
