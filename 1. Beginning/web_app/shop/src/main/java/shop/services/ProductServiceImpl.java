package shop.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shop.DTO.product.ProductCreateDTO;
import shop.DTO.product.ProductItemDTO;
import shop.entities.CategoryEntity;
import shop.entities.ProductEntity;
import shop.entities.ProductImageEntity;
import shop.interfaces.ProductService;
import shop.mapper.ProductMapper;
import shop.repositories.ProductImageRepository;
import shop.repositories.ProductRepository;
import shop.storage.StorageService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductImageRepository productImageRepository;
    private final StorageService storageService;
    private final ProductMapper productMapper;
    @Override
    public List<ProductItemDTO> get() {
        var products = productRepository.findAll();
        var result = new ArrayList<ProductItemDTO>();
        for(var p : products) {
            var item = productMapper.ProductItemDTOByProduct(p);
            for(var img : p.getProductImages())
                item.getFiles().add(img.getName());
            result.add(item);
        }
        return result;
    }
    @Override
    public ProductItemDTO create(ProductCreateDTO model) {
        var pe = new ProductEntity();
        var cat = new CategoryEntity();
        int priority = 1;
        cat.setId(model.getCategory_id());
        pe.setName(model.getName());
        pe.setDescription(model.getDescription());
        pe.setPrice(model.getPrice());
        pe.setDateCreated(new Date());
        pe.setCategory(cat);
        pe.setDelete(false);
        productRepository.save(pe);
        for(var img : model.getFiles()) {
            var file = storageService.saveMultipartFile(img);
            ProductImageEntity pi = new ProductImageEntity();
            pi.setName(file);
            pi.setDateCreated(new Date());
            pi.setPriority(priority);
            pi.setDelete(false);
            pi.setProduct(pe);
            productImageRepository.save(pi);
            priority++;
        }
        return null;
    }

}
