package pl.prim.ebookdeliveryservice;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ebook-delivery-service")
public class EmailController {

    @Autowired
    MailService mailService;

    @GetMapping("/send-email")
    public void sendEmail(@RequestParam String mail) throws MessagingException {
        mailService.sendEmail(mail);
    }

    @GetMapping("/send")
    public void sendEmail() throws MessagingException {
        mailService.sendEmail("paw3@op.pl");
    }

}
