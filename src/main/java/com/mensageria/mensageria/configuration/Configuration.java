package com.mensageria.mensageria.configuration;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;

public class Configuration {

    private static CachingConnectionFactory connectionFactory;

    public static CachingConnectionFactory getConnection(){
        if(connectionFactory == null){
            connectionFactory = new CachingConnectionFactory("jackal.rmq.cloudamqp.com");
            connectionFactory.setUsername("lkfjfkci");
            connectionFactory.setPassword("r0eSNn_4jW0_4dDPpUGhGihubbWcTBW2");
            connectionFactory.setVirtualHost("lkfjfkci");

            connectionFactory.setRequestedHeartBeat(30);
            connectionFactory.setConnectionTimeout(30000);
        }
        return connectionFactory;
    }
}
