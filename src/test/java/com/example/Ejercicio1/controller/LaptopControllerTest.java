package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.entities.Laptop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    //Usaremos autowired para decirle a spring que no inyecte RestTemplateBuilder restTemplateBuilder
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @Test
    void findAll() {
        ResponseEntity<Laptop[]> response =
                testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        List<Laptop> laptops = Arrays.asList(response.getBody());
        System.out.println(laptops.size());
    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response =
                testRestTemplate.getForEntity("/api/laptops/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }

    @Test
    void create() {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json =  """
                        {
                       "price": 680.0,
                       "model": "Asus",
                       "serie": "K55U"
                        }
                """;
        HttpEntity<String> request = new HttpEntity<>(json,header);
        ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops",HttpMethod.POST,request,Laptop.class);
        Laptop laptop1 = response.getBody();
        assertEquals(1L,laptop1.getId());
        assertEquals("Laptop creado desde Spring Test",laptop1.getModel());
    }
}