/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.dao;

import com.swcguild.addressbookmvc.model.Address;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author apprentice
 */
public interface AddressBookDAO {
    
        //Create
    public Address addAddress(Address address);
    
    //read
    public Address getAddressById(int addressId);
    public List<Address> getAllAddresses();
    
    public List<Address> searchAddress(Map<SearchTerm, String> criteria);
    public List<Address> searchAddress(Predicate<Address> criteria);
    
    
    //update
    public void updateAddress(Address address);
    
    //delete
    public Address removeAddress(int addressId);
    
}
