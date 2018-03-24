package com.deal.servlet;

import com.deal.base.pojo.Category;
import com.deal.base.pojo.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Mahmoud.Marzouk
 */
public class ProductEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Product product = DbHandler.getProductDAO().retrieveProduct(Long.parseLong(request.getParameter("productIdField")));
//        product.setProductName(request.getParameter("productNameForEdit"));
//        product.setProductDesc(request.getParameter("productDescriptionForEdit"));
//        product.setProductPrice(Double.parseDouble(request.getParameter("productPriceForEdit")));
//        product.setAvailableQuantity(Integer.parseInt(request.getParameter("productQuantityForEdit")));
//        product.setProductCategory(DbHandler.getCategoryDAO()
//                                .retrieveCategory(Long.parseLong(request.getParameter("productCategoryFieldForEdit"))));
//        
//        DbHandler.getProductDAO().updateProduct(product);
        
        response.sendRedirect("/DealTime/administration");
    }
    
}
