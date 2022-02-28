package emlakburada.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emlakburada.dto.request.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.UserRepository;

@Service
@Slf4j
public class UserService extends UserBaseService {

	@Autowired
	private UserRepository userRepository;

	public List<UserResponse> getAllUser() {
		List<User> users = userRepository.findAll();
		return users.stream().map(user -> convertToUserResponse(user)).collect(Collectors.toList());
	}

	public void saveUser(UserRequest userRequest) {
		userRepository.save(convertToUserEntity(userRequest));	}

	public UserResponse findOne(int userId){

		Optional<User> foundUser = userRepository.findById(userId);

		User user = convertToUser(foundUser);

		try {

			if (user == null) {
				throw new Exception("Kullanıcı bulunamadı.");
			}

			User savedUser = userRepository.save(user);

			return convertToUserResponse(savedUser);
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		return null;
	}

	public void deleteUserByUserId(int userId) {
		userRepository.deleteById(userId);
	}

}
