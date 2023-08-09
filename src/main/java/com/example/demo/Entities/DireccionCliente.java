package com.example.demo.Entities;

import java.io.Serializable;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Mauri
 */
@Entity
@Table(name = "direccion_cliente")
@NamedQueries({
        @NamedQuery(name = "DireccionCliente.findAll", query = "SELECT d FROM DireccionCliente d"),
        @NamedQuery(name = "DireccionCliente.findById", query = "SELECT d FROM DireccionCliente d WHERE d.id = :id"),
        @NamedQuery(name = "DireccionCliente.findByProvincia", query = "SELECT d FROM DireccionCliente d WHERE d.provincia = :provincia"),
        @NamedQuery(name = "DireccionCliente.findByCiudad", query = "SELECT d FROM DireccionCliente d WHERE d.ciudad = :ciudad"),
        @NamedQuery(name = "DireccionCliente.findByClient", query = "SELECT d FROM DireccionCliente d WHERE d.idCliente = :idCliente"),
        @NamedQuery(name = "DireccionCliente.findByDireccionMatriz", query = "SELECT d FROM DireccionCliente d WHERE d.idCliente = :idCliente and d.matriz = :matriz"),
        @NamedQuery(name = "DireccionCliente.findByDireccion", query = "SELECT d FROM DireccionCliente d WHERE d.direccion = :direccion"),
        @NamedQuery(name = "DireccionCliente.findByMatriz", query = "SELECT d FROM DireccionCliente d WHERE d.matriz = :matriz") })
public class DireccionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "provincia")
    private String provincia;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "matriz")
    private Boolean matriz;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes idCliente;

    public DireccionCliente() {
    }

    public DireccionCliente(Integer id) {
        this.id = id;
    }

    public DireccionCliente(Integer id, String provincia, String ciudad, String direccion) {
        this.id = id;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public DireccionCliente(Integer id, String provincia, String ciudad, String direccion, Boolean matriz) {
        this.id = id;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.matriz = matriz;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getMatriz() {
        return matriz;
    }

    public void setMatriz(Boolean matriz) {
        this.matriz = matriz;
    }

    public Clientes getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Clientes idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DireccionCliente)) {
            return false;
        }
        DireccionCliente other = (DireccionCliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + id;
    }

}
