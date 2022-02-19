package com.wilsonevs.negocio;

import com.wilsonevs.excepciones.DatosInvalidosExcepcion;
import com.wilsonevs.modelos.dto.*;
import com.wilsonevs.modelos.modelo.Auto;
import com.wilsonevs.repositorio.mysql.AutoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoNegocio {

    @Autowired
    private AutoDao autoDao;

    public RespuestaPaginada<Auto> obtenerLista(AutoFiltroDTO datos){
        RespuestaPaginada<Auto> autoRespuestaPaginada = new RespuestaPaginada<>();
        autoRespuestaPaginada.setLista(autoDao.obtenerLista(datos));
        autoRespuestaPaginada.setTotal(autoDao.totalLista(datos));
        return autoRespuestaPaginada;
    }

    public AutoDTO obtenerPorId(Integer id){
        validarId(id);
        AutoDTO dto = new AutoDTO();
        dto.setAuto(autoDao.obtenerPorId(id));
        return dto;
    }


    public AutoInsertarDTO insertar (AutoInsertarDTO dto){
        autoDao.insertar(dto);
        return dto;
    }

    public Auto actualizar (Auto dto){
        autoDao.actualizar(dto);
        return dto;
    }

    public Auto eliminar(Integer id){
        validarId(id);
        autoDao.eliminar(id);
        Auto accion = new Auto();
        return accion;
    }

    public Boolean validarId (Integer id) {
        boolean ban = false;
        List<Auto> listaAuto = autoDao.obtenerListaPorId();
        for (Auto item : listaAuto) {
            if(item.getId().equals(id)) {
                ban = true;
            }
        }
        if(ban == false) {
            throw new DatosInvalidosExcepcion("No se encuentra el registro... ingresar otro registro !Por favor¡");
        }
        return ban;
    }

}
