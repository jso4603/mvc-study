package com.java.ex;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// isAssignableFrom : 특정 Class가 어떤 클래스/인터페이스를 상속/구현했는지 체크
		return Student.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입 정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate()");
		Student student = (Student) target;

//		String studentName = student.getName();
//
////		자바 11 미만 : trim().isEmpty() -> whitespace 체크
////		if(studentName == null || studentName.trim().isEmpty()) {
////		자바 11 이상 : isBlank() == trim().isEmpty()
//		if(studentName == null || studentName.isBlank()) {
//			System.out.println("studentName is null or empty");
//			errors.rejectValue("name", "trouble");
//		}

//		Spring util 이용
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");

		int studentId = student.getId();

		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id", "trouble");
		}

	}

}
