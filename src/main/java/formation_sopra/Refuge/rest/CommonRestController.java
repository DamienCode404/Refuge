package formation_sopra.Refuge.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import formation_sopra.Refuge.config.JwtUtil;
import formation_sopra.Refuge.rest.request.ConnexionRequest;
import formation_sopra.Refuge.rest.response.ConnexionResponse;

@RestController
@RequestMapping("/api")
public class CommonRestController {



	   @Autowired
	    private AuthenticationManager authenticationManager;
	   
	@PostMapping("/connexion")
	public ConnexionResponse create(@RequestBody ConnexionRequest connexionRequest) {

		Authentication authentication = new
				UsernamePasswordAuthenticationToken(connexionRequest.getLogin(),
				connexionRequest.getPassword());
		
		this.authenticationManager.authenticate(authentication);
		
		ConnexionResponse connexionResponse = new ConnexionResponse();
		
		String token = JwtUtil.generate(authentication);
		connexionResponse.setSuccess(true);
		connexionResponse.setToken(token);
		
		return connexionResponse;
	}
}
