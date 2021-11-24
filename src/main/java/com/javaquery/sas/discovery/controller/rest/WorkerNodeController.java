package com.javaquery.sas.discovery.controller.rest;

import com.javaquery.sas.discovery.controller.rest.request.WorkerNodeFindRequest;
import com.javaquery.sas.discovery.controller.rest.request.WorkerNodeRequest;
import com.javaquery.sas.discovery.controller.rest.response.CommonResponse;
import com.javaquery.sas.discovery.model.mongodb.WorkerNode;
import com.javaquery.sas.discovery.service.WorkerNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author vicky.thakor
 * @since 1.0.0
 */
@RestController
@RequestMapping("/worker-nodes")
@Validated
public class WorkerNodeController {

    @Autowired
    private WorkerNodeService workerNodeService;

    @GetMapping
    public CommonResponse<List<WorkerNode>> findAllWorkerNodes(){
        return CommonResponse.of(workerNodeService.findAllWorkerNodes());
    }

    @PostMapping("/find")
    public CommonResponse<List<WorkerNode>> findWorkerNodes(@RequestBody WorkerNodeFindRequest request){
        return CommonResponse.of(workerNodeService.findWorkerNodes(request));
    }

    @PostMapping
    public CommonResponse<WorkerNode> saveWorkerNode(@RequestBody @Valid WorkerNodeRequest request){
        return CommonResponse.of(workerNodeService.save(request));
    }

    @PutMapping("/{id}")
    public CommonResponse<WorkerNode> updateWorkerNode(@PathVariable ("id") String id, @RequestBody @Valid WorkerNodeRequest request){
        return CommonResponse.of(workerNodeService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public CommonResponse<WorkerNode> deleteWorkerNode(@PathVariable ("id") String id){
        return CommonResponse.of(workerNodeService.delete(id));
    }
}
