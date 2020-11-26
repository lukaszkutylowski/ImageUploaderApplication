package lukaszkutylowski.frontend.service;

import lukaszkutylowski.model.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontendService {

    public String indexHtml() {
        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<body>");
        builder.append("<h4>Image Uploader Application</h4>");
        builder.append("<div>");
        builder.append("<a href='/upload_image'><button style=\"width:200px\">Upload [Admin]</button></a>");
        builder.append("</div>");
        builder.append("<div>");
        builder.append("<a href='/gallery'><button style=\"width:200px\">Gallery [User]</button></a>");
        builder.append("</div>");
        builder.append("<div>");
        builder.append("<a href='/logout'><button style=\"width:200px\">Logout</button></a>");
        builder.append("</div>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

    public String uploadHtml() {
        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<body>");
        builder.append("<h4>Image Uploader Application</h4>");
        builder.append("<form action=\"http://localhost:8080/upload\" method=\"post\">");
        builder.append("<input name=\"path\" type=\"text\"/>");
        builder.append("<button type=\"submit\">Upload</button>");
        builder.append("</form>");
        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }

    public String galleryHtml(List<Image> list) {
        StringBuilder builder = new StringBuilder();

        builder.append("<html>");
        builder.append("<body>");

        for(Image i : list) {
            builder.append("<img src='" + i.getImageAddress() + "'/>");
        }

        builder.append("</body>");
        builder.append("</html>");

        return builder.toString();
    }
}
