

# CONTROL DE VERSIONES #

Se llama control de versiones a la gestión de los diversos cambios que se realizan sobre los elementos de algún producto o una configuración del mismo. Una versión, revisión o edición de un producto, es el estado en el que se encuentra dicho producto en un momento dado de su desarrollo o modificación. Aunque un sistema de control de versiones puede realizarse de forma manual, es muy aconsejable disponer de herramientas que faciliten esta gestión dando lugar a los llamados sistemas de control de versiones o SVC (del inglés System Version Control). Estos sistemas facilitan la administración de las distintas versiones de cada producto desarrollado, así como las posibles especializaciones realizadas (por ejemplo, para algún cliente específico).

## Repositorio ##

El repositorio es el lugar en el que se almacenan los datos actualizados e históricos de cambios, a menudo en un servidor. A veces se le denomina depósito o depot. Puede ser un sistema de archivos en un disco duro, un banco de datos, etc.

## Módulo ##

Conjunto de directorios y/o archivos dentro del repositorio que pertenecen a un proyecto común.

## Revisión ("version") ##

Una revisión es una versión determinada de la información que se gestiona. Hay sistemas que identifican las revisiones con un contador (Ej. subversion). A la última versión se le suele identificar de forma especial con el nombre de HEAD. Para poner especial a una revisión concreta se usan los rótulos o tags

## Rotular ("tag") ##

Darle a alguna versión de cada uno de los ficheros del módulo en desarrollo en un momento preciso un nombre común ("etiqueta" o "rótulo") para asegurarse de reencontrar ese estado de desarrollo posteriormente bajo ese nombre. En la práctica se rotula a todos los archivos en un momento determinado. Para eso el módulo se "congela" durante el rotulado para imponer una versión coherente. Pero bajo ciertas circunstancias puede ser necesario utilizar versiones de algunos ficheros que no coinciden temporalmente con las de los otros ficheros del módulo.
Los tags permiten identificar de forma fácil revisiones importantes en el proyecto. Por ejemplo se suelen usar tags para identificar el contenido de las versiones publicadas del proyecto.
En algunos sistemas se considera un tag como una rama en la que los ficheros no evolucionan, están congelados.

## Línea base ("Baseline") ##

Una revisión aprobada de un documento o fichero fuente, a partir del cual se pueden realizar cambios subsiguientes.

## Abrir rama ("branch") o ramificar ##

Un módulo puede ser branched o bifurcado en un instante de tiempo de forma que, desde ese momento en adelante se tienen dos copias (ramas) que evolucionan de forma independiente siguiendo su propia línea de desarrollo. El módulo tiene entonces 2 (o más) "ramas". La ventaja es que se puede hacer un "merge" de las modificaciones de ambas ramas, posibilitando la creación de "ramas de prueba" que contegan código para evaluación, si se dedice que las modificaciones realizadas en la "rama de prueba" sean preservadas, se hace un "merge" con la rama principal. Son motivos habituales para la creación de ramas la creación de nuevas funcionalidades o la corrección de errores.

## Desplegar ("Check-out", "checkout", "co") ##

Un despliegue crea una copia de trabajo local desde el repositorio. Se puede especificar una revisión concreta, y por defecto se suele obtener la última.

## "Publicar" o "Enviar"("commit", "check-in", "ci", "install", "submit") ##

Un commit sucede cuando una copia de los cambios hechos a una copia local es escrita o integrada sobre repositorio.

## Cambio ("change", "diff", "delta") ##

Un cambio representa una modificación específica a un documento bajo control de versiones. La granularidad de la modificación considerada un cambio varía entre diferentes sistemas de control de versiones.

## Lista de cambios ("changelist", "change set", "patch") ##

En muchos sistemas de control de versiones con commits multi-cambio atómicos, una lista de cambios identifica el conjunto de cambios hechos en un único commit. Esto también puede representar una vista secuencial del código fuente, permitiendo que el fuente sea examinado a partir de cualquier identificador de lista de cambios particular.

## Exportación ("export") ##

Una exportación es similar a un check-out, salvo porque crea un árbol de directorios limpio sin los metadatos de control de versiones presentes en la copia de trabajo. Se utiliza a menudo de forma previa a la publicación de los contenidos.

## Importación ("import") ##

