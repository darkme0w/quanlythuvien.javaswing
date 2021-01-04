/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mapper.RowMapper;
import utils.DBConnect;

/**
 *
 * @author admin
 */
public class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameter) {
        List<T> result = new ArrayList<>();
        CallableStatement csmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DBConnect.getInstance().getConnection();
            csmt = conn.prepareCall(sql);
            setParameter(csmt, parameter);
            rs = csmt.executeQuery();
            while (rs.next()) {
                result.add(rowMapper.mapRow(rs));
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (csmt != null) {
                    csmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }
        return null;
    }

    private void setParameter(CallableStatement cstm , Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Integer) {
                    cstm.setInt(index, (int) parameter);
                } else if (parameter instanceof String) {
                    cstm.setNString(index, (String) parameter);
                } else if (parameter instanceof Float) {
                    cstm.setFloat(index, (float) parameter);
                } else if (parameter instanceof Boolean) {
                    cstm.setBoolean(index, (boolean) parameter);
                } else if (parameter instanceof LocalDate) {
                    cstm.setDate(index, (Date.valueOf((LocalDate) parameter)));
                }
            }
        } catch (SQLException e) {
        }
    }

    private void setParameter(PreparedStatement pstm, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Integer) {
                    pstm.setInt(index, (int) parameter);
                } else if (parameter instanceof String) {
                    pstm.setNString(index, (String) parameter);
                } else if (parameter instanceof Float) {
                    pstm.setFloat(index, (float) parameter);
                } else if (parameter instanceof Boolean) {
                    pstm.setBoolean(index, (boolean) parameter);
                } else if (parameter instanceof LocalDate) {
                    pstm.setDate(index, (Date.valueOf((LocalDate) parameter)));
                }
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public void update(String sql, Object... parameters) {
        CallableStatement csmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DBConnect.getInstance().getConnection();
            conn.setAutoCommit(false);
            csmt = conn.prepareCall(sql);
            setParameter(csmt, parameters);
            csmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (csmt != null) {
                    csmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }

    }

    @Override
    public void insert(String sql, Object... parameters) {
        CallableStatement csmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = DBConnect.getInstance().getConnection();
            conn.setAutoCommit(false);
            csmt = conn.prepareCall(sql);
            setParameter(csmt, parameters);
            csmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (csmt != null) {
                    csmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }
    }

    @Override
    public Integer insertReturnId(String sql, Object... parameters) {
        ResultSet rs = null;
        Integer id = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBConnect.getInstance().getConnection();
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            setParameter(pstmt, parameters);
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            conn.commit();
            return id;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // TODO: handle exception
            }
        }
        return null;
    }

}
