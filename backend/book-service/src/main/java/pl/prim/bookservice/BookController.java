package pl.prim.bookservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book-service")
@CrossOrigin("*")
public class BookController {

    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping("/hello")
    public String string() {
        return "hello world my id: " + id;
    }

    @GetMapping("/get-ebooks")
    public List<Ebook> getEbooks() {
        List<Ebook> ebooks = List.of(
                new Ebook("Spring Boot LiveBook", "100", "PB", "https://livebooks.pl/assets/img/livebook-cover.png", ""),
                new Ebook("Java chalenges", "200", "PB", "https://bykowski.pl/wp-content/uploads/2023/12/Java-Challenges-Real-Interview-Edition-Small.png", "")
        );

        return ebooks;
    }

}
