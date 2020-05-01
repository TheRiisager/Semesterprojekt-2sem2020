package FunctionLayer;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListCreatorTest {

    @Test
    public void testCreateList(){
        Order order = new Order(69,420, 480);
        assertFalse( ListCreator.createList(order).isEmpty() );
        assertFalse(ListCreator.createList(order).get(0).getKey() != null);
    }

}
