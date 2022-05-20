package tn.esprit.Dari.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Dari.modal.Category;
import tn.esprit.Dari.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public Category addCategory(Category category) {
		categoryRepository.save(category) ;
		return category;
	}
	@Override
	public String DeleteCategory(long id) {
		categoryRepository.delete(categoryRepository.findById((long) id).get());
		return "Deleted"; 

	}

	@Override
	public Category updateCategory (Category category) {
		categoryRepository.save(category);
		return category;
	}
	@Override
	public List<Category> retrieveAllCategory() {
		List<Category> categories=(List<Category>)categoryRepository.findAll();
		return categories;
	}
	@Override
	public Category findCategoryById(long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
}
