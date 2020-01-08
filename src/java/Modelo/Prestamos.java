/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "prestamos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamos.findAll", query = "SELECT p FROM Prestamos p")
    , @NamedQuery(name = "Prestamos.findByIdPrestamos", query = "SELECT p FROM Prestamos p WHERE p.idPrestamos = :idPrestamos")
    , @NamedQuery(name = "Prestamos.findByFechaPrestamo", query = "SELECT p FROM Prestamos p WHERE p.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "Prestamos.findByDevuelto", query = "SELECT p FROM Prestamos p WHERE p.devuelto = :devuelto")
    , @NamedQuery(name = "Prestamos.findByFechaDevolucion", query = "SELECT p FROM Prestamos p WHERE p.fechaDevolucion = :fechaDevolucion")})
public class Prestamos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamos")
    private Integer idPrestamos;
    @Column(name = "fecha_prestamo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Column(name = "devuelto")
    private Boolean devuelto;
    @Column(name = "fecha_devolucion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDevolucion;
    @JoinColumn(name = "libros_id_libros", referencedColumnName = "id_libros")
    @ManyToOne(optional = false)
    private Libros librosIdLibros;
    @JoinColumn(name = "persona_id_persona", referencedColumnName = "id_persona")
    @ManyToOne(optional = false)
    private Persona personaIdPersona;

    public Prestamos() {
    }

    public Prestamos(Integer idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public Integer getIdPrestamos() {
        return idPrestamos;
    }

    public void setIdPrestamos(Integer idPrestamos) {
        this.idPrestamos = idPrestamos;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libros getLibrosIdLibros() {
        return librosIdLibros;
    }

    public void setLibrosIdLibros(Libros librosIdLibros) {
        this.librosIdLibros = librosIdLibros;
    }

    public Persona getPersonaIdPersona() {
        return personaIdPersona;
    }

    public void setPersonaIdPersona(Persona personaIdPersona) {
        this.personaIdPersona = personaIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamos != null ? idPrestamos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamos)) {
            return false;
        }
        Prestamos other = (Prestamos) object;
        if ((this.idPrestamos == null && other.idPrestamos != null) || (this.idPrestamos != null && !this.idPrestamos.equals(other.idPrestamos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Prestamos[ idPrestamos=" + idPrestamos + " ]";
    }
    
}
