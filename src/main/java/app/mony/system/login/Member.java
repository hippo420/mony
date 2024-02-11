package app.mony.system.login;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "SYS_USER")
public class Member {
    @Id
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "NICKNAME")
    private String nickName;

    @Column(name = "THUMBS")
    private String thumbs;


}
