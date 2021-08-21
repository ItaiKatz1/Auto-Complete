package io.javabrains.springbootquickstart.services;

import io.javabrains.springbootquickstart.models.NameRepo;
import io.javabrains.springbootquickstart.models.people;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


@Service
public class DictionaryService implements InitializingBean {

    private List<people> names;
    private HashMap<String, LinkedList<String>> dictionary;
    @Autowired
    NameRepo repo;

    @Override
    /**
     * The function runs when the application starts, reads all the names from the DB.
     * In addition, creates a hashmap where every substring of a name is a key and the value is a linked-list of the names that begin with the given prefix.
     */
    public void afterPropertiesSet() throws Exception {
        try {
            dictionary = new HashMap<>();
            names = repo.findAll();
            for (people name : names) {
                String word = name.getName();
                for (int i = 0; i < word.length(); i++) {
                    String subword = word.substring(0, i + 1);
                    LinkedList<String> temp = new LinkedList<>();
                    if (!dictionary.containsKey(subword)) {
                        temp.add(word);
                        dictionary.put(subword, temp);
                    } else {
                        temp = dictionary.get(subword);
                        temp.add(word);
                        dictionary.put(subword, temp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Could not build the data-structure properly, please check the database is correct.");
        }
    }

    /**
     * The function receives a prefix, and returns all the names that begin with the prefix.
     * If no name that starts with such prefix exists, returns an empty list.
     *
     * @param prefix
     * @return
     */
    public List<String> getNames(String prefix) {

        //to make the application case-sensitive, we lower-case the prefix and upper-case only the first letter
        String casePrefix = prefix.toLowerCase();
        casePrefix = Character.toUpperCase(casePrefix.charAt(0)) + casePrefix.substring(1);

        if (dictionary.containsKey(casePrefix)) {
            return dictionary.get(casePrefix);
        } else {
            return new LinkedList<>();
        }
    }
}
