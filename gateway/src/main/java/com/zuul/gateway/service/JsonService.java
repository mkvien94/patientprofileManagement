package com.zuul.gateway.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JsonService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Configuration configuration;

    public String writeValueAsString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public DocumentContext toDocumentContext(String s) {
        return JsonPath.using(configuration).parse(s);
    }
}
