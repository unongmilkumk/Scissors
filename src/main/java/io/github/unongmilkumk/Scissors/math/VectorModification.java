package io.github.unongmilkumk.Scissors.math;

import lombok.Getter;
import org.bukkit.util.Vector;

public class VectorModification {
    @Getter
    private final Vector vector;

    public VectorModification(Vector v) {
        this.vector = v;
    }

    public VectorModification x(int x) {
        vector.setX(x);
        return this;
    }
    public VectorModification x(float x) {
        vector.setX(x);
        return this;
    }
    public VectorModification x(double x) {
        vector.setX(x);
        return this;
    }

    public VectorModification y(int y) {
        vector.setY(y);
        return this;
    }
    public VectorModification y(float y) {
        vector.setY(y);
        return this;
    }
    public VectorModification y(double y) {
        vector.setY(y);
        return this;
    }

    public VectorModification z(int z) {
        vector.setZ(z);
        return this;
    }
    public VectorModification z(float z) {
        vector.setZ(z);
        return this;
    }
    public VectorModification z(double z) {
        vector.setZ(z);
        return this;
    }

    /**
     * same as MathHelper.pow, but for Vector
     * @param value when VectorModification.pow(2.0) make it 1.0*2.0, so it make 2.0
     * @return Same class
     */
    public VectorModification multiply(double value) {
        vector.multiply(value);
        return this;
    }
}
