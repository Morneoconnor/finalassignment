package usermanager.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudentemergencycontact")
public class StudentEmergencyContact {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "name" )
    private String name;
    @Column(name = "mobile" )
    private String mobile;


    private StudentEmergencyContact() {}

    public StudentEmergencyContact(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.mobile = builder.mobile;
    }

    public String getId() {
        return id;
    }
    public String getCourse() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }

    @Override
    public String toString() {
        return "Student emergenct contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public static class Builder{

        private String id, name, mobile;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder copy(StudentEmergencyContact adminEmergencyContact) {
            this.id = adminEmergencyContact.id;
            this.name = adminEmergencyContact.name;
            this.mobile = adminEmergencyContact.mobile;

            return this;
        }

        public StudentEmergencyContact build() {
            return new StudentEmergencyContact(this);
        }
    }
}
