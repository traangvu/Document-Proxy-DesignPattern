import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> allowedAccess = new HashSet<>();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String username, String documentId) {
        allowedAccess.add(username + ":" + documentId);
    }

    public boolean isAllowed(String username, String documentId) {
        return allowedAccess.contains(username + ":" + documentId);
    }
}
