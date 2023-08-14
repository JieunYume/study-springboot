package com.another;

import com.example.Person;

public class Stranger {
    public void printInfo(Person person) {
        System.out.println(person.name); // 가능
        // System.out.println(person.age); // 오류! protected 멤버
        // System.out.println(person.address); // 오류! private 멤버
        // System.out.println(person.phoneNumber); // 오류! 패키지 레벨
    }
}