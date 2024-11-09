package pl.prim.ebookdeliveryservice;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class MailService {

    // localhost:9411/zipkin mozna zobaczyc wszystkie requesty ktore ida

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String email) throws MessagingException {
        System.out.println("sending email....");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("paw3@op.pl");
        helper.setTo(email);
        helper.setSubject("Twoj Ebook");
        helper.setText("Tutaj jest e book");

        javaMailSender.send(message);
    }

}
