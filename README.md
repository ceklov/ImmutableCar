# ImmutableCar

A demonstration of an immutable class with a variety of Java features, including the following:

## Immutability:
*   denoted by the usage of the 'final' keyword on both the class fields and the class itself
*   promotes thread safety in multithreaded environments
*   prevents unexpected side effects
*   protects against null reference errors

## Exceptions and argument checks:
*   arguments supplied to the constructor are verified to be both non-null and valid
*   failure to meet these criteria results in throwing the proper exception
*   it is better to fail earlier than later

## Enums and constants
*   enum is preferred where a limited set of values are to be expected
*   constants are utilized in testing for model names
*   enums and constants prevent errors caused by using "magic" numbers and values

## Encapsulation
*   class fields are marked private and accessible only by the getter/accessor methods
*   no setters/mutators are present because it is an immutable class

## Overriding
*   equals() and hashCode() have both been overridden, following the same ordering of fields utilized
*   compareTo() has been overridden, as required by implementing the Comparable interface, following the same ordering of fields as equals() and hashCode()
*   toString() has been overridden such that it returns a human-readable value
    