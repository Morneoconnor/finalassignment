package usermanager.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.student.StudentCourse;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.student.StudentCourseFactory;
import usermanager.service.student.StudentCourseService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/student/course"})
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping(value = "/create/{studentcourse}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String course) {
        System.out.println("Entered Value: " + id + " - " + course);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Course created!");
        StudentCourse savedStudentCourse;
        if (course == null || course.trim().isEmpty() || course.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedStudentCourse = studentCourseService.retrieveById(id);
            if (savedStudentCourse != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedStudentCourse = StudentCourseFactory.buildStudentCourse(id, course);
                savedStudentCourse = studentCourseService.create(savedStudentCourse);
            }
            responseObj.setResponse(savedStudentCourse);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{adminlogin}")
    public void updateEmployee(@RequestBody String id, String course){
        StudentCourse savedAdminLogin;

        savedAdminLogin = StudentCourseFactory.buildStudentCourse( id, course);
        studentCourseService.update(savedAdminLogin);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        studentCourseService.delete(id);
    }

    @GetMapping("/read/{admin}")
    @ResponseBody
    public StudentCourse read(@PathVariable String id) {
        return studentCourseService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<StudentCourse> adminLogins = studentCourseService.getAll();
        responseObj.setResponse(adminLogins);
        return ResponseEntity.ok(responseObj);
    }
}

