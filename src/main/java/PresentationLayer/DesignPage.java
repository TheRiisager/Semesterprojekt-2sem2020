package PresentationLayer;

import FunctionLayer.Drawing;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class DesignPage extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ArrayList<Integer> options = Drawing.widthLengthOptionsArray();

        HttpSession session = request.getSession();
        session.setAttribute("widthlengthoptions", options);
        return "designpage";
    }
}
