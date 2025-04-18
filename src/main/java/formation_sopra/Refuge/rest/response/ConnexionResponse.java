package formation_sopra.Refuge.rest.response;

public class ConnexionResponse {
	private boolean success;
	private String token; // ← Ajout de la propriété token

	public ConnexionResponse() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}