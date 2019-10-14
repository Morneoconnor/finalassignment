package usermanager.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudentpersonaldetails")
public class StudentPersonalDetails {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "name" )
    private String name;
    @Column(name = "lastname" )
    private String lastname;
    @Column(name = "email" )
    private String email;
    @Column(name = "mobile" )
    private String mobile;


    private StudentPersonalDetails() {}

    public StudentPersonalDetails(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.email = builder.email;
        this.mobile = builder.mobile;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "AdminSosPassword{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{

        private String id, name, lastname, email, mobile;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }
        public Builder email(String email) {
            this.email = email;
            return this;
        }
        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(StudentPersonalDetails studentPersonalDetails) {
            this.id = studentPersonalDetails.id;
            this.name = studentPersonalDetails.name;
            this.lastname = studentPersonalDetails.lastname;
            this.email = studentPersonalDetails.email;
            this.mobile = studentPersonalDetails.mobile;

            return this;
        }

        public StudentPersonalDetails build() {
            return new StudentPersonalDetails(this);
        }
    }
}


