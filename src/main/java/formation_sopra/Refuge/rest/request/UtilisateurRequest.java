package formation_sopra.Refuge.rest.request;

import org.springframework.beans.BeanUtils;

import formation_sopra.Refuge.model.Admin;
import formation_sopra.Refuge.model.Client;
import formation_sopra.Refuge.model.Utilisateur;
import formation_sopra.Refuge.model.Worker;

public class UtilisateurRequest {
	private Integer id;
	private String login;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	private UtilisateurType utilisateurType;

	public UtilisateurRequest() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UtilisateurType getUtilisateurType() {
		return utilisateurType;
	}

	public void setUtilisateurType(UtilisateurType utilisateurType) {
		this.utilisateurType = utilisateurType;
	}

	public static Utilisateur convert(UtilisateurRequest utilisateurRequest) {
		Utilisateur utilisateur = null;
		if(utilisateurRequest.getUtilisateurType() == UtilisateurType.ADMIN) {
			utilisateur = new Admin();
		} else if(utilisateurRequest.getUtilisateurType() == UtilisateurType.WORKER) {
			utilisateur = new Worker();
		} else if(utilisateurRequest.getUtilisateurType() == UtilisateurType.CLIENT) {
			utilisateur = new Client();
		}
		
		BeanUtils.copyProperties(utilisateurRequest, utilisateur);
		
		return utilisateur;
	}
	
	public enum UtilisateurType {
		ADMIN, WORKER, CLIENT;
	}
}
