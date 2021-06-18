/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.java.springboot.rest;

import cl.java.springboot.entities.Tareas;
import cl.java.springboot.models.JornadaModels;
import cl.java.springboot.models.TareasModels;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Gamer
 */
@Controller
@RequestMapping("/tareas")
public class TareasController {

    @Autowired
    RestTemplate restTemplate;
    Logger LOGGER = LoggerFactory.getLogger(TareasController.class);

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/obtenerTareas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTareas() {
        LOGGER.trace("ingresando al servicio : " + "obtenerTareas");
        try {
            ResponseEntity<Tareas[]> response
                    = restTemplate.getForEntity(
                            "http://localhost:8080/generator/schedule/tasks",
                            Tareas[].class);
            LOGGER.trace("invocando servicio externo /schedule/tasks");
            LOGGER.trace(Arrays.toString(response.getBody()));
            Tareas[] tareas = response.getBody();
            System.out.println(Arrays.toString(tareas));
            int horasJornada = 8;
            List<Tareas> listaTareasFor = new LinkedList<>(Arrays.asList(tareas));
            List<Tareas> listaTareasFor1 = new LinkedList<>(Arrays.asList(tareas));
            System.out.println(listaTareasFor.size());
            int totalHorasTrabajo = 0;
            for (Tareas countLista : listaTareasFor) {
                totalHorasTrabajo = totalHorasTrabajo + countLista.getDuration();
            }

            TareasModels tareasModelss = new TareasModels();
            tareasModelss.setHoras_jornadas(horasJornada);
            tareasModelss.setTotal_horas(totalHorasTrabajo);
            ArrayList<JornadaModels> jor1 = new ArrayList<>();

            int contadori = 0;
            for (int i = 0; i < listaTareasFor.size();) {
                if (listaTareasFor.isEmpty()) {
                    break;
                }
                switch (listaTareasFor.get(i).getDuration()) {
                    case 8:
                        ArrayList<String> str = new ArrayList<>();

                        str.add(listaTareasFor.get(i).getTask_id());
                        listaTareasFor.remove(i);
                        listaTareasFor1 = listaTareasFor;
                        //  i = 0;
                        if (str.size() > 0) {
                            contadori++;
                            JornadaModels obj = new JornadaModels(contadori, str);
                            jor1.add(obj);
                        }

                        break;
                    case 7:
                        int contadorFor7 = 0;
                        ArrayList<String> str1 = new ArrayList<>();
                        for (int a = 0; a < listaTareasFor1.size(); a++) {

                            if ((contadorFor7 + listaTareasFor1.get(a).getDuration()) <= horasJornada) {

                                str1.add(listaTareasFor1.get(a).getTask_id());
                                contadorFor7 = contadorFor7 + listaTareasFor1.get(a).getDuration();
                                listaTareasFor1.remove(a);

                            }
                        }
                        if (str1.size() > 0) {
                            contadori++;
                            JornadaModels obj1 = new JornadaModels(contadori, str1);
                            jor1.add(obj1);
                        }
                        // i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;

                    case 6:
                        int contadorFor6 = 0;
                        ArrayList<String> str2 = new ArrayList<>();
                        for (int e = 0; e < listaTareasFor1.size(); e++) {

                            if ((contadorFor6 + listaTareasFor1.get(e).getDuration()) <= horasJornada) {
                                str2.add(listaTareasFor1.get(e).getTask_id());
                                contadorFor6 = contadorFor6 + listaTareasFor1.get(e).getDuration();
                                listaTareasFor1.remove(e);

                            }
                        }
                        if (str2.size() > 0) {
                            contadori++;
                            JornadaModels obj2 = new JornadaModels(contadori, str2);
                            jor1.add(obj2);
                        }
                        listaTareasFor = listaTareasFor1;
                        //i = 0;
                        break;
                    case 5:
                        int contadorFor5 = 0;
                        ArrayList<String> str3 = new ArrayList<>();
                        for (int b = 0; b < listaTareasFor1.size(); b++) {

                            if ((contadorFor5 + listaTareasFor1.get(b).getDuration()) <= horasJornada) {
                                str3.add(listaTareasFor1.get(b).getTask_id());
                                contadorFor5 = contadorFor5 + listaTareasFor1.get(b).getDuration();
                                listaTareasFor1.remove(b);

                            }
                        }
                        if (str3.size() > 0) {
                            contadori++;
                            JornadaModels obj3 = new JornadaModels(contadori, str3);
                            jor1.add(obj3);
                        }
                        //i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 4:
                        int contadorFor4 = 0;
                        ArrayList<String> str4 = new ArrayList<>();
                        for (int c = 0; c < listaTareasFor1.size(); c++) {

                            if ((contadorFor4 + listaTareasFor1.get(c).getDuration()) <= horasJornada) {
                                str4.add(listaTareasFor1.get(c).getTask_id());
                                contadorFor4 = contadorFor4 + listaTareasFor1.get(c).getDuration();
                                listaTareasFor1.remove(c);

                            }
                        }
                        if (str4.size() > 0) {
                            contadori++;
                            JornadaModels obj4 = new JornadaModels(contadori, str4);
                            jor1.add(obj4);
                        }
                        // i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 3:
                        int contadorFor3 = 0;
                        ArrayList<String> str5 = new ArrayList<>();
                        for (int d = 0; d < listaTareasFor1.size(); d++) {

                            if ((contadorFor3 + listaTareasFor1.get(d).getDuration()) <= horasJornada) {
                                str5.add(listaTareasFor1.get(d).getTask_id());
                                contadorFor3 = contadorFor3 + listaTareasFor1.get(d).getDuration();
                                listaTareasFor1.remove(d);

                            }
                        }
                        if (str5.size() > 0) {
                            contadori++;
                            JornadaModels obj5 = new JornadaModels(contadori, str5);
                            jor1.add(obj5);
                        }
                        // i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 2:
                        int contadorFor2 = 0;
                        ArrayList<String> str6 = new ArrayList<>();
                        for (int f = 0; f < listaTareasFor1.size(); f++) {

                            if ((contadorFor2 + listaTareasFor1.get(f).getDuration()) <= horasJornada) {
                                str6.add(listaTareasFor1.get(f).getTask_id());
                                contadorFor2 = contadorFor2 + listaTareasFor1.get(f).getDuration();
                                listaTareasFor1.remove(f);

                            }
                        }
                        if (str6.size() > 0) {
                            contadori++;
                            JornadaModels obj6 = new JornadaModels(contadori, str6);
                            jor1.add(obj6);
                        }
                        //  i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 1:
                        int contadorFor1 = 0;
                        ArrayList<String> str7 = new ArrayList<>();
                        for (int g = 0; g < listaTareasFor1.size(); g++) {

                            if ((contadorFor1 + listaTareasFor1.get(g).getDuration()) <= horasJornada) {
                                str7.add(listaTareasFor1.get(g).getTask_id());
                                contadorFor1 = contadorFor1 + listaTareasFor1.get(g).getDuration();
                                listaTareasFor1.remove(g);

                            }
                        }
                        if (str7.size() > 0) {
                            contadori++;
                            JornadaModels obj7 = new JornadaModels(contadori, str7);
                            jor1.add(obj7);
                        }

                        //  i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                }
            }
            if (jor1.size() > 0) {
                tareasModelss.setJornadas(jor1);
                int DiasTrabajados = tareasModelss.getJornadas().size();
                tareasModelss.setDias_trabajo(DiasTrabajados);
            }

            LOGGER.trace("respuesta servicio obtenerTareas");
            LOGGER.trace(Arrays.toString(tareas));
            List<TareasModels> m = Arrays.asList(tareasModelss);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (RestClientException e) {
            LOGGER.error(e.toString());
            return new ResponseEntity<>("hubo un problema en el servicio.", HttpStatus.NO_CONTENT);
        }

    }

}
