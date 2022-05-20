package tn.esprit.Dari.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Dari.modal.Category;
import tn.esprit.Dari.service.CategoryService;


@RestController
public class CategoryController {
	@Autowired 
	CategoryService categoryService;

	
	@GetMapping("/retrieve-all-Category") 
	@ResponseBody 
	 //http://localhost:8080/SpringMVC/servlet/retrieve-all-Category 
	 public List<Category> getCategory() { 
		 List<tn.esprit.Dari.modal.Category> category = categoryService.retrieveAllCategory();
		 return category ; 
	}
	@PostMapping("/add-Category")
    @ResponseBody
    public Category addCategory(@RequestBody Category a) {
		Category category = categoryService.addCategory(a);
        return category ; }
	@DeleteMapping("/remove-category/{category-id}")
    @ResponseBody
    public void removeCategory(@PathVariable("category-id")  long categoryId) {
		categoryService.DeleteCategory(categoryId);
		
    }

    @PutMapping("/modify-Category")
    @ResponseBody
    public Category modifyCategory(@RequestBody Category cat) {
        return categoryService.updateCategory(cat);
    }


    @GetMapping("/retrieve-Category/{category-id}")
    @ResponseBody
    public Category retrieveCategory(@PathVariable("category-id") int categoryId) {
        return categoryService.findCategoryById(categoryId);  }
	

}
