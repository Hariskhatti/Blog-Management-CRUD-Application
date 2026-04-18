package hello.security.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import hello.security.main.entity.BlogEntity;
import hello.security.main.entity.RestEntity;
import hello.security.main.repository.BlogRepository;

@Controller
public class MyController {

    @Autowired
    private BlogRepository blogRepo;

    @Autowired
    private ServiceClass sc;

    // ----------------- PUBLIC PAGES -----------------
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("blogList", blogRepo.findAll());
        BlogEntity be = new BlogEntity();
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("modelObj", new RestEntity());
        return "login";
    }

    @GetMapping("/blog/{title}")
    public String blogDetails(@PathVariable String title, Model model) {
        BlogEntity blog = blogRepo.findByTitle(title);
        model.addAttribute("blog", blog);
        return "BlogDetails";
    }

    // ----------------- ADMIN PAGES -----------------
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model, Authentication auth) {
        model.addAttribute("adminName", auth.getName());
        model.addAttribute("modelList", blogRepo.findAll());
        return "Dashboard";
    }

    @GetMapping("/addBlog")
    public String addBlog(Model model) {
        model.addAttribute("modelBlog", new BlogEntity());
        return "AddBlog";
    }

    @PostMapping("/saveBlog")
    public String saveBlog(@ModelAttribute BlogEntity blog) {
        sc.addBlog(blog);
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/editBlog/{title}")
    public String editBlog(@PathVariable String title, Model model) {
        BlogEntity blog = blogRepo.findByTitle(title);
        model.addAttribute("modelBlog", blog);
        return "EditBlog"; 
    }

    @PostMapping("/updateBlog")
    public String updateBlog(@ModelAttribute BlogEntity blog) {
    	BlogEntity existsBlog = blogRepo.findById(blog.getId());
    	blog.setPublishDate(existsBlog.getPublishDate());
        sc.editBlog(blog);         return "redirect:/admin/dashboard";
    }

    @PostMapping("/deleteBlog/{title}")
    public String deleteBlog(@PathVariable String title) {
        sc.deleteBlog(title);
        return "redirect:/admin/dashboard";
    }
    @GetMapping("/admin/blog/{title}")
    public String adminBlog(@PathVariable String title, Model model) {
        BlogEntity blog = blogRepo.findByTitle(title);
        model.addAttribute("blog", blog);
        return "AdminBlogView";
    }

    
}
