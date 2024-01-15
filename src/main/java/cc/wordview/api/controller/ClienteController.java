package cc.wordview.api.controller;

import static cc.wordview.api.controller.util.ExceptionHandler.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.wordview.api.database.entity.Cliente;
import cc.wordview.api.request.ClienteCreateRequest;
import cc.wordview.api.request.ClienteUpdateRequest;
import cc.wordview.api.service.interf.ClienteServiceInterface;

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
        @Autowired
        private ClienteServiceInterface service;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<?> create(@RequestBody ClienteCreateRequest request) {
                return response(() -> {
                        Cliente cliente = service.insert(request.toEntity());
                        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
                });
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getById(@PathVariable Long id) {
                return response(() -> {
                        Cliente cliente = service.getById(id);
                        return new ResponseEntity<>(cliente, HttpStatus.OK);
                });
        }

        @PutMapping(consumes = "application/json")
        public ResponseEntity<?> update(@RequestBody ClienteUpdateRequest request) {
                return response(() -> {
                        Cliente cliente = service.update(request.toEntity());
                        return new ResponseEntity<>(cliente, HttpStatus.OK);
                });
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
