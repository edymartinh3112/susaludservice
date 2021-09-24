/*     */ package pe.com.susalud.jr.transaccion.afiliacion.util;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ public class ManagerUtil
/*     */ {
/*     */   public static String DateToString(Date fech)
/*     */   {
/*  12 */     SimpleDateFormat dayFormatter = new SimpleDateFormat("yyyyMMdd");
/*  13 */     String displayDate = dayFormatter.format(fech);
/*  14 */     return displayDate;
/*     */   }
/*     */   
/*     */   public static final char validaCaracterPalabra(String p_palabra) {
/*  18 */     String palabra = p_palabra.toUpperCase();
/*  19 */     String validos = "ABCDEFGHIJKLMN√ëOPQRSTUVWXYZ ";
/*  20 */     int len = palabra.length();
/*  21 */     char c = '0';
/*  22 */     for (int i = 0; i < len; i++) {
/*  23 */       c = palabra.charAt(i);
/*  24 */       if ("ABCDEFGHIJKLMN√ëOPQRSTUVWXYZ ".indexOf(c) == -1) {
/*  25 */         return c;
/*     */       }
/*     */     }
/*  28 */     return '0';
/*     */   }
/*     */   
/*     */   public static final boolean cadenaUsuarioCorrecto(String p_usuario) {
/*  32 */     char c_caracter = '0';
/*  33 */     int len = p_usuario.length();
/*  34 */     if (len != 8) {
/*  35 */       return false;
/*     */     }
/*  37 */     c_caracter = validaSoloDigito(p_usuario);
/*  38 */     if (c_caracter != '0') {
/*  39 */       return false;
/*     */     }
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public static final boolean validaCantidadDigito(String p_digitos) {
/*  45 */     char c_caracter = '0';
/*  46 */     int len = p_digitos.length();
/*  47 */     if (len != 8) {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public static final char validaDigitoEspacio(String p_palabra)
/*     */   {
/*  57 */     String palabra = p_palabra.trim();
/*  58 */     String validos = "0123456789 ";
/*  59 */     int len = palabra.length();
/*  60 */     char c = '0';
/*  61 */     for (int i = 0; i < len; i++) {
/*  62 */       c = palabra.charAt(i);
/*  63 */       if ("0123456789 ".indexOf(c) == -1) {
/*  64 */         return c;
/*     */       }
/*     */     }
/*  67 */     return '0';
/*     */   }
/*     */   
/*     */   public static final char validaUnoEspacio(String p_palabra) {
/*  71 */     String palabra = p_palabra.trim();
/*  72 */     String validos = "1 ";
/*  73 */     int len = palabra.length();
/*  74 */     char c = '0';
/*  75 */     for (int i = 0; i < len; i++) {
/*  76 */       c = palabra.charAt(i);
/*  77 */       if ("1 ".indexOf(c) == -1) {
/*  78 */         return c;
/*     */       }
/*     */     }
/*  81 */     return '0';
/*     */   }
/*     */   
/*     */   public static final char validaSoloDigito(String p_palabra) {
/*  85 */     String palabra = p_palabra.trim();
/*  86 */     String validos = "0123456789";
/*  87 */     int len = palabra.length();
/*  88 */     char c = '0';
/*  89 */     for (int i = 0; i < len; i++) {
/*  90 */       c = palabra.charAt(i);
/*  91 */       if ("0123456789".indexOf(c) == -1) {
/*  92 */         return c;
/*     */       }
/*     */     }
/*  95 */     return '0';
/*     */   }
/*     */   
/*     */   public static char validaNombres(String p_palabra) {
/*  99 */     String palabra = p_palabra.toUpperCase();
/* 100 */     String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
/* 101 */     int len = palabra.length();
/* 102 */     char c = '0';
/* 103 */     for (int i = 0; i < len; i++) {
/* 104 */       c = palabra.charAt(i);
/* 105 */       if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".indexOf(c) == -1) {
/* 106 */         return c;
/*     */       }
/*     */     }
/* 109 */     return '0';
/*     */   }
/*     */   
/*     */   public static char validaAlfanumerico(String p_palabra) {
/* 113 */     String palabra = p_palabra.toUpperCase();
/* 114 */     String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
/* 115 */     int len = palabra.length();
/* 116 */     char c = '0';
/* 117 */     for (int i = 0; i < len; i++) {
/* 118 */       c = palabra.charAt(i);
/* 119 */       if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".indexOf(c) == -1) {
/* 120 */         return c;
/*     */       }
/*     */     }
/* 123 */     return '0';
/*     */   }
/*     */   
/*     */   public static char validaAlfanumericoGuion(String p_palabra) {
/* 127 */     String palabra = p_palabra.toUpperCase();
/* 128 */     String validos = "-ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ";
/* 129 */     int len = palabra.length();
/* 130 */     char c = '0';
/* 131 */     for (int i = 0; i < len; i++) {
/* 132 */       c = palabra.charAt(i);
/* 133 */       if ("-ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ".indexOf(c) == -1) {
/* 134 */         return c;
/*     */       }
/*     */     }
/* 137 */     return '0';
/*     */   }
/*     */   
/*     */   public static char validaAN_caracteres(String p_palabra) {
/* 141 */     String palabra = p_palabra.toUpperCase();
/* 142 */     String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789—'-.¥`_¡…Õ”⁄ƒÀœ÷‹¿»Ã“Ÿ¬ Œ‘€√’›&()/'=#∞| ";
/* 143 */     int len = palabra.length();
/* 144 */     char c = '0';
/* 145 */     for (int i = 0; i < len; i++) {
/* 146 */       c = palabra.charAt(i);

/* 147 */       if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789—'-.¥`_¡…Õ”⁄ƒÀœ÷‹¿»Ã“Ÿ¬ Œ‘€√’›&()/'=#∞| ".indexOf(c) == -1) {	
/* 148 */         return c;
/*     */       }
/*     */     }
/* 151 */     return '0';
/*     */   }
/*     */   
/*     */   public static char validaNombreTx(String p_palabra) {
/* 155 */     String palabra = p_palabra.toUpperCase();
/* 156 */     String validos = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_ ";
/* 157 */     int len = palabra.length();
/* 158 */     char c = '0';
/* 159 */     for (int i = 0; i < len; i++) {
/* 160 */       c = palabra.charAt(i);
/* 161 */       if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_ ".indexOf(c) == -1) {
/* 162 */         return c;
/*     */       }
/*     */     }
/* 165 */     return '0';
/*     */   }
/*     */   
/*     */   public static final String ordenaListaNumerica(String listaNumerica) {
/* 169 */     String subTipoConsulta = listaNumerica;
/* 170 */     String[] aSubTipo = new String[subTipoConsulta.length()];
/* 171 */     for (int i = 0; i < subTipoConsulta.length(); i++) {
/* 172 */       aSubTipo[i] = subTipoConsulta.substring(i, i + 1);
/*     */     }
/* 174 */     for (int i = 0; i < aSubTipo.length - 1; i++) {
/* 175 */       String menor = aSubTipo[i];
/* 176 */       for (int j = i + 1; j < aSubTipo.length; j++) {
/* 177 */         if (Integer.parseInt(menor) > Integer.parseInt(aSubTipo[j])) {
/* 178 */           String mayor = menor;
/* 179 */           menor = aSubTipo[j];
/* 180 */           aSubTipo[j] = mayor;
/*     */         }
/*     */       }
/* 183 */       aSubTipo[i] = menor;
/*     */     }
/* 185 */     String cadena = "";
/* 186 */     for (int i = 0; i < aSubTipo.length - 1; i++) {
/* 187 */       String valor = aSubTipo[i];
/* 188 */       for (int j = i + 1; j < aSubTipo.length; j++) {
/* 189 */         if (Integer.parseInt(valor) != Integer.parseInt(aSubTipo[j])) {
/* 190 */           cadena = cadena + valor;
/* 191 */           j = aSubTipo.length;
/*     */         } else {
/* 193 */           j = aSubTipo.length;
/*     */         }
/*     */       }
/*     */     }
/* 197 */     if (aSubTipo.length == 1) {
/* 198 */       cadena = aSubTipo[0];
/*     */     } else {
/* 200 */       cadena = cadena + aSubTipo[(aSubTipo.length - 1)];
/*     */     }
/* 202 */     return cadena;
/*     */   }
/*     */   
/*     */   public static final int verificaLista(String[][] listaCompleta, String listaValidar, String tipoConsulta, String tipoFicha) {
/* 206 */     String[][] aConsulta = listaCompleta;
/* 207 */     String subConsultas = listaValidar;
/* 208 */     String tipConsulta = tipoConsulta;
/* 209 */     int iExiste = 0;
/*     */     
/* 211 */     for (int j = 0; j < subConsultas.length(); j++) {
/* 212 */       String sCaracter = subConsultas.substring(j, j + 1);
/* 213 */       for (int i = 0; i < aConsulta.length; i++) {
/* 214 */         if ((aConsulta[i][0].equals(tipConsulta)) && (aConsulta[i][1].equals(sCaracter)))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 222 */           iExiste++;
/*     */         }
/*     */       }
/*     */     }
/* 226 */     return iExiste;
/*     */   }
/*     */   
/*     */   public static final String[] listaConsulta(String listaCadena) {
/* 230 */     String subTipoConsulta = listaCadena.trim();
/* 231 */     String[] aSubTipo = new String[subTipoConsulta.length()];
/* 232 */     for (int i = 0; i < subTipoConsulta.length(); i++) {
/* 233 */       aSubTipo[i] = subTipoConsulta.substring(i, i + 1);
/*     */     }
/* 235 */     return aSubTipo;
/*     */   }
/*     */   
/*     */   public static final int validaConsulta(String[][] listaCompleta, String valor) {
/* 239 */     String[][] aConsulta = listaCompleta;
/* 240 */     int iExiste = 0;
/* 241 */     for (int i = 0; i < aConsulta.length; i++) {
/* 242 */       if (aConsulta[i][0].equals(valor)) {
/* 243 */         iExiste++;
/*     */       }
/*     */     }
/* 246 */     return iExiste;
/*     */   }
/*     */   
/*     */   public static String DateToStringFechaHora(Date fech)
/*     */   {
/* 251 */     SimpleDateFormat dayFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
/* 252 */     String displayDate = dayFormatter.format(fech);
/* 253 */     return displayDate;
/*     */   }
/*     */   
/*     */   public static boolean validaFecha(String sFecha, String sFormato) {
/*     */     try {
/* 258 */       SimpleDateFormat formatoFecha = new SimpleDateFormat(sFormato, Locale.getDefault());
/* 259 */       formatoFecha.setLenient(false);
/* 260 */       formatoFecha.parse(sFecha);
/*     */     } catch (ParseException e) {
/* 262 */       return false;
/*     */     }
/* 264 */     return true;
/*     */   }
/*     */   
/*     */   public static String removerCaractEspecial(String input)
/*     */   {
/* 269 */     String original = "·‡‰ÈËÎÌÏÔÛÚˆ˙˘uÒ<>&¡¿ƒ…»ÀÕÃœ”“÷⁄Ÿ‹—Á«";
/*     */     
/* 271 */     String ascii = "aaaeeeiiiooouuu#   AAAEEEIIIOOOUUU#cC";
/* 272 */     String output = input;
/* 273 */     for (int i = 0; i < original.length(); i++)
/*     */     {
/* 275 */       output = output.replace(original.charAt(i), ascii.charAt(i));
/*     */     }
/* 277 */     return output;
/*     */   }
/*     */   
/*     */   public static boolean validaFechaValores(String sFecha)
/*     */   {
/* 282 */     String year = "";String month = "";String day = "";
/* 283 */     boolean flag = false;
/*     */     
/* 285 */     if (sFecha.length() == 8) {
/* 286 */       year = sFecha.trim().substring(0, 4);
/* 287 */       month = sFecha.trim().substring(4, 6);
/* 288 */       day = sFecha.trim().substring(6, 8);
/*     */       
/* 290 */       if ((1900 > Integer.parseInt(year)) || (2050 < Integer.parseInt(year))) {
/* 291 */         flag = true;
/* 292 */       } else if ((1 > Integer.parseInt(month)) || (12 < Integer.parseInt(month))) {
/* 293 */         flag = true;
/* 294 */       } else if ((1 > Integer.parseInt(day)) || (31 < Integer.parseInt(day))) {
/* 295 */         flag = true;
/*     */       }
/*     */     }
/*     */     
/* 299 */     if (flag) {
/* 300 */       return false;
/*     */     }
/* 302 */     return true;
/*     */   }
/*     */ }

