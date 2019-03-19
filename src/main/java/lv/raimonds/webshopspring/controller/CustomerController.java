package lv.raimonds.webshopspring.controller;


import lv.raimonds.webshopspring.model.Customer;
import lv.raimonds.webshopspring.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping("customers")
    public List<Customer> getAllCustomer(){
        System.out.println("Get all Customer...");
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);

        return customers;
    }

    @PostMapping("/customer")
    public Customer postCustomer(@RequestBody Customer customer) {

        Customer _customer = customerRepository.save(new Customer(customer.getName(), customer.getAge()));
        return _customer;
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
        System.out.println("Delete Customer with ID = " + id + "...");

        customerRepository.deleteById(id);

        return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
    }
    @GetMapping("customers/age/{age}")
    public List<Customer> findByAge(@PathVariable int age) {

        List<Customer> customers = customerRepository.findByAge(age);
        return customers;
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        System.out.println("Update Customer with ID = " + id + "...");

        Optional<Customer> customerData = customerRepository.findById(id);

        if (customerData.isPresent()) {
            Customer _customer = customerData.get();
            _customer.setName(customer.getName());
            _customer.setAge(customer.getAge());
            _customer.setActive(customer.isActive());
            return new ResponseEntity<>(customerRepository.save(_customer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }









}
