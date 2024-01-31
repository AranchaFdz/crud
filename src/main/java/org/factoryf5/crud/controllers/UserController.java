package org.factoryf5.crud.controllers;

import org.factoryf5.crud.models.UserModel;
import org.factoryf5.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user") //Aqui definimos la ruta
public class UserController {
    // Aqui definimos las peticiones HTTP y las rutas

    @Autowired
    private UserService userService;

    @GetMapping//("/getusers")
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping // Hacemos una request atraves del body postman
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);

        if(ok){
            return "user with id " + id + "deleted correctly.";
        } else {
            return "Error, we can not find the user with id " + id + "sorry.";
        }

    }
}

