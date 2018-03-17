package net.jcip.examples;

import net.jcip.annotations.*;

/**
 * Sequence
 *
 */

@ThreadSafe
public class Sequence {
    @GuardedBy("this") private int nextValue;

    public synchronized int getNext() {
        return nextValue++;
    }
}