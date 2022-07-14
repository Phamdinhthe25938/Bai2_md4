package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CrudProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class Admin {
    private static Pattern pattern;
    private Matcher matcher;


    @GetMapping("/tinhtoan")
    public ModelAndView tinhtoan(ModelAndView modelAndView,@RequestParam("Caculate") String condiment, @RequestParam("input1") String input1,@RequestParam("input2") String input2){
        modelAndView = new ModelAndView("home");
        if(condiment.equals("cong")){
            int kq = Integer.parseInt(input1) + Integer.parseInt(input2);
            modelAndView.addObject("kq",kq);
            modelAndView.addObject("value1",input1);
            modelAndView.addObject("value2",input2);
        }
        return modelAndView;
    }
    @GetMapping("/saveCheckBox")
    public ModelAndView save(ModelAndView modelAndView, @RequestParam("hello") String[] condiment) {
        modelAndView = new ModelAndView("home");
        modelAndView.addObject("condiment",condiment);
        return  modelAndView;
    }
    @GetMapping("/worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Get current time at local
        Date date = new Date();
        // Get timezone by the local
        TimeZone local = TimeZone.getDefault();
        // Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Reset the date by locale_time
        date.setTime(locale_time);
        // Set the data sent to the view
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "home";
    }
    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean isvalid = this.validate(email);
        if (!isvalid) {
            model.addAttribute("message", "Email is invalid");
            return "home";
        }
        model.addAttribute("email", email);
        model.addAttribute("message", "Email is thanh cong");
        return "home";
    }
    private boolean validate(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @Autowired
    CrudProduct crudProduct;

    @GetMapping("/admin")
    public String showHome(Model model){
        model.addAttribute("products", crudProduct.products);
        return "home";
    }
    @GetMapping("/delele")
    public String delete(HttpServletRequest request, HttpServletResponse response,Model model){
        int id = Integer.parseInt(request.getParameter("idDelete"));
        for(int i=0;i<crudProduct.products.size();i++){
            if(crudProduct.products.get(i).getId()==id){
                crudProduct.products.remove(i);
                break;
            }
        }
        model.addAttribute("products", crudProduct.products);
        return "home";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("idEdit",id);
        for(Product p : crudProduct.products){
            if(p.getId() ==  id){
                model.addAttribute("product",p);
            }
        }
        return "Edit";
    }
     @PostMapping("/editPost/{id}")
    public String editPost(Product product,@PathVariable int id, Model model){
         for(int i=0;i<crudProduct.products.size();i++){
             if(crudProduct.products.get(i).getId()==id){
                 crudProduct.products.set(i,product);
                 break;
             }
         }
         model.addAttribute("products", crudProduct.products);
         return "home";
        }
        @GetMapping("/add")
        public String add(){
           return "Add";
        }
        @PostMapping("/add")
        public String addP(Product product,Model model){
            crudProduct.products.add(product);
            model.addAttribute("products", crudProduct.products);
            return "home";
        }
        @PostMapping("/search")
        public String search(Model model,@RequestParam String search){
             List<Product> listSearch = new ArrayList<>();
            for (Product p :crudProduct.products){
                if(p.getName().contains(search)){
                    listSearch.add(p);
                }
            }
            model.addAttribute("products", listSearch);
            return "home";
        }
        @PostMapping("/timtudien")
        public String SearchWord(@RequestParam String timtudien,Model model){

        model.addAttribute("products", crudProduct.products);
        String kq =null;
        crudProduct.addWord();
        Set<String> list =crudProduct.listWord.keySet();
                for(String s:list){
                    if(s.equalsIgnoreCase(timtudien)){
                        kq= crudProduct.listWord.get(s);
                    }
                }
            model.addAttribute("kq",kq);
            return "home";
        }

}
