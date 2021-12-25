package user.management.user.service.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import user.management.user.service.VO.Department;
import user.management.user.service.VO.ResponseTemplateVO;
import user.management.user.service.entity.User;
import user.management.user.service.repository.UserRepo;

@AllArgsConstructor
@Service
@Slf4j
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public User registerUser(User user) {
		log.info("inside the saveUser method of User service ");
		return userRepo.save(user);
	}

	public List<User> getAllUsers(){
		log.info("inside the getAllUsers method of User service ");
		return userRepo.findAll();
	}	
	
	public User getById(String userId) {
		log.info("inside the getById method of User service ");
		return userRepo.findById(userId).get();
	}
	
	public User updateUser(User user, String userId) {
		log.info("inside the updateUser method of User service ");
		User getUser = user;
		getUser.setUserId(userId);
		return userRepo.save(getUser);
	}
	 public void deleteUserById(String userId) {
		 log.info("inside the deleteUserById method of User service ");
		  userRepo.deleteById(userId);
		 
	 }

	public ResponseTemplateVO getUserWithDepartment(String userId) {
		log.info("inside the getUserWithDepartment method of User service ");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepo.findUserByUserId(userId);
		
		Department department = 
				restTemplate.getForObject("http://DEPARTMENT-SERVICE/department-service/getById/" +user.getDepartmentId()
				, Department.class);
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}

	
}
