package mock;

import java.util.Collections;
import java.util.List;

/**
 * Created by rpacheco on 05/09/2016.
 */
public class LibroDAO {

    private static LibroDAO libroDAO = new LibroDAO();

    public List<LibroBean> getTodosLosLibros(){
        return Collections.EMPTY_LIST;
    }

    public LibroBean getLibro(String isbn){
        return null;
    }

    public String agregarLibro(LibroBean libro){
        return libro.getIsbn();
    }

    public String actualizarLibro(LibroBean libro){
        return libro.getIsbn();
    }

    public static LibroDAO getInstance(){
        return libroDAO;
    }
}
