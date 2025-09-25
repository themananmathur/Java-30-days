package day18;

import java.util.concurrent.Semaphore;

public class ParkingLot {

    private final Semaphore parkingSpots = new Semaphore(3);

    public void parkCar(String carName) {
        try {
            System.out.println(carName + " is trying to park. [STOP]");
            parkingSpots.acquire();  // acquire a permit

            System.out.println(carName + " has parked. [WAIT]");
            Thread.sleep(2000); // simulate parking duration

            System.out.println(carName + " is leaving. [GO]");
            parkingSpots.release();  // release the permit
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot();

        for (int i = 1; i <= 6; i++) {
            final String carName = "Car " + i;
            new Thread(() -> lot.parkCar(carName)).start();
        }
    }
}
