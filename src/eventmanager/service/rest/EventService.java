/**
 * 
 */
package eventmanager.service.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import eventmanager.entity.Event;
import eventmanager.service.redis.RedisService;

/**
 * @author JLHERMIT
 * 
 *
   {
	  "id": 2,
	  "nom": "name",
	  "adresse": "toto",
	  "dateHeureDebut": "lundi",
	  "dateHeureFin": "mardi",
	  "login": null,
	  "publish": null,
	  "url": null
	}
 *
 */
@Path("/event")
public class EventService {
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Event getEvent(@PathParam("id") String id) {
		RedisService.connection();
		Event event = RedisService.getEvent(Integer.parseInt(id));
		RedisService.deconnexion();
		return event;
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void create(Event event) {
		RedisService.connection();
		RedisService.createOrUpdateEvent(event);
		RedisService.deconnexion();

	}
	
	@GET
	@Path("/publish/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String publish(@PathParam("id") String id) {
		RedisService.connection();
		RedisService.publish(id);
		RedisService.deconnexion();
		return "OK";
	}
	
}
