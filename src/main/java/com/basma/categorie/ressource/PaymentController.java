package com.basma.categorie.ressource;
import com.basma.categorie.entity.HttpResponse;
import com.basma.categorie.entity.Payment;
import com.basma.categorie.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    public static final String PAYMENT_DELETED_SUCCESSFULLY = "Payment deleted successfully";

    @Autowired
    PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        Payment newPayment = paymentService.savePayment(payment);
        return new ResponseEntity<>(newPayment, OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.findByIdPayment(id);
        return new ResponseEntity<>(payment, OK);
    }

    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                message), httpStatus);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deletePayment(@PathVariable("id") Long id) throws IOException {
        paymentService.deletePayment(id);
        return response(OK, PAYMENT_DELETED_SUCCESSFULLY);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Payment>> getAllPayment() {
        List<Payment> payment = paymentService.getPayments();
        return new ResponseEntity<>(payment, OK);
    }
}
