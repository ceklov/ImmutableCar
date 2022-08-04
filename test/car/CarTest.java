package car;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarTest {

    private static Car bronco;
    private static Car malibu;
    private static Car newBronco;
    private static Car newMalibu;
    private static Car mustang;

    private static final String BRONCO = "Bronco";
    private static final String MALIBU = "Malibu";
    private static final String MUSTANG = "Mustang";

    @Before
    public void setUp() {
        bronco = new Car(Car.Make.FORD, BRONCO, 2022);
        malibu = new Car(Car.Make.CHEVY, MALIBU, 2014);
        newBronco = new Car(Car.Make.FORD, BRONCO, 2022);
        newMalibu = new Car(Car.Make.CHEVY, MALIBU, 2022);
        mustang = new Car(Car.Make.FORD, MUSTANG, 2022);
    }

    @Test
    public void testGetMake() {
        assertEquals(Car.Make.FORD, bronco.getMake());
        assertEquals(Car.Make.CHEVY, malibu.getMake());
    }

    @Test
    public void testGetModel() {
        assertEquals(BRONCO, bronco.getModel());
        assertEquals(MALIBU, malibu.getModel());
    }

    @Test
    public void testGetYear() {
        assertEquals(Integer.valueOf(2022), bronco.getYear());
        assertEquals(Integer.valueOf(2014), malibu.getYear());
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorForNullMake() {
        bronco = new Car(null, "Bronco", 2022);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorForNullModel() {
        bronco = new Car(Car.Make.FORD, null, 2022);
    }

    @Test(expected=NullPointerException.class)
    public void testConstructorForNullYear() {
        bronco = new Car(Car.Make.FORD, "Bronco", null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorForInvalidMake() {
        bronco = new Car(Car.Make.UNKNOWN, "Bronco", 2022);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorForInvalidModel() {
        bronco = new Car(Car.Make.FORD, "", 2022);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testConstructorForInvalidYear() {
        bronco = new Car(Car.Make.FORD, BRONCO, 1885);
    }

    @Test
    public void testToString() {
        assertEquals("Car { make=FORD, model=Bronco, year=2022 }", bronco.toString());
        assertEquals("Car { make=CHEVY, model=Malibu, year=2014 }", malibu.toString());
    }

    @Test
    public void testHashCode() {
        assertEquals(newBronco.hashCode(), bronco.hashCode());
        assertNotEquals(newMalibu.hashCode(), malibu.hashCode());
    }

    @Test
    public void testEqualsDifferentClass() {
        assertFalse(bronco.equals("a string"));
    }

    @Test
    public void testEqualsSameObject() {
        assertSame(bronco, bronco);
    }

    @Test
    public void testEqualsNull() {
        assertNotEquals(null, bronco);
    }

    @Test
    public void testEqualsDifferentMake() {
        assertNotEquals(bronco, malibu);
    }

    @Test
    public void testEqualsDifferentModel() {
        assertNotEquals(bronco, mustang);
    }

    @Test
    public void testEqualsDifferentYear() {
        assertNotEquals(malibu, newMalibu);
    }

    @Test
    public void testEqualsButNotSame() {
        assertEquals(bronco, newBronco);
    }

    @Test
    public void testCompareToMake() {
        assertTrue(bronco.compareTo(malibu) > 0);
    }

    @Test
    public void testCompareToModel() {
        assertTrue(bronco.compareTo(mustang) < 0);
    }

    @Test
    public void testCompareToYear() {
        assertTrue(malibu.compareTo(newMalibu) < 0);
    }

    @Test
    public void testCompareToSame() {
        Car otherBronco = bronco;
        assertEquals(0, bronco.compareTo(otherBronco));
    }

    @Test
    public void testCompareToEqual() {
        assertEquals(0, bronco.compareTo(newBronco));
    }
}
