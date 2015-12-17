/**
 *
 */
package com.onlinemarketplace.dto.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dto.domain.CategoryDto;

/**
 * @author jitendra Dec 7, 2015 2015
 */
@Transactional
public class CategoryDtoHelper
    extends DTOHelperBase<ProductCategory, CategoryDto> {

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serialize(java.lang.Object)
     */
    @Override
    public CategoryDto serialize(ProductCategory base) throws NullPointerException {
        CategoryDto categoryDto = new CategoryDto();
        if (base == null)
            throw new NullPointerException("Product category is null.");

        categoryDto.setName(base.getCategoryName());
        categoryDto.setId(base.getId());

        return categoryDto;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerialize(java.lang.Object)
     */
    @Override
    public ProductCategory deSerialize(CategoryDto dto) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serializeAll(java.util.List)
     */
    @Override
    public List<CategoryDto> serializeAll(List<ProductCategory> bases) throws NullPointerException {
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
        if (bases == null) {
            throw new NullPointerException("No Category is found or null.");
        } else {
            for (ProductCategory productCategory : bases) {
                categoryDtos.add(serialize(productCategory));
            }
        }
        return categoryDtos;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerializeAll(java.util.List)
     */
    @Override
    public List<ProductCategory> deSerializeAll(List<CategoryDto> dtos) throws NullPointerException {
        if (dtos == null)
            throw new NullPointerException("No Category is found or null.");
        return null;
    }

}
