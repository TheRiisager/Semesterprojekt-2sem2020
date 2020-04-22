package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String name = request.getParameter("name");
        String phoneNumber = request.getParameter("phonenumber");
        String address = request.getParameter("address");

       if ( password1.equals( password2 ) ) {
            User user = LogicFacade.createUser( name, phoneNumber, email, address, password1);
            HttpSession session = request.getSession();

           session.setAttribute( "user", user );
           session.setAttribute( "role", user.getRole() );
           session.setAttribute("email", email);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
           session.setAttribute("name", user.getName() );
           session.setAttribute("phonenumber", user.getPhoneNumber());
           session.setAttribute("address", user.getAddress());

            return user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}
