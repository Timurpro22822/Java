package shop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import shop.DTO.category.CategoryCreateDTO;
import shop.DTO.category.CategoryItemDTO;
import shop.entities.CategoryEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "image", ignore = true)
    CategoryEntity CategoryByCreateDTO(CategoryCreateDTO dto);

    CategoryItemDTO CategoryItemByCategory(CategoryEntity entity);
    List<CategoryItemDTO> CategoryItemsByCategories(List<CategoryEntity> entities);
}
