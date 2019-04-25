package vn.fsoft.bookingbusticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("vn.fsoft.bookingbusticket")
public class BookingBusTicketApplication {
//
	public static void main(String[] args) {
		SpringApplication.run(BookingBusTicketApplication.class, args);
	}

}
