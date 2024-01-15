package cc.wordview.api.controller;

import static cc.wordview.api.controller.util.ExceptionHandler.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.wordview.api.database.entity.Produto;
import cc.wordview.api.request.ProdutoCreateRequest;
import cc.wordview.api.request.ProdutoUpdateRequest;
import cc.wordview.api.service.interf.ProdutoServiceInterface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
        @Autowired
        private ProdutoServiceInterface service;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<?> create(@RequestBody ProdutoCreateRequest request) {
                return response(() -> {
                        Produto produto = service.insert(request.toEntity());
                        return new ResponseEntity<>(produto, HttpStatus.CREATED);
                });
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getById(@PathVariable Long id) {
                return response(() -> {
                        Produto produto = service.getById(id);
                        return new ResponseEntity<>(produto, HttpStatus.OK);
                });
        }

        @PutMapping(consumes = "application/json")
        public ResponseEntity<?> update(@RequestBody ProdutoUpdateRequest request) {
                return response(() -> {
                        Produto produto = service.update(request.toEntity());
                        return new ResponseEntity<>(produto, HttpStatus.OK);
                });
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
}
