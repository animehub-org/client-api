package org.animefoda.client.controllers;

import entities.state.State;
import entities.state.StateDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import response.ApiResponse;
import services.StateService;

import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {
    private final StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/all")
    public ApiResponse<List<StateDTO>> allGenres() {
        return ApiResponse.setSuccess(stateService.getAll().stream().map(State::toDTO).toList());
    }
}
