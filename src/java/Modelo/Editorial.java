/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "editorial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editorial.findAll", query = "SELECT e FROM Editorial e")
    , @NamedQuery(name = "Editorial.findByIdEditorial", query = "SELECT e FROM Editorial e WHERE e.idEditorial = :idEditorial")
    , @NamedQuery(name = "Editorial.findByNombreEditorial", query = "SELECT e FROM Editorial e WHERE e.nombreEditorial = :nombreEditorial")})
public class Editorial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_editorial")
    private Integer idEditorial;
    @Size(max = 45)
    @Column(name = "nombre_editorial")
    private String nombreEditorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "editorialIdEditorial")
    private Collection<Libros> librosCollection;

    public Editorial() {
    }

    public Editorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public Integer getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Integer idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    @XmlTransient
    public Collection<Libros> getLibrosCollection() {
        return librosCollection;
    }

    public void setLibrosCollection(Collection<Libros> librosCollection) {
        this.librosCollection = librosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEditorial != null ? idEditorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editorial)) {
            return false;
        }
        Editorial other = (Editorial) object;
        if ((this.idEditorial == null && other.idEditorial != null) || (this.idEditorial != null && !this.idEditorial.equals(other.idEditorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Editorial[ idEditorial=" + idEditorial + " ]";
    }
    
}
