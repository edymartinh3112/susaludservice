package pe.com.susalud.dao.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import pe.com.susalud.afiliacion.entidad.bean.AfiliacionData;
import pe.com.susalud.beans.AfiliadoRequestPayloadBean;
import pe.com.susalud.dao.EnvioMqDao;

@Repository
public class EnvioMqDaoImpl implements EnvioMqDao {

	private static final Logger LOGGER = LogManager.getLogger(EnvioMqDaoImpl.class);

	@Override
	public void consultaInformacionAfiliado() {
		try {

		} catch (Exception ex) {
			LOGGER.error(ex);
		}

	}

	@Override
	public void insertarTbEnvioSuSalud(AfiliadoRequestPayloadBean afiliadoBean, AfiliacionData afiliacion) {
		//TODO FIX DAO
		
		// TODO Auto-generated method stub
		/*
		 * CallableStatement cstmt = this.Cn.prepareCall(
		 * "{call SP_INSERT_TB_ENVIO_SUSALUD(?,?,?,?)}"); cstmt.setInt(1,
		 * a.getC_tipo()); cstmt.setString(2, a.getC_c_usuario()); cstmt.setInt(3,
		 * a.getN_i_cantidad()); cstmt.registerOutParameter(4, java.sql.Types.VARCHAR);
		 * graba1 = cstmt.execute(); codEnvioSusalud = cstmt.getString(4);
		 * Constante.codigoEnvioSusalud = codEnvioSusalud;
		 */
	}

	@Override
	public void insertarTbEnvioSuSaludDetalle(AfiliadoRequestPayloadBean afiliadoBean) {
		//TODO FIX DAO
		// TODO Auto-generated method stub
		/*
		 * CallableStatement cstmt2 = this.Cn.prepareCall(
		 * "{call SP_INSERT_TB_ENVIO_SUSALUD_DET (?,?,?)}"); cstmt2.setString(1,
		 * codEnvioSusalud.trim()); cstmt2.setString(2, afi.getC_c_afiliado());
		 * cstmt2.setString(3, afi.getN_dni()); graba2 = cstmt2.execute();
		 */

	}

}
