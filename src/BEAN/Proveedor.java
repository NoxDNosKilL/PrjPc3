package BEAN;

import java.util.Date;

public class Proveedor {
    private int idProveedor;
    private String razSoc;
    private String ruc;
    private String direccion;
    private int telefono;
    private int estado;
    private Date fechCrea;
    private String tipo;

    public Proveedor() {
        fechCrea = new Date();
    }

    
    public Proveedor(int idProveedor, String razSoc, String ruc, String direccion, int telefono, int estado, Date fechCrea, String tipo) {
        this();
        this.idProveedor = idProveedor;
        this.razSoc = razSoc;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.fechCrea = fechCrea;
        this.tipo = tipo;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazSoc() {
        return razSoc;
    }

    public void setRazSoc(String razSoc) {
        this.razSoc = razSoc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechCrea() {
        return fechCrea;
    }

    public void setFechCrea(Date fechCrea) {
        this.fechCrea = fechCrea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", razSoc=" + razSoc + ", ruc=" + ruc + ", direccion=" + direccion + ", telefono=" + telefono + ", estado=" + estado + ", fechCrea=" + fechCrea + ", tipo=" + tipo + '}';
    }

    public void setFechCrea(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
