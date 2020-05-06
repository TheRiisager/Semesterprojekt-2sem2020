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
        commands.put( "salesOrderView", new showOrder() );
        commands.put( "designpage", new DesignPage() );
        commands.put( "UpdateOrder", new UpdateOrder() );
        commands.put( "savedesign", new SaveDesign() );
        commands.put( "UpdateUser", new UpdateUser());
        commands.put( "drawing", new drawingOLD() );

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
