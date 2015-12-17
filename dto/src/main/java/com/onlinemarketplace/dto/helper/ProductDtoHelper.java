/**
 *
 */
package com.onlinemarketplace.dto.helper;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductProperty;
import com.onlinemarketplace.dto.domain.ProductDto;

/**
 * @author jitendra Dec 7, 2015 2015
 */
@Transactional
public class ProductDtoHelper
    extends DTOHelperBase<Product, ProductDto> {

    private static final Logger logger = LoggerFactory.getLogger(ProductDtoHelper.class);

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serialize(java.lang.Object)
     */
    @Override
    public ProductDto serialize(Product product) throws NullPointerException {
        ProductDto productDto = new ProductDto();

        if (product == null)
            throw new NullPointerException("Product is null");

        productDto.setName(product.getName());

        if (!StringUtils.isEmpty(product.getAvailableDate()))
            productDto.setAvailableDate(product.getAvailableDate());

        productDto.setCastPrice(product.getCastPrice());

        productDto.setId(product.getId());
        productDto.setListingPrice(product.getListingPrice());
        // productDto.setOffer( );

        productDto.setPreOrderStatus(product.isPreOrderStatus());

        productDto.setPrice(product.getPrice());
        if (product.getProductPriority() != null)
            productDto.setPriority(product.getProductPriority().id);

        productDto.setProductCode(product.getProductCode());
        // product.setProductProperty(productProperty);
        if (product.getQuantity() != null)
            productDto.setQuantity(product.getQuantity());
        else
            productDto.setQuantity(1);

        productDto.setSubCategory(new SubCategoryDtoHelper().serialize(product.getProductSubCategory()));

        productDto.setCategory(new CategoryDtoHelper().serialize(product.getProductCategory()));

        if (product.getSubSubCategory() != null)
            productDto.setSubSubCategory(new SubSubCategoryDtoHelper().serialize(product.getSubSubCategory()));

        return productDto;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerialize(java.lang.Object)
     */
    @Override
    public Product deSerialize(ProductDto dto) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serializeAll(java.util.List)
     */
    @Override
    public List<ProductDto> serializeAll(List<Product> bases) throws NullPointerException {

        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        ProductDto productDto;
        int iParsingError = 0;
        if (bases == null)
            throw new NullPointerException("List of bases of is null or empty.");

        for (Product product : bases) {
            try {
                productDto = new ProductDto();
                productDto = serialize(product);
                productDtos.add(productDto);
            } catch (Exception e) {

                iParsingError++;
                logger.error(iParsingError
                    + " object are unable to parse.", e);
            }
        }

        if (iParsingError == 0) {
            logger.error(iParsingError
                + " object are unable to parse.");
        }

        return productDtos;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerializeAll(java.util.List)
     */
    @Override
    public List<Product> deSerializeAll(List<ProductDto> dtos) throws NullPointerException {
        List<Product> products = new ArrayList<Product>();
        Product product;
        int iParsingError = 0;
        if (dtos == null)
            throw new NullPointerException("List of Dto's of is null or empty.");

        for (ProductDto productDto : dtos) {
            try {
                product = new Product();
                product = deSerialize(productDto);

                products.add(product);

            } catch (Exception e) {
                iParsingError++;
            }

        }

        if (iParsingError == 0) {
            logger.error(iParsingError
                + " object are unable to parse.");
        }
        return products;
    }

    public Map<String, String> convertIntoProprtyName(List<ProductProperty> properties) {
        Map<String, String> propertyMap = new Hashtable<String, String>();

        return propertyMap;

    }

}
