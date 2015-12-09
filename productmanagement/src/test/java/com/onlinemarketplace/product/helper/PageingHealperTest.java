package com.onlinemarketplace.product.helper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.onlinemarketplace.dataentity.constants.ProductConstants;
import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.ProductCategory;
import com.onlinemarketplace.dataentity.domain.ProductSubCategory;
import com.onlinemarketplace.dataentity.domain.SubSubCategory;
import com.onlinemarketplace.dataentity.dto.Pagenation;
import com.onlinemarketplace.dataentity.enums.ProductStatus;
import com.onlinemarketplace.dataentity.enums.Status;
import com.onlinemarketplace.dto.domain.ProductDto;
import com.onlinemarketplace.dto.helper.ProductDtoHelper;
import com.onlinemarketplace.exception.InvalidParameterException;

public class PageingHealperTest {

    @Test
    public void pagingCounters() {
        int[] values = PageingHelper.pagingCounters(10, 3, 26);
        System.out.println(values[ProductConstants.START]);
        System.out.println(values[ProductConstants.END]);
        System.out.println(values[ProductConstants.NOPAGE]);
    }

    @Test
    public void queryString() {
        Map<String, String> resultMap = null;
        try {
            resultMap = PageingHelper.getMap("jitendra/sagoriya/shalu/singh");
            Assert.assertEquals(2, resultMap.size());
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryStringWithHash() {
        Map<String, String> resultMap = null;
        try {
            resultMap = PageingHelper.getMap("jitendra/sagoriya/");
            Assert.assertEquals(1, resultMap.size());
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getParam() {
        Map<String, String> resultMap = null;
        try {
            resultMap = PageingHelper.getParam(
                "category/RACING/subcategory/CAR/price/2500/3000/property/INSTOCK/TRUE/PUBLISHER/EASPORT");
            Assert.assertEquals(2, resultMap.size());
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getParamException() {
        Map<String, String> resultMap = null;
        try {
            resultMap = PageingHelper.getParam(
                "category/RACING/subcategory/CAR/price/2500/3000/properties/INSTOCK/TRUE/PUBLISHER/EASPORT");
            Assert.assertEquals(2, resultMap.size());
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryStringExceptionOnlyOneParam() {
        try {
            PageingHelper.getMap("jitendra");

        } catch (InvalidParameterException e) {
            Assert.assertEquals(InvalidParameterException.class, e.getClass());
        }
    }

    @Test
    public void queryStringException() {
        try {
            PageingHelper.getMap("jitendra/sagoriya/shalu");

        } catch (InvalidParameterException e) {
            Assert.assertEquals(InvalidParameterException.class, e.getClass());
        }
    }

    @Test
    public void convertDto() {
        List<Product> products = new ArrayList<Product>();
        products.add(getProduct());

        Pagenation<Product> pagenation = new Pagenation<Product>();
        pagenation.setiCount(1);
        pagenation.setiEnd(1);
        pagenation.setiPageNo(1);
        pagenation.setiPageSize(1);
        pagenation.setiStart(1);
        pagenation.setResult(products);

        @SuppressWarnings("unchecked")
        Pagenation<ProductDto> pagenation2 = PageingHelper.convertDto(new ProductDtoHelper(), pagenation);

        System.out.println(pagenation2);
        Assert.assertNotNull(pagenation2);
        Assert.assertNotNull(pagenation2.getResult());

    }

    public Product getProduct() {
        Product product = new Product();
        ProductCategory category = new ProductCategory();
        ProductSubCategory subCategory = new ProductSubCategory();

        SubSubCategory subSubCategory = new SubSubCategory();
        /* --------------------------------------------------------- */
        subSubCategory.setCategoryName("SubSubCategory");
        subSubCategory.setSubCategory(subCategory);
        subSubCategory.setId(2L);
        /* ---------------------------------------------------------- */
        subCategory.setCategoryName("subcategory");
        subCategory.setCategory(category);
        subCategory.setId(3l);

        /* --------------------------------------------------------- */

        category.setCategoryName("categoryName");
        category.setId(1l);
        category.setStatus(Status.ACTIVE);

        product.setAvailableDate(new Timestamp(System.currentTimeMillis()));
        product.setCastPrice(122F);
        product.setListingPrice(140f);
        product.setName("New Product");
        product.setPreOrderStatus(true);
        product.setPrice(125f);
        product.setProductCategory(category);
        product.setProductCode("CODE12");
        product.setQuantity(1);
        product.setProductSubCategory(subCategory);
        product.setSubSubCategory(subSubCategory);
        product.setStatus(ProductStatus.ACTIVE);

        return product;
    }

}
