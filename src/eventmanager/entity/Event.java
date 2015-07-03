/**
 * 
 */
package eventmanager.entity;

/**
 * @author JLHERMIT
 *
 */
public class Event {

	private int id;
	private String nom;
	private String adresse;
	private String dateHeureDebut;
	private String dateHeureFin;
	private String login;
	private String publish;
	private String url;
	
	public Event() {
		
	}
	
	public Event(int id, String nom, String adresse, String dateHeureDebut,
			String dateHeureFin, String login, String publish, String url) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.dateHeureDebut = dateHeureDebut;
		this.dateHeureFin = dateHeureFin;
		this.login = login;
		this.publish=publish;
		this.url=url;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDateHeureDebut() {
		return dateHeureDebut;
	}
	public void setDateHeureDebut(String dateHeureDebut) {
		this.dateHeureDebut = dateHeureDebut;
	}
	public String getDateHeureFin() {
		return dateHeureFin;
	}
	public void setDateHeureFin(String dateHeureFin) {
		this.dateHeureFin = dateHeureFin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
		
}
