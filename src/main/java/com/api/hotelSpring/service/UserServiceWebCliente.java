package com.api.hotelSpring.service;


import com.api.hotelSpring.model.UserModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceWebCliente {


    private final WebClient webClient;

    public UserModel getUser(String username) throws WebClientResponseException.NotFound {
        UserModel user = webClient
                .method(HttpMethod.GET)
                .uri("/" + username)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new Exception("User not found")))
                .bodyToMono(UserModel.class)
                .block();

        ObjectMapper mapper = new ObjectMapper();

            return mapper.convertValue(user, UserModel.class);
    }

}
