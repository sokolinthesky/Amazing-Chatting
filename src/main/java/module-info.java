module ua.yurkov.amazingchatting {
    //java
    requires java.xml;
    requires java.annotation;

    //jpa
    requires hibernate.jpa;

    //spring
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires spring.web;
    requires spring.webflux;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    //reactor
    requires reactor.core;

    //logging
    requires slf4j.api;

    //mapper
    requires modelmapper;
}