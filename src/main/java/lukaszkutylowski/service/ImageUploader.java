package lukaszkutylowski.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lukaszkutylowski.model.Image;
import lukaszkutylowski.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageUploader {

    private Cloudinary cloudinary;
    private ImageRepo imageRepo;

    @Autowired
    public ImageUploader(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;

        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dj2vinf28",
                "api_key", "118613721751983",
                "api_secret", "CXxvtP9CPZuNAZunJaBnMSvQyuU"
        ));
    }

    //"C:\\Users\\Łukasz\\IdeaProjects\\springboot-image-uploader\\images\\image3.jpg"

    public String get(String path) {
        File file = new File(path);
        Map uploadResult = null;

        try {
            uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            imageRepo.save(new Image(uploadResult.get("url").toString()));
        } catch (IOException e) {
            //
        }
        return uploadResult.get("url").toString();
    }

}
