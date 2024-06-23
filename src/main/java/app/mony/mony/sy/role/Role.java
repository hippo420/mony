package app.mony.mony.sy.role;

import app.mony.Common;
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
@Table(name = "SY_ROLE")
public class Role extends Common {


    @Id
    @Column(name = "USER_ID")
    private String USER_ID;

    @Column(name = "MENU_ID")
    private String MENU_ID;

    @Column(name = "SEL_YN")
    private String SEL_YN;

    @Column(name = "DEL_YN")
    private String DEL_YN;

    @Column(name = "INS_YN")
    private String INS_YN;

    @Column(name = "UPD_YN")
    private String UPD_YN;

    @Column(name = "PRC_YN")
    private String PRC_YN;

}
