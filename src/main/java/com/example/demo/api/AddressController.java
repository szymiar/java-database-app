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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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






    @RequestMapping("/editAddress")
    public String showEditAddress(Model model){
        Address address=new Address();
        model.addAttribute("address",address);

        return "edit_address";
    }

    @RequestMapping(value="/saveEditAddress", method = RequestMethod.POST)
    public String saveEditAddress(@ModelAttribute("address") Address address){
        addressesDAO.update(address);
        return "redirect:/viewAddresses";
    }


    @RequestMapping("/deletePerson")
    public String showDeletePerson(Model model){

        int id = 0;
        model.addAttribute("id",id);

        return "delete_person";
    }

    @RequestMapping(value="/saveDeletePerson", method = RequestMethod.POST)
    public String saveDeletePerson(@ModelAttribute("id") int id){
        person2DAO.delete(id);
        return "redirect:/viewPersons";
    }

    @RequestMapping("/deleteAddress")
    public String showDeleteAddress(Model model){
        int id = 0;
        model.addAttribute("id",id);

        return "delete_Address";
    }

    @RequestMapping(value="/saveDeleteAddress", method = RequestMethod.POST)
    public String saveDeleteAddress(@ModelAttribute("id") int id){
        addressesDAO.delete(id);
        return "redirect:/viewAddresses";
    }

    @RequestMapping("/deleteAnimal")
    public String showDeleteAnimal(Model model){
        int id = 0;
        model.addAttribute("id",id);

        return "delete_animal";
    }

    @RequestMapping(value="/saveDeleteAnimal", method = RequestMethod.POST)
    public String saveDeleteAnimal(@ModelAttribute("id") int id){
        animalsDAO.delete(id);
        return "redirect:/viewAnimals";
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



    @RequestMapping(value="/saveAddress", method = RequestMethod.POST)
    public String saveAddress(@ModelAttribute("address") Address address){
        addressesDAO.save(address);

        return "redirect:/viewAddresses";
    }


    @RequestMapping("/backHomePage")
    public String backHomePage(Model model){


        return "redirect:/HomePage";
    }


    @RequestMapping("/")
    public String loginPage(Model model){
        Login login = new Login();
        //info
        model.addAttribute("login",login);
        return "login_screen";
    }




    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("login") Login login){

        if(loginsDAO.verify(login)){
            System.out.println(login.getLogin());
            System.out.println(login.getPassword());
            return "redirect:/HomePage";
        }
        System.out.println(login.getLogin());
        System.out.println(login.getPassword());
        return "redirect:/";

    }




}
