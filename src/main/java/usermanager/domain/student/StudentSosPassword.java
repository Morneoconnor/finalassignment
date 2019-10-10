package usermanager.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class StudentSosPassword {

    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "username" )
//    @OneToMany()
    private String username;
    @Column(name = "password" )
    private String password;

    private StudentSosPassword() {}

    public StudentSosPassword(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getId() {
        return id;
    }
    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "StudentSosPassword{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{

        private String id, username, password;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder copy(StudentSosPassword studentSosLogin) {
            this.id = studentSosLogin.id;
            this.username = studentSosLogin.username;
            this.password = studentSosLogin.password;

            return this;
        }

        public StudentSosPassword build() {
            return new StudentSosPassword(this);
        }
    }
}

