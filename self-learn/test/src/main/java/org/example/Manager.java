package org.example;

class Manager extends Employee {
    @Override
    String getDetail() {
        return "Manager Detail";
    }

    String only() {
        return "only";
    }
}
