package com.example.demo.api;

import com.example.demo.dao.AddressesDAO;
import com.example.demo.dao.LoginsDAO;
import com.example.demo.dao.Person2DAO;
import com.example.demo.model.Address;
import com.example.demo.model.Login;
import com.example.demo.model.Person2;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Person2DAO person2DAO;

    private LoginsDAO loginsDAO= new LoginsDAO();

    @RequestMapping("/HomePage")
    public String viewHomePage(Model model){
    List<Address> listAddress=addressesDAO.list();
    model.addAttribute("listAddress",listAddress);

    return "index";

    }

    @RequestMapping("/persons")
    public String viewPersons(Model model){

        List<Person2> person2List = person2DAO.list();
        System.out.println(person2List.get(0).getSURNAME());
        model.addAttribute("person2List",person2List);

        return "persons";

    }






    @RequestMapping("/new")
    public String showNewForm(Model model){
        Address address=new Address();
        model.addAttribute("address",address);

        return "add_address";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("address") Address address){
        addressesDAO.save(address);

        return "redirect:/HomePage";

    }
    @RequestMapping("/")
    public String loginPage(Model model){
        Login login = new Login();
        model.addAttribute("login",login);
        return "login_screen";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("login") Login login){

        if(loginsDAO.verify(login)){
            return "redirect:/HomePage";
        }
        return "redirect:/";

    }


}
