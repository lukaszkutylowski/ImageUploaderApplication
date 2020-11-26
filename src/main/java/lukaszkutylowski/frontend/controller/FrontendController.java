package lukaszkutylowski.frontend.controller;

import lukaszkutylowski.frontend.service.FrontendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendController {

    private FrontendService service;

    @Autowired
    public FrontendController(FrontendService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index() {
        return service.indexHtml();
    }

    @GetMapping("/upload_image")
    public String upload() {
        return service.uploadHtml();
    }
}
