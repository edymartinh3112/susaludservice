package pe.com.susalud.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.com.susalud.beans.AfiliadoRequestPayloadBean;
import pe.com.susalud.beans.ResponseBean;
import pe.com.susalud.service.EnvioMqService;

@RestController
@RequestMapping("/afiliado")
public class EnvioMqController {

	private static final Logger LOGGER = LogManager.getLogger(EnvioMqController.class);

	@Autowired
	private EnvioMqService envioMqService;

	@GetMapping
	@RequestMapping("/info")
	public ResponseBean sendMqInfoAfiliado(

			@RequestParam(defaultValue = "", name = "codAfiliado") String codAfiliado,
			@RequestParam(defaultValue = "", name = "descAfiliado") String descAfiliado,
			@RequestParam(defaultValue = "", name = "dni") String dni,
			@RequestParam(defaultValue = "", name = "tipoAfiliacion") String tipoAfiliacion,
			@RequestParam(defaultValue = "", name = "codMotivoAfiliacion") String codMotivoAfiliacion,
			@RequestParam(defaultValue = "", name = "descMotivoAfiliacion") String descMotivoAfiliacion,
			@RequestParam(defaultValue = "", name = "doc") String doc

	) {
		ResponseBean response = null;
		try {
			AfiliadoRequestPayloadBean afiliadoBean = new AfiliadoRequestPayloadBean();
			afiliadoBean.setCodAfiliado(codAfiliado);
			afiliadoBean.setDescAfiliado(descAfiliado);
			afiliadoBean.setDni(dni);
			afiliadoBean.setTipoAfiliacion(tipoAfiliacion);
			afiliadoBean.setCodMotivoAfiliacion(codMotivoAfiliacion);
			afiliadoBean.setDescMotivoAfiliacion(descMotivoAfiliacion);
			afiliadoBean.setDoc(doc);
			response = envioMqService.sendMqInfoAfiliado(afiliadoBean);

		} catch (Exception ex) {
			LOGGER.error(ex);
		}
		return response;
	}

}
