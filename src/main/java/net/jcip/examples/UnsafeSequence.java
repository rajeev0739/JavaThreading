package net.jcip.examples;

import net.jcip.annotations.*;

/**
 * UnsafeSequence
 *
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}