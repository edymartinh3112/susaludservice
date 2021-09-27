# susaludservice
susalud service

ubicarse en libs ibm mq , others
mvn install:install-file -DgroupId=com.ibm.mq -DartifactId=mq -Dversion=1.1.0 -Dpackaging=jar -Dfile=com.ibm.mq.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ibm.mq -DartifactId=commonservices -Dversion=1.1.0 -Dpackaging=jar -Dfile=com.ibm.mq.commonservices.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ibm.mq -DartifactId=headers -Dversion=1.1.0 -Dpackaging=jar -Dfile=com.ibm.mq.headers.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ibm.mq -DartifactId=jmqi -Dversion=1.1.0 -Dpackaging=jar -Dfile=com.ibm.mq.jmqi.jar -DgeneratePom=true
mvn install:install-file -DgroupId=com.ibm.mq -DartifactId=pcf -Dversion=1.1.0 -Dpackaging=jar -Dfile=com.ibm.mq.pcf.jar -DgeneratePom=true
mvn install:install-file -DgroupId=javax.resource -DartifactId=connector -Dversion=1.1.0 -Dpackaging=jar -Dfile=connector.jar -DgeneratePom=true
mvn install:install-file -DgroupId=pe.gob.susalud.jr.transaccion.susalud -DartifactId=jr-afiliacion-susalud -Dversion=1.1.0 -Dpackaging=jar -Dfile=jr-afiliacion-susalud-1.0.0.jar -DgeneratePom=true
