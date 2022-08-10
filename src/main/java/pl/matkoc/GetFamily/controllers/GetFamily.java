package pl.matkoc.GetFamily.controllers;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.matkoc.GetFamily.model.Family;

@RestController
@RequestMapping("/getFamily")
public class GetFamily {

    @GetMapping("/{id}")
    public Family getFamily(@PathVariable int id){

        String getId = String.valueOf(id);
        String url = "http://localhost:8080/family/id";

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Family> exchange = restTemplate.exchange(url.replace("id",getId),
                HttpMethod.GET,
                null,
                Family.class);

        return exchange.getBody();
    }

}
