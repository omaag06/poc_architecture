package mock;

/**
 * Created by rpacheco on 09/09/2016.
 */
public class Evaluador {

    public boolean evalua(String expresion) {
            /*
            3.- Escribir el código mínimo para que pase.
                En este punto es demasiado sencillo. Como soy muy positivo, nomás devuelvo "true"
            4.- Correr las pruebas existente.
                Corremos las pruebas y vemos que el resultado esta en verde

            Parecerá ridículo que si mi método regresa true "hardcodeado" yo diga que ya funciona, pero la verdad es que ya
            funciona para el conjunto de pruebas que tengo. Es como si dijera, "así es como la pretendo usar". Obvio, no cumple
            con todos mis expectativas, pero la idea es que no codifique nada más de lo que estoy probando, es decir, hay que
            evitar hacer suposiciones, evitar adelantar código, evitar pensar *"Y si quiero hacer esto? Y si que va a pasar
            con esto otro? etc". Si se nos ocurren más escenarios para nuestro código, lo que debemos hacer es: escribir una
            prueba PRIMERO y el código mínimo para pasar esa prueba DESPUÉS ( ¿por eso se llama dirigido por pruebas no? )*/
        //return true;



        /*Escribir el código para que pase
          Aquí viene toda la magia ( que no es mucha ) ¿Qué tengo que escribir para que mi prueba pase?
          ¿Que tan complejo debe de ser mi código? Respuesta, LO MÁS SIMPLE, POSIBLE, a veces incluso hay que exagerar.
          Entonces el código que hace que mi prueba pase es:
          */
        /*
        if( "verdadero".equals(expresion)) {
            return true;
        } else {
            return false;
        }*/



        //Test en Rojo. ¿Lo mínimo para componerlo? Quitarle los paréntesis.
        /*
        if( expresion.startsWith("(") &&  expresion.endsWith(")")){

            expresion = expresion.substring(1, expresion.length()-1);
        }
        return "verdadero".equals(expresion);
          */




        //Rojo, de nuevo. ¿Lo mínimo para que funcione? Ignorar los espacios
        /*
        expresion = expresion.trim();
        if( expresion.startsWith("(") &&  expresion.endsWith(")")){
            expresion = expresion.substring(1, expresion.length()-1).trim();

        }
        return "verdadero".equals(expresion);
        */




        //Rojo de nuevo.
        //¿Que será lo mínimo esta vez? Se me ocurre, que si tiene una "y" , entonces partir por la letra "y" y ver si las partes dan verdadero.
        /*
        expresion = expresion.trim();
        if( expresion.startsWith("(") && expresion.endsWith(")")){
            expresion = expresion.substring(1, expresion.length()-1).trim();

        }
        String[] partes = expresion.split("y");
        if( partes.length > 1 ) {
            boolean parcial = true;// todos son verdaderos hasta que se demuestre lo contrario.
            for( String parte : partes ) {
                parcial = parcial && evalua( parte  );
            }
            return parcial;
        }
        return "verdadero".equals(expresion);
        */


        /*
        expresion = expresion.trim();
        if( expresion.startsWith("(")) {
            expresion = expresion.substring(1).trim();
        }
        if( expresion.endsWith((")"))) {
            expresion = expresion.substring(0, expresion.length()-1).trim();
        }

        int indexOfY = expresion.indexOf("y");
        if( indexOfY > 0 ) {
            return evalua( expresion.substring(0,indexOfY) ) && evalua( expresion.substring(indexOfY+1));
        }
        return "verdadero".equals(expresion);
        */

        expresion = expresion.trim();
        if( expresion.startsWith("(")) {
            expresion = expresion.substring(1).trim();
        }
        if( expresion.endsWith((")"))) {
            expresion = expresion.substring(0, expresion.length()-1).trim();
        }

        int indexOfY = expresion.lastIndexOf(" y ");
        if( indexOfY > 0 ) {
            return evalua( expresion.substring(0,indexOfY) ) && evalua( expresion.substring(indexOfY+3));

        }
        int indexOfO = expresion.indexOf(" o ");
        if( indexOfO > 0 ) {
            return evalua( expresion.substring(0,indexOfO) ) || evalua( expresion.substring(indexOfO+3));

        }

        return "verdadero".equals(expresion);


    }
}
