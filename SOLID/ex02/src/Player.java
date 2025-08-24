public class Player {
    private final Decoder decoder;
    private final Renderer renderer;
    private final Cache cache;

    public Player(Decoder decoder, Renderer renderer, Cache cache) {
        this.decoder = decoder;
        this.renderer = renderer;
        this.cache = cache;
    }

    public void play(byte[] fileBytes) {
        Frame frame = decoder.decode(fileBytes);
        renderer.render(frame);
        cache.store(frame);
    }
}
