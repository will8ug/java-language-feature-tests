package net.will.javatest.basicconcept.jdk15.sealed;

public sealed interface Service permits Car, Truck {
    int getMaxServiceIntervalInMonths();

    default int getMaxDistanceBetweenServicesInKilometers() {
        return 100_000;
    }
}
