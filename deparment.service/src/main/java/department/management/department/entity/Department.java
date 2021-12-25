package department.management.department.entity;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document("department_data")
public class Department {
	@Id
	private String departmentId;
	@NotNull(message="{Name}")
	private String departmentName;
	@NotNull(message="{Address}")
	private String departmentAddress;
	@NotNull(message="{Code}")
	private String departmentCode;

}
