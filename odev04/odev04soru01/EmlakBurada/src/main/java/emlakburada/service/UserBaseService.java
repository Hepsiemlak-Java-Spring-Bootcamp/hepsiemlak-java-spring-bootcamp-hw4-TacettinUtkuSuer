package emlakburada.service;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.Message;
import emlakburada.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class UserBaseService {

	protected User convertToUserEntity(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setBio(userRequest.getBio());
		user.setPhoto(userRequest.getPhoto());
		user.setUserType(userRequest.getUserType());
		return user;
	}

	protected UserResponse convertToUserResponse(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setName(user.getName());
		userResponse.setEmail(user.getEmail());
		userResponse.setBio(user.getBio());
		userResponse.setPhoto(user.getPhoto());
		userResponse.setUserType(user.getUserType());
		return userResponse;
	}

	protected User convertToUser(Optional<User> foundUser) {

		User user = null;

		if (foundUser.isPresent()) {
			user = new User();
			user.setUserType(foundUser.get().getUserType());
			user.setPhoto(foundUser.get().getPhoto());
			user.setBio(foundUser.get().getBio());
			user.setName(foundUser.get().getName());
			user.setEmail(foundUser.get().getEmail());
			user.setId(foundUser.get().getId());
		} else {
			log.info("Kullanıcı Bulunamadı!");
		}

		return user;
	}



}