Una importación es la acción de copia un árbol de directorios local (que no es en ese momento una copia de trabajo) en el repositorio por primera vez.

## Integración o fusión ("merge") ##

Una integración o fusión une dos conjuntos de cambios sobre un fichero o un conjunto de ficheros en una revisión unificada de dicho fichero o ficheros. Esto puede suceder cuando un usuario, trabajando en esos ficheros, actualiza su copia local con los cambios realizados, y añadidos al repositorio, por otros usuarios. Análogamente, este mismo proceso puede ocurrir en el repositorio cuando un usuario intenta check-in sus cambios. Puede suceder después de que el código haya sido branched, y un problema anterior al branching sea arreglado en una rama, y se necesite incorporar dicho arreglo en la otra. Puede suceder después de que los ficheros hayan sido branched, desarrollados de forma independiente por un tiempo, y que entonces se haya requerido que fueran fundidos de nuevo en un único trunk unificado.

## Integración inversa ##

El proceso de fundir ramas de diferentes equipos en el trunk principal del sistema de versiones.

## Actualización ("sync" ó "update") ##

Una actualización integra los cambios que han sido hechos en el repositorio (por ejemplo por otras personas) en la copia de trabajo local.

## Copia de trabajo ("workspace") ##

La copia de trabajo es la copia local de los ficheros de un repositorio, en un momento del tiempo o revisión específicos. Todo el trabajo realizado sobre los ficheros en un repositorio se realiza inicialmente sobre una copia de trabajo, de ahí su nombre. Conceptualmente, es un cajón de arena o sandbox.

## Congelar ##

Congelar significa permitir los últimos cambios (commits) para solucionar las fallas a resolver en una entrega (release) y suspender cualquier otro cambio antes de una entrega, con el fin de obtener una versión consistente. Si no se congela el repositorio, un desarrollador podría comenzar a resolver una falla cuya resolución no esta prevista y cuya solución dé lugar a efectos colaterales imprevistos.

# Definición WIKI #

Wiki es un concepto que se utiliza en el ámbito de Internet para nombrar a las páginas web cuyos contenidos pueden ser editados por múltiples usuarios a través de cualquier navegador. Dichas páginas, por lo tanto, se desarrollan a partir de la colaboración de los internautas, quienes pueden agregar, modificar o eliminar información.

Una de las grandes ventajas de un wiki es la facilidad para crear páginas de forma instantánea, sin necesidad de preocuparse por el diseño y otras cuestiones. Muchos wikis crean hipervínculos y páginas de manera automática cuando el usuario escribe una palabra o frase de cierta forma (en mayúsculas y sin espacio, entre dos corchetes, etc.).

Entre las distintas formas de visualizar un wiki para su edición, se encuentran el código fuente (un texto plano), el HTML (renderizado a partir del código fuente) y la plantilla (que establece cómo se disponen los elementos comunes en todas las páginas).

# Conflictos #

Un conflicto ocurre en las siguientes circunstancias:
  * Los usuarios X e Y despliegan versiones del archivo A en que las líneas n1 hasta n2 son comunes.
  * El usuario X envía cambios entre las líneas n1 y n2 al archivo A.
  * El usuario Y no actualiza el archivo A tras el envío del usuario X.
  * El usuario Y realiza cambios entre las líneas n1 y n2.
  * El usuario Y intenta posteriormente enviar esos cambios al archivo A.
  * El sistema es incapaz de fusionar los cambios.
  * El usuario Y debe resolver el conflicto combinando los cambios, o eligiendo uno de ellos para descartar el otro.

# Estructura Source-Browse #

Subversion no es un sistema de gestión de la configuración pero es posible implementar sobre Subversion buenas prácticas de gestión de la configuración utilizando la estructura habitual de Subversion,4 sin embargo no existe un sistema automático para obligar a que se cumplan.
La estructura habitual de un repositorio de Subversion es:
  * Trunk: desarrollo principal.
  * Tags: ubicación de las versiones congeladas.
  * Branches: ubicación con versiones de desarrollo paralelas al trunk.

# Fuente #

  * http://es.wikipedia.org/wiki/Subversion_(software)
  * http://es.wikipedia.org/wiki/Control_de_versiones
  * http://definicion.de/wiki/#ixzz29nUBrwcE