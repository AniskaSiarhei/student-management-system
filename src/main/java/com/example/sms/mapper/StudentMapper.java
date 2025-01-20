package com.example.sms.mapper;

import com.example.sms.dto.StudentDto;
import com.example.sms.entity.Student;

public class StudentMapper {

    public static StudentDto mapToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getDateOfBirth(),
                student.getEmail(),
                student.getPhoneNumber()
        );
        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto) {
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getDateOfBirth(),
                studentDto.getEmail(),
                studentDto.getPhoneNumber()
        );
        return student;
    }
}
