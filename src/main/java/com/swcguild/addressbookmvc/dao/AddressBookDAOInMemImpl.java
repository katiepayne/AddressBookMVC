/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookmvc.dao;

import com.swcguild.addressbookmvc.model.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author apprentice
 */
public class AddressBookDAOInMemImpl implements AddressBookDAO {

    private ArrayList<Address> addresses = new ArrayList<>();
    private static int addressIDCounter = 0;

    @Override
    public Address addAddress(Address address) {
        address.setAddressID(addressIDCounter);
        addressIDCounter++;
        addresses.add(address);
        return address;
    }

    @Override
    public Address getAddressById(int addressID) {

        Optional<Address> address = addresses.stream()
                .filter(bob -> bob.getAddressID() == addressID)
                .findFirst();

        if (address.isPresent()) {
            return address.get();
        }

        return null;
    }

    @Override
    public List<Address> getAllAddresses() {
        return addresses;
    }

    @Override
    public List<Address> searchAddress(Map<SearchTerm, String> criteria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Address> searchAddress(Predicate<Address> filter) {
        return addresses.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    @Override
    public void updateAddress(Address address) {
        Address x = this.getAddressById(address.getAddressID());
        if (x != null) {
            addresses.remove(x);
            addresses.add(address);
        }
    }

    @Override
    public Address removeAddress(int addressID) {
        Address x = this.getAddressById(addressID);
        if (x != null) {
            addresses.remove(x);
        }
        return x;
    }

}
