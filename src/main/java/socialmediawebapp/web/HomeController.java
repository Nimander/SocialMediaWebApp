package socialmediawebapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import socialmediawebapp.repo.CommentRepository;
import socialmediawebapp.repo.UserRepository;

@Controller
public class HomeController {
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value="/")
	public String home(Model model){
		model.addAttribute("users", userRepository.getUserNames());
		return "home";
	}

	//@PostMapping(value="/")
	//public String home1(@RequestParam("message") String message){
	//	repository.addNewCommentToDataBase(getNameOfLoggedUser(), message);
	//	return "redirect:/";
	//}

	//private String getNameOfLoggedUser(){
	//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	//	return auth.getName();
	//}
}
