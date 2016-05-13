package com.example;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.FastInput;
import com.esotericsoftware.kryo.io.FastOutput;
import com.esotericsoftware.kryo.io.Output;

final class KryoSerializer {
    private final Kryo kryo = new Kryo();

    public final byte[] serialize(final Object value) {
        final Output output = new FastOutput(16, 1024);
        kryo.writeClassAndObject(output, value);
        return output.toBytes();
    }

    public final Object deserialize(final byte[] bytes) {
        return kryo.readClassAndObject(new FastInput(bytes));
    }
}
