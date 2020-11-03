package com.example.demo.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserDaoService {

    private static List<User> users=new ArrayList<>();

    private static int userCount=3;
    static {
        users.add(new User(1,"Ro",new Date()));
        users.add(new User(2,"Wen",new Date()));
        users.add(new User(3,"Joe",new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        if (user.getId()==0) user.setId(++userCount);
        users.add(user);
        return user;
    }

    public User findOne(int id){
        Optional<User> first = users.stream().filter(user -> user.getId() == id).findFirst();
        if (!first.isPresent())
            throw new UserNotFoundException("id : "+id);

        return first.get();
    }
}
