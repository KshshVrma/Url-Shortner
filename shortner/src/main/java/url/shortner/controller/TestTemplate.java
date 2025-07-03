package url.shortner.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TestTemplate{
    RestTemplate restTemplate;
    public TestTemplate() {
        this.restTemplate = new RestTemplate();
    }
    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
