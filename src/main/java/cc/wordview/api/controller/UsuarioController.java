package cc.wordview.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.wordview.api.database.entity.Usuario;
import cc.wordview.api.request.UsuarioCreateRequest;
import cc.wordview.api.service.interf.UsuarioServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

        @Autowired
        private UsuarioServiceInterface service;

        @PostMapping(consumes = "application/json")
        public ResponseEntity<?> novoUsuario(@RequestBody UsuarioCreateRequest request) {
                try {
                        Usuario usuario = service.insert(request.toEntity());
                        return new ResponseEntity<>(usuario.getId(), HttpStatus.CREATED);
                } catch (Exception e) {
                        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
                }
        }
        
}
