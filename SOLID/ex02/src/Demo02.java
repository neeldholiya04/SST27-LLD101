/*
 * Player decodes, renders UI, and caches frames. That’s three responsibilities in one class. It violates the Single Responsibility Principle.
 * If you want to change how decoding happens (e.g., MP3 vs. WAV), or how UI draws (CLI vs. GUI), you’d have to modify Player. This is the violation of Open/Closed Principle.
 * Player depends on concrete classes. It should depend on abstractions. This is the violation of Dependency Inversion Principle.
 */

public class Demo02 {
    public static void main(String[] args) {
        Decoder decoder = new SimpleDecoder();
        Renderer renderer = new ConsoleRenderer();
        Cache cache = new LastFrameCache();

        Player player = new Player(decoder, renderer, cache);

        player.play(new byte[] { 1, 2, 3, 4 });
    }
}
