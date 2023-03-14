package shop.interfaces;

import shop.DTO.product.ProductCreateDTO;
import shop.DTO.product.ProductItemDTO;

import java.util.List;

public interface ProductService {
    ProductItemDTO create(ProductCreateDTO model);
    List<ProductItemDTO> get();
}
