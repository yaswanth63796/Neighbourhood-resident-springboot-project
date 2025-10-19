package com.neighborhoodhelp.neighborhood_help.controller;



import com.neighborhoodhelp.neighborhood_help.model.HelpRequest;
import com.neighborhoodhelp.neighborhood_help.service.HelpRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class HelpRequestController {
    private final HelpRequestService helpRequestService;

    public HelpRequestController(HelpRequestService helpRequestService) {
        this.helpRequestService = helpRequestService;
    }

    @PostMapping("/{postedById}")
    public HelpRequest create(@PathVariable Long postedById, @RequestBody HelpRequest request) {
        return helpRequestService.createRequest(postedById, request);
    }

    @GetMapping
    public List<HelpRequest> getAll() {
        return helpRequestService.getAllRequests();
    }
}

