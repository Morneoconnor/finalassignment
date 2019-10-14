package usermanager.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudentcourse")
public class StudentCourse {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "course" )
    private String course;


    private StudentCourse() {}

    public StudentCourse(Builder builder) {
        this.id = builder.id;
        this.course = builder.course;
    }

    public String getId() {
        return id;
    }
    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "AdminSosPassword{" +
                "id='" + id + '\'' +
                ", password='" + course + '\'' +
                '}';
    }

    public static class Builder{

        private String id, course;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder course(String course) {
            this.course = course;
            return this;
        }

        public Builder copy(StudentCourse studentCourse) {
            this.id = studentCourse.id;
            this.course = studentCourse.course;

            return this;
        }

        public StudentCourse build() {
            return new StudentCourse(this);
        }
    }
}


