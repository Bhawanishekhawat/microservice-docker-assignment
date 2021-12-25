package user.management.user.service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import user.management.user.service.entity.User;

@DataMongoTest
class UserRepoTest {

	@Autowired
	private UserRepo userRepo;
	
	

	@Test
	void checkWhenFindUserByUserIdExists() {
		// given

		User user = new User("Kartik", "Sharma", 9876787656L, "k@gmail.com", new Date(1991 - 12 - 25), "jaipur",
				"61b1a551e4ec0206941f5c9c");
		userRepo.save(user);
		// when
		User expected = userRepo.findUserByUserId(user.getUserId());
		// then
		assertThat(expected).isEqualTo(user);
	}

	@Test
	void checkWhenFindUserByUserIdNotExist() {
		// given
		User user = new User();

		// when
		User expected = userRepo.findUserByUserId(user.getUserId());
		// then
		assertThat(expected).isNotEqualTo(user);
	}

}
