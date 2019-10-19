//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
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

	public Optional<Product> getProductById(String id) {
        
        /*int i=0;
        boolean isHere = false;
        while(i<hardList.size())
        {
            if(hardList.get(i).getId() == id)
            {
                isHere = true;
                break;
            }
            else
            {
                i++;
            }
        }
        if(isHere == true)
        {
            Product temp = hardList.get(i);
            return temp;
        }*/
        

        //This return will be correct for the mongodb, so save it.
        return productRepository.findById(id);
	}

	public Iterable<Product> getAllProducts(Iterable<String> id) {
        /*List<String> getAll = new ArrayList<>();
        getAll.add("Get all products is working");
        return getAll;*/

        //This return will be correct for the mongodb, so save it.
        //return productRepository.findAllById(id);
        return hardList;
	}

	public Iterable<String> getProductById() {
		return null;
	}

	/*public void save(Product products) {
	}*/

}