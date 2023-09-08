package com.dh.catalogservice.Feign;

import com.dh.catalogservice.model.Serie;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "serie-service")
@LoadBalancerClient(name = "serie-service", configuration = MovieConfiguration.class)
public interface ISerieClient {

        @GetMapping("/series/{genre}")
        public List<Serie> getSeriesBygGenre(@PathVariable String genre);

        @PostMapping("/series/save")
        public String create(@RequestBody Serie serie);
}

