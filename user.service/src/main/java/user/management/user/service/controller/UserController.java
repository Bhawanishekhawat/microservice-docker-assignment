package user.management.user.service.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import user.management.user.service.VO.ResponseTemplateVO;
import user.management.user.service.entity.User;
import user.management.user.service.service.UserService;

@RestController
@RequestMapping("/user-service")
@Slf4j
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")	
		public ResponseEntity<User> insertUser(@RequestBody @Valid User user){
		log.info("inside the saveUser method of User controller ");
		User saveUser = userService.registerUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
		
	}
	
	@GetMapping("/getAll")
		public ResponseEntity<List<User>> getAllUsers(){
		log.info("inside the getAllUsers  method of User controller ");
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	
	@GetMapping("/getUserById/{userId}")
		public ResponseEntity<User> findById(@PathVariable String userId){
		log.info("inside the findById  method of User controller ");
		User getUser = userService.getById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(getUser);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable String userId){
		log.info("inside the updateUserById  method of User controller ");
		User update = userService.updateUser(user, userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(update);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUserById(@PathVariable String userId ){
		log.info("inside the deleteUserById  method of User controller ");
		userService.deleteUserById(userId);
		return "User deleted Sucessfully with userId " + userId;
	}
	@GetMapping("/getUserWithDepartment/{userId}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable String userId) {
		log.info("inside the getUserWithDepartment method of User controller ");
		return userService.getUserWithDepartment(userId);
	}
}
