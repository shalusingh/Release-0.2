/**
 *
 */
package com.onlinemarketplace.dto.helper;

import java.util.List;

import com.onlinemarketplace.dataentity.domain.SubSubCategory;
import com.onlinemarketplace.dto.domain.SubSubCategoryDto;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class SubSubCategoryDtoHelper
    extends DTOHelperBase<SubSubCategory, SubSubCategoryDto> {

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serialize(java.lang.Object)
     */
    @Override
    public SubSubCategoryDto serialize(SubSubCategory base) throws NullPointerException {
        SubSubCategoryDto subSubCategoryDto = new SubSubCategoryDto();

        if (base == null)
            throw new NullPointerException("Sub-Sub Category is null");

        subSubCategoryDto.setCategoryId(base.getId());
        subSubCategoryDto.setName(base.getCategoryName());

        return subSubCategoryDto;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerialize(java.lang.Object)
     */
    @Override
    public SubSubCategory deSerialize(SubSubCategoryDto dto) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#serializeAll(java.util.List)
     */
    @Override
    public List<SubSubCategoryDto> serializeAll(List<SubSubCategory> bases) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.onlinemarketplace.dto.helper.DTOHelperBase#deSerializeAll(java.util.List)
     */
    @Override
    public List<SubSubCategory> deSerializeAll(List<SubSubCategoryDto> dtos) throws NullPointerException {
        // TODO Auto-generated method stub
        return null;
    }

}
