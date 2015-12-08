/**
 *
 */
package com.onlinemarketplace.dto.domain;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class SubSubCategoryDto
    extends BaseDto {

    /**
    *
    */
    private static final long serialVersionUID = 1761815952394852746L;

    private Long categoryId;

    private Long subcategoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((categoryId == null)
                ? 0 : categoryId.hashCode());
        result = prime
            * result
            + ((subcategoryId == null)
                ? 0 : subcategoryId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubSubCategoryDto other = (SubSubCategoryDto) obj;
        if (categoryId == null) {
            if (other.categoryId != null)
                return false;
        } else
            if (!categoryId.equals(other.categoryId))
                return false;
        if (subcategoryId == null) {
            if (other.subcategoryId != null)
                return false;
        } else
            if (!subcategoryId.equals(other.subcategoryId))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "SubSubCategory [categoryId="
            + categoryId + ", subcategoryId=" + subcategoryId + "]";
    }

}
