package usermanager.domain.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbladmincourse")
public class AdminCourse {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "course" )
    private String course;


    private AdminCourse() {}

    public AdminCourse(Builder builder) {
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

        public Builder copy(AdminCourse adminCourse) {
            this.id = adminCourse.id;
            this.course = adminCourse.course;

            return this;
        }

        public AdminCourse build() {
            return new AdminCourse(this);
        }
    }
}

