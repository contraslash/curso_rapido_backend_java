import java.util.List;

public interface Dao<T> {

    List<T> todos();

    void crear(T t);

    void actualizar(T t, String[] params);

    void eliminar(T t);
}