package abdullah.todomanagement.service;

import abdullah.todomanagement.model.User;
import abdullah.todomanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User findById(Long id) throws Exception {
		Optional<User> userOptional = userRepository.findById(id);
		if(userOptional.isPresent()){
			return userOptional.get();
		} else {
			throw new Exception("User not found!");
		}
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}