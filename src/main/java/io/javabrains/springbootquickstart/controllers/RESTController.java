package io.javabrains.springbootquickstart.controllers;

import io.javabrains.springbootquickstart.services.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RESTController {

    @Autowired
    private DictionaryService dictionService;

    @GetMapping("/getNames")
    public String getPrefixNames(@RequestParam String prefix) {

        if (prefix == null || prefix.length()==0) {
            return "Illegal string was given, please type a new name prefix.";
        }
        boolean flag = prefix.matches("[a-zA-Z]+");
        if(!flag){
            return "Illegal string was given, please type a new name prefix.";
        }
        List<String> list = dictionService.getNames(prefix);
        if (list.isEmpty()) {
            return "No names that begin with the given prefix were found.";
        }
        return list.toString();
    }

}
