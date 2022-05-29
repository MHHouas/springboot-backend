package crud.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crud.model.Utilisateur;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

	@GetMapping(produces = "application/json")
	@RequestMapping({ "/validateLogin" })
	public Utilisateur validateLogin() {
		return new Utilisateur(0,"user","user" ,"user");
	}

}