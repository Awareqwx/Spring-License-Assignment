package com.awareqwx.License.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.awareqwx.License.models.License;
import com.awareqwx.License.models.Person;
import com.awareqwx.License.repositories.LicenseRepository;
import com.awareqwx.License.repositories.PersonRepository;
import com.awareqwx.License.services.LicenseService;

@Controller
@RequestMapping("/licenses")
public class LicenseController
{
    
    private LicenseService ls;
    
    public LicenseController(LicenseRepository lr, PersonRepository pr)
    {
        ls = new LicenseService(lr, pr);
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, false));
    }
    
    @RequestMapping("/")
    public String index(Model model)
    {
        try
        {
            ls.allPersons();
        }
        catch(NullPointerException e)
        {
            return "index.jsp";
        }
        model.addAttribute("persons", ls.allPersons());
        return "index.jsp";
    }
    
    @RequestMapping("/person/{ident}")
    public String index(@PathVariable(name="ident") long ident, Model model)
    {
        model.addAttribute("person", ls.findPersonById(ident));
        return "show.jsp";
    }
    
    @RequestMapping("/person/new")
    public String newPerson(Model model)
    {
        model.addAttribute("person", new Person());
        return "newPerson.jsp";
    }
    
    @PostMapping("/person/new")
    public String addPerson(@ModelAttribute("person") Person person)
    {
        ls.addPerson(person);
        return "redirect:/licenses/person/" + person.getId();
    }
    
    @RequestMapping("/license/new")
    public String newLicense(Model model)
    {
        model.addAttribute("persons", ls.allPersons());
        model.addAttribute("license", new License());
        return "newLicense.jsp";
    }
    
    @PostMapping("/license/new")
    public String addLicense(@ModelAttribute("license") License license, BindingResult result)
    {
        ls.addLicense(license);
        String num = "" + license.getId();
        while(num.length() < 6)
        {
            num = "0" + num;
        }
        license.setNumber(num);
        ls.addLicense(license);
        return "redirect:/licenses/person/" + license.getPerson().getId();
    }
    
}

