package com.zkteco.entity;

import java.sql.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

	@Id
	@NotNull(message = "Please Enter Id for Employee")
	@Column(name="empId",length = 36)
	private Long id;
	
	@NotBlank(message = "Please Enter First Name")
	@Pattern(regexp ="^[A-Z][a-zA-Z]+$", message = "Name should start with Captial Letter and contains alphabets only.")
	@Column(name = "first_name",length = 50)
	private String firstName;
	
	@Pattern(regexp ="^[A-Z][a-zA-Z]+$", message = "Name should start with Captial Letter and contains alphabets only.")
	@Column(name = "last_name",length = 50)
	private String lastName;
	
	private Gender gender;
		
	@Column(name = "email", unique = true, nullable=false)
	@NotBlank(message = "Please Enter the Email")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+[a-zA-Z]{2,}", message = "Please Write a Valid Email")
	private String email;
	
	@Column(name = "phone", unique = true, nullable=false)	
	@NotBlank(message = "Please Enter the Phone Number")
	@Pattern(regexp = "[\\\\+]+[0-9]{2}+[-]+[0-9]{10}", message = "Please Enter Valid Phone Number")
	private String phone;
	
	@DateTimeFormat
	private Date dateOfBirth;
	
	private String profileImage;

}
