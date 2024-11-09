package pl.prim.paymentvalidationservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment-validation-service")
public class PaymentController {

    // stripe.com ->
    // checkout.session.complete <- ten
    // payment_intend.success

    // Endpoint URL =
    // tunelowanie SSH czyli możemy tunelem wystawić coś do weba

    @Autowired
    EbookDeliveryClient ebookDeliveryClient;

    @PostMapping("/webhook")
    public String webhook(@RequestBody String paymentInfo) throws JsonProcessingException {
        System.out.println(paymentInfo);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(paymentInfo);

        String email = root.path("data").path("object").path("customer_details").path("email").asText();

        System.out.println("email: " + email);
        ebookDeliveryClient.sendEmail(email);
        return "hello world";
    }
}
