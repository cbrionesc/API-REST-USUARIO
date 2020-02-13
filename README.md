# Aplicacion Usuario

Para compilar y ejecutar el codigo se debe realizar lo siguiente:

  - Descargar el codigo fuente desde github
  - abrir una ventana cmd
  - posicionarse en la carpeta fuente del proyecto (usuario)
  - ejecutar comando "gradlew clean build"
  - posicionarse en la carpeta /build/libs
  - ejecutar: java -jar usuario-0.0.1-SNAPSHOT.jar
  
# En POSTman

  - Metodo GET: http://localhost:8080/api/v1/usuario
  - Metodo GET{1}: http://localhost:8080/api/v1/usuario/1
  - Metodo POST: http://localhost:8080/api/v1/usuario 
        - JSON: {
            "nombre": "Claudio",
            "email": "cl@gmail.com",
            "password": "Rgdgdgd65"
        }
  - Metodo PUT{1}:  http://localhost:8080/api/v1/usuario/1
         - JSON: {
            "nombre": "Nombre",
            "email": "casilla@coreo.cl",
            "password": "Usuario66"
        }
  - Metodo DELETE{1}: http://localhost:8080/api/v1/usuario/1

