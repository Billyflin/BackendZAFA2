package model;

public class Usuario {
    private String id;
    private String rut;
    private String nombre;
    private String apellido;
    private String correo;
    private String numero;

    public Usuario(String id, String rut, String nombre, String apellido, String correo, String numero) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numero = numero;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

}
