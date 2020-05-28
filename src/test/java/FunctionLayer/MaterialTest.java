package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

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

    @Test
    public void testMaterial(){
        Material test = new Material(1, 1, 2, 3, "testType", "testName", 99);

        assertEquals(test.getMaterialID(), 1);
        assertEquals(test.getWidth(), 1);
        assertEquals(test.getLength(), 2);
        assertEquals(test.getHeight(), 3);
        assertEquals(test.getType(), "testType");
        assertEquals(test.getName(), "testName");
        assertEquals(test.getPrice(), 99);

    }

    @Test
    public void testComparable(){
        Material mat1 = new Material(1 , 5 , 100 , 5, "test" , "test01", 69 );
        Material mat2 = new Material(1 , 5 , 200 , 5, "test" , "test02", 69 );

        ArrayList<Material> testList = new ArrayList<>();
        testList.add(mat1);
        testList.add(mat2);

        Collections.sort(testList);

        assertEquals( testList.get(0) , mat2 );
        assertEquals( testList.get(1) , mat1 );
    }

}
