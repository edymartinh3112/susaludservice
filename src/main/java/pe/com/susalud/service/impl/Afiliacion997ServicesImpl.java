package pe.com.susalud.service.impl;

import org.springframework.stereotype.Service;

import pe.com.susalud.service.Afiliacion997Services;
import pe.com.susalud.util.AfiliacionUtil;

@Service
public class Afiliacion997ServicesImpl implements Afiliacion997Services {
	public void procesarTrama(String trama) throws Exception {

		AfiliacionUtil.procesarTrama997(trama);
	}
}
