package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Quiz;
import com.example.demo.model.category;
import com.example.demo.service.CategoryService;
import com.example.demo.service.QuizService;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final CategoryService categoryService;

    @Autowired
    private QuizService quizService;
    
    public AdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
   
    
    
    
    @GetMapping("/dashboard")
    public String getAdminDashboard(Model model) {
        model.addAttribute("quizzes", quizService.getAllQuizzes());
        model.addAttribute("categories", categoryService.getAllCategories()); // Add categories to the model

        return "admin-dashboard"; // Display all quizzes in the dashboard
    }
    
    @GetMapping("/delete-category/{categoryId}")
    public String deleteCategory(@PathVariable("categoryId") Long categoryId, RedirectAttributes redirectAttributes) {
        try {
            // Call the service layer to delete the category by ID
            categoryService.deleteCategory(categoryId);

            // Add a success message to be shown after redirection
            redirectAttributes.addFlashAttribute("successMessage", "Category deleted successfully!");
        } catch (Exception e) {
            // Handle failure to delete (e.g., if category doesn't exist)
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to delete category.");
        }

        // Redirect back to the dashboard page
        return "redirect:/admin/dashboard";
    }


    @GetMapping("/create-quiz")
    public String showCreateQuizForm(Model model) {
        model.addAttribute("quiz", new Quiz());
        return "create-quiz"; // Show the form to create a new quiz
    }

    @PostMapping("/create-quiz")
    public String createQuiz(@ModelAttribute Quiz quiz) {
        quizService.createQuiz(quiz);
        return "redirect:/admin/dashboard"; // Redirect to the dashboard after creating quiz
    }
    
    @GetMapping("/new-category")
    public String showNewCategoryForm() {
        return "new-category";  // JSP page with the form
    }

    // Method to save the new category
    @PostMapping("/save-category")
    public String saveCategory(@RequestParam("name") String name,
                               @RequestParam("description") String description,
                               RedirectAttributes redirectAttributes) {
        try {
            category category = new category();
            category.setName(name);
            category.setDescription(description);

            categoryService.saveCategory(category);

            redirectAttributes.addFlashAttribute("successMessage", "Category uploaded successfully!");
            return "redirect:/admin/dashboard";  // Redirect to the dashboard after successful upload
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to upload category.");
            e.printStackTrace();  // Print the stack trace for debugging
            return "redirect:/admin/new-category";  // Stay on the form page if there's an error
        }
    }
//    @RequestMapping("/dashboard")
//    public String dashboard(Model model) {
//        List<category> categories = categoryService.getAllCategories();
//        model.addAttribute("categories", categories);  // Add the categories to the model
//        return "admin-dashboard";  // This will resolve to /WEB-INF/jsp/admin-dashboard.jsp
//    }
    
}
