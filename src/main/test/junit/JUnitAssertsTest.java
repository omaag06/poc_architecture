package junit;

import org.hamcrest.CoreMatchers;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

import static org.junit.Assert.*;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JUnitAssertsTest {

    JUnitAsserts jUnitAsserts;

    @Before
    public void setUp() throws Exception {
        jUnitAsserts =  new JUnitAsserts();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testCompararStringArray() throws Exception {

        String[] arrayPrueba   = {"uno", "dos", "tres"};
        assertArrayEquals("Error - No son iguales los arreglos!!",jUnitAsserts.compararStringArray(), arrayPrueba);

    }

    @Test
    public void testCompararObjetosIguales() throws Exception {

        Assert.assertEquals(jUnitAsserts.compararObjetosIguales(), "uno");

    }

    @Test
    public void testCompararTrue() throws Exception {

        Assert.assertTrue(jUnitAsserts.compararTrue());

    }

    @Test
    public void testCompararFalse() throws Exception {

        Assert.assertFalse(jUnitAsserts.compararFalse());

    }

    @Test
    public void testCompararNull() throws Exception {

        Assert.assertNull(jUnitAsserts.compararNull());

    }

    @Test
    public void testCompararNotNull() throws Exception {

        Assert.assertNotNull(jUnitAsserts.compararNotNull());

    }

    @Test
    public void testCompararSamePorReferencia() throws Exception {

        Assert.assertSame(jUnitAsserts.compararSamePorReferencia(), "Same");

    }

    @Test
    public void testCompararNotSamePorReferencia() throws Exception {

        Assert.assertNotSame(jUnitAsserts.compararNotSamePorReferencia(), "Same");

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void empty() {
        new ArrayList<Object>().get(0);
    }
}