package shop.interfaces;

import shop.DTO.product.ProductCreateDTO;
import shop.DTO.product.ProductEditDTO;
import shop.DTO.product.ProductItemDTO;

import java.util.List;

public interface ProductService {
    ProductItemDTO create(ProductCreateDTO model);
    List<ProductItemDTO> get();
    ProductItemDTO edit(int id, ProductEditDTO model);
    ProductItemDTO getById(int id);
    void delete(int id);
}
