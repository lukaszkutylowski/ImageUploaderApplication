package lukaszkutylowski.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imageAddress;

    public Image(){}

    public Image(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public Long getId() {
        return id;
    }

    public String getImageAddress() {
        return imageAddress;
    }
}
