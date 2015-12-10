/**
 *
 */
package com.onlinemarketplace.dto.helper;

import java.util.ArrayList;
import java.util.List;

import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.dto.domain.SubCategoryDto;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class SubCategoryDtoHelper
    extends DTOHelperBase<ProductSubCategory, SubCategoryDto> {

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serialize(java.lang.Object)
     */
    @Override
    public SubCategoryDto serialize(ProductSubCategory base) throws NullPointerException {
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        if (base == null)
            throw new NullPointerException("Sub-Category is null.");

        subCategoryDto.setCategoryId(base.getCategory().getId());
        subCategoryDto.setName(base.getCategoryName());
        subCategoryDto.setId(base.getId());
        return subCategoryDto;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerialize(java.lang.Object)
     */
    @Override
    public ProductSubCategory deSerialize(SubCategoryDto dto) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serializeAll(java.util.List)
     */
    @Override
    public List<SubCategoryDto> serializeAll(List<ProductSubCategory> bases) throws NullPointerException {
        List<SubCategoryDto> subCategoryDtos = new ArrayList<SubCategoryDto>();
        if (bases == null)
            throw new NullPointerException("List of sub-category is null or empty.");
        for (ProductSubCategory productSubCategory : bases) {
            subCategoryDtos.add(serialize(productSubCategory));
        }
        return subCategoryDtos;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerializeAll(java.util.List)
     */
    @Override
    public List<ProductSubCategory> deSerializeAll(List<SubCategoryDto> dtos) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

}
