package cc.wordview.api.test.api.controller;

import cc.wordview.api.Application;
import cc.wordview.api.test.api.controller.mockentity.MockUsuario;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.MethodName.class)
public class UsuarioControllerTest {
        @Autowired
        private MockMvc request;

        @Test
        void create() throws Exception {
                MockUsuario mock = new MockUsuario("Arthur N.", "test@example.com",
                                "Qwerty12345");

                TestRequest.post(request, "/usuario", mock.toJson(), status().isCreated());
        }

        @Test
        void createEmailExistente() throws Exception {
                MockUsuario mock = new MockUsuario("Arthur N.", "usuario1@example.com",
                                "Qwerty12345");

                TestRequest.post(request, "/usuario", mock.toJson(), status().isInternalServerError());
        }
}
