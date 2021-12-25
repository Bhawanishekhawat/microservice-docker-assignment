package user.management.user.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import user.management.user.service.entity.User;

@Repository
public interface UserRepo extends MongoRepository<User, String>{

	User findUserByUserId(String userId);

	
	

}
