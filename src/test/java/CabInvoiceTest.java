import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceTest {
    CabInvoice cabInvoice = new CabInvoice();

    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){
        double fare= cabInvoice.calculateFare(2.0,5.0);
        Assertions.assertEquals(25,fare);
    }

    @Test
    void givenNumberOfRidesShouldReturnTotalFare(){
        Ride[] arr ={new Ride(2.0,5.0), new Ride(3.0,7.0), new Ride(0.1,0.3)};
        double fare1= cabInvoice.calculateFare(arr);
        Assertions.assertEquals(67,fare1);
    }
    @Test
    void  givenMultipleRidesShouldReturnInvoice(){
        Ride[] arr ={new Ride(2.0,5.0), new Ride(3.0,7.0), new Ride(0.1,0.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(arr);
        Invoice expectedInvoice = new Invoice(67.0,3,67.0/3);
        Assertions.assertEquals(expectedInvoice,actualInvoice);
    }

}
