package ru.skillbench.tasks.secondTask.extendedclass;

public class ExtendedClass {
    private byte b;
    private int i;
    private double d;
    private String s;

    public boolean equals(Object anObject) {
        if (this == anObject)
            return true;
        if (anObject == null)
            return false;
        if (getClass() != anObject.getClass())
            return false;
        ExtendedClass other = (ExtendedClass) anObject;
        if (b != other.b)
            return false;
        if (i != other.i)
            return false;
        if (d != other.d)
            return false;
        return s.equals(other.s);
    }

    public int hashCode() {
        return (int) (31 * i * d * b * s.hashCode());
    }

    public String toString() {
        return "string: " + s + ", byte: " + b + ", int: " + i + ", double: " + d;
    }
}
