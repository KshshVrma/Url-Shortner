package url.shortner.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.System.in;

@RestController
@RequestMapping("hello")
public class Controller {

    @GetMapping("getworld")
    String fun(){
        return "hello world";
    }

    @GetMapping("geturl")
    String getUrl(@RequestParam("url") String input){
        String temp="";
        for(int i=0;i<5;i++){
            temp+="wow-";
        }
        return temp;

    }
//    curl -X POST -H "Content-Type: application/json" -d "{\"key1\":\"value1\", \"key2\":\"value2\"}" http://localhost:8080/hello/addurl
    @PostMapping("addurl")
    String addurl(@RequestBody Map<String,String> k){
        int count=0;
        String ans="";
        for(Map.Entry<String,String> p : k.entrySet()){

                ans+=p.getKey();
                ans+="|";
                ans+=p.getValue();
            }

        return ans;
    }



}
