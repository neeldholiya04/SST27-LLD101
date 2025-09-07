package com.example.video;

import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy) {
        this.legacy = Objects.requireNonNull(legacy, "legacy");
    }

    public Frame[] apply(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");
        String handle = "HANDLE:" + frames.length;
        String newHandle = legacy.applySharpen(handle, strength);
        return frames;
    }
}

