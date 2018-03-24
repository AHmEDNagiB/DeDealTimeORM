package com.deal.servlet;

import com.deal.base.pojo.Category;
import com.deal.base.pojo.Product;
import com.deal.control.DbHandler;
import java.io.File;
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

public class ProductManage extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // post for new product insertion
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        String productName = request.getParameter("productName");
        String productDesc = request.getParameter("productDescription");
        System.out.println(request.getParameter("productName"));
        int price = Integer.parseInt(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("productQuantity"));
        System.out.println(request.getParameter("productCategoryField"));
        Category category = DbHandler.getCategoryDAO()
                .retrieveCategory(Long.parseLong(request.getParameter("productCategoryField")));
         */
        //String productImgFileName = request.getParameter("pic");
        
        Product product = new Product();

        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        List<FileItem> items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            ex.printStackTrace();
        }
        if (items != null) {
            Iterator<FileItem> itr = items.iterator();
          /*  while (itr.hasNext()) {
                FileItem item = itr.next();
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "productName":
                            product.setProductName(item.getString());
                            break;
                        case "productDescription":
                            product.setProductDesc(item.getString());
                            break;
                        case "productPrice":
                            product.setProductPrice(Double.parseDouble(item.getString()));
                            break;
                        case "productQuantity":
                            product.setAvailableQuantity(Integer.parseInt(item.getString()));
                            break;
                        case "productCategoryField":
                            System.out.println(item.getString());
                            Category category = DbHandler.getCategoryDAO()
                                .retrieveCategory(Long.parseLong(item.getString()));
                            product.setProductCategory(category);
                    }
                } else {
                    System.out.println("file founded in request");
                    try {
                        product.setProductImageFileName(item.getName());
                        String filesStorageUrl = getServletContext().getRealPath("/res/products_images") + "/" + item.getName();
                        File file = new File(filesStorageUrl);
                        item.write(file);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }*/
        }
        
        String resultProductId = DbHandler.getProductDAO().insertProduct(product);
        
        //response.getWriter().write(resultProductId);
        response.sendRedirect("/DealTime/administration");
    }

}
