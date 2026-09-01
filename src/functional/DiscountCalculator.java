package src.functional;

@FunctionalInterface
    public interface DiscountCalculator{
        double apply(double value);
    }