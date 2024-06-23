package app.mony;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Common {

    private String insId;
    private String insDate;
    private String updId;
    private String updDate;

}
