package pe.edu.ulima.persistenciarealm;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

/**
 * Created by sodm on 11/4/2016.
 */

@RealmClass
public class Alumno extends RealmObject {
    @PrimaryKey
    private long id;
    @Required
    private String codigo;

    private String nombre;
    @Ignore
    private int numeroSesiones;

    public Alumno() {
    }

    public Alumno(long id, String codigo, String nombre, int numeroSesiones) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroSesiones = numeroSesiones;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroSesiones() {
        return numeroSesiones;
    }

    public void setNumeroSesiones(int numeroSesiones) {
        this.numeroSesiones = numeroSesiones;
    }
}
