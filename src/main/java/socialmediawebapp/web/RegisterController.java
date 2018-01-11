package socialmediawebapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import socialmediawebapp.repo.UserRepository;

@Controller
public class RegisterController {
	@Autowired
	UserRepository userRepository;

	@GetMapping("/register")
	public String register(){
		return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam("username") String username,
						   @RequestParam("email") String email,
						   @RequestParam("password") String password){
		userRepository.registerUser(username, email, password);
		return "redirect:/";
	}
}
