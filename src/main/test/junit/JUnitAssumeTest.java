package junit;

import org.junit.Test;

import static org.junit.Assume.*;
import static org.junit.Assert.*;

/**
 * Created by Administrador on 31/03/2017.
 */
public class JUnitAssumeTest {

    @Test
    public void testAssumeTrue() {

        boolean esCierto = false;

        int num1 = 3;
        int num2 = 7;

        int resultado = num1 + num2;

        if (resultado == 9) {
            esCierto = true;
        }

        assumeFalse(esCierto);
        assertTrue(esCierto);
    }
}
