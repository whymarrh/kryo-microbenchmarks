package com.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@SuppressWarnings("unused")
public class KryoPerfTest {
    /**
     * The Kryo serializer.
     */
    private final KryoSerializer serializer = new KryoSerializer();

    private String name = "someone@microsoft.com";

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final void noop() {
        // ???
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final float random() {
        return (float) Math.random();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final byte[] serializeMutableObject() {
        final SixAxisMutable obj = new SixAxisMutable();
        obj.name = name;
        obj.heave = (float) Math.random();
        obj.sway = (float) Math.random();
        obj.surge = (float) Math.random();
        obj.pitch = (float) Math.random();
        obj.yaw = (float) Math.random();
        obj.roll = (float) Math.random();
        return serializer.serialize(obj);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final byte[] serializeImmutableObject() {
        final SixAxis obj = new SixAxis(
            name,
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random()
        );
        return serializer.serialize(obj);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final byte[] serializeAutoValueObject() {
        final SixAxisValue obj = SixAxisValue.create(
            name,
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random()
        );
        return serializer.serialize(obj);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final Object serializeDeserializeMutableObject() {
        final SixAxisMutable obj = new SixAxisMutable();
        obj.name = name;
        obj.heave = (float) Math.random();
        obj.sway = (float) Math.random();
        obj.surge = (float) Math.random();
        obj.pitch = (float) Math.random();
        obj.yaw = (float) Math.random();
        obj.roll = (float) Math.random();
        return serializer.deserialize(serializer.serialize(obj));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final Object serializeDeserializeImmutableObject() {
        final SixAxis obj = new SixAxis(
            name,
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random()
        );
        return serializer.deserialize(serializer.serialize(obj));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public final Object serializeDeserializeAutoValueObject() {
        final SixAxisValue obj = SixAxisValue.create(
            name,
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random(),
            (float) Math.random()
        );
        return serializer.deserialize(serializer.serialize(obj));
    }
}
