package br.com.x10d.presencarest.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TesteAppEngineResource {

	@GetMapping("/")
    public String hello() {
            return "Hello Spring Boot com App Engine!";
    }
	
}
