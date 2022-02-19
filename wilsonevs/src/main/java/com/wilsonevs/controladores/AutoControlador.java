package com.wilsonevs.controladores;

import com.wilsonevs.modelos.dto.AutoDTO;
import com.wilsonevs.modelos.dto.AutoFiltroDTO;
import com.wilsonevs.modelos.dto.AutoInsertarDTO;
import com.wilsonevs.modelos.dto.RespuestaPaginada;
import com.wilsonevs.modelos.modelo.Auto;
import com.wilsonevs.negocio.AutoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/auto")
public class AutoControlador {

    @Autowired
    private AutoNegocio autoNegocio;

    @GetMapping("/")
    public ResponseEntity<RespuestaPaginada<Auto>> obtenerLista(@PathParam("id") AutoFiltroDTO datos){
        return new ResponseEntity<>(autoNegocio.obtenerLista(datos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutoDTO> obtenerPorId(@PathVariable("id") Integer id){
        return new ResponseEntity<>(autoNegocio.obtenerPorId(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<AutoInsertarDTO> insertar(@RequestBody AutoInsertarDTO dto) {
        return new ResponseEntity<>(autoNegocio.insertar(dto), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<Auto> actualizar(@RequestBody Auto dto) {
        return new ResponseEntity<>(autoNegocio.actualizar(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Auto> eliminar(@PathVariable("id") Integer id){
        return new ResponseEntity<>(autoNegocio.eliminar(id), HttpStatus.OK);
    }


}
