/**
 *
 */
package com.onlinemarketplace.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinemarketplace.dataentity.builder.CategoryBuilder;
import com.onlinemarketplace.dataentity.domain.ProductCategory;
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
    public @ResponseBody Response<ProductCategory> getAll(HttpServletResponse httpServletResponse) {
        Response<ProductCategory> response = new Response<ProductCategory>();
        try {
            List<ProductCategory> categories = categoryService.getRepository().findAll();
            response.setMessage("Successfull get all category");
            response.setStatus(true);
            response.setResult(categoryDtoHelper.serializeAll(categories));
            httpServletResponse.setStatus(HttpStatus.OK.value());

        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), 500);
            response.setException(exception);
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return response;

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Response<ProductCategory> get(@RequestParam("id") String id,
        HttpServletResponse httpServletResponse) {
        Response<ProductCategory> response = new Response<ProductCategory>();
        try {
            if (id == null) {
                response = new Response<ProductCategory>(false, "Category id/name is not found.",
                    HttpStatus.PARTIAL_CONTENT.value());
                httpServletResponse.setStatus(HttpStatus.PARTIAL_CONTENT.value());
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
            response = new Response<ProductCategory>(false, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
                .value());
            response.setException(exception);
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

        return response;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Response<ProductCategory> add(HttpServletRequest request,
        HttpServletResponse httpServletResponse) {
        ProductCategory category = new ProductCategory();
        Response<ProductCategory> response = null;
        String name = request.getParameter("name");
        try {
            if (StringUtils.isBlank(name)) {
                response = new Response<ProductCategory>(false, "Category name is compulsory.", 202);
                httpServletResponse.setStatus(HttpStatus.PARTIAL_CONTENT.value());
            } else {
                response = new Response<ProductCategory>(true, "Successful insert cotegory.", HttpStatus.OK.value());
                category = new CategoryBuilder(name).build();

                category = categoryService.getRepository().save(category);

                response.setResult(category);
                httpServletResponse.setStatus(HttpStatus.OK.value());

            }
        } catch (Exception exception) {
            response = new Response<ProductCategory>(false, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
                .value());
            httpServletResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setException(exception);
        }
        return response;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody Response<ProductCategory> update(HttpServletRequest request,
        HttpServletResponse httpServletResponse) {
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
