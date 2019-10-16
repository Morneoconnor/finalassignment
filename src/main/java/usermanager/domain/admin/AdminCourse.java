package usermanager.domain.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbladmincourse")
public class AdminCourse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Id
    @Column(name = "username" )
    private String username;
    @Column(name = "course" )
    private String course;


    private AdminCourse() {}

    public AdminCourse(Builder builder) {
        this.username = builder.username;
        this.id = builder.id;
        this.course = builder.course;
    }

    public long getId() {
        return id;
    }
    public String getUsername() {
        return username;
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

        private long id;
        private String username, course;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder username(String username) {
            this.username = username;
            return this;
        }
        public Builder course(String course) {
            this.course = course;
            return this;
        }

        public Builder copy(AdminCourse adminCourse) {
            this.id = adminCourse.id;
            this.username = adminCourse.username;
            this.course = adminCourse.course;

            return this;
        }

        public AdminCourse build() {
            return new AdminCourse(this);
        }
    }
}

