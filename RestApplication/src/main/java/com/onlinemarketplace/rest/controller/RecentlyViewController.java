package com.onlinemarketplace.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.onlinemarketplace.dataentity.domain.Customer;
import com.onlinemarketplace.dataentity.domain.Product;
import com.onlinemarketplace.dataentity.domain.RecntlyView;
import com.onlinemarketplace.datamanagement.repository.ProductRepository;
import com.onlinemarketplace.datamanagement.repository.RecntlyViewRepository;
import com.onlinemarketplace.product.service.ProductService;
import com.onlinemarketplace.rest.responce.Response;

@Controller
@RequestMapping("/rview")
public class RecentlyViewController {

    @Autowired
    private RecntlyViewRepository recntlyViewRepository;

    @Autowired
    ProductService service;

    @Autowired
    ProductRepository repository;

    String cookieName = "CODE24*#$KO";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Response<Product> get(HttpSession session, HttpServletRequest request) {
        Response<Product> response = new Response<Product>();
        List<RecntlyView> recentlyViews = null;
        List<Product> products = new ArrayList<Product>();
        List<Long> ids = new ArrayList<Long>();
        Customer customer = null;
        String value = "";
        if (session.getAttribute("customer") != null) {
            customer = (Customer) session.getAttribute("customer");
        }

        try {
            if (customer != null) {
                recentlyViews = recntlyViewRepository.getByCustomerId(customer.getId());
                if (recentlyViews != null
                    && !recentlyViews.isEmpty()) {
                    for (RecntlyView recntlyView : recentlyViews) {
                        if (recntlyView != null)
                            ids.add(recntlyView.getProductId());
                    }
                }

            } else {
                System.out.println("Customer is not found");
                Cookie[] cookies = request.getCookies();
                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equalsIgnoreCase(cookieName)) {
                            value = cookie.getValue();
                            break;
                        }
                    }
                    System.out.println(value
                        + " : " + cookieName);
                }
                if (value != null
                    && !value.isEmpty()) {
                    String[] productIds = value.split("~");
                    for (String string : productIds) {
                        if (StringUtils.isNumeric(string)) {
                            ids.add(Long.parseLong(string));
                        }
                    }
                }
            }

            int icounter = 1;
            for (Long long1 : ids) {
                if (icounter == 10)
                    break;
                products.add(service.getById(long1));
                icounter++;
            }
            response.setStatus(true);
            response.setMessage("Successfully get wishlist");
            response.setResult(products);
        } catch (Exception exception) {
            response.setStatus(false);
            response.setException(exception);
        }
        return response;

    }

    @RequestMapping(value = "/add/{pId}", method = RequestMethod.POST)
    public @ResponseBody Response<RecntlyView> add(HttpServletRequest request, HttpServletResponse servletResponse,
        @PathVariable("pId") long productId, HttpSession session) {
        Response<RecntlyView> response = new Response<RecntlyView>();

        Customer customer = null;

        if (session.getAttribute("customer") != null) {
            customer = (Customer) session.getAttribute("customer");
        }

        Cookie[] cookies = request.getCookies();

        String value = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase(cookieName)) {
                    value = cookie.getValue();
                    break;
                }
            }
            System.out.println(value
                + " : " + cookieName);
            value = productId
                + "~" + value;
        } else {
            value = productId
                + "";
        }

        if (customer != null) {
            cookieName = cookieName
                + customer.getId();
            RecntlyView recntlyView = new RecntlyView();
            recntlyView.setCustomerId(customer.getId());
            recntlyView.setProductId(productId);
            recntlyViewRepository.save(recntlyView);
        }

        Cookie cookie = new Cookie(cookieName, value);
        cookie.setMaxAge(1000000000);
        cookie.setDomain("http://localhost:8080/");
        servletResponse.addCookie(cookie);
        return response;

    }

}
