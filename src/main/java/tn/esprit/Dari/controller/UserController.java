package tn.esprit.Dari.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Dari.modal.User;
import tn.esprit.Dari.service.UserService;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping(path = "user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/adduser")
	private ResponseEntity<?> addUser (@RequestBody User user){
		return userService.addUser(user);
	}
	@GetMapping(value="/getusers")
	private ResponseEntity<?> getUsers (){
		return userService.getUsers();
	}
	@GetMapping(value = "/getuser/{id}")
	private ResponseEntity<?> getUser (@PathVariable Long id ){
		return userService.getUser(id);

	}
	@PutMapping(value="/updateuser")
	private ResponseEntity<?> updateUser (@RequestBody User user ){
		return userService.updateUser(user);

	}
	@DeleteMapping(value="/deleteuser/{id}")
	private ResponseEntity<?> deleteUser (@PathVariable Long id){
		return userService.deleteUser(id);

	}
	@GetMapping(value = "/login")
	private ResponseEntity<?> login (@RequestBody ObjectHandler oj ){
		System.out.println(oj.getLogin()+oj.getPassword());
		return userService.login(oj.getLogin(),oj.getPassword());

	}
	static class ObjectHandler{
		private String password;
		private String login;
		
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
		
	}

}


