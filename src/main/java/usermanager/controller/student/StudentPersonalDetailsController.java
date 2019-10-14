package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentPersonalDetails;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentPersonalDetailsFactory;
import usermanager.service.student.StudentPersonalDetailsService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/student/personaldetail"})
public class StudentPersonalDetailsController {

    @Autowired
    private StudentPersonalDetailsService studentPersonalDetailsService;

    @PostMapping(value = "/create/{Studentpersonaldetails}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String name, String lastname, String email, String mobile) {
        System.out.println("Entered Value: " + id + " - " + name + " - " + lastname);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "details created!");
        StudentPersonalDetails savedPersonalDetails;
        if (name == null || name.trim().isEmpty() || name.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedPersonalDetails = studentPersonalDetailsService.retrieveById(id);
            if (savedPersonalDetails != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedPersonalDetails = StudentPersonalDetailsFactory.buildStudentPersonalDetails( id, name, lastname,email, mobile);
                savedPersonalDetails = studentPersonalDetailsService.create(savedPersonalDetails);
            }
            responseObj.setResponse(savedPersonalDetails);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{studentpersonaldetails}")
    public void updateEmployee(@RequestBody String id, String name, String lastname, String email, String mobile){
        StudentPersonalDetails savedstudentPersonalDetails;

        savedstudentPersonalDetails = StudentPersonalDetailsFactory.buildStudentPersonalDetails( id, name, lastname, email, mobile);
        studentPersonalDetailsService.update(savedstudentPersonalDetails);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        studentPersonalDetailsService.delete(id);
    }

    @GetMapping("/read/{student}")
    @ResponseBody
    public StudentPersonalDetails read(@PathVariable String id) {
        return studentPersonalDetailsService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentPersonalDetails> adminPasswords = studentPersonalDetailsService.getAll();
        responseObj.setResponse(adminPasswords);
        return ResponseEntity.ok(responseObj);
    }
}


