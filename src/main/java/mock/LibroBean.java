package mock;

import java.util.List;

/**
 * Created by rpacheco on 05/09/2016.
 */
public class LibroBean {
    private String isbn;
    private String titulo;
    private List<String> autores;
    private String publicacion;
    private Integer anhoPublicacion;
    private Integer numeroPaginas;
    private String imagen;

    public LibroBean(String isbn,
                     String titulo,
                     List<String> autores,
                     String publicacion,
                     Integer anhoPublicacion,
                     Integer numeroPaginas,
                     String imagen){

        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = autores;
        this.publicacion = publicacion;
        this.anhoPublicacion = anhoPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.imagen = imagen;

    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public Integer getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getImagen() {
        return imagen;
    }

}
