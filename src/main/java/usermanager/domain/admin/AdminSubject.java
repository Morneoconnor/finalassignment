package usermanager.domain.admin;

import javax.persistence.*;

@Entity
@Table(name = "tbladminsubject")
public class AdminSubject {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "subject" )
    private String subject;


    private AdminSubject() {}

    public AdminSubject(Builder builder) {
        this.id = builder.id;
        this.subject = builder.subject;
    }

    public String getId() {
        return id;
    }
    public String getSubject() {
        return subject;
    }

    @Override
    public String toString() {
        return "AdminSosPassword{" +
                "id='" + id + '\'' +
                ", password='" + subject + '\'' +
                '}';
    }

    public static class Builder{

        private String id, subject;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder copy(AdminSubject adminSubject) {
            this.id = adminSubject.id;
            this.subject = adminSubject.subject;

            return this;
        }

        public AdminSubject build() {
            return new AdminSubject(this);
        }
    }
}

