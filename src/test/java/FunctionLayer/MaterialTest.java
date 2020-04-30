package FunctionLayer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MaterialTest {

    @Before
    public void setup() {
        Material.InitMaterials();

    }

    @Test
    public void testSetupOk() {
        assertNotNull(Material.materialList);
        assertFalse(Material.materialList.isEmpty());
        assertTrue(Material.materialList.get(0) instanceof Material);
        assertTrue(Material.materialList.get(2) instanceof Material);
        assertTrue(Material.materialList.get(4) instanceof Material);
    }

}
