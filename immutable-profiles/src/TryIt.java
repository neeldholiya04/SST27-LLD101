import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();

        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Profile email: " + p.getEmail());

        UserProfile p2 = new UserProfile.Builder("u2", "x@y.com")
                .displayName("Alice the Great")
                .twitter("@alice")
                .marketingOptIn(true)
                .build();

        System.out.println("Profile2 displayName: " + p2.getDisplayName());
        System.out.println("Profile2 twitter:     " + p2.getTwitter());

        System.out.println("=> Now immutable: no setters, safe after construction.");
    }
}
