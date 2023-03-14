package shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import shop.DTO.product.ProductItemDTO;
import shop.entities.ProductEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.name", target = "category")
    ProductItemDTO ProductItemDTOByProduct(ProductEntity product);
}
