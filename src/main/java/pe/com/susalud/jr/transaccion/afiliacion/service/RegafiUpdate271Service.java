package pe.com.susalud.jr.transaccion.afiliacion.service;

import pe.com.susalud.jr.transaccion.afiliacion.bean.In271RegafiUpdate;

public abstract interface RegafiUpdate271Service
{
  public abstract String beanToX12N(In271RegafiUpdate paramIn271RegafiUpdate);
  
  public abstract In271RegafiUpdate x12NToBean(String paramString);
}


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\service\RegafiUpdate271Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */