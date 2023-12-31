package com.demo.conferencedemo.Controller;

import com.demo.conferencedemo.Entity.Session;
import com.demo.conferencedemo.Repository.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;
    @GetMapping
    public List<Session> list(){
        return sessionRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id){
        return sessionRepository.getReferenceById(id);
    }
    @PostMapping
    public Session create (@RequestBody final Session session){
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteSession (@PathVariable Long id){
        sessionRepository.deleteById(id);
    }
    @RequestMapping(value= "{id}", method = RequestMethod.PUT)
    public Session updateSession(@PathVariable Long id, @RequestBody Session session){
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session,existingSession,"session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }
}
