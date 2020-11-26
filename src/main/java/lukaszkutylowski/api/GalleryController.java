package lukaszkutylowski.api;

import lukaszkutylowski.frontend.service.FrontendService;
import lukaszkutylowski.model.Image;
import lukaszkutylowski.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class GalleryController {

    private ImageRepo imageRepo;
    private FrontendService frontend;

    @Autowired
    public GalleryController(ImageRepo imageRepo, FrontendService frontend) {
        this.imageRepo = imageRepo;
        this.frontend = frontend;
    }

    @GetMapping("/gallery")
    public String getAll() {
        List<Image> list = imageRepo.findAll();
        return frontend.galleryHtml(list);
   }
}
