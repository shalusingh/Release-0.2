/**
 *
 */
package com.onlinemarketplace.dto.domain;

/**
 * @author jitendra Dec 7, 2015 2015
 */
public class SubCategoryDto
    extends BaseDto {
    /**
     *
     */
    private static final long serialVersionUID = 7228419282442644911L;

    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime
            * result
            + ((categoryId == null)
                ? 0 : categoryId.hashCode());
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
        SubCategoryDto other = (SubCategoryDto) obj;
        if (categoryId == null) {
            if (other.categoryId != null)
                return false;
        } else
            if (!categoryId.equals(other.categoryId))
                return false;
        return true;
    }

    @Override
    public String toString() {
        return "SubCategory [categoryId="
            + categoryId + ",  Id=" + getId() + ", Name=" + getName() + "]";
    }

}
