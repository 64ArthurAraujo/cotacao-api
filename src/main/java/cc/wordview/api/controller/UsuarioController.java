package cc.wordview.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.wordview.api.database.entity.Usuario;
import cc.wordview.api.request.UsuarioCreateRequest;
import cc.wordview.api.request.UsuarioUpdateRequest;
import cc.wordview.api.response.UsuarioSafeResponse;
import cc.wordview.api.service.interf.UsuarioServiceInterface;

import static cc.wordview.api.controller.util.ExceptionHandler.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

        @Autowired
        private UsuarioServiceInterface service;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<?> create(@RequestBody UsuarioCreateRequest request) {
                return response(() -> {
                        Usuario usuario = service.insert(request.toEntity());
                        return new ResponseEntity<>(usuario.getId(), HttpStatus.CREATED);
                });
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> getById(@PathVariable Long id) {
                return response(() -> {
                        Usuario usuario = service.getById(id);
                        return new ResponseEntity<>(new UsuarioSafeResponse(usuario), HttpStatus.OK);
                });
        }

        @PutMapping(consumes = "application/json")
        public ResponseEntity<?> update(@RequestBody UsuarioUpdateRequest request) {
                return response(() -> {
                        Usuario usuario = service.update(request.toEntity());
                        return new ResponseEntity<>(usuario.getId(), HttpStatus.OK);
                });
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable Long id) {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
