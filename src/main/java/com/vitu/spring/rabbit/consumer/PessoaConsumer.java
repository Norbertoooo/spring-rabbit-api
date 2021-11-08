package com.vitu.spring.rabbit.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.spring.rabbit.domain.Pessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class PessoaConsumer {

    @Value("${queue.pessoa.name}")
    String queueName;

    @RabbitListener(queues = "${queue.pessoa.name}")
    public void receberPessoa(Message message) throws IOException {
        log.info("Recebendo pessoa");
        log.info("Mensagem recebida: {}", message);
        Pessoa pessoaRecebida = new ObjectMapper().readValue(message.getBody(), Pessoa.class);
        log.info("Pessoa recebida: {}", pessoaRecebida);
    }

}
