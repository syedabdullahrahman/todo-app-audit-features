package abdullah.todomanagement.service;


import abdullah.todomanagement.model.User;

import java.util.List;

public interface UserService {

	User findById(Long id) throws Exception;
	
	List<User> findAll();

	void saveOrUpdate(User user);
	
	void delete(Long id);
	
}