package com.example.demo.Entities;

import java.io.Serializable;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.NamedQueries;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author Mauri
 */

@Entity
@Table(name = "clientes")
@NamedQueries({
        @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
        @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id"),
        @NamedQuery(name = "Clientes.findByCorreo", query = "SELECT c FROM Clientes c WHERE c.correo = :correo"),
        @NamedQuery(name = "Clientes.findByNombres", query = "SELECT c FROM Clientes c WHERE c.nombres = :nombres"),
        @NamedQuery(name = "Clientes.findByNumeroCelular", query = "SELECT c FROM Clientes c WHERE c.numeroCelular = :numeroCelular"),
        @NamedQuery(name = "Clientes.findByNumeroId", query = "SELECT c FROM Clientes c WHERE c.numeroId = :numeroId"),
        @NamedQuery(name = "Clientes.findByTipoId", query = "SELECT c FROM Clientes c WHERE c.tipoId = :tipoId") })
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @Column(name = "numero_celular")
    private String numeroCelular;
    @Basic(optional = false)
    @Column(name = "numero_id")
    private String numeroId;
    @Basic(optional = false)
    @Column(name = "tipo_id")
    private String tipoId;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<DireccionCliente> direccionClienteCollection;

    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, String correo, String nombres, String numeroCelular, String numeroId, String tipoId) {
        this.id = id;
        this.correo = correo;
        this.nombres = nombres;
        this.numeroCelular = numeroCelular;
        this.numeroId = numeroId;
        this.tipoId = tipoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getNumeroId() {
        return numeroId;
    }

    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public Collection<DireccionCliente> getDireccionClienteCollection() {
        return direccionClienteCollection;
    }

    public void setDireccionClienteCollection(Collection<DireccionCliente> direccionClienteCollection) {
        this.direccionClienteCollection = direccionClienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " " + id + " " + correo + " " + nombres + " " + numeroId + " " + tipoId + " "
                + direccionClienteCollection;
    }

}
