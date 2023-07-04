package com.demo.conferencedemo.Repository;

import com.demo.conferencedemo.Entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository  extends JpaRepository<Session,Long> {

}
