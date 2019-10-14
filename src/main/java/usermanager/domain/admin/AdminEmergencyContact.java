package usermanager.domain.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbladminemergencycontact")
public class AdminEmergencyContact {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "name" )
    private String name;
    @Column(name = "mobile" )
    private String mobile;


    private AdminEmergencyContact() {}

    public AdminEmergencyContact(Builder builder) {
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
        return "Admin emergenct contact{" +
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

        public Builder copy(AdminEmergencyContact adminEmergencyContact) {
            this.id = adminEmergencyContact.id;
            this.name = adminEmergencyContact.name;
            this.mobile = adminEmergencyContact.mobile;

            return this;
        }

        public AdminEmergencyContact build() {
            return new AdminEmergencyContact(this);
        }
    }
}

