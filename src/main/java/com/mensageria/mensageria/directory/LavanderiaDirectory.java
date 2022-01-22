package com.mensageria.mensageria.directory;

import com.mensageria.mensageria.configuration.Configuration;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;


public class LavanderiaDirectory {

    public static void main (String[]args){

        RabbitAdmin admin = new RabbitAdmin(Configuration.getConnection());
        Queue queueLavanderia = new Queue("lavanderia");
        final String exchange = "exchange.lavanderia";
        admin.declareQueue(queueLavanderia);

        DirectExchange directExchange = new DirectExchange(exchange);
        admin.declareExchange(directExchange);

        admin.declareBinding(BindingBuilder.bind(queueLavanderia).to(directExchange).with("iclean"));

        RabbitTemplate template = new RabbitTemplate(Configuration.getConnection());
        template.convertAndSend(exchange, "iclean", "{\"nome\":\"5 A SEC\", \"endereco\":\"Avenida do Rio Bonito\"}");

    }
}
