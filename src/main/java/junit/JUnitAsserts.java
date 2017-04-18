package junit;

/**
 * Created by rpacheco on 15/03/2017.
 */
public class JUnitAsserts {

    public String[] compararStringArray() {

        String[] arrayEsperado = {"uno", "dos", "tres"};
        return arrayEsperado;

    }

    public String compararObjetosIguales() {

        return "uno";

    }

    public boolean compararTrue() {

        return true;

    }

    public boolean compararFalse() {

        return false;

    }

    public Object compararNull() {

        return null;

    }

    public Object compararNotNull() {

        return "Algo";

    }

    public Object compararSamePorReferencia() {

        return "Same";

    }

    public Object compararNotSamePorReferencia() {

        return "NotSame";

    }

    public Object compararPorMatchers() {

        return "1234";

    }

}
