package com.nector.student.restInvoker;

import com.nector.student.dto.ResponseDTO;
import com.nector.student.exception.ErrorGettingResponseThroughHttpRequest;
import com.nector.student.exception.ServiceNotAvailableException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseClient {

    @Value("${base.url}")
    public String baseUrl;

    private final RestTemplate restTemplate;


    public CourseClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Object> getMarkList(final long studentId) {
        ResponseEntity<ResponseDTO> responseEntity;
        try{
            responseEntity = restTemplate.getForEntity(baseUrl+"course/get-student-marklist/" + studentId, ResponseDTO.class);
        } catch (Exception e) {
            throw new ServiceNotAvailableException(e.getMessage());
        }
        if(responseEntity == null && responseEntity.getStatusCode() != HttpStatusCode.valueOf(200)) {
            throw  new ErrorGettingResponseThroughHttpRequest("Error while fetching data from course-service");
        }
        ResponseDTO body = responseEntity.getBody();
        return  (List<Object>) body.getData();
    }
}
