package com.example;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")
public class SixAxisMutable {
    public String name;

    public float heave;

    public float sway;

    public float surge;

    public float pitch;

    public float yaw;

    public float roll;

    @Override
    public final boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        final SixAxisMutable that = (SixAxisMutable) other;
        return Float.compare(that.heave, heave) == 0
            && Float.compare(that.sway, sway) == 0
            && Float.compare(that.surge, surge) == 0
            && Float.compare(that.pitch, pitch) == 0
            && Float.compare(that.yaw, yaw) == 0
            && Float.compare(that.roll, roll) == 0
            && Objects.equals(name, that.name);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, heave, sway, surge, pitch, yaw, roll);
    }
}
