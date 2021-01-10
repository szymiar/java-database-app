package com.example.demo.api;

import com.example.demo.dao.AddressesDAO;
import com.example.demo.model.Address;
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

    @RequestMapping("/")
    public String viewHomePage(Model model){
    List<Address> listAddress=addressesDAO.list();
    model.addAttribute("listAddress",listAddress);

    return "index";

    }
    @RequestMapping("/new")
    public String showNewForm(Model model){
        Address address=new Address();
        model.addAttribute("address",address);

        return "new_form";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("address") Address address){
        addressesDAO.save(address);

        return "redirect:/";

    }

}
