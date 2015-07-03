/**
 * 
 */
package eventmanager.service.redis;

import java.util.HashMap;
import java.util.Map;

import eventmanager.entity.Event;
import redis.clients.jedis.Jedis;

/**
 * @author JLHERMIT
 *
 */
public class RedisService {
	
	private static Jedis jedis = null;
	
	public static void connection() {
		RedisService.jedis = new Jedis("localhost");
	}
	
	public static void createOrUpdateEvent(Event event) {
		if(!jedis.hexists(Integer.toString(event.getId()), "nom")) {
			jedis.lpush(event.getLogin(), Integer.toString(event.getId()));
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("nom", event.getNom());
		map.put("adresse", event.getAdresse());
		map.put("dateHeureDebut", event.getDateHeureDebut());
		map.put("dateHeureFin", event.getDateHeureFin());
		jedis.hmset(Integer.toString(event.getId()), map);
	}
	
	public static Event getEvent(int id) {
		Map<String, String> map = jedis.hgetAll(Integer.toString(id));
		Event event = new Event();
		event.setAdresse(map.get("adresse"));
		event.setDateHeureDebut(map.get("dateHeureDebut"));
		event.setDateHeureFin(map.get("dateHeureFin"));
		event.setNom(map.get("nom"));
		event.setId(id);
		event.setPublish(map.get("publish"));
		event.setUrl(map.get("url"));
		return event;
	}
	
	public static void publish(String id) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("publish", "1");
		map.put("url", "http://localhost:8080/EventManager/rest/event/"+id);
		jedis.hmset(id, map);
		
	}
	
	public static void deconnexion() {
		jedis.close();
	}

}
