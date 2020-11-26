package lukaszkutylowski.api;

import lukaszkutylowski.frontend.service.FrontendService;
import lukaszkutylowski.service.ImageUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UploadController {

    private ImageUploader imageUploader;
    private FrontendService frontend;

    @Autowired
    public UploadController(ImageUploader imageUploader, FrontendService frontend) {
        this.imageUploader = imageUploader;
        this.frontend = frontend;
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("path") String path) {
        imageUploader.get(path);
        return frontend.indexHtml();
    }

}