package com.wilsonevs.repositorio.mysql;

import com.wilsonevs.configuracion.ContextoEsquema;
import com.wilsonevs.modelos.dto.AutoDTO;
import com.wilsonevs.modelos.dto.AutoFiltroDTO;
import com.wilsonevs.modelos.dto.AutoInsertarDTO;
import com.wilsonevs.modelos.modelo.Auto;
import com.wilsonevs.utilidades.Constantes;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AutoDao {

    private AutoJdbc autoJdbc = new AutoJdbc();
    private AutoJRomMapper autoJRomMapper = new AutoJRomMapper();
    private String contexto = "AUTO";

    private JdbcTemplate jdbcTemplate;
    AutoDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Auto> obtenerLista(AutoFiltroDTO dto) {
        String sql = autoJdbc.obtenerLista(dto);
        sql = sql.replace("%s", contexto);
        return jdbcTemplate.query(sql, autoJRomMapper);
    }

    public int totalLista(AutoFiltroDTO dto) {
        String sql = autoJdbc.totalLista(dto);
        sql = sql.replace("%s", contexto);
        return jdbcTemplate.queryForObject(sql, new Object[]{} , Integer.class);
    }

    public Auto obtenerPorId(Integer id) {
        String sql = autoJdbc.obtenerPorId(id);
        sql = sql.replace("%s", contexto);
        return jdbcTemplate.queryForObject(sql, new Object[]{id} , autoJRomMapper);
    }

    public List<Auto> obtenerListaPorId() {
        String sql = autoJdbc.obtenerListaPorId();
        sql = sql.replace("%s", contexto);
        return jdbcTemplate.query(sql,autoJRomMapper);
    }

    @Transactional
    public void insertar (AutoInsertarDTO dto) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
        @Override
        public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            String sql= String.format(autoJdbc.insertar(), contexto);
            PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
            ps.setString(1,dto.getMarca());
            ps.setString(2,dto.getAnos());
            ps.setInt(3,dto.getCapacidad());
            ps.setInt(4,dto.getPrecio());
            return ps;
            }
        }, keyHolder);

    }

    @Transactional
    public void actualizar (Auto dto) {
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql= String.format(autoJdbc.actualizar(), contexto);
                PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
                ps.setString(1,dto.getMarca());
                ps.setString(2,dto.getAnos());
                ps.setInt(3,dto.getCapacidad());
                ps.setInt(4,dto.getPrecio());
                ps.setInt(5,dto.getId());
                return ps;
            }
        });

    }


    @Transactional
    public void eliminar (Integer id) {
        String sql = autoJdbc.eliminar();
        sql = sql.replace("%s", contexto);
        jdbcTemplate.update(sql, id);
    }


    public static class AutoJRomMapper implements RowMapper<Auto> {
        @Override
        public Auto mapRow(ResultSet rs, int romNum ) throws SQLException {
            return new Auto(
                    rs.getInt("id"),
                    rs.getString("marca"),
                    rs.getString("anos"),
                    rs.getInt("capacidad"),
                    rs.getInt("precio")
            );
        }
    }

}
