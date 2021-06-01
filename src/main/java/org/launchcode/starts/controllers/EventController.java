package org.launchcode.starts.controllers;

import org.launchcode.starts.data.CompanyRepository;
import org.launchcode.starts.data.EventRepository;
import org.launchcode.starts.models.ArtLevel;
import org.launchcode.starts.models.ArtType;
import org.launchcode.starts.models.Company;
import org.launchcode.starts.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("")
    public String showEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute(new Event());
        model.addAttribute("artTypes", ArtType.values());
        model.addAttribute("artLevels", ArtLevel.values());
        model.addAttribute("companies", companyRepository.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String submitCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("artTypes", ArtType.values());
            model.addAttribute("artLevels", ArtLevel.values());
            return "events/create";
        }

        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping("detail")
    public String displayEventDetails(@RequestParam Integer eventId, Model model) {

        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName());
            model.addAttribute("event", event);
//            model.addAttribute("events", eventRepository.findAll());
        }

        return "events/detail";
    }

}
