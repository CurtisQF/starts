package org.launchcode.starts.controllers;

import org.launchcode.starts.data.CompanyRepository;
import org.launchcode.starts.data.EventRepository;
import org.launchcode.starts.data.UserRepository;
import org.launchcode.starts.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String userSessionKey = "user";


    @GetMapping("")
    public String showEvents(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping("create")
    public String displayCreateEventForm(HttpSession session, Model model) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        Optional<User> sessionUser = userRepository.findById(userId);
        User user = sessionUser.get();

        model.addAttribute(new Event(user));
        model.addAttribute("sessionUser", user);
        model.addAttribute("artTypes", ArtType.values());
        model.addAttribute("artLevels", ArtLevel.values());
        model.addAttribute("companies", companyRepository.findAll());
        return "events/create";
    }

    @PostMapping("create")
    public String submitCreateEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model, HttpSession session) {
        if(errors.hasErrors()) {

            Integer userId = (Integer) session.getAttribute(userSessionKey);
            Optional<User> sessionUser = userRepository.findById(userId);
            User user = sessionUser.get();

            model.addAttribute("sessionUser", user);
            model.addAttribute("artTypes", ArtType.values());
            model.addAttribute("artLevels", ArtLevel.values());
            model.addAttribute("companies", companyRepository.findAll());
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
