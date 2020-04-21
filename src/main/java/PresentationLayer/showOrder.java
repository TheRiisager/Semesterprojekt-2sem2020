package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class showOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String oidString = request.getParameter("oid");

        int oid = Integer.parseInt( oidString );

        HttpSession session = request.getSession();

        session.setAttribute("oid",oidString);

        return "salesorderview";
    }
}
