package ru.skillbench.tasks.basics.math;

import java.util.Arrays;

public class ComplexNumberImpl implements ComplexNumber{

    private double im;
    private double re;

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumberImpl() {
        this.re = 0;
        this.im = 0;
    }

    @Override
    public double getRe() {
        return this.re;
    }

    @Override
    public double getIm() {
        return this.im;
    }

    @Override
    public boolean isReal() {
        return this.im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        if (value.length() == 0) {
            this.im = 0;
            this.re = 0;
            return;
        }
        String[] tmp = value.split("\\+");
        if (tmp.length == 1) {
            if (!tmp[0].contains("-")) {
                if (tmp[0].contains("i")) {
                    this.re = 0;
                    this.im = Double.parseDouble(tmp[0].replace("i", ""));
                } else {
                    this.im = 0;
                    this.re = Double.parseDouble(tmp[0]);
                }
            } else {
                int count = 0;
                for (char element : tmp[0].toCharArray()){
                    if (element == '-') count++;
                }
                tmp = tmp[0].split("-");
                if (count == 1) {
                    if (tmp[0].length() == 0) {
                        if (tmp[1].contains("i")) {
                            this.re = 0;
                            this.im = Double.parseDouble("-" + tmp[1].replace("i", ""));
                        } else {
                            this.re = Double.parseDouble("-" + tmp[1]);
                            this.im = 0;
                        }
                    } else {
                        this.re = Double.parseDouble(tmp[0]);
                        this.im = Double.parseDouble("-" + tmp[1].replace("i", ""));
                    }
                } else if (count == 2) {
                    this.re = Double.parseDouble("-" + tmp[1]);
                    this.im = Double.parseDouble("-" + tmp[2].replace("i", ""));
                } else {
                    this.re = Double.parseDouble(tmp[0]);
                }
            }
        } else if (tmp.length == 3) {
            this.re = Double.parseDouble(tmp[1]);
            this.im = Double.parseDouble(tmp[2].replace("i", ""));
        } else if (tmp[0].length() == 0) {
            tmp = tmp[1].split("-");
            if (tmp.length == 2) {
                this.re = Double.parseDouble(tmp[0]);
                this.im = Double.parseDouble("-" + tmp[1].replace("i", ""));
            } else {
                if (tmp[0].contains("i")) {
                    this.re = 0;
                    this.im = Double.parseDouble(tmp[0].replace("i", ""));
                } else {
                    this.im = 0;
                    this.re = Double.parseDouble(tmp[0]);
                }
            }

        } else {
            this.re = Double.parseDouble(tmp[0]);
            this.im = Double.parseDouble(tmp[1].replace("i", ""));
        }
    }

    @Override
    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.re, this.im);
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return new ComplexNumberImpl(this.re, this.im);
    }

    @Override
    public String toString() {
        String ans = "";
        if (this.re != 0) {
            ans += Double.toString(this.re);
        }
        if (this.im != 0) {
            if (this.re == 0) {
                ans += this.im + "i";
            } else {
                if (this.im > 0) {
                    ans += "+" + this.im + "i";
                } else {
                    ans += this.im + "i";
                }
            }
        }
        if (ans.equals("")) {
            ans = "0.0";
        }
        return ans;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (other instanceof ComplexNumberImpl) {
            return ((ComplexNumberImpl) other).compareTo(this) == 0;
        }
        return other.equals(this);
    }

    @Override
    public int compareTo(ComplexNumber other) {
        return Double.compare(Math.pow(this.im, 2) + Math.pow(this.re, 2), Math.pow(other.getIm(), 2) + Math.pow(other.getRe(), 2));
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array);
    }

    @Override
    public ComplexNumber negate() {
        this.set(-this.re, -this.im);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.set(this.re + arg2.getRe(), this.im + arg2.getIm());
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        this.set(this.re * arg2.getRe() - this.im * arg2.getIm(),
                this.im * arg2.getRe() + this.re * arg2.getIm());
        return this;
    }
}
