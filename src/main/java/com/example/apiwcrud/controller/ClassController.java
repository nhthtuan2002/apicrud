package com.example.apiwcrud.controller;

import com.example.apiwcrud.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    @Autowired
    ClassService classService;

    @RequestMapping(value ="list",method = RequestMethod.GET)
    public ResponseEntity<List<Class>> findAllClass(){
        List<Class> lsClass = classService.findAll();
        if(lsClass.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Class>>(lsClass,HttpStatus.OK);
    }

    @RequestMapping(value ="classbyname",method = RequestMethod.GET)
    public ResponseEntity<List<Class>> findAllClass(@PathParam("name") String name){
        List<Class> lsClass = classService.findAllByName(name);
        if(lsClass.size()==0){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new  ResponseEntity<List<Class>>(lsClass,HttpStatus.OK);
    }




    @RequestMapping(value ="create",method = RequestMethod.POST)
    public ResponseEntity<Class> saveNewClass(@RequestBody Class c ){
        classService.saveClass(c);
        return new ResponseEntity<Class>(c,HttpStatus.OK);
    }
    //    http://localhost:8080/updateUser
    @RequestMapping(value ="update",method = RequestMethod.PUT)
    public ResponseEntity<Class> saveNewClass(
            @Param("id") Integer id,
            @RequestBody Class c ){
        Class oldClass = classService.findById(id);
        oldClass.setName(c.getName());
        oldClass.setRoom(c.getRoom());
        oldClass.setNote(c.getNote());
        classService.saveClass(oldClass);
        return new ResponseEntity<Class>(oldClass,HttpStatus.OK);
    }

    @RequestMapping(value ="delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Class> deleteClass(@PathVariable(value = "id") Integer id){
        classService.deleteClass(id);
        return ResponseEntity.ok().build();
    }
}
