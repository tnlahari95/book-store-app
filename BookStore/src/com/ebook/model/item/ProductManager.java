package com.ebook.model.item;

//import java.util.List;
import java.util.Set;

import com.ebook.dal.ProductDAO;
//import com.ebook.model.item.Product;

//public class ProductManager implements IProductManager{
public class ProductManager implements IProductManager {
	
	
	private static ProductDAO productDAO = new ProductDAO();
	
	@Override
	public Set<Product> getAllProducts(){
        
           return productDAO.getAllProducts();
        
    }
    
	@Override
    public Product getProductById(String productId){
        
            return productDAO.getProductById(productId);     
    }
    
	@Override
    //void-no return-product object
    public Product AddProduct(String prodTitle, String prodDesc, double prodprice, String prodAuthor){
      /*  try{
          productDAO.AddProduct(prodTitle, prodDesc, prodprice);
        }catch (Exception ex){
            System.out.println("Product service:Threw an error adding a product.");
        }
        return product;		*/
    	
    	Product pm = productDAO.AddProduct(prodTitle, prodDesc, prodprice, prodAuthor);
    	
		
		return pm;
    }
	
	@Override
    //product object
    public void UpdateProduct(String productId, String prodTitle, String prodDesc, double prodprice, String prodAuthor){
      /*  try{
            productDAO.UpdateProduct(product);
        }catch (Exception ex){
            System.out.println("Product service:Threw an error updating a product.");
        }*/
    	productDAO.UpdateProduct(productId, prodTitle, prodDesc, prodprice, prodAuthor);
    	
    }
    
   //void-no return
    public void removeProduct(String productId){
    
            productDAO.removeProduct(productId);
    }
    
}

	/*@Override
	public void Add(Object object) {
		// TODO Auto-generated method stub
		productDAO.AddProduct((Product)object);
		
	}

	@Override
	public void Update(Object object) {
		// TODO Auto-generated method stub
		productDAO.UpdateProduct((Product)object);
		
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		productDAO.removeProduct((Product)object);
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		productDAO.getAllProducts();
	}
	
	@Override
	public void getById(Object objectid) {
		// TODO Auto-generated method stub
		productDAO.getProductById((String)objectid);
	}

}*/
    
    
