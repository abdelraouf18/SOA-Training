package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response; //JAX-RS

@Path("/hello")
public class Hellows {
    //ws 1=>API: Return a hello msg
    @Path("/hi")//URL for the web service
    @GET//http method
    @Produces(MediaType.TEXT_PLAIN)//data type
    public Response sayHi(){
        return Response.status(200).entity("Hello There").build();
    }
}
