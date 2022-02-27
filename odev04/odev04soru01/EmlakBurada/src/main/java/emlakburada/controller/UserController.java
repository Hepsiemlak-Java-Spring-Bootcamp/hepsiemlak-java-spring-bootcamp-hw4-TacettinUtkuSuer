package emlakburada.controller;

import java.util.List;

import emlakburada.dto.response.AdvertResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public ResponseEntity<List<UserResponse>> getAllUser() {
		return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest request) {
		userService.saveUser(request);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserResponse> getUserByUserId(@PathVariable(required = false) int userId) {
		return new ResponseEntity<>(userService.findOne(userId), HttpStatus.OK);
	}

	@DeleteMapping(value = "/users/{userId}")
	public ResponseEntity<AdvertResponse> deleteUserByUserId(@PathVariable(required = false) int userId) {
		userService.deleteUserByUserId(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
