package url.shortner.Service;

import java.util.HashMap;

public class Store {
    HashMap<String, String> urlStore = new HashMap<>();

    private addToRedis redisService = addToRedis.getInstance();


    private String getUrl(String key){

        if(urlStore.containsKey(key)){
            return urlStore.get(key);
        } else {
            return "URL not found";
        }
    }
    public void addUrl(String key, String value){
        urlStore.put(key, value);
    }
    private void deleteUrl(String key){
        if(urlStore.containsKey(key)){
            urlStore.remove(key);
        } else {
            System.out.println("URL not found");
        }
    }
    private void updateUrl(String key, String newValue){
      if(urlStore.containsKey(key)){
            urlStore.put(key, newValue);
        } else {
            System.out.println("URL not found");
        }
    }
    private void displayUrls(){
        for (String key : urlStore.keySet()) {
            System.out.println("Key: " + key + ", Value: " + urlStore.get(key));
        }
    }
    public String getFromRedis(String key) {
        String value = redisService.getFromRedis(key);
        return value;

    }
    public String addToRed() {

        String response = redisService.addToRed(urlStore);
        return response;
    }

    public String deleteFromRedis(String key) {
        String response = redisService.deleteFromRedis(key);
        if(response.equals("Key deleted successfully")){
            deleteUrl(key);
        }
        return response;
    }



}
