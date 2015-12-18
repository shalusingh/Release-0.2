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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.datamanagement.service.ProductCategoryService;
import com.onlinemarketplace.dto.helper.CategoryDtoHelper;
import com.onlinemarketplace.rest.responce.Response;

/**
 * @author jitendra Dec 9, 2015 2015
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ProductCategoryService categoryService;

    private CategoryDtoHelper categoryDtoHelper = new CategoryDtoHelper();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Response<ProductCategory> getAll() {
        Response<ProductCategory> response = new Response<ProductCategory>();
        try {
            List<ProductCategory> categories = categoryService.getRepository().findAll();
            response.setMessage("Successfull get all category");
            response.setStatus(true);
            response.setResult(categoryDtoHelper.serializeAll(categories));

        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }

        return response;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<ProductCategory> get(@RequestParam("id") String id) {
        Response<ProductCategory> response = new Response<ProductCategory>();
        try {
            if (id == null) {
                response = new Response<ProductCategory>(false, "Category id/name is not found.", 417);
            } else {
                ProductCategory categorie;
                if (NumberUtils.isNumber(id)) {
                    categorie = categoryService.getRepository().findOne(Long.parseLong(id));
                } else {
                    categorie = categoryService.getRepository().getByName(new String(id.toString()));
                }

                response.setMessage("Successfull get all category");
                response.setStatus(true);
                response.setResult(categoryDtoHelper.serialize(categorie));
            }

        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }

        return response;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Response<ProductCategory> add(HttpServletRequest request) {
        ProductCategory category = new ProductCategory();
        Response<ProductCategory> response = null;
        String name = request.getParameter("name");
        try {
            if (StringUtils.isBlank(name)) {
                response = new Response<ProductCategory>(false, "Category name is compulsory.", 202);
            } else {
                response = new Response<ProductCategory>(true, "Successful insert cotegory.", 200);
                category.setCategoryName(name);
                category.setStatus(Status.ACTIVE);

                category = categoryService.getRepository().save(category);

                response.setResult(category);

            }
        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody Response<ProductCategory> update(HttpServletRequest request) {
        Response<ProductCategory> response = null;
        ProductCategory category = new ProductCategory();
        try {

        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
        }
        return response;

    }

}
