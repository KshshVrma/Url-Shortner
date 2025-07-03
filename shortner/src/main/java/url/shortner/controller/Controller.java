package url.shortner.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import url.shortner.Service.Store;

import java.io.IOException;
import java.util.Map;

import static java.lang.System.in;

@RestController
@RequestMapping("hello")
public class Controller {
    Store store=new Store();
    @Autowired
    TestTemplate testTemplate;

    @GetMapping("getworld")
    String fun(){
        return "hello world";
    }

    @GetMapping("geturl")
    String getUrl(@RequestParam("url") String input){
        String temp="";
        if(input==null || input.isEmpty()){
            return "Please provide a valid URL";
        }else{
            temp = store.getFromRedis(input);
            if(temp.equals("URL not found")){
                return "URL not found in the store";
            }
        }
        return temp;

    }
//    curl -X POST -H "Content-Type: application/json" -d "{\"key1\":\"value1\", \"key2\":\"value2\"}" http://localhost:8080/hello/addurl
    @PostMapping("addurl")
    String addurl(@RequestBody Map<String,String> k){
        int count=0;
        String ans="";
        for(Map.Entry<String,String> p : k.entrySet()){
store.addUrl(p.getKey(), p.getValue());
            }
        ans=store.addToRed();

        return ans;
    }

    @DeleteMapping("deleteurl")
    String deleteUrl(@RequestParam("url") String input){
        if(input==null || input.isEmpty()){
            return "Please provide a valid URL";
        }
        String ans=store.deleteFromRedis(input);
        return ans;
    }

    @GetMapping("request")
    String redirect(@RequestParam("url") String input) {
        if (input == null || input.isEmpty()) {
            return "Please provide a valid URL";
        }
        String temp = store.getFromRedis(input);
        if (temp.equals("URL not found")) {
            return "URL not found in the store";
        }
        return testTemplate.get(temp);
    }
    @GetMapping("redirect")
    void redirect(@RequestParam("url") String input, HttpServletResponse response) throws IOException, IOException {
        if (input == null || input.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please provide a valid URL");
            return;
        }
        String temp = store.getFromRedis(input);
        if (temp.equals("URL not found")) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "URL not found in the store");
            return;
        }
        response.sendRedirect(temp); // Redirect to the URL stored in temp
    }


}
