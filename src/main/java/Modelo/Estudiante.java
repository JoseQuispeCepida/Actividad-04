package Modelo;

import java.util.Date;

public class Estudiante {
    
    private String Codigo;
    private String Nombre;
    private Date FechaNacimiento;
    private String Direccion;
    private int Telefono;
    
    public void Estudiante(){      
    }    

    public Estudiante(String Codigo, String Nombre, Date FechaNacimiento, String Direccion, int Telefono) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "Codigo=" + Codigo + ", Nombre=" + Nombre + ", FechaNacimiento=" + FechaNacimiento + ", Direccion=" + Direccion + ", Telefono=" + Telefono + '}';
    }
    
}
