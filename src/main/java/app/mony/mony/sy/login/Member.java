package app.mony.mony.sy.login;

import jakarta.persistence.*;
import lombok.*;

@Data

@AllArgsConstructor
@Entity
@Builder
@Table(name = "SY_USER", schema = "MONY")
public class Member {

    @Id
    @Column(name = "USER_ID")
    private String USERID;

    @Column(name = "USER_PWD")
    private String USERPWD;

    @Column(name = "USER_NAME")
    private String USERNAME;

    @Column(name = "NICKNAME")
    private String NICKNAME;

    @Column(name = "USER_ROLE")
    private String ROLE;

    @Lob
    @Column(name = "THUMBS", columnDefinition="BLOB")
    private Byte[] THUMBS;

    @Column(name = "SALT")
    private String SALT;
    public Member(){}

    @Override
    public String toString() {
        return "Member{" +
                "USERID='" + USERID + '\'' +
                ", USERPWD='" + USERPWD + '\'' +
                ", USERNAME='" + USERNAME + '\'' +
                ", NICKNAME='" + NICKNAME + '\'' +
                ", ROLE='" + ROLE + '\'' +
                ", THUMBS='" + THUMBS + '\'' +
                ", SALT='" + SALT + '\'' +
                '}';
    }
}
