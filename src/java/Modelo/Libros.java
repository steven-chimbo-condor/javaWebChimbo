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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "libros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l")
    , @NamedQuery(name = "Libros.findByIdLibros", query = "SELECT l FROM Libros l WHERE l.idLibros = :idLibros")
    , @NamedQuery(name = "Libros.findByCodigoLibro", query = "SELECT l FROM Libros l WHERE l.codigoLibro = :codigoLibro")
    , @NamedQuery(name = "Libros.findByNombreLibro", query = "SELECT l FROM Libros l WHERE l.nombreLibro = :nombreLibro")
    , @NamedQuery(name = "Libros.findByPrestado", query = "SELECT l FROM Libros l WHERE l.prestado = :prestado")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_libros")
    private Integer idLibros;
    @Column(name = "codigo_libro")
    private Integer codigoLibro;
    @Size(max = 45)
    @Column(name = "nombre_libro")
    private String nombreLibro;
    @Column(name = "prestado")
    private Boolean prestado;
    @JoinColumn(name = "autor_id_autor", referencedColumnName = "id_autor")
    @ManyToOne(optional = false)
    private Autor autorIdAutor;
    @JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false)
    private Categoria categoriaIdCategoria;
    @JoinColumn(name = "editorial_id_editorial", referencedColumnName = "id_editorial")
    @ManyToOne(optional = false)
    private Editorial editorialIdEditorial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "librosIdLibros")
    private Collection<Prestamos> prestamosCollection;

    public Libros() {
    }

    public Libros(Integer idLibros) {
        this.idLibros = idLibros;
    }

    public Integer getIdLibros() {
        return idLibros;
    }

    public void setIdLibros(Integer idLibros) {
        this.idLibros = idLibros;
    }

    public Integer getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(Integer codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public Autor getAutorIdAutor() {
        return autorIdAutor;
    }

    public void setAutorIdAutor(Autor autorIdAutor) {
        this.autorIdAutor = autorIdAutor;
    }

    public Categoria getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(Categoria categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public Editorial getEditorialIdEditorial() {
        return editorialIdEditorial;
    }

    public void setEditorialIdEditorial(Editorial editorialIdEditorial) {
        this.editorialIdEditorial = editorialIdEditorial;
    }

    @XmlTransient
    public Collection<Prestamos> getPrestamosCollection() {
        return prestamosCollection;
    }

    public void setPrestamosCollection(Collection<Prestamos> prestamosCollection) {
        this.prestamosCollection = prestamosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLibros != null ? idLibros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libros)) {
            return false;
        }
        Libros other = (Libros) object;
        if ((this.idLibros == null && other.idLibros != null) || (this.idLibros != null && !this.idLibros.equals(other.idLibros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Libros[ idLibros=" + idLibros + " ]";
    }
    
}
