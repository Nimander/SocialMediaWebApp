package socialmediawebapp.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import socialmediawebapp.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class ProfileController {
	@Autowired
	private CommentRepository repository;

	@GetMapping("user/{profile}")
	public String viewProfile(@PathVariable String profile, Model model){
		model.addAttribute("comments", repository.getCommentsFromProfile(profile));
		return "profile";
	}

	@PostMapping("user/{profile}")
	public String addCommentToProfile(@PathVariable String profile, @RequestParam("message") String message){
		repository.addNewCommentToDataBase(getNameOfLoggedUser(), message, profile);
		return "redirect:/user/" + profile;
	}

	private String getNameOfLoggedUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}
}
