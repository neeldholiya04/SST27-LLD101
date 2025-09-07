package com.example.video;

import java.nio.file.Path;
import java.util.Objects;

public class VideoPipelineFacade {
    private final Decoder decoder = new Decoder();
    private final FilterEngine filters = new FilterEngine();
    private final Encoder encoder = new Encoder();
    private final SharpenAdapter sharpen = new SharpenAdapter(new LegacySharpen());

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Objects.requireNonNull(src, "src");
        Objects.requireNonNull(out, "out");

        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filters.grayscale(frames);
        }

        if (scale != null) {
            frames = filters.scale(frames, scale);
        }

        if (sharpenStrength != null) {
            frames = sharpen.apply(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
