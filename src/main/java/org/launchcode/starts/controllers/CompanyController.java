package org.launchcode.starts.controllers;

import org.launchcode.starts.data.CompanyRepository;
import org.launchcode.starts.data.EventRepository;
import org.launchcode.starts.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @GetMapping("detail")
    public String displayCompanyDetails(@RequestParam Integer companyId, Model model) {

        Optional<Company> result = companyRepository.findById(companyId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Company ID: " + companyId);
        } else {
            Company company = result.get();
            model.addAttribute("title", company.getName());
            model.addAttribute("company", company);
            model.addAttribute("events", eventRepository.findAll());
        }

        return "companies/detail";
    }
}
