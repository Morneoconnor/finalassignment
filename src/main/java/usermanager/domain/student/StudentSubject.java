package usermanager.domain.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblstudentsubject")
public class StudentSubject {
    @Id
    @Column(name = "id" )
    private String id;
    @Column(name = "subject" )
    private String subject;


    private StudentSubject() {}

    public StudentSubject(Builder builder) {
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
        return "Student SosPassword{" +
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

        public Builder copy(StudentSubject adminSubject) {
            this.id = adminSubject.id;
            this.subject = adminSubject.subject;

            return this;
        }

        public StudentSubject build() {
            return new StudentSubject(this);
        }
    }
}


