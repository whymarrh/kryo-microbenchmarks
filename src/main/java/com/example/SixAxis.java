package com.example;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")
public class SixAxis {
    private final String name;

    private final float heave;

    private final float sway;

    private final float surge;

    private final float pitch;

    private final float yaw;

    private final float roll;

    private SixAxis() {
        this.name = null;
        this.heave = 0;
        this.sway = 0;
        this.surge = 0;
        this.pitch = 0;
        this.yaw = 0;
        this.roll = 0;
    }

    public SixAxis(
        final String name,
        final float heave,
        final float sway,
        final float surge,
        final float pitch,
        final float yaw,
        final float roll
    ) {
        this.name = name;
        this.heave = heave;
        this.sway = sway;
        this.surge = surge;
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }

    public final String getName() {
        return name;
    }

    public final float getHeave() {
        return heave;
    }

    public final float getSway() {
        return sway;
    }

    public final float getSurge() {
        return surge;
    }

    public final float getPitch() {
        return pitch;
    }

    public final float getYaw() {
        return yaw;
    }

    public final float getRoll() {
        return roll;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SixAxis sixAxis = (SixAxis) o;
        return Float.compare(sixAxis.getHeave(), getHeave()) == 0
            && Float.compare(sixAxis.getSway(), getSway()) == 0
            && Float.compare(sixAxis.getSurge(), getSurge()) == 0
            && Float.compare(sixAxis.getPitch(), getPitch()) == 0
            && Float.compare(sixAxis.getYaw(), getYaw()) == 0
            && Float.compare(sixAxis.getRoll(), getRoll()) == 0
            && Objects.equals(getName(), sixAxis.getName());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getName(), getHeave(), getSway(), getSurge(), getPitch(), getYaw(), getRoll());
    }
}
