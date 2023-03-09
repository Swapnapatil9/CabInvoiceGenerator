public class CabInvoice {
    static final  double COST_PER_KM = 10;
    static final  double COST_PER_MINUTE = 1;
    public double calculateFare(double distance, double time) {
        double fare= distance * COST_PER_KM + time * COST_PER_MINUTE;
       if(fare<5)
           fare=5;
        return fare;
    }

    public double calculateFare(Ride[] rideArray) {
        double totalFare=0;
        for (Ride ride:rideArray) {
            totalFare+= calculateFare(ride.distance,ride.time);
        }
        return totalFare;
    }

    public Invoice generateInvoice(Ride[] rideArray) {
      double totalFare = calculateFare(rideArray);
      int totalRides= rideArray.length;
      double avgFare = totalFare/totalRides;
      return  new Invoice(totalFare,totalRides,avgFare);
    }
}
