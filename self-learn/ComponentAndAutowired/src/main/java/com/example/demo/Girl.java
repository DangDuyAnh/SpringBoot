package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class Girl {

    @Autowired
    Outfit outfit;

    public Girl() {
    }

    public Girl(Outfit outfit) {
        this.outfit = outfit;
    }

    // GET
    // SET
}
