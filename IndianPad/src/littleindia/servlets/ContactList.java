package littleindia.servlets;



import java.util.ArrayList;

import java.util.Collection;





public class ContactList {

    

    private Collection<Contact> customers;

    

    public ContactList(){

    }

    

    public ContactList(Collection<Contact> customers){

        this.customers = customers;

    }

    

    public ContactList(Contact c) {

        this.customers = new ArrayList<Contact>();

        this.customers.add(c);

    }



    public Collection<Contact> getCustomers() {

        return customers;

    }



    public void setCustomers(Collection<Contact> c) {

        this.customers = c;

    }

}

