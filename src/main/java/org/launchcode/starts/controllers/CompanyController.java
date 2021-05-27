package org.launchcode.starts.controllers;

import org.launchcode.starts.data.CompanyRepository;
import org.launchcode.starts.data.EventRepository;
import org.launchcode.starts.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("")
    public String displayCompanies(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "companies/index";
    }


    @GetMapping("create")
    public String displayCreateCompanyForm(Model model) {
        model.addAttribute(new Company());
        model.addAttribute("artTypes", ArtType.values());
        model.addAttribute("artLevels", ArtLevel.values());
        model.addAttribute("states", State.values());
        return "companies/create";
    }

    @PostMapping("create")
    public String submitCreateCompanyForm(@ModelAttribute @Valid Company newCompany, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("artTypes", ArtType.values());
            model.addAttribute("artLevels", ArtLevel.values());
            model.addAttribute("states", State.values());
            return "companies/create";
        }

        companyRepository.save(newCompany);
        return "redirect:";
    }
}
