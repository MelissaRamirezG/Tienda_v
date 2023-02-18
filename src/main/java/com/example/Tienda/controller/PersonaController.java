/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Tienda.controller;

import com.example.Tienda.entity.Pais;
import com.example.Tienda.entity.Persona;
import com.example.Tienda.service.IPaisService;
import com.example.Tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author User
 */
@Controller
public class PersonaController{
   
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/persona")
    public String index (Model model){
        List<Persona>listaPersona=personaService.getAllPersona();
        model.addAttribute("titulo","Tabla Persona");
        model.addAttribute("persona",listaPersona);
        return"personas";
    }
    @GetMapping("/personaN")
    public String crearPersona (Model model){
        List<Pais> listaPaises = paisService.listCountry();
        model.addAttribute("persona",new Persona());
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
        personaService.savePersona(persona);
        return"redirect:/persona";
    }
}
