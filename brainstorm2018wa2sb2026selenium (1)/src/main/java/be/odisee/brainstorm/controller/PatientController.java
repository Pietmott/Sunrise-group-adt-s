package be.odisee.brainstorm.controller;

import be.odisee.brainstorm.domain.Bed;
import be.odisee.brainstorm.domain.Patient;
import be.odisee.brainstorm.service.BedToewijzingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PatientController {

    @Autowired
    protected BedToewijzingService bedToewijzingService =null; // ready for dependency injection

    @RequestMapping(value={"/home.html","/index.html","lijst.html"},method=RequestMethod.GET)
    public String index(ModelMap model){
        List<Patient> deLijst = bedToewijzingService.geefAllePatienten();
        model.addAttribute("personen", deLijst);
        return "/index";
    }
    // je zal naar index.html gaan

    @RequestMapping(value={"/patient.html"},method=RequestMethod.GET)
    public String patientDetail(@RequestParam("id") Integer id, ModelMap model){
    	// Optional<Patient> is nu nodig in deze versie van Spring  boot bij een opzoeking op id
        Patient patient = bedToewijzingService.zoekPatientMetId(id);
        model.addAttribute("patient",patient);
        return "/patient";
    }
    // je zal naar patient.html gaan
    
    @RequestMapping(value={"/patientviamail.html"},method=RequestMethod.GET)
    public String patientDetailViaEmail(@RequestParam("email") String email, ModelMap model){
        Patient patient = bedToewijzingService.zoekPatientMetEmail(email);
        model.addAttribute("patient", patient);
        return "/patient";
    }
    // je zal naar patient.jsp gaan

    @RequestMapping(value={"/patientviavoornaam.html"},method=RequestMethod.GET)
    public String patientDetailViaVoornaam(@RequestParam("voornaam") String voornaam, ModelMap model){
        Patient patient = bedToewijzingService.zoekPatientMetVoornaam(voornaam);
        model.addAttribute("patient", patient);
        return "/patient";
    }
    // je zal naar patient.jsp gaan

    @RequestMapping(value={"/nieuwePatient.html"},method=RequestMethod.GET)
    public String patientFormulier(ModelMap model){
        Patient patient = new Patient();
        model.addAttribute("depatient", patient);
        return "/nieuwePatient";
    }
    // je zal naar nieuwePatient.html gaan

    @RequestMapping(value={"/nieuwePatient.html"},method=RequestMethod.POST)
    public String patientToevoegen(@ModelAttribute("depatient") Patient patient, ModelMap model){
        Patient toegevoegdPatient = bedToewijzingService.voegPatientToe(patient.getVoornaam(),
                                                                            patient.getFamilienaam(),
                                                                            patient.getEmailadres());
        System.out.println("DEBUG patientsgegevens familienaam: "+patient.getFamilienaam());
        return "redirect:patient.html?id="+toegevoegdPatient.getId();
    }
    // je zal naar de detailpagina van de toegevoegde patient gaan

    @RequestMapping(value = {"/bedToewijzing.html"}, method = RequestMethod.GET)
    public String bedToewijzingFormulier(@RequestParam("patientId") Integer patientId, ModelMap model) {
        Patient patient = bedToewijzingService.zoekPatientMetId(patientId);
        List<Bed> vrijeBedden = bedToewijzingService.geefVrijeBedden();
        model.addAttribute("patient", patient);
        model.addAttribute("vrijeBedden", vrijeBedden);
        return "/bedToewijzing";
    }
    // toont een formulier met de patiënt en de beschikbare vrije bedden

    @RequestMapping(value = {"/bedToewijzing.html"}, method = RequestMethod.POST)
    public String bedToewijzingOpslaan(@RequestParam("patientId") Integer patientId,
                                       @RequestParam("bedId") Integer bedId,
                                       ModelMap model) {
        bedToewijzingService.wijsPatientAanBedToe(patientId, bedId);
        return "redirect:patient.html?id=" + patientId;
    }
    // wijst het geselecteerde bed toe aan de patiënt en keert terug naar de detailpagina

}
