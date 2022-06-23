package com.callor.ems.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmsVO {

	private long e_seq;
	private String e_from_email;
	
	@Email(message="Email 형식이 아닙니다")
	@NotEmpty(message="받는사람 email 써야하쥬? 킹받쥬?")
	private String e_to_email;
	
	@NotEmpty(message=" 난 널을 사랑해~~ ")
	private String e_from_name;
	
	@Length(min=1,max=100,message="받는사람 이름은 1글자 ~ 100글자 까지만 가능")
	@NotEmpty(message="어쩔티비저쩔티비쓰고 넘어가야하쥬")
	private String e_to_name;
	
	@NotEmpty(message="슈슉~ 슉 못넘어가쥬")
	private String e_subject;
	private String e_content;
	
	// @Size(min=1,max=10,message="num 는 1부터 10 사이 값이어야 ham")
	private String e_send_date;
	private String e_send_time;
	
	// @Min(value = 1,message = "num 는 1보다 커야함")
	// @Max(value = 10,message = "num 는 10보다는 작아야함")
	private int num;
	
	// @DecimalMin(value = "1",message = "decimal 은 십진수 1보다 커야 ham")
	// @DecimalMax(value = "10",message = "decimal 은 십진수 10보다 작아야 ham")
	private int decimal;
	
	// @Pattern(regexp = "^.*(?=^.{8,15}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
	private String password;
	
}
