package com.programadorescl.petconsultation.resources;

import com.programadorescl.petconsultation.domain.service.VeterinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "v1//veterinarians")
public class VeterinaryController {

    @Autowired
    private VeterinaryService service;
}
