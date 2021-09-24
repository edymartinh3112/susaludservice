package pe.com.susalud.dao;

import pe.com.susalud.afiliacion.entidad.bean.AfiliacionData;
import pe.com.susalud.beans.AfiliadoRequestPayloadBean;

public interface EnvioMqDao {

	void consultaInformacionAfiliado();

	void insertarTbEnvioSuSalud(AfiliadoRequestPayloadBean afiliadoBean, AfiliacionData afiliacion);

	void insertarTbEnvioSuSaludDetalle(AfiliadoRequestPayloadBean afiliadoBean);

}
