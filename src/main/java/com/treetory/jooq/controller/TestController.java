package com.treetory.jooq.controller;

import com.treetory.jooq.model.SampleModel;
import com.treetory.jooq.service.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class TestController {

    private final TestService testService;
    public TestController(TestService testService) { this.testService = testService; }

    /**
     * Retrieve
     *
     * @param request
     * @param response
     * @param modelName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/test/{modelName}",
            method = {RequestMethod.GET},
            produces = { MediaType.APPLICATION_JSON_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseStatus(HttpStatus.OK)
    public SampleModel getModelWithCameraIntrinsicParameter(
            HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable String modelName) throws Exception {
        return testService.getTest(modelName);
    }

}
