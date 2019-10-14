package usermanager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminCourse;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminCourseFactory;
import usermanager.service.admin.AdminCourseService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/course"})
public class AdminCourseController {
    @Autowired
    private AdminCourseService adminCourseService;

    @PostMapping(value = "/create/{admincourse}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@PathVariable String id, String course) {
        System.out.println("Entered Value: " + id + " - " + course);
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Course created!");
        AdminCourse savedCourse;
        if (course == null || course.trim().isEmpty() || course.trim().equalsIgnoreCase("null")) {
            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObj.setResponseDescription("Provide login details!");
        } else {
            savedCourse = adminCourseService.retrieveById(id);
            if (savedCourse != null) {
                responseObj.setResponseDescription("Login details already exist!");
            } else {
                savedCourse = AdminCourseFactory.buildAdminCourse(id, course);
                savedCourse = adminCourseService.create(savedCourse);
            }
            responseObj.setResponse(savedCourse);
        }
        return ResponseEntity.ok(responseObj);
    }
    @PutMapping("/update/{id}")
    public void updateEmployee(@RequestBody String id, String course){
        AdminCourse savedCourse;

        savedCourse = AdminCourseFactory.buildAdminCourse( id, course);
        adminCourseService.update(savedCourse);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        adminCourseService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public AdminCourse read(@PathVariable String id) {
        return adminCourseService.read(id);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminCourse> adminLogins = adminCourseService.getAll();
        responseObj.setResponse(adminLogins);
        return ResponseEntity.ok(responseObj);
    }
}


