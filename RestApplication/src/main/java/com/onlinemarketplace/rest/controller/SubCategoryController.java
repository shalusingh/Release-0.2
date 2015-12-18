/**
 *
 */
package com.onlinemarketplace.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.datamanagement.service.ProductSubCategoryService;
import com.onlinemarketplace.dto.helper.SubCategoryDtoHelper;
import com.onlinemarketplace.rest.responce.Response;

/**
 * @author jitendra Dec 9, 2015 2015
 */

@Controller
@RequestMapping(value = "/subcategory")
public class SubCategoryController {

    @Autowired
    private ProductSubCategoryService subCategoryService;

    @Autowired
    private ProductCategoryService productCategoryService;

    private final SubCategoryDtoHelper categoryDtoHelper = new SubCategoryDtoHelper();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Response<ProductSubCategory> getAll() {
        Response<ProductSubCategory> response = null;
        List<ProductSubCategory> subCategories;
        try {
            subCategories = subCategoryService.getRepository().findAll();
            if (subCategories == null) {
                response = new Response<ProductSubCategory>(true, "Sub category is not found", 204);
            } else {
                response = new Response<ProductSubCategory>(true, subCategories.size()
                    + " sub category found", 200);
                response.setResult(categoryDtoHelper.serializeAll(subCategories));
            }
        } catch (Exception exception) {
            response = new Response<ProductSubCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<ProductSubCategory> get(@RequestParam("id") String id) {
        Response<ProductSubCategory> response = null;
        ProductSubCategory subCategory;
        try {
            if (id == null) {
                response = new Response<ProductSubCategory>(false, "Sub-Category id/name is not found.", 417);
            } else {
                if (NumberUtils.isNumber(id)) {
                    subCategory = subCategoryService.getRepository().findOne(Long.parseLong(id));
                } else {
                    subCategory = subCategoryService.getRepository().getByName(new String(id.toString()));
                }
                response = new Response<ProductSubCategory>(true, "Sub-Category found.", 200);
                response.setResult(subCategory);
            }
        } catch (Exception exception) {
            response = new Response<ProductSubCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }
        return response;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Response<ProductSubCategory> add(HttpServletRequest request) {
        Response<ProductSubCategory> response = null;
        ProductCategory productCategory;
        ProductSubCategory subCategory;
        String name = request.getParameter("name");
        Long catId = 0l;
        String id = request.getParameter("id");
        if (id != null
            && NumberUtils.isDigits(id)) {
            catId = NumberUtils.toLong(id);
        }

        try {
            if (StringUtils.isEmpty(name)) {
                response = new Response<ProductSubCategory>(false, "Sub-Category name is compulsory.", 202);
            } else {
                productCategory = productCategoryService.getRepository().getOne(catId);

                if (productCategory == null) {
                    response = new Response<ProductSubCategory>(false, "Invalid category.", 201);
                } else {
                    response = new Response<ProductSubCategory>(true, "sub-category successfully inserted", 200);

                    subCategory = new ProductSubCategory();
                    subCategory.setCategory(productCategory);
                    subCategory.setCategoryName(name);

                    subCategory = subCategoryService.getRepository().save(subCategory);

                    response.setResult(subCategory);
                }
            }
        } catch (Exception exception) {
            response = new Response<ProductSubCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }
        return response;
    }
}
