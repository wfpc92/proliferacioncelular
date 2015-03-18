# Introduction #

Se presenta a continuación un pequeño texto para llevar versiones en proyectos.


# Details #

Control de versiones con el método X.Y.Z

El método más común para numerar las versiones de un sistema es basándose en dos o tres cifras decimales, dependiendo de la importancia de los cambios es el número que se debe cambiar. La primer cifra siempre se cambia cuando se hizo una modificación crítica o muy importante, siendo la segunda cifra de menor importancia.

Se debe iniciar desde 0.Y.Z, con esto estamos diciendo que el documento no está listo aún o que no cumple con los requerimientos mínimos.
Cada cambio en esta cifra denota una reescritura o la incompatibilidad con versiones anteriores.

La segunda cifra X.0.Z se cambia cuando hay modificaciones en el contenido o la funcionalidad del documento, pero no lo suficientemente importantes como para decir que ya no es el mismo documento.
Cuando se hace un cambio mayor (en la primer cifra), el segundo número se reinicia a 0

La tercer cifra se cambia cuando se hacen correcciones al documento pero no se ha añadido ni eliminado nada relevante.
Si se hace un cambio en la segunda cifra se debe reiniciar el número de la tercera a 0

Los que usan Linux me pueden decir que el núcleo del OS maneja cuatro cifras en lugar de tres y que yo estoy hablando nada más de tres niveles. Pero se pueden tener tantos niveles como sea necesario, aunque tampoco es para que abusen de los números.

# Source #

http://www.cristalab.com/blog/control-de-versiones-de-software-c82353l/