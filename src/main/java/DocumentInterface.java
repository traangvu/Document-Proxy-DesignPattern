import java.util.Date;

public interface DocumentInterface {
    String getId();
    Date getCreationDate();
    String getContent(User user) throws AccessDeniedException;
}
