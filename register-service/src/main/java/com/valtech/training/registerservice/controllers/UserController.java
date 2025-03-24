package com.valtech.training.registerservice.controllers;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.valtech.training.registerservice.services.UserService;
import com.valtech.training.registerservice.vos.UserVO;
 
 
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
 
		@Autowired
		private UserService userService;

 
		@PostMapping("/")
		public UserVO register(@RequestBody UserVO uvo) {

			return userService.signIn(uvo);

		}
		
		@PostMapping("/subscription/{sid}")
	    public void addUserToSubscription(@PathVariable long sid, @RequestBody UserVO vo) {
	        userService.addUserToSubscription(vo, sid);  
	    }
		
		@DeleteMapping("/{userId}")
	    public void deleteUserFromSubscription(@PathVariable("userId") long userId) {
	        userService.deleteUserFromSubscription(userId);  
	    }


}

 