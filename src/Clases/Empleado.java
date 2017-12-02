package Clases;

/**
 *
 * @author alan
 */
public class Empleado {

    private String nombre;
    private String apellido;
    private String ci;
    private String turno;
    private float sueldo;

    public Empleado() {
        nombre = "";
        apellido = "";
        ci = "";
        turno = "";
        sueldo = 0.0f;
    }

    public Empleado(String nombre, String apellido, String ci, 
            String turno, float sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.turno = turno;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }        
}
