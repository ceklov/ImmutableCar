package car;

public final class Car implements Comparable<Car> {

    private final Make make;
    private final String model;
    private final Integer year;

    public Car(Make make, String model, Integer year) {

        if (areAnyNull(make, model, year)) throw new NullPointerException();
        if (areAnyIllegal(make, model, year)) throw new IllegalArgumentException();

        this.make = make;
        this.model = model;
        this.year = year;
    }

    public enum Make {
        CHEVY,
        FORD,
        UNKNOWN
    }

    private boolean areAnyNull(Make make, String model, Integer year) {
        return make == null || model == null || year == null;
    }

    private boolean areAnyIllegal(Make make, String model, Integer year) {
        return make == Make.UNKNOWN || model.equals("") || year < 1886;
    }

    public Make getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public int compareTo(Car that) {
        if (make != that.make) return make.compareTo(that.make);
        if (!model.equals(that.model)) return model.compareTo(that.model);
        if (!year.equals(that.year)) return year.compareTo(that.year);
        return 0;
    }

    @Override
    public String toString() {
        return "Car { " +
                "make=" + make +
                ", model=" + model +
                ", year=" + year +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Car)) return false;

        Car that = (Car) o;
        if (make != that.make) return false;
        if (!model.equals(that.model)) return false;
        return year.equals(that.year);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + make.hashCode();
        result = prime * result + model.hashCode();
        result = prime * result + year.hashCode();
        return result;
    }
}
