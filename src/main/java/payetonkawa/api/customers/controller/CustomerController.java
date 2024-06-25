package payetonkawa.api.customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payetonkawa.api.customers.model.Customer;
import payetonkawa.api.customers.service.CustomerService;

import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Crée un nouveau client en base de données
     * @param customer l'objet à créer
     * @return le client enregistré
     */
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService.saveCustomer(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Récupère un client par son identifiant
     * @param id l'identifiant du client
     * @return une réponse http OK contenant l'objet client s'il existe, sinon une réponse http NOT_FOUND ou une réponse HTTP INTERNAL_SERVER_ERROR en cas d'erreur du serveur
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") final Integer id) {
        try {
            Optional<Customer> client = customerService.findCustomerById(id);
            if (client.isPresent()) {
                return ResponseEntity.ok(client.get());
            }
            else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Récupère une liste de clients
     * @return une réponse HTTP OK contenant la liste des clients, ou une réponse HTTP INTERNAL_SERVER_ERROR en cas d'erreurs
     */
    @GetMapping("/customers")
    public ResponseEntity<Iterable<Customer>> getCustomers() {
        try {
            Iterable<Customer> customers = customerService.getAllCustomers();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Met à jour un client
     * @param id l'identifiant du client
     * @param customer le client qu'on veut mettre à jour
     * @return retourne l'objet client mis à jour
     */
    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") final Integer id, @RequestBody Customer customer) {
        try {
            Optional<Customer> c = customerService.findCustomerById(id);
            if (c.isPresent()) {
                Customer currentCustomer = c.get();

                String firstName = customer.getFirstName();
                if(firstName != null) {
                    currentCustomer.setFirstName(firstName);
                }
                String lastName = customer.getLastName();
                if(lastName != null) {
                    currentCustomer.setLastName(lastName);;
                }
                String mail = customer.getMail();
                if(mail != null) {
                    currentCustomer.setMail(mail);
                }
                String address = customer.getAddress();
                if(address != null) {
                    currentCustomer.setAddress(address);
                }
                String company = customer.getCompany();
                if(company != null) {
                    currentCustomer.setCompany(company);
                }
                customerService.saveCustomer(currentCustomer);
                return new ResponseEntity<>(currentCustomer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Supprime un client par son identifiant
     * @param id l'identifiant du client
     */
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") final Integer id) {
        try {
            customerService.deleteCustomerById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
