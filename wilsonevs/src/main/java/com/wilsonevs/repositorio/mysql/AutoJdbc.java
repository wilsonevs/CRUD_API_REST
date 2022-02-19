package com.wilsonevs.repositorio.mysql;

import com.wilsonevs.modelos.dto.AutoFiltroDTO;
import com.wilsonevs.modelos.modelo.Auto;

public class AutoJdbc {

    public String obtenerLista(AutoFiltroDTO filtro) {
        String consulta = " SELECT A.*, ROW_NUMBER() OVER (ORDER BY A.ID DESC) RNUM ";
        consulta += " FROM %s A ";
        consulta += " WHERE A.ID > 0 ";

        if (filtro.getId() != null) {
            consulta += " AND A.ID IN ( " + filtro.getId().toString().replace("[", "").replace("]", "") + " ) ";
        }

        if (filtro.getMarca() != null) {
            consulta += " AND UPPER(A.MARCA) LIKE UPPER('%" + filtro.getMarca().toUpperCase()  + "%')";
        }

        if (filtro.getAnos() != null) {
            consulta += " AND UPPER(A.ANOS) LIKE UPPER('%" + filtro.getAnos().toUpperCase()  + "%')";
        }

        if (filtro.getCapacidad() != null) {
            consulta += " AND A.CAPACIDAD IN ( " + filtro.getCapacidad().toString().replace("[", "").replace("]", "") + " ) ";
        }

        if (filtro.getPrecio() != null) {
            consulta += " AND A.PRECIO IN ( " + filtro.getPrecio().toString().replace("[", "").replace("]", "") + " ) ";
        }

        consulta += " ORDER BY A.ID DESC ";
        consulta += " LIMIT " + filtro.getPaginacion();
        consulta += " OFFSET " + ((filtro.getPaginaActual() - 1) * filtro.getPaginacion());
        return consulta;
    }


    public String totalLista(AutoFiltroDTO filtro) {
        String consulta = " SELECT COUNT(*) ";
        consulta += " FROM %s A ";
        consulta += " WHERE A.ID > 0 ";

        if (filtro.getId() != null) {
            consulta += " AND A.ID IN ( " + filtro.getId().toString().replace("[", "").replace("]", "") + " ) ";
        }

        if (filtro.getMarca() != null) {
            consulta += " AND UPPER(A.MARCA) LIKE UPPER('%" + filtro.getMarca().toUpperCase()  + "%')";
        }

        if (filtro.getAnos() != null) {
            consulta += " AND UPPER(A.ANOS) LIKE UPPER('%" + filtro.getAnos().toUpperCase()  + "%')";
        }

        if (filtro.getCapacidad() != null) {
            consulta += " AND A.CAPACIDAD IN ( " + filtro.getCapacidad().toString().replace("[", "").replace("]", "") + " ) ";
        }

        if (filtro.getPrecio() != null) {
            consulta += " AND A.PRECIO IN ( " + filtro.getPrecio().toString().replace("[", "").replace("]", "") + " ) ";
        }

        return consulta;
    }


    public String obtenerPorId(Integer id) {
        String consulta = "SELECT ID, MARCA, ANOS, CAPACIDAD, PRECIO ";
        consulta += " FROM %s ";
        consulta += " WHERE ID = ?";
        return consulta;
    }

    public String obtenerListaPorId() {
        String consulta = "SELECT ID, MARCA, ANOS, CAPACIDAD, PRECIO ";
        consulta += " FROM %s ";
        return consulta;
    }

    public String insertar() {
        String consulta = "INSERT INTO %s (MARCA, ANOS, CAPACIDAD, PRECIO) VALUES (?,?,?,?) ";
        return consulta;
    }

    public String actualizar() {
        String consulta = " UPDATE %s SET ";
        consulta += " MARCA = ?,";
        consulta += " ANOS = ?, ";
        consulta += " CAPACIDAD = ?, ";
        consulta += " PRECIO = ? ";
        consulta += " WHERE ID = ? ";
        return consulta;
    }

    public String eliminar() {
        String consulta = " DELETE FROM %s WHERE ID = ?";
        return consulta;
    }

}
