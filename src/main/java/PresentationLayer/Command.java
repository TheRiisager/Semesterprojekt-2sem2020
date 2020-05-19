package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "loadOrders", new LoadOrders() );
        commands.put( "showOrder", new showOrder() );
        commands.put( "designpage", new DesignPage() );
        commands.put( "UpdateOrder", new UpdateOrder() );
        commands.put( "savedesign", new SaveDesign() );
        commands.put( "updateuser", new UpdateUser());
        commands.put( "accountpage", new AccountPage() );
        commands.put( "updateuserinfo", new UpdateUserInfo() );
        commands.put( "home", new Home() );
        commands.put( "logout", new LogOut() );

    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException;

}
