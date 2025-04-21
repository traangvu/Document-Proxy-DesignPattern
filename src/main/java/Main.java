public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addUnprotectedDocument("doc_1", "This is a public document.");
        library.addProtectedDocument("doc_2", "This is a protected document.", "cindy");

        User cindy = new User("cindy");
        User trang = new User("trang");

        try {
            System.out.println("Cindy accesses doc_1: " + library.getDocument("doc_1").getContent(cindy));
            System.out.println("Cindy accesses doc_2: " + library.getDocument("doc_2").getContent(cindy));

            System.out.println("Trang accesses doc_1: " + library.getDocument("doc_1").getContent(trang));
            System.out.println("Trang accesses doc_2: " + library.getDocument("doc_2").getContent(trang));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
