package com.integrative.project.controller.health;

import com.integrative.project.model.User;
import com.integrative.project.service.ServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/v1/users")
public class Controller {
    private final ServiceI serviceI;

    public Controller(ServiceI serviceI) {
        this.serviceI = serviceI;
    }

    @GetMapping
    public ResponseEntity<HashMap<Integer, User>> all(){
        return new ResponseEntity<>(serviceI.all(), HttpStatus.OK);
    }

    @GetMapping("{idUser}")
    public ResponseEntity<User> readById(@PathVariable("idUser") Integer id){
        return new ResponseEntity<>(serviceI.readById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(serviceI.createUser(user), HttpStatus.OK);
    }

    @PostMapping("{idUser}")
    public ResponseEntity<User> updateUser(@PathVariable("idUser") Integer id, User user){
        return new ResponseEntity<>(serviceI.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping("{idUser}")
    public ResponseEntity deleteUser(@PathVariable("idUser") Integer id){
        boolean user = serviceI.deleteUser(id);
        if(user == true){
            return new ResponseEntity(HttpStatus.OK);
        } else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
