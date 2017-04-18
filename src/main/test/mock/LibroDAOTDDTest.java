package mock;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by rpacheco on 08/09/2016.
 */

public class LibroDAOTDDTest {

    private static LibroDAO libroDAO;
    private static LibroBean libro1;
    private static LibroBean libro2;

    @BeforeClass
    public static void setUp() {
        //Creamos un objecto mock de LibroDAO
        libroDAO = new LibroDAO();

        //Creamos algunas instancias de LibroBean y le seteamos los valores.
        libro1 = new LibroBean("8131721019","Principios de Compilacion",
                Arrays.asList("D. Jeffrey Ulman", "Ravi Sethi", "Alfred V. Aho", "Monica S. Lam"),
                "Pearson Education Singapore Pte Ltd", 2008,1009,"BOOK_IMAGE");

        libro2 = new LibroBean("9788183331630","Java Book 13th Edition",
                Arrays.asList("Yashavant Kanetkar"),"BPB PUBLICATIONS", 2012,675,"BOOK_IMAGE");

    }

    @Test
    public void testGetTodosLosLibros() throws Exception {

        List<LibroBean> libros = libroDAO.getTodosLosLibros();
        assertEquals(2, libros.size());
        LibroBean miLibro = libros.get(0);
        assertEquals("8131721019", miLibro.getIsbn());
        assertEquals("Principios de Compilacion", miLibro.getTitulo());
        assertEquals(4, miLibro.getAutores().size());
        assertEquals((Integer)2008, miLibro.getAnhoPublicacion());
        assertEquals((Integer) 1009, miLibro.getNumeroPaginas());
        assertEquals("Pearson Education Singapore Pte Ltd", miLibro.getPublicacion());
        assertEquals("BOOK_IMAGE", miLibro.getImagen());
    }

    @Test
    public void testGetLibro(){

        String isbn = "8131721019";

        LibroBean miLibro = libroDAO.getLibro(isbn);

        assertNotNull(miLibro);
        assertEquals(isbn, miLibro.getIsbn());
        assertEquals("Principios de Compilacion", miLibro.getTitulo());
        assertEquals(4, miLibro.getAutores().size());
        assertEquals("Pearson Education Singapore Pte Ltd", miLibro.getPublicacion());
        assertEquals((Integer)2008, miLibro.getAnhoPublicacion());
        assertEquals((Integer)1009, miLibro.getNumeroPaginas());

    }

    @Test
    public void testAgregarLibro(){
        String isbn = libroDAO.agregarLibro(libro1);
        assertNotNull(isbn);
        assertEquals(libro1.getIsbn(), isbn);
    }

    @Test
    public void testActualizarLibro(){

        String isbn = libroDAO.actualizarLibro(libro1);
        assertNotNull(isbn);
        assertEquals(libro1.getIsbn(), isbn);
    }
}
