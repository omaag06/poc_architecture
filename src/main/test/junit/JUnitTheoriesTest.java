package junit;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith(Theories.class)
public class JUnitTheoriesTest {

    @DataPoints
    public static int[] integers() {
        return new int[]{ -1, -10, -1234567,1, 10, 1234567};
    }

    @Theory
    public void primeraCondicionTest(Integer a, Integer b) {
        System.out.println("Valor de a ->"+a);
        System.out.println("Valor de b ->"+b);

        Assume.assumeTrue(a > 0 && b > 0);
        Assert.assertTrue(a + b > a);
        Assert.assertTrue(a + b > b);
    }

    @Theory
    public void adicionEsConmutativa(Integer a, Integer b) {
            Assert.assertTrue(a + b == b + a);
    }
}