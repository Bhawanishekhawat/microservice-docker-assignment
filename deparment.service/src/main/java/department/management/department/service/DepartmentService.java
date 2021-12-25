package department.management.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import department.management.department.entity.Department;
import department.management.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("inside saveDepartment method of DepartmentService ");
		return departmentRepository.save(department);
	}

	public Department findDepartById(String departmentId) {
		log.info("inside findDepartmentById method of DepartmentService ");
		return departmentRepository.findById(departmentId).get();
	}

}
