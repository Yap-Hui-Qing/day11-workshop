package vttp.batchb.ssf.day11_workshop.controllers;

import java.io.File;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// make this a request handler
@Controller
// handles the / resource
@RequestMapping(path = "/")

public class PictureController {
    
    // this method to handle GET /index.html
    @GetMapping("/index.html")
    public String getIndexPicture(Model model){
        // use the relative path to the static images folder
        String path = "src/main/resources/static/images";
        File directory = new File(path);
        File[] images = directory.listFiles();

        // check if images is null
        if (images == null || images.length == 0){
            model.addAttribute("imageName", "No images were found");
            return "error"; // error.html template if no images are available
        }

        Random random = new Random();
        int imageNumber = random.nextInt(images.length);
        
        // generate a random image
        String filename = "/images/" + images[imageNumber].getName();
        model.addAttribute("imagename", filename);
        return "index"; // return the appropriate template name here -- index.html
    }

    // this method to handle GET /
    // inject the model into the handler
    @GetMapping()
    public String getPicture(Model model){
        String path = "src/main/resources/static/images";
        File directory = new File(path);
        File[] images = directory.listFiles();

        Random random = new Random();
        int imageNumber = random.nextInt(images.length);
        
        // generate a random image
        String filename = "/images/" + images[imageNumber].getName();
        model.addAttribute("imagename", filename);

        return "index";
    }
}
