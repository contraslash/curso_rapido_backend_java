Title: Despliegue
Author: Mauricio Collazos
Date: 2019-02-19
![]()
---
class: center, middle, light, first-slide
# Despliegue
## Mauricio Collazos
.footnote[]
---
# Tipos de servicios de nube
- IaaS
- PaaS
- CaaS
- FaaS

---
# Diferencias entre los modelos
![https://blogs.bmc.com/wp-content/uploads/2017/09/iaas-paas-saas-comparison.jpg](https://blogs.bmc.com/wp-content/uploads/2017/09/iaas-paas-saas-comparison.jpg)
---
# Despliegue en IaaS

- Permisos para instalar paquetes
- Acceso al código fuente
- Tener el código configurado para despliegue
- Instalar dependencias
- Configurar software

---
# Configuración de código fuente
```groovy
jar {
    manifest {
        attributes "Main-Class": "com.contraslash.java.Application"
    }

    from {
        configurations.runtimeClasspath.collect { it.isDirectory() ? it : zipTree(it) }
    }


    archiveName "app.jar"
}
```


---
# Creación de recursos en AWS

- VPC
- Subnets
- TableRoutes
- Internet Gateway
- EC2

S3
---
# Conexión al servidor remoto

```bash
ssh -i llave usuario@ip.del.servidor
```

---
# Dependencias

```bash
# sudo apt install tomcat8 tomcat8-docs tomcat8-examples tomcat8-admin
sudo apt install openjdk-8-jdk
```

---
# Configuración de Front End

Subir código a S3