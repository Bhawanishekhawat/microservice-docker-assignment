package user.management.user.service.entity;

import java.util.Date;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("user_data")
public class User {
	@Id
	private String userId;
	@NotNull(message = "{firstName}")
	private String firstName;
	@NotNull(message = "{lastName}")
	private String lastName;
	@Digits(integer = 10, fraction = 0, message = "{MobileNo}")
	@Min(value = 1000000000, message = "{MobileNo}")
	@NotNull(message = "{mobile_No}")
	private Long mobileNo;
	@Email(message = "{email}")
	@NotNull(message = "{email_id}")
	private String emailId;
	@NotNull(message = "{dateOfBirth}")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date dob;
	@NotNull(message = "{address}")
	private String address;
	private String departmentId;
	
	public User(@NotNull(message = "{firstName}") String firstName, @NotNull(message = "{lastName}") String lastName,
			@Digits(integer = 10, fraction = 0, message = "{MobileNo}") @Min(value = 1000000000, message = "{MobileNo}") @NotNull(message = "{mobile_No}") Long mobileNo,
			@Email(message = "{email}") @NotNull(message = "{email_id}") String emailId,
			@NotNull(message = "{dateOfBirth}") Date dob, @NotNull(message = "{address}") String address,
			String departmentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.dob = dob;
		this.address = address;
		this.departmentId = departmentId;
	}
	
	
	}
	
	
	