package com.example;

import com.google.auto.value.AutoValue;

@AutoValue
@SuppressWarnings("WeakerAccess")
public abstract class SixAxisValue {
    public static SixAxisValue zero(final String name) {
        return create(name, 0, 0, 0, 0, 0, 0);
    }

    public static SixAxisValue create(
        final String name,
        final float heave,
        final float sway,
        final float surge,
        final float pitch,
        final float yaw,
        final float roll
    ) {
        return new AutoValue_SixAxisValue(name, heave, sway, surge, pitch, yaw, roll);
    }

    SixAxisValue() {
        // ???
    }

    public abstract String name();

    public abstract float heave();

    public abstract float sway();

    public abstract float surge();

    public abstract float pitch();

    public abstract float yaw();

    public abstract float roll();
}
