package usermanager.service.student.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usermanager.domain.student.StudentCourse;
import usermanager.repository.student.StudentCourseRespository;
import usermanager.service.student.StudentCourseService;

import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

    private static StudentCourseService studentCourseService = null;
    @Autowired
    private StudentCourseRespository studentCourseRepository;

    private StudentCourseServiceImpl() {
    }

    public static StudentCourseService getStudentCourseServiceService() {
        if (studentCourseService == null) studentCourseService = new StudentCourseServiceImpl();
        return studentCourseService;
    }

    @Override
    public StudentCourse create(StudentCourse adminLogin) {
        return this.studentCourseRepository.save(adminLogin);
    }

    @Override
    public StudentCourse read(String s) {
        return this.studentCourseRepository.findById(s).orElse(null);
    }

    @Override
    public StudentCourse update(StudentCourse adminLogin) {
        return this.studentCourseRepository.save(adminLogin);
    }

    @Override
    public void delete(String s) {
        this.studentCourseRepository.deleteById(s);
    }

    @Override
    public StudentCourse retrieveById(String id) {
        List<StudentCourse> adminLogins = getAll();
        for(StudentCourse adminLogin : adminLogins) {
            if (adminLogin.getId().equalsIgnoreCase(id))
                return adminLogin;
        } return null;
    }

    @Override
    public List<StudentCourse> getAll() {
        return this.studentCourseRepository.findAll();
    }
}



