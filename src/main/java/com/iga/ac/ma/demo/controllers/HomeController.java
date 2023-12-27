package com.iga.ac.ma.demo.controllers;

import com.iga.ac.ma.demo.Repository.PatientRepository;
import com.iga.ac.ma.demo.entities.Patient;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
@AllArgsConstructor
@Slf4j
public class HomeController {
    private PatientRepository patientRepository;

    @GetMapping("/home")
    public String home(Model model,
                       @RequestParam(name="page",defaultValue = "0")int page,
                       @RequestParam(name="size",defaultValue = "5")int size,
                       @RequestParam(name="keyword",defaultValue = "")String keyword){
        Page<Patient>patients=patientRepository.findByNameContains(keyword,PageRequest.of(page,size));
       //log.info(patients.toString());
        model.addAttribute("patients",patients.getContent());
        model.addAttribute("pages",new int[patients.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "home";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(method = RequestMethod.GET,path="/new")
    public String NewPatient(Model model){
        model.addAttribute("patient",new Patient());
        return "newPatient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@Valid Patient patient, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            log.error("error");
        return "newPatient";
        }

        patientRepository.save(patient);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String delete(Long id,String keyword,int page){
        patientRepository.deleteById(id);
        return  "redirect:/home?page="+page+"&keyword="+keyword;
    }
}
