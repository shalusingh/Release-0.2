/**
 *
 */
package com.onlinemarketplace.dataentity.builder;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.enums.Status;

/**
 * @author jitendra Dec 21, 2015 2015
 */
public class CategoryBuilder {

    private ProductCategory category;

    public CategoryBuilder(String categoryName) {
        this.category = new ProductCategory();
        this.category.setStatus(Status.ACTIVE);
        this.category.setCategoryName(categoryName);
    }

    public CategoryBuilder name(String name) {
        this.category.setCategoryName(name);
        return this;
    }

    public ProductCategory build() {
        return this.category;
    }

}
