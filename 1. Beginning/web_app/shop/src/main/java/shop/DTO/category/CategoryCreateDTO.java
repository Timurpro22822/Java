package shop.DTO.category;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CategoryCreateDTO {
    private String name;
    //private String base64;
    private String description;
    MultipartFile file;
}
