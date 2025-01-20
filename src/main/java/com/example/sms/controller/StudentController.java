package com.example.sms.controller;

import com.example.sms.dto.StudentDto;
import com.example.sms.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list students request
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        model.addAttribute("students", studentDtos);
        return "students";
    }

    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        // student model to store student form data
        StudentDto studentDto = new StudentDto();
        model.addAttribute("studentDto", studentDto);
        return "create_student";
    }

    //handler method to handle save student form submit request
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("studentDto") StudentDto studentDto,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "create_student";
        }

        studentService.createStudent(studentDto);
        return "redirect:/students";
    }

    // handler method to handle method student request
    @GetMapping("students/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId,
                              Model model) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("studentDto", studentDto);
        return "edit_student";
    }

    // handle method to handle edit student form submit request
    @PostMapping("students/{studentId}")
    public String updateStudent(@PathVariable("studentId") Long studentId,
                                @Valid @ModelAttribute("studentDto") StudentDto studentDto,
                                BindingResult bindingResult,
                                Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("studentDto", studentDto);
            return "edit_student";
        }
        studentDto.setId(studentId);
        studentService.updateStudent(studentDto);
        return "redirect:/students";
    }

    // handle method to handle method del;ete student request
    @GetMapping("students/{studentId}/delete")
    public String deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

    // handle method to handle view student request
    @GetMapping("students/{studentId}/view")
    public String viewStudent(@PathVariable("studentId") Long studentId,
                              Model model) {
        StudentDto studentDto = studentService.getStudentById(studentId);
        model.addAttribute("studentDto", studentDto);
        return "view_student";
    }
}
