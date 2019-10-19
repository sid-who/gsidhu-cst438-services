//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

//Remember to annotate what type of class this is!
@Service
public class ProductService
{
    //We need to autowire the database here. If you are stuck, look at ProductController!
    @Autowired
    ProductRepository productRepository;

    List<Product> hardList = new ArrayList<>();
    Product p1 = new Product("1", "HC Product 1", "Test Value 1", "Temp URL", 30, 1);
    Product p2 = new Product("2", "HC Product 2", "Test Value 2", "Temp URL", 35, 2);
    Product p3 = new Product("3", "HC Product 3", "Test Value 3", "Temp URL", 40, 3);
    Product p4 = new Product("4", "HC Product 4", "Test Value 4", "Temp URL", 45, 4);
    

    public Iterable<String> example()
    {
        List<String> sList = new ArrayList<>();
        sList.add("Cameron is such a good TA, i'm going to give him 5 stars on every review!");
        return sList;
    }

	public List getProductById(String id) {
        
        if(hardList.size() < 4)
        {
            hardList.add(p1);
            hardList.add(p2);
            hardList.add(p3);
            hardList.add(p4);
        }

        String here = id;
        //System.out.println(id);

        int i=0;
        List<Product> slist = new ArrayList<>();
        //slist.clear();
        boolean isHere = false;
        while(i<hardList.size())
        {
            if((hardList.get(i).getId()).equals(here))//here.equals("3"))//here == "3")//hardList.get(i).getId() == here)
            {
                isHere = true;
                Product temp = new Product();
                temp = hardList.get(i);
                slist.add(temp);
                return slist;
                //break;
            }
            else
            {
                i++;
            }
        }
        if(isHere == true)
        {
            //Product temp = hardList.get(i);
            //slist.add(temp);
            //return slist;
        }
        /*else
        {
            return null;
        }*/
        //return slist;
        return slist;
        

        //This return will be correct for the mongodb, so save it.
        //return productRepository.findById(id);
	}

	public List getAllProducts() {

        if(hardList.size() < 4)
        {
            hardList.add(p1);
            hardList.add(p2);
            hardList.add(p3);
            hardList.add(p4);
        }
        /*List<String> getAll = new ArrayList<>();
        getAll.add("Get all products is working");
        return getAll;*/

        //This return will be correct for the mongodb, so save it.
        //return productRepository.findAllById(id);
        return hardList;
	}
	/*public void save(Product products) {
	}*/

	public void save(Product products) {
        Product temp = new Product();
        temp.setId(products.getId());
        temp.setName(products.getName());
        temp.setDescription(products.getDescription());
        temp.setImageURL(products.getImageURL());
        temp.setPrice(products.getPrice());
        temp.setStock(products.getStock());

        hardList.add(temp);
	}

}