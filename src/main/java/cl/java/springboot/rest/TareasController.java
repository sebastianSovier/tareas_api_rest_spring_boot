/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.java.springboot.rest;

import cl.java.springboot.entities.Tareas;
import cl.java.springboot.models.JornadaModels;
import cl.java.springboot.models.TareasModels;
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

    /**
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/obtenerTareas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> obtenerTareas() {
        // LOGGER.info("ingresando al servicio : " + "obtenerTareas");
        try {
            System.out.println("asdsadsa");
            ResponseEntity<Tareas[]> response
                    = restTemplate.getForEntity(
                            "http://localhost:8080/generator/schedule/tasks",
                            Tareas[].class);
            //  LOGGER.info("invocando servicio externo /schedule/tasks");
            //   LOGGER.info(Arrays.toString(response.getBody()));
            Tareas[] tareas = response.getBody();
            System.out.println(Arrays.toString(tareas));
            int horasJornada = 8;
            List<Tareas> listaTareasFor = new LinkedList<>(Arrays.asList(tareas));
            List<Tareas> listaTareasFor1 = new LinkedList<>(Arrays.asList(tareas));
            System.out.println(listaTareasFor.size());
            Double sumaDiasTrabajo = 0.0;
            int totalHorasTrabajo = 0;
            Long valorCalculo = 0L;
            for (Tareas countLista : listaTareasFor) {
                totalHorasTrabajo = totalHorasTrabajo + countLista.getDuration();
                sumaDiasTrabajo = sumaDiasTrabajo + countLista.getDuration();
                System.out.println(sumaDiasTrabajo);
            }
            sumaDiasTrabajo = sumaDiasTrabajo / 8;
            valorCalculo = Math.round(sumaDiasTrabajo);

            if (sumaDiasTrabajo % 2 != 0) {
                valorCalculo = valorCalculo + 1;
            }
            TareasModels tareasModelss = new TareasModels();
            tareasModelss.setDias_trabajo(Integer.valueOf(valorCalculo.toString()));
            tareasModelss.setHoras_jornadas(horasJornada);
            tareasModelss.setTotal_horas(totalHorasTrabajo);
            ArrayList<JornadaModels> jor1 = new ArrayList<>();
            ArrayList<String> str = new ArrayList<>();
            ArrayList<String> str1 = new ArrayList<>();
            ArrayList<String> str2 = new ArrayList<>();
            ArrayList<String> str3 = new ArrayList<>();
            ArrayList<String> str4 = new ArrayList<>();
            ArrayList<String> str5 = new ArrayList<>();
            ArrayList<String> str6 = new ArrayList<>();
            ArrayList<String> str7 = new ArrayList<>();
            for (int i = 0; i < listaTareasFor.size();) {
                if (listaTareasFor.isEmpty()) {
                    break;
                }

                switch (listaTareasFor.get(i).getDuration()) {
                    case 8:
                        System.out.println(listaTareasFor.get(i).getDuration());
                        System.out.println(listaTareasFor.get(i).getTask_name());
                        str.add(listaTareasFor.get(i).getTask_id()+"()");
                        listaTareasFor.remove(i);
                        i = 0;
                        break;
                    case 7:

                        int contadorCase7 = listaTareasFor.get(i).getDuration();
                        int contadorFor7 = 0;
                        for (int a = 0; a < listaTareasFor1.size(); a++) {
                            if (contadorCase7 + contadorFor7 <= horasJornada) {
                                str1.add(listaTareasFor1.get(a).getTask_id()+"()");
                                contadorFor7 = listaTareasFor1.get(a).getDuration();
                                listaTareasFor1.remove(a);

                                System.out.println(listaTareasFor1);
                            }
                        }
                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;

                    case 6:

                        int contadorCase6 = listaTareasFor.get(i).getDuration();
                        int contadorFor6 = 0;
                        for (int e = 0; e < listaTareasFor1.size(); e++) {
                            if (contadorCase6 + contadorFor6 <= horasJornada) {
                                str2.add(listaTareasFor1.get(e).getTask_id()+"()");
                                contadorFor6 = listaTareasFor1.get(e).getDuration();
                                listaTareasFor1.remove(e);
                                System.out.println(listaTareasFor1);
                            }
                        }

                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 5:

                        int contadorCase5 = listaTareasFor.get(i).getDuration();
                        int contadorFor5 = 0;
                        for (int b = 0; b < listaTareasFor1.size(); b++) {
                            if (contadorCase5 + contadorFor5 <= horasJornada) {
                                str3.add(listaTareasFor1.get(b).getTask_id()+"()");
                                contadorFor5 = listaTareasFor1.get(b).getDuration();
                                listaTareasFor1.remove(b);
                                System.out.println(listaTareasFor1);
                            }
                        }

                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 4:

                        int contadorCase4 = listaTareasFor.get(i).getDuration();
                        int contadorFor4 = 0;

                        for (int c = 0; c < listaTareasFor1.size(); c++) {
                            if (contadorCase4 + contadorFor4 <= horasJornada) {
                                str4.add(listaTareasFor1.get(c).getTask_id()+"()");
                                contadorFor4 = listaTareasFor1.get(c).getDuration();
                                listaTareasFor1.remove(c);
                                System.out.println(listaTareasFor1);
                            }
                        }

                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 3:
                        int contadorCase3 = listaTareasFor.get(i).getDuration();
                        int contadorFor3 = 0;
                        for (int d = 0; d < listaTareasFor1.size(); d++) {
                            if (contadorCase3 + contadorFor3 <= horasJornada) {
                                str5.add(listaTareasFor1.get(d).getTask_id()+"()");
                                contadorFor3 = listaTareasFor1.get(d).getDuration();
                                listaTareasFor1.remove(d);
                                System.out.println(listaTareasFor1);
                            }
                        }
                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 2:
                        int contadorCase2 = listaTareasFor.get(i).getDuration();
                        int contadorFor2 = 0;
                        for (int f = 0; f < listaTareasFor1.size(); f++) {
                            if (contadorCase2 + contadorFor2 <= horasJornada) {
                                str6.add(listaTareasFor1.get(f).getTask_id()+"()");
                                contadorFor2 = listaTareasFor1.get(f).getDuration();
                                listaTareasFor1.remove(f);
                            }
                        }
                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                    case 1:
                        int contadorCase1 = listaTareasFor.get(i).getDuration();
                        int contadorFor1 = 0;
                        for (int g = 0; g < listaTareasFor1.size(); g++) {
                            if (contadorCase1 + contadorFor1 <= horasJornada) {
                                str7.add(listaTareasFor1.get(g).getTask_id()+"()");
                                contadorFor1 = listaTareasFor1.get(g).getDuration();
                                listaTareasFor1.remove(g);
                            }
                        }
                        i = 0;
                        listaTareasFor = listaTareasFor1;
                        break;
                }
            }
            int contadori = 0;
            if (str.size() > 0) {
                contadori++;
                JornadaModels obj = new JornadaModels(contadori, str);
                jor1.add(obj);
            }
            if (str1.size() > 0) {
                contadori++;
                JornadaModels obj1 = new JornadaModels(contadori, str1);
                jor1.add(obj1);
            }
            if (str2.size() > 0) {
                contadori++;
                JornadaModels obj2 = new JornadaModels(contadori, str2);
                jor1.add(obj2);
            }
            if (str3.size() > 0) {
                contadori++;
                JornadaModels obj3 = new JornadaModels(contadori, str3);
                jor1.add(obj3);
            }
            if (str4.size() > 0) {
                contadori++;
                JornadaModels obj4 = new JornadaModels(contadori, str4);
                jor1.add(obj4);
            }
            if (str5.size() > 0) {
                contadori++;
                JornadaModels obj5 = new JornadaModels(contadori, str5);
                jor1.add(obj5);
            }
            if (str6.size() > 0) {
                contadori++;
                JornadaModels obj6 = new JornadaModels(contadori, str6);
                jor1.add(obj6);
            }
            if (str7.size() > 0) {
                contadori++;
                JornadaModels obj7 = new JornadaModels(contadori, str7);
                jor1.add(obj7);
            }

            tareasModelss.setJornadas(jor1);
            //  LOGGER.info("respuesta servicio obtenerTareas");
            // LOGGER.info(Arrays.toString(tareas));
            List<TareasModels> m = Arrays.asList(tareasModelss);
            return new ResponseEntity<>(m, HttpStatus.OK);
        } catch (RestClientException e) {
            System.out.println(e.toString());
            return new ResponseEntity<>(e.toString(), HttpStatus.NO_CONTENT);
        }

    }

}
