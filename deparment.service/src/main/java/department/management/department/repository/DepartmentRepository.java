package department.management.department.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import department.management.department.entity.Department;

@Repository
public interface DepartmentRepository extends MongoRepository<Department, String>{

}
