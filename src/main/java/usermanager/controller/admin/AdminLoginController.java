package usermanager.controller.admin;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usermanager.domain.ResponseObj;
import usermanager.domain.admin.AdminLogin;
import usermanager.factory.ResponseObjFactory;
import usermanager.factory.admin.AdminLoginFactory;
import usermanager.service.admin.AdminLoginService;

import java.util.List;

@RestController
@RequestMapping(value = {"/", "/cputusermanager/admin/login"})
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("/create")
    @ResponseBody
    public AdminLogin create(@RequestBody AdminLogin adminObj) {
        AdminLogin savedAdminLogin;
        savedAdminLogin = adminLoginService.create(adminObj);
//        System.out.println("Entered Value: " + username + " - " + password);
//        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Gender created!");
//        AdminLogin savedAdminLogin;
//        if (username == null || username.trim().isEmpty() || username.trim().equalsIgnoreCase("null")) {
//            responseObj.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
//            responseObj.setResponseDescription("Provide login details!");
//        } else {
//            savedAdminLogin = adminLoginService.retrieveById(username);
//            if (savedAdminLogin != null) {
//                responseObj.setResponseDescription("Login details already exist!");
//            } else {
//                savedAdminLogin = AdminLoginFactory.buildAdminLogin(username, password);
//                savedAdminLogin = adminLoginService.create(savedAdminLogin);
//            }
//            responseObj.setResponse(savedAdminLogin);
//        }
        return savedAdminLogin;
    }
    @PostMapping("/update")
    @ResponseBody
    public void updateEmployee(@RequestBody AdminLogin adminObj){
        AdminLogin savedAdminLogin;

        adminLoginService.update(adminObj);
    }

    @GetMapping("/delete/{admin}")
    @ResponseBody
    public void delete(@PathVariable("admin") String username) {

        adminLoginService.delete(username);
    }

    @GetMapping("/read/{admin}")
    @ResponseBody
    public AdminLogin read(@PathVariable("admin") String username) {

        return adminLoginService.read(username);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity getAll(){
        ResponseObj responseObj = ResponseObjFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Success");
        List<AdminLogin> adminLogins = adminLoginService.getAll();
        responseObj.setResponse(adminLogins);
        return ResponseEntity.ok(responseObj);
    }
}

