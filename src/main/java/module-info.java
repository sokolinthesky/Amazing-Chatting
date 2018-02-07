module ua.yurkov.amazingchatting {
    //jpa
    requires hibernate.jpa;

    //spring
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.tx;
    requires spring.web;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.boot;
    requires spring.boot.autoconfigure;

    //logging
    requires slf4j.api;

    //mapper
    requires modelmapper;
}