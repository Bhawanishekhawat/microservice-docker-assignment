package user.management.user.service.VO;

import lombok.Data;
import user.management.user.service.entity.User;

@Data
public class ResponseTemplateVO {
	
	private User user;
	private Department department;

}
