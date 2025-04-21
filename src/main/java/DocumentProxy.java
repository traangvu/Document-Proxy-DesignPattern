import java.util.Date;

public class DocumentProxy implements DocumentInterface {
    private final Document realDocument;
    private final AccessControlService accessControlService = AccessControlService.getInstance();

    public DocumentProxy(Document realDocument) {
        this.realDocument = realDocument;
    }

    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(user.getUsername(), realDocument.getId())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }
}
