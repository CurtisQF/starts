package org.launchcode.starts.controllers;

import org.launchcode.starts.data.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;


}
