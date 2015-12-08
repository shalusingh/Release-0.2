package com.onlinemarketplace.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.util.UriTemplate;

import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.dto.domain.ProductDto;
import com.onlinemarketplace.dto.helper.ProductDtoHelper;
import com.onlinemarketplace.exception.InvalidParameterException;
import com.onlinemarketplace.product.manager.CSVManager;
import com.onlinemarketplace.product.service.ProductNameIdMappingService;
import com.onlinemarketplace.product.service.ProductService;
import com.onlinemarketplace.rest.helper.ClassPathHealper;
import com.onlinemarketplace.rest.responce.Response;

/**
 * @author jitendra sagoriya
 *
 * @version
 *
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CSVManager manager;

    @SuppressWarnings("unused")
    @Autowired
    private ProductNameIdMappingService mappingService;

    @Autowired
    private WebApplicationContext applicationContext;

    private ProductDtoHelper productDtoHelper = new ProductDtoHelper();

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @Transactional
    public @ResponseBody Response<ProductDto> getAllProduct() {
        Response<ProductDto> response = new Response<ProductDto>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);

        try {

            List<Product> products = new ArrayList<Product>(service.getProduct().values());
            List<ProductDto> productDtos = productDtoHelper.serializeAll(products);
            Pagenation<ProductDto> pagenation = new Pagenation<ProductDto>(productDtos);
            response.setStatus(true);
            response.setResult(pagenation);
        } catch (Exception exception) {
            response.setException(exception);
            response.setStatus(false);
        }
        return response;
    }

    @RequestMapping(value = "/all/{pageNumber}/{productPerPage}", method = RequestMethod.GET)
    public @ResponseBody Response<ProductDto> getAllProductSortedAndPageing(
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {
        Response<ProductDto> response = new Response<ProductDto>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);

        try {
            Pagenation<Product> products = service.getSortedAndPagingProduct(null, pageNumber, productPerPage);

            response.setStatus(true);
            response.setResult(products);
        } catch (Exception exception) {
            response.setException(exception);
            response.setStatus(false);
        }
        return response;
    }

    @RequestMapping(value = "/category/{value}")
    public @ResponseBody Response<Product> getByCategory(@PathVariable("value") String value) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(value);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{value}/{pageNumber}/{productPerPage}", method = RequestMethod.GET)
    public @ResponseBody Response<Product> getByCategorySortedAndPaging(@PathVariable("value") String value,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {

        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        List<Product> products = service.getByCategory(value);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping("/{name}/**")
    public void foo(@PathVariable("id") int id, HttpServletRequest request) {
        String restOfTheUrl = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        /* We can use UriTemplate to map the restOfTheUrl */
        UriTemplate template = new UriTemplate("/{id}/{value}");
        boolean isTemplateMatched = template.matches(restOfTheUrl);
        if (isTemplateMatched) {
            Map<String, String> matchTemplate = new HashMap<String, String>();
            matchTemplate = template.match(restOfTheUrl);
            String value = matchTemplate.get("value");
            /* variable `value` will contain the required detail. */
            System.out.println(value);
        }
    }

    @RequestMapping("/{name}/{db}/display")
    public Response<Product> getById(@PathVariable("id") String name, @PathVariable boolean db) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        ProductNameIdMappingService.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        long id = ProductNameIdMappingService.getMapping().get(name);

        Product product = null;
        if (db) {
            product = repository.findOne(id);
        } else {
            product = service.getById(id);
        }

        if (product != null) {
            response.setStatus(true);
            response.setResult(product);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/subcategory/{value}")
    public @ResponseBody Response<Product> getBySubCategory(@PathVariable("value") String value) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getBySubCategory(value);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/subcategory/{value}/{pageNumber}/{productPerPage}", method = RequestMethod.GET)
    public @ResponseBody Response<Product> getBySubCategorySortedAndPaging(@PathVariable("value") String value,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {

        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        List<Product> products = service.getBySubCategory(value);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{category}/subcategory/{subcategory}")
    public @ResponseBody Response<Product> getByCategoryAndSubCategory(@PathVariable("category") String category,
        @PathVariable("subcategory") String subcategory) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getBySubCategory(products, subcategory);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{category}/subcategory/{subcategory}/{pageNumber}/{productPerPage}",
        method = RequestMethod.GET)
    public @ResponseBody Response<Product> getByCategoryAndSubCategorySortedAndPaging(
        @PathVariable("category") String category, @PathVariable("subcategory") String subcategory,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {

        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getBySubCategory(products, subcategory);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/price/{min}/{max}")
    public @ResponseBody Response<Product> getByPrice(@PathVariable("min") Long min, @PathVariable("max") Long max) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByPrice(min, max);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/price/{min}/{max}/{pageNumber}/{productPerPage}")
    public @ResponseBody Response<Product> getByPrice(@PathVariable("min") Long min, @PathVariable("max") Long max,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByPrice(min, max);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/{name}/{value}", method = RequestMethod.GET)
    public @ResponseBody Response<Product> getByProperty(@PathVariable("name") String name,
        @PathVariable("value") String value) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByPropertyNameAndValue(name, value);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{category}/price/{min}/{max}")
    public @ResponseBody Response<Product> getByCategoryAndPrice(@PathVariable("category") String category,
        @PathVariable("min") Long min, @PathVariable("max") Long max) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{category}/price/{min}/{max}/{pageNumber}/{productPerPage}")
    public @ResponseBody Response<Product> getByCategoryAndPrice(@PathVariable("category") String category,
        @PathVariable("min") Long min, @PathVariable("max") Long max, @PathVariable("pageNumber") int pageNumber,
        @PathVariable("productPerPage") int productPerPage) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/subcategory/{subcategory}/price/{min}/{max}")
    public @ResponseBody Response<Product> getBySubCategoryAndPrice(@PathVariable("subcategory") String category,
        @PathVariable("min") Long min, @PathVariable("max") Long max) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getBySubCategory(category);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/subcategory/{subcategory}/price/{min}/{max}/{pageNumber}/{productPerPage}")
    public @ResponseBody Response<Product> getBySubCategoryAndPrice(@PathVariable("subcategory") String subCategory,
        @PathVariable("min") Long min, @PathVariable("max") Long max, @PathVariable("pageNumber") int pageNumber,
        @PathVariable("productPerPage") int productPerPage) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getBySubCategory(subCategory);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/category/{category}/subcategory/{subcategory}/price/{min}/{max}")
    public @ResponseBody Response<Product> getByCategorySubCategoryAndPrice(@PathVariable("category") String category,
        @PathVariable("subcategory") String subcategory, @PathVariable("min") Long min,
        @PathVariable("max") Long max) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getBySubCategory(products, subcategory);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = new Pagenation<Product>(products);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/subcategory/{category}/price/{min}/{max}/{pageNumber}/{productPerPage}")
    public @ResponseBody Response<Product> getByCategorySubCategoryAndPrice(@PathVariable("category") String category,
        @PathVariable("subcategory") String subCategory, @PathVariable("min") Long min, @PathVariable("max") Long max,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));

        service.setRepository(repository);
        List<Product> products = service.getByCategory(category);
        products = service.getBySubCategory(products, subCategory);
        products = service.getByPrice(products, min, max);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Pagenation<Product> getBySearch(HttpServletRequest request) {
        String queryString = request.getQueryString();
        Pagenation<Product> pagenation = null;
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        try {
            pagenation = service.search(queryString);
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
        return pagenation;
    }

    @RequestMapping(value = "/status/{value}/{pageNumber}/{productPerPage}", method = RequestMethod.GET)
    public @ResponseBody Response<Product> getByStatusSortedAndPaging(@PathVariable("value") String value,
        @PathVariable("pageNumber") int pageNumber, @PathVariable("productPerPage") int productPerPage) {

        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        List<Product> products = service.getByStatus(value);
        Pagenation<Product> pagenation = service.getSortedAndPagingProduct(products, pageNumber, productPerPage);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(pagenation);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/status/{value}/{}", method = RequestMethod.GET)
    public @ResponseBody Response<Product> getByStatus(@PathVariable("value") String value) {
        Response<Product> response = new Response<Product>();
        service.setFile(ClassPathHealper.getClassPathFile("product.csv", applicationContext));
        service.setRepository(repository);
        List<Product> products = service.getByStatus(value);
        if (!products.isEmpty()) {
            response.setStatus(true);
            response.setResult(products);
        } else {
            response.setStatus(false);
            response.setMessage("No product found..");
        }
        return response;
    }

    @RequestMapping(value = "/reload", method = RequestMethod.POST)
    public @ResponseBody void writeCsvFile() {

    }

}
