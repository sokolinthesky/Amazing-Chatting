module ua.yurkov.amazingchatting {
    //jpa
    requires hibernate.jpa;

    //spring
    requires spring.context;
    requires spring.data.jpa;
    requires spring.web;
    requires spring.tx;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.websocket;
    requires spring.messaging;

    //logging
    requires slf4j.api;

    //mapper
    requires modelmapper;
}