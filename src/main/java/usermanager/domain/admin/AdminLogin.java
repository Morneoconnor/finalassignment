package usermanager.domain.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbladminlogin")
public class AdminLogin {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;
    @Id
    @Column(name = "username" )
    private String username;
    @Column(name = "password" )
    private String password;

    private AdminLogin() {}

    public AdminLogin(Builder builder) {
        this.id = builder.id;
        this.username = builder.username;
        this.password = builder.password;
    }

    public long getId() {
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
        return "AdminLogin{" +
                //"id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{

        private long id;
        private String  username, password;

        public Builder id(long id) {
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

        public Builder copy(AdminLogin adminLogin) {
            //this.id = adminLogin.id;
            this.username = adminLogin.username;
            this.password = adminLogin.password;

            return this;
        }

        public AdminLogin build() {
            return new AdminLogin(this);
        }
    }
}

