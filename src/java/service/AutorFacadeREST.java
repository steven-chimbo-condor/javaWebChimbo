/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Modelo.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author usuario
 */
@Stateless
@Path("modelo.autor")
public class AutorFacadeREST extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "BibliotecaPU")
    private EntityManager em;

    public AutorFacadeREST() {
        super(Autor.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Autor entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Autor entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Autor find(@PathParam("id") Integer id) {
        return super.find(id);
    }
//este es el get 
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> findAll() {
        return super.findAll();
    }
    //el post que creamos 0
    @POST
    @Path("post")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> obtnerTodos(){
        return super.findAll();
    }
    //creo nuevo post 8/02/2020 nuevo metodo post
    @POST
    @Path("OBTENERAUTOR")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Autor ObtenerAutor(@FormParam("idUser") Integer idU){
        return super.find(idU);
    }
    //metodo para crear un usuario, creando un objeto de autor
    @POST
    @Path("Crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String CrearAutorNuevo(@FormParam("id_autor") Integer idA ,@FormParam("nombre_autor")String n_a){
        Autor a= new Autor();
        a.setIdAutor(idA);
        a.setNombreAutor(n_a);
        super.create(a);
        return "Crear";
    }
    //metodo pra editar un autor
    @POST
    @Path("Editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String EditarAutor(@PathParam("id_autor") Integer id, @PathParam("nombre_autor") String n_a ){
        Autor a ;
        a=super.find(id);
        a.setIdAutor(id);
        a.setNombreAutor(n_a);
        
        super.edit(a);
        return "Editar";
    }
    
    @POST
    @Path("Eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String EliminarAutor(@PathParam("id_autor") Integer id, @PathParam("nombre_autor") String n_a ){
        Autor a= new Autor();
        a.setIdAutor(id);
        a.setNombreAutor(n_a);
        a=super.find(a);
        super.remove(a);
        return "Editar";
    }
    

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Autor> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
