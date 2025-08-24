public class LastFrameCache implements Cache {
    private Frame last;

    @Override
    public void store(Frame frame) {
        this.last = frame;
        System.out.println("Cached last frame? " + (last != null));
    }

    @Override
    public Frame getLast() {
        return last;
    }
}
