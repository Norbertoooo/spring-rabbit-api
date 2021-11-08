package com.vitu.spring.rabbit.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitu.spring.rabbit.domain.Pessoa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class PessoaProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void enviarPessoa() throws JsonProcessingException {
        log.info("Enviando pessoa!");
        String pessoa = new ObjectMapper().writeValueAsString(new Pessoa("vitor", 24));
        rabbitTemplate.convertAndSend(queue.getName(), pessoa);
    }

}
