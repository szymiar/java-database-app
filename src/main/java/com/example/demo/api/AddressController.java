package com.example.demo.api;

import com.example.demo.dao.*;
import com.example.demo.model.Address;
import com.example.demo.model.Animal;
import com.example.demo.model.Login;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class AddressController {

    @Autowired
    private AddressesDAO addressesDAO;
    @Autowired
    private Person2DAO person2DAO;

    @Autowired
    private AnimalsDAO animalsDAO;

    @Autowired
    private UsersDao usersDao;

    private LoginsDAO loginsDAO= new LoginsDAO();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/HomePage")
    public String viewHomePage(Model model){

        return "index";

    }
    @RequestMapping("/viewAddresses")
    public String viewAddresses(Model model){
        List<Address> listAddress;
        if(currentUserAuthorities().equals("ROLE_ADMIN")){
            listAddress=addressesDAO.list();}
        else{
            listAddress=addressesDAO.listPerson(currentUserid());
        }
        model.addAttribute("listAddress",listAddress);

        return "addresses";

    }

    @RequestMapping("/login")
    public String login(Model model){
        return "redirect:/login";
    }


    private int currentUserid() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name=authentication.getName();
        return usersDao.getPERSON_ID(name);
    }

    private String currentUserAuthorities() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("tearz");
        System.out.println(authentication.getAuthorities().toArray()[0].toString());
        return authentication.getAuthorities().toArray()[0].toString();
    }





    @RequestMapping("/viewPersons")
    public String viewPersons(Model model){

        List<Person2> person2List;

        if(currentUserAuthorities().equals("ROLE_ADMIN")){
            person2List =  person2DAO.list();}
        else{
            person2List=person2DAO.listPerson(currentUserid());}
        model.addAttribute("person2List",person2List);

        return "persons";

    }


    @RequestMapping("/viewAnimals")
    public String viewAnimals(Model model){
        List<Animal> animalsList;


        if(currentUserAuthorities().equals("ROLE_ADMIN")){
            animalsList =  animalsDAO.list();
        }
        else{
            animalsList=animalsDAO.listPerson(currentUserid());
        }
        model.addAttribute("animalsList",animalsList);

        return "animals";

    }

    @RequestMapping("/addAddress")
    public String showAddAddress(Model model){
        Address address=new Address();
        model.addAttribute("address",address);

        return "add_address";
    }

    @RequestMapping("/addAnimal")
    public String showAddAnimal(Model model){
        Animal animal=new Animal();
        model.addAttribute("animal",animal);

        return "add_animal";
    }


    @RequestMapping("/addPerson")
    public String showAddPerson(Model model){
        Person2 person=new Person2();
        model.addAttribute("person",person);

        return "add_person";
    }

    @RequestMapping(value="/saveEditAnimal", method = RequestMethod.POST)
    public String saveEditAnimal(@ModelAttribute("animal") Animal animal){

        if(person2DAO.listPerson(animal.getPERSON_ID()).isEmpty()){


            return "redirect:/noPerson";
        }

        if(animal.getDATE_OF_BIRTH().isBlank()| animal.getNAME().isBlank() |animal.getRACE().isBlank()|animal.getSPECIES().isBlank()) {


            return "redirect:/blankPage";
        }

        else {
            animalsDAO.update(animal);
            return "redirect:/viewAnimals";
        }
    }

    @RequestMapping(value="/saveEditPerson", method = RequestMethod.POST)
    public String saveEditPerson(@ModelAttribute("person") Person2 person){

        if(addressesDAO.listAddressId(person.getADDRESS_ID()).isEmpty()){


            return "redirect:/noAddress";
        }

        if(person.getBIRTH_DATE().isBlank()|person.getNAME().isBlank()|person.getSURNAME().isBlank()){

            return "redirect:/blankPage";
        }
        else{
        person2DAO.update(person);
        return "redirect:/viewPersons";}
    }

    @RequestMapping(value="/saveEditAddress", method = RequestMethod.POST)
    public String saveEditAddress(@ModelAttribute("address") Address address){

        if(address.getAPT_NUMBER().isBlank()| address.getCITY().isBlank() |address.getCODE().isBlank()|address.getSTREET().isBlank()) {

            return "redirect:/blankPage";
        }
        else{

        addressesDAO.update(address);
        return "redirect:/viewAddresses";}
    }

    @RequestMapping("/noPerson")
    public String noPerson(Model model){
        return "noPerson";
    }
    @RequestMapping("/noAddress")
    public String noAddress(Model model){
        return "noAddress";
    }

    @RequestMapping(value="/saveDeletePerson/{id}")
    public String saveDeletePerson(@PathVariable(name="id") int id){
        if (animalsDAO.listPerson(id).isEmpty()){
        person2DAO.delete(id);
        return "redirect:/viewPersons";}
        else{
            System.out.println("blad2");
            //co najmniej 1 zwierzak jest przypisany do tej osoby
            return "redirect:/errorPerson";

        }
    }


    @RequestMapping("/saveDeleteAddress/{id}")
    public String saveDeleteAddress(@PathVariable(name="id") int id){
        if(addressesDAO.listPerson2(id).isEmpty()){
        addressesDAO.delete(id);
        return "redirect:/viewAddresses";}
        else{
            System.out.println("blad");
            // ten adres jest przypisany do jakiejs osoby
            return "redirect:/errorAddress";

        }
    }



    @RequestMapping("/saveDeleteAnimal/{id}")
    public String saveDeleteAnimal(@PathVariable(name="id") int id){
        animalsDAO.delete(id);
        return "redirect:/viewAnimals";
    }

    @RequestMapping("/user")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("tearz");
        System.out.println(authentication.getAuthorities());
        return principal.getName();
    }




    @RequestMapping("/editAddress/{id}")
    public ModelAndView EditAddress(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_address");
        Address address=addressesDAO.get(id);
        mav.addObject("address",address);
        return mav;

    }

    @RequestMapping("/editPerson/{id}")
    public ModelAndView EditPerson(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_person");
        Person2 person=person2DAO.get(id);
        mav.addObject("person",person);
        return mav;

    }

    @RequestMapping("/editAnimal/{id}")
    public ModelAndView EditAnimal(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_animal");
        Animal animal=animalsDAO.get(id);
        mav.addObject("animal",animal);
        return mav;

    }


    @RequestMapping(value="/savePerson", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person2 person){

        if(addressesDAO.listAddressId(person.getADDRESS_ID()).isEmpty()){

            System.out.println("haha");
            return "redirect:/noAddress";
        }

        if(person.getBIRTH_DATE().isBlank()|person.getNAME().isBlank()|person.getSURNAME().isBlank()){

            return "redirect:/blankPage";
        }
        else {
            person2DAO.save(person);

            return "redirect:/viewPersons";
        }
    }

    @RequestMapping(value="/saveAddress", method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute("address") Address address){

        if(address.getAPT_NUMBER().isBlank()| address.getCITY().isBlank() |address.getCODE().isBlank()|address.getSTREET().isBlank()) {

            return "redirect:/blankPage";
        }
        else {
        addressesDAO.save(address);

        return "redirect:/viewAddresses";
        }
    }


    @RequestMapping(value="/saveAnimal", method = RequestMethod.POST)
    public String saveAnimal(@ModelAttribute("animal") Animal animal){
        if(person2DAO.listPerson(animal.getPERSON_ID()).isEmpty()){


            return "redirect:/noPerson";
        }



        if(animal.getDATE_OF_BIRTH().isBlank()| animal.getNAME().isBlank() |animal.getRACE().isBlank()|animal.getSPECIES().isBlank()) {

            return "redirect:/blankPage";
        }
        else {
        animalsDAO.save(animal);
        return "redirect:/viewAnimals";
        }

    }
    @RequestMapping("/blankPage")
    public String blankpage(Model model){
        return "blankPage";
    }

    @RequestMapping("/errorPerson")
    public String errorPerson(Model model){
        return "errorPerson";
    }
    @RequestMapping("/errorAddress")
    public String errorAddress(Model model){
        return "errorAddress";
    }



    @RequestMapping("/backHomePage")
    public String backHomePage(Model model){


        return "redirect:/HomePage";
    }}
