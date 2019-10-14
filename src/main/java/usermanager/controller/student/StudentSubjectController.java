package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentSubject;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentSubjectFactory;
import usermanager.service.student.StudentSubjectService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/student/subject"})
public class StudentSubjectController {

    @Autowired
    private StudentSubjectService studentSubjectService;

    @PostMapping(value = "/create/{adminsospassword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String subject) {
        System.out.println("Entered Value: " + id + " - " + subject);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Subject created!");
        StudentSubject savedSubject;
        if (subject == null || subject.trim().isEmpty() || subject.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedSubject = studentSubjectService.retrieveById(id);
            if (savedSubject != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedSubject = StudentSubjectFactory.buildStudentSubject( id, subject);
                savedSubject = studentSubjectService.create(savedSubject);
            }
            responseObj.setResponse(savedSubject);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{subject}")
    public void updateEmployee(@RequestBody String id, String subject){
        StudentSubject savedSubject;

        savedSubject = StudentSubjectFactory.buildStudentSubject( id, subject);
        studentSubjectService.update(savedSubject);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        studentSubjectService.delete(id);
    }

    @GetMapping("/read/{admin}")
    @ResponseBody
    public StudentSubject read(@PathVariable String id) {
        return studentSubjectService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentSubject> adminPasswords = studentSubjectService.getAll();
        responseObj.setResponse(adminPasswords);
        return ResponseEntity.ok(responseObj);
    }
}

