package department.management.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import department.management.department.entity.Department;
import department.management.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/department-service")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/addDepartment")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("inside saveDepartment method of DepartmentController ");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/getById/{departmentId}")
	public Department findDepartmentById(@PathVariable String departmentId) {
		log.info("inside findDepartmentById method of DepartmentController ");
		return departmentService.findDepartById(departmentId);
	}
}
