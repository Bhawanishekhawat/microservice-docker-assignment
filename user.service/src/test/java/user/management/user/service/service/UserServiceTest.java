package user.management.user.service.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.web.client.RestTemplate;

import user.management.user.service.entity.User;
import user.management.user.service.repository.UserRepo;

@ExtendWith(MockitoExtension.class)
@DataMongoTest
class UserServiceTest {
	@Mock
	private UserRepo userRepo;
	private RestTemplate restTemplate;
	private UserService userService;

	@BeforeEach
	void setUp() {
		userService = new UserService(userRepo, restTemplate);
	}

	@Test
	void testRegisterUser() {
		// given
		User user = new User("Karan", "Singh", 9876787656L, "karan@gmail.com", new Date(1991 - 12 - 25), "jaipur",
				"61b1a551e4ec0206941f5c9c");
		// when
		userService.registerUser(user);

		// then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		verify(userRepo).save(userArgumentCaptor.capture());
		User capturedUser = userArgumentCaptor.getValue();
		assertThat(capturedUser).isEqualTo(user);
	}

	@Test
	void testGetAllUsers() {

		userService.getAllUsers();
		verify(userRepo).findAll();

	}

	@Test
	void testGetById() {
		String userId = "61b1a826b3ea10523111d2fd";
		User user = new User(userId,"Kartik", "Sharma", 9876787656L, "k@gmail.com", new Date(1991 - 12 - 25), "jaipur",
				"61b1a551e4ec0206941f5c9c");

		Mockito.when(userRepo.findById(user.getUserId())).thenReturn(Optional.ofNullable(user));
		assertEquals(user, userService.getById(user.getUserId()));

	}

	@Test
	void testUpdateUser() {
		String userId = "61b1a826b3ea10523111d2fd";

		User user = new User(userId, "Kartik", "Sharma", 9876787656L, "k@gmail.com", new Date(1991 - 12 - 25), "jaipur",
				"61b1a551e4ec0206941f5c9c");
		User getUser = user;
//		getUser.setUserId(userId);
		userService.updateUser(getUser, userId);
		verify(userRepo, times(1)).save(getUser);

	}

	@Test
	void testDeleteUserById() {
		String userId = "61b86e9e50d9c558f1e65ac6";
		userService.deleteUserById(userId);
		verify(userRepo, times(1)).deleteById(userId);

	}

	@Test
	@Disabled
	void testGetUserWithDepartment() {

	}

}
