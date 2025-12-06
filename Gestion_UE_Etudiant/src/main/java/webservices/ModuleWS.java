package webservices;


import entities.Module;
import entities.UniteEnseignement;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/module")
public  class ModuleWS {
    static ModuleBusiness helper = new ModuleBusiness();
   @Path("/listm")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.status(200).entity(helper.getAllModules()).build();
    }

    @Path("/addm")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addm(Module m) {
        if(helper.addModule(m)==true){
            return Response.status(201).entity("object added").build();
        }
        else{
            return Response.status(400).entity("object not added").build();
        }
    }

    @Path("/deletem/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("matricule")  String matricule) {
       if(helper.deleteModule(matricule)==true){
           return Response.status(200).entity("object deleted").build();
       }
       else{
            return Response.status(400).entity("object not deleted").build();
       }
    }

    @Path("/updatem/{matricule}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateUE(@PathParam("matricule") String matricule, Module m) {
        if (helper.updateModule(matricule,m)==true){
            return Response.status(202).entity("object updated").build();
        }
        else{
            return Response.status(400).entity("object not updated").build();
        }
    }

}
