package junit;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rpacheco on 30/03/2017.
 */
public class JUnitMatcherAsserts {

    public String contieneAmbosStrings(){
        return "ambos";
    }

    public String[] contieneEstosItems() {
        String[] arreglo = {"uno", "dos", "tres"};
        return arreglo;
    }

    public String[] contieneCadaItemEsteString() {
        String[] arreglo = { "con", "sin", "fan" };
        return arreglo;
    }

}
