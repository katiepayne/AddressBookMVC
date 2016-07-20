/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.controller;

import com.swcguild.addressbookmvc.dao.AddressBookDAO;
import com.swcguild.addressbookmvc.model.Address;
import java.util.List;
import java.util.Random;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {

    // Reference to the DAO
    private AddressBookDAO dao;

    @Inject // This replaces the controller bean & constructor-arg wiring
    // that we've done in the application context xml from before
    public HomeControllerNoAjax(AddressBookDAO dao) {
        this.dao = dao; // plug in the parameter into our
        // dao shaped hole reference & property
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/displayAddressListNoAjax", method = RequestMethod.GET)
    public String displayAddressListNoAjax(Model model) {

        this.addABunchaAddresses();

        // Get a list of your contacts
        List<Address> addresses = dao.getAllAddresses();

        // Then update the model so that SpringMVC can pass it
        // along to the view that is going to display it!
        model.addAttribute("addressList", addresses);

        // return the name of the view
        return "noajax/otherhome"; // turns into jsp/noajax/home.jsp via VR
    }
    
        @RequestMapping(value = "/deleteAddressNoAjax", method = RequestMethod.GET)
    public String deleteAddressNoAjax(HttpServletRequest request) {
        String addressIdInput = request.getParameter("addressID");

        if (addressIdInput != null && !addressIdInput.isEmpty()) {
            try {
                int addressID = Integer.parseInt(addressIdInput);
                dao.removeAddress(addressID);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return "redirect:displayAddressListNoAjax";
    }
    
    
        @RequestMapping (value="/bob", method=RequestMethod.GET)    
//    @RequestMapping(value="/displayEditContactFormNoAjax", method=RequestMethod.GET)
    public String editAddressNoAjax(HttpServletRequest request, Model model){
        String addressIdInput = request.getParameter("addressID");

        if (addressIdInput != null && !addressIdInput.isEmpty()) {
            try {
                int addressID = Integer.parseInt(addressIdInput);
                Address address = dao.getAddressById(addressID);
                model.addAttribute("address", address);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "redirect:displayAddressListNoAjax";
            }
        }
        
        return "noajax/otheredit";
    }
    
    @RequestMapping(value="editAddressNoAjax", method=RequestMethod.POST)
    public String editAddressNoAjax(@Valid @ModelAttribute("address") Address xenophormagic,
            BindingResult result){
   // public String editContactNoAjax(@ModelAttribute("contact") Contact contact){ 
   
        if (result.hasErrors()) {
         return "noajax/otheredit";   
        }
   
        dao.updateAddress(xenophormagic);
        return "redirect:displayAddressListNoAjax";
    }
    
    @RequestMapping(value="/newAddressFormNoAjax", method=RequestMethod.GET)
    public String addAddressFormNoAjax(){
        return "noajax/otheradd";
    }

    @RequestMapping(value="/addNewAddressNoAjax", method=RequestMethod.POST)
    public String processNewAddressFormRequestNoAjax(HttpServletRequest request, Model model){
        // Remember, this parameter name matches the NAME of the form input
        // Not the id, the id is for styling purposes, not for processing
        String firstNameInput = request.getParameter("firstName");
        String lastNameInput = request.getParameter("lastName");
        String streetInput = request.getParameter("street");
        String cityInput = request.getParameter("city");
        String stateInput = request.getParameter("state");
        String zipCodeInput = request.getParameter("zipCode");

        Address address = new Address();
        address.setFirstName(firstNameInput);
        address.setLastName(lastNameInput);
        address.setStreet(streetInput);
        address.setCity(cityInput);
        address.setState(stateInput);
        address.setZipCode(zipCodeInput);
        
        // Make sure that you update the dao with your new information!!
        dao.addAddress(address);

        model.addAttribute("addressList", dao.getAllAddresses());
        return "noajax/otherhome";
//        return "redirect:displayAddressListNoAjax";
    }

    // String firstName, String lastName, String street, String city, String state, int zipCode, int addressID
    private void addABunchaAddresses() {
        Address[] addresses = {
            new Address("Doctor", "Who", "52 Wild Horse Rd", "Moses Lake", "WA", 98837, 0),
            new Address("Christoper", "Robins", "8676 Queen Dr.", "Rahway", "NJ", 07065, 1),
            new Address("Chance", "Fagen", "9540 South Birch Hill Court", "Waukegan", "IL", 60085, 2),
            new Address("Librada", "Weymouth", "106 Theatre Lane", "Redondo Beach", "CA", 90278, 3),
            new Address("Gladis", "Janicki", "159 Rockcrest St.", "Deltona", "Ky", 32725, 4),
            new Address("Danae", "Maddalena", "19 Bay Ave.", "Palm Coast", "FL", 32137, 5),
            new Address("Tuan", "Cattaneo", "885 East Clay Street", "Lake Mary", "FL", 32746, 6),
            new Address("Russel", "Chairez", "572 Green Lake Street", "Valparaiso", "IN", 46383, 7),
            new Address("Nedra", "Bellini", "84 S. Garden St.", "Fond Du Lac", "WI", 54935, 8),
            new Address("Bye-Felicia", "Domina", "75 Helen Ave.", "Hamden", "CT", 06514, 9)
        };

        Random r = new Random();
        dao.addAddress(addresses[r.nextInt(addresses.length)]);
    }

}
