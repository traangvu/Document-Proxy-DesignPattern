import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, DocumentInterface> documents = new HashMap<>();

    public void addUnprotectedDocument(String id, String content) {
        Document doc = new Document(id, new Date(), content);
        documents.put(id, doc);
    }

    public void addProtectedDocument(String id, String content, String... allowedUsers) {
        Document doc = new Document(id, new Date(), content);
        DocumentProxy proxy = new DocumentProxy(doc);

        AccessControlService accessControlService = AccessControlService.getInstance();
        for (String user : allowedUsers) {
            accessControlService.allowAccess(user, id);
        }

        documents.put(id, proxy);
    }

    public DocumentInterface getDocument(String id) {
        return documents.get(id);
    }
}
