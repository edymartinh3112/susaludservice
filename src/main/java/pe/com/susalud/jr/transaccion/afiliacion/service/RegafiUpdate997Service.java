package pe.com.susalud.jr.transaccion.afiliacion.service;

import pe.com.susalud.jr.transaccion.afiliacion.bean.In997RegafiUpdate;

public abstract interface RegafiUpdate997Service
{
  public abstract String beanToX12N(In997RegafiUpdate paramIn997RegafiUpdate);
  
  public abstract In997RegafiUpdate x12NToBean(String paramString);
}


/* Location:              D:\WorkSpace\Desarrollo Afiliacion On Linea\Fuentes\FebanAfiliacionesFH\lib\jr-afiliacion-susalud_v1.5.jar!\pe\gob\susalud\jr\transaccion\susalud\service\RegafiUpdate997Service.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */