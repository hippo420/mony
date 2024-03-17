package app.mony.fw.sy.role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "SYS_ROLE")
public class Role {
    @Id
    private Long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "MENU_ID")
    private String menuId;

    @Column(name = "AUTH_DTL")
    private String authDtl;

}
