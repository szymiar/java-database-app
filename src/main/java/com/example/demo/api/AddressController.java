package com.example.demo.api;

import com.example.demo.dao.AddressesDAO;
import com.example.demo.dao.AnimalsDAO;
import com.example.demo.dao.LoginsDAO;
import com.example.demo.dao.Person2DAO;
import com.example.demo.model.Address;
import com.example.demo.model.Animal;
import com.example.demo.model.Login;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
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

    private LoginsDAO loginsDAO= new LoginsDAO();
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/HomePage")
    public String viewHomePage(Model model){

        return "index";

    }
    @RequestMapping("/viewAddresses")
    public String viewAddresses(Model model){
        List<Address> listAddress=addressesDAO.list();
        model.addAttribute("listAddress",listAddress);

        return "addresses";

    }

    @RequestMapping("/viewPersons")
    public String viewPersons(Model model){
        List<Person2> person2List =  person2DAO.list();
        model.addAttribute("person2List",person2List);

        return "persons";

    }


    @RequestMapping("/viewAnimals")
    public String viewAnimals(Model model){
        List<Animal> animalsList =  animalsDAO.list();
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


    @RequestMapping("/editAnimal")
    public String showEditAnimal(Model model){
        Animal animal=new Animal();
        model.addAttribute("animal",animal);

        return "edit_animal";
    }

    @RequestMapping(value="/saveEditAnimal", method = RequestMethod.POST)
    public String saveEditAnimal(@ModelAttribute("animal") Animal animal){
        animalsDAO.update(animal);
        return "redirect:/viewAnimals";
    }

    @RequestMapping("/editPerson")
    public String showEditPerson(Model model){
        Person2 person=new Person2();
        model.addAttribute("person",person);

        return "edit_person";
    }

    @RequestMapping(value="/saveEditPerson", method = RequestMethod.POST)
    public String saveEditPerson(@ModelAttribute("person") Person2 person){
        person2DAO.update(person);
        return "redirect:/viewPersons";
    }

    @RequestMapping(value = "/updatePerson", method = RequestMethod.POST)
    public String deletePerson(@PathVariable(name = "id") int id){
        person2DAO.delete(id);
        return "redirect:/viewPersons";
    }

    @RequestMapping(value = "/updateAnimal", method = RequestMethod.POST)
    public String deleteAnimal(@PathVariable(name = "id") int id){
        animalsDAO.delete(id);
        return "redirect:/viewAnimals";
    }
    @RequestMapping(value = "/updateAddress", method = RequestMethod.POST)
    public String deleteAddress(@PathVariable(name = "id") int id){
        addressesDAO.delete(id);
        return "redirect:/viewAddresses";
    }



    @RequestMapping(value="/saveEditAddress", method = RequestMethod.POST)
    public String saveEditAddress(@ModelAttribute("address") Address address){
        addressesDAO.update(address);
        return "redirect:/viewAddresses";
    }






    @RequestMapping("/user")
    public String currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("tearz");
        System.out.println(authentication.getAuthorities());
        return principal.getName();
    }







    @RequestMapping(value="/savePerson", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person2 person){
        person2DAO.save(person);

        return "redirect:/viewPersons";

    }



    @RequestMapping(value="/saveAnimal", method = RequestMethod.POST)
    public String saveAnimal(@ModelAttribute("animal") Animal animal){
        animalsDAO.save(animal);

        return "redirect:/viewAnimals";

    }



    @RequestMapping("/editAddress/{id}")
    public ModelAndView editAddress(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_address");
        Address address=addressesDAO.get(id);
        mav.addObject("address",address);
        return mav;
    }

    @RequestMapping("/editPerson/{id}")
    public ModelAndView editPerson(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_person");
        Person2 person=person2DAO.get(id);
        mav.addObject("person",person);
        return mav;
    }

    @RequestMapping("/editAnimal/{id}")
    public ModelAndView editAnimal(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("edit_animal");
        Animal animal=animalsDAO.get(id);
        mav.addObject("animal",animal);
        return mav;

    }
    @RequestMapping(value="/saveAddress", method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute("address") Address address){
        addressesDAO.save(address);

        return "redirect:/viewAddresses";
    }
}
