package mock;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by rpacheco on 09/09/2016.
 */
public class EvaluadorTest {

    private static EvaluadorDAO mockedEvaluadorDAO;
    Evaluador evaluador = new Evaluador();

    @BeforeClass
    public static void setUp() {
        //Creamos un objecto mock de EvaluadorDAO
        mockedEvaluadorDAO = mock(EvaluadorDAO.class);

        //Simulamos los metodos del mock LibroDAO con data "burlada".
        when(mockedEvaluadorDAO.getVerdaderoOVerdadero()).thenReturn("verdadero o verdadero");
        when(mockedEvaluadorDAO.getFalsoOVerdadero()).thenReturn("falso o verdadero");
    }

    @Test
    /*1.- Agregamos la primera prueba
     2.- Vemos que falle.

    Un momento, creo que eso fue demasiado breve. Ni siquiera compila, por que aún no existe la clase EvaluadorBoleano
    pero aquí hay algo importante; al crear la prueba, voy a describir como quiero que se llame mi clase, como es que va a ser
    usada y que métodos va a tener, que parámetros y esto ¡mientras la pruebo!. Es algo extremo ya sé, no en vano el TDD forma parte
    de la metodología de programación extrema ( XP ). Si cambiamos de opinión en el futuro ( más bien, si las pruebas nos hacen
    cambiar de opinión ) podemos sin mucho temor, cambiar alguna firma o método y luego volver a correr las pruebas y podemos ver
    que es lo que se rompe. Aún así, por el momento podemos decir que ejecutamos bien el paso 2.
     */
    public void testTrue() {

        assertTrue(evaluador.evalua("verdadero"));
    }

    //Así que vamos a la segunda prueba ¿Cual podría ser?, Pos claaaro!!!, probar con "falso" no?
    @Test
    public void testFalse() {
        assertFalse(evaluador.evalua("falso"));
    }


    /*Parece ridículo a esta altura pero estas son las bases de TDD.
    Repetir
    Entonces. Tenemos que el ciclo es este:

        test -> falla -> fix -> verde -> refactoring -> repetir

    Vamos a poner más código.
    Mi siguiente prueba, será parentesis:
    */

    @Test
    public void testParentesis() {
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua("(verdadero)"));
        assertFalse(evaluador.evalua("(false)"));
    }

    //Se me ocurre validar también los espacios en blanco. Agrego otro test:
    @Test
    public void testEspacios() {
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua(" verdadero  "));
        assertFalse(evaluador.evalua(" falso    "));
        assertTrue(evaluador.evalua(" ( verdadero   )     "));
        assertFalse(evaluador.evalua(" ( falso   )     "));
    }


    //Por que no probamos con el operador "y"
    @Test
    public void testOperadorY() {
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua("verdadero y verdadero"));
        assertFalse(evaluador.evalua("verdadero y falso"));
    }

    //Seguimos. ¿Cual podría ser mi siguiente prueba? Podría ser probar usando paréntesis:
    @Test
    public void testOperadorYConParentesis() {
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua("(verdadero ) y verdadero"));
        assertFalse(evaluador.evalua("( falso ) y verdadero"));
        assertTrue(evaluador.evalua("(verdadero ) y ( verdadero )"));
        assertFalse(evaluador.evalua("(verdadero ) y ( falso )"));
    }


    //Ya podemos seguir con el "o" ( or lógico )
    @Test
    public void testOperadorO(){
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua("verdadero o verdadero"));
        assertTrue(evaluador.evalua("falso o verdadero"));
    }

    //Y ahora usando mockito:
    @Test
    public void testMockOperadorO(){
        Evaluador evaluador = new Evaluador();
        assertTrue(evaluador.evalua(mockedEvaluadorDAO.getVerdaderoOVerdadero()));
        assertTrue(evaluador.evalua(mockedEvaluadorDAO.getFalsoOVerdadero()));
    }
}
