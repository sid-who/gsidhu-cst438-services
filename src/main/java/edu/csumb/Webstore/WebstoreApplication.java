//You don't really need to touch this file for anything in the class. It just serves to run to spring project.

package edu.csumb.Webstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import edu.csumb.Webstore.model.Product;
import edu.csumb.Webstore.repositories.ProductRepository;

@Controller
@SpringBootApplication
public class WebstoreApplication
{
	@Autowired
	private ProductRepository repo;

	public static void main(String[] args)
	{
		SpringApplication.run(WebstoreApplication.class, args);
	}

	/*@Override
	public void run(String... args){
		repo.deleteAll();

		//test products
		repo.save(new Product("Product1", "Random Description Value", "Random Image URL", 1.00, 1));
		repo.save(new Product("Product2", "Random Description Value", "Random Image URL", 1.00, 1));
	}*/

}
