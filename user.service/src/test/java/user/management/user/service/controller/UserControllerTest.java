package user.management.user.service.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import user.management.user.service.entity.User;
import user.management.user.service.service.UserService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

	@Autowired
	UserController userController;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserService userService;

	@Test
	@Disabled
	void testInsertUser() throws Exception {
		MockHttpServletRequestBuilder saveUserRequestBuilder = MockMvcRequestBuilders.post("/user-service/saveUser")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.contentType("{\r\n" + "	\"firstName\" : \"kartik\",\r\n" + "	\"lastName\" : \"Sharma\",\r\n"
						+ "	\"mobileNo\" : 9876545789,\r\n" + "	\"emailId\" : \"ks@gmail.com\",\r\n"
						+ "	\"dob\" : \"2021/11/10\",\r\n" + "	\"address\" : \"dwarka\",\r\n"
						+ "	\"departmentId\" : \"61b065c774d9bc710503a7a8\"\r\n" + "	\r\n" + "	\r\n" + "	\r\n"
						+ "}");

		User user = new User();

		user.setFirstName("kartik");
		user.setLastName("Sharma");
		user.setDob(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmailId("kartik@gmail.com");
		user.setAddress("dwarka");
		user.setDepartmentId("61b065c774d9bc710503a7a8");

		when(userService.registerUser(user)).thenReturn(user);

		try {
			mockMvc.perform(saveUserRequestBuilder).andExpect(status().isCreated());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Test

	void testGetAllUsers() {
		MockHttpServletRequestBuilder getAllUserRequestBuilder = MockMvcRequestBuilders.get("/user-service/getAll")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);
		User user = new User();
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		user.setFirstName("kartik");
		user.setLastName("Sharma");
		user.setDob(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmailId("kartik@gmail.com");
		user.setAddress("dwarka");
		user.setDepartmentId("61b065c774d9bc710503a7a8");
		when(userService.getAllUsers()).thenReturn(userList);

		try {
			mockMvc.perform(getAllUserRequestBuilder).andExpect(status().isOk());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test
	void testFindById() {
		MockHttpServletRequestBuilder findUserRequestBuilder = MockMvcRequestBuilders
				.get("/user-service/getUserById/user.getUserId()").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		User user = new User();
		user.setFirstName("kartik");
		user.setLastName("Sharma");
		user.setDob(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmailId("kartik@gmail.com");
		user.setAddress("dwarka");
		user.setDepartmentId("61b065c774d9bc710503a7a8");
		when(userService.getById(user.getUserId())).thenReturn(user);

		try {
			mockMvc.perform(findUserRequestBuilder).andExpect(status().isOk());
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Test

	void testDeleteUserById() {

		User user = new User();
		user.setFirstName("kartik");
		user.setLastName("Sharma");
		user.setDob(new Date(2021 / 11 / 10));
		user.setMobileNo(9876545789L);
		user.setEmailId("kartik@gmail.com");
		user.setAddress("dwarka");
		user.setDepartmentId("61b065c774d9bc710503a7a8");

		try {
			mockMvc.perform(MockMvcRequestBuilders.delete("/user-service/deleteUser/user.getUserId()"))
					.andExpect(status().isOk());
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
