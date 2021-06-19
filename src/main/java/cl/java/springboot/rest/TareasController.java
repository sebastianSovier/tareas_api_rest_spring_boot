/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.java.springboot.rest;

import cl.java.springboot.bo.TareasBo;
import cl.java.springboot.models.TareasModels;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;

/**
 *
 * @author Gamer
 */
@Controller
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    TareasBo tareasBo;
    
    Logger LOGGER = LoggerFactory.getLogger(TareasController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/obtenerTareas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTareas() {
        LOGGER.trace("ingresando al servicio : " + "obtenerTareas");

        List<TareasModels> response = tareasBo.calculoDeTareasPorDia();
        try {

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RestClientException e) {
            LOGGER.error(e.toString());
            return new ResponseEntity<>("hubo un problema en el servicio.", HttpStatus.NO_CONTENT);
        }

    }

}
