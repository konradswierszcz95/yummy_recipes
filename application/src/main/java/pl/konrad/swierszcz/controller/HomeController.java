package pl.konrad.swierszcz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.konrad.swierszcz.model.id.RecipeId;

import java.util.UUID;

@RestController
public class HomeController {
    @GetMapping("/")
    String hello() {
        return "during construction";
    }

    @GetMapping("/reciepeId")
    String id() {
        return RecipeId.of(UUID.randomUUID()).valueAsString();
    }

    @GetMapping("/unexpected")
    public void throwUnexpected() {
        throw new RuntimeException();
    }
}
