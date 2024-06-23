package app.mony.system.utils.mail;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
@Builder
public class EmailMessage {
    private String rcvUser;
    private String sndUser;
    private String title;
    private String message;

    public EmailMessage(String rcvUser, String sndUser, String title, String message) {
        this.rcvUser = rcvUser;
        this.sndUser = sndUser;
        this.title = title;
        this.message = message;
    }

    public EmailMessage() {

    }
}
