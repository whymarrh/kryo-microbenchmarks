Kryo (Micro)benchmark
=====================

Is (de)serializing a mutable class with [Kryo] _actually_ faster than an immutable one? Let's try to find out.

To run the benchmarks, run `gradle clean jmh`.

Spoiler: it doesn't look like it makes much of a difference.

  [Kryo]:https://github.com/EsotericSoftware/kryo
