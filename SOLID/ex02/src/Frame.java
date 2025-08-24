public class Frame {
    private final byte[] data;

    public Frame(byte[] data) {
        this.data = data;
    }

    public int size() {
        return data.length;
    }

    public byte[] getData() {
        return data;
    }
}
