package usermanager.domain.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbladminsospassword")
public class AdminSosPassword {
    @Column(name = "id" )
    private String id;
    @Column(name = "username" )
    private String username;
    @Column(name = "password" )
    private String password;

    private AdminSosPassword() {}

    public AdminSosPassword(Builder builder) {
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
        return "AdminSosPassword{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{

        private String  id, username, password;

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

        public Builder copy(AdminSosPassword sosPassword) {
            this.id = sosPassword.id;
            this.username = sosPassword.username;
            this.password = sosPassword.password;

            return this;
        }

        public AdminSosPassword build() {
            return new AdminSosPassword(this);
        }
    }
}

