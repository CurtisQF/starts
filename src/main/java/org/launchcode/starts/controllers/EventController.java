package org.launchcode.starts.controllers;

import org.launchcode.starts.data.EventRepository;
import org.launchcode.starts.models.ArtLevel;
import org.launchcode.starts.models.ArtType;
import org.launchcode.starts.models.Event;
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
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

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
}
