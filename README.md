# MicrosoftFramework

Este es un pequeño framework the Automatización en el que se automatizan los siguientes escenarios:
TC1 – Search validation
1. Go to https://www.microsoft.com/es-mx/
2. Go to Windows
3. Go to Search
4. Search for “Xbox”
5. Once in the result page you will see Aplicaciones (647)
6. Click on Mostrar todo
7. Go through the pages 1 to 8 and verify that items count is 647

**** Repeat the same process now using “Halo” in the search bar

TC2 – Shopping cart
1. Using Halo as a result search, select any option
2. Once in the details page click on the button to add it to the shopping cart
3. Verify the shopping cart on the right top menu adds the number 1 in a blue circle
4. Select another item and do the same and verify the shopping cart on the right top menu, now says 2
5. Remove one item and verify it actually gets removed and that the notification on the shopping cart menu decreases

## Prerequisitos
Para correr este framework de forma local se debe tener instalado los siguiente programas:
- Java >= 8
- Maven

## Corriendo el framework
Una ves instalados Java y Maven con todas sus variables de entorno, pasamos a clonar el repositorio con el comando:

`git clone https://github.com/desteban1117/GoogleFramework.git`

entramos a la carpeta `MicrosoftFramework` y utilizamos el siguiente comando para correr los dos scenarios descritos previamente
`mvn clean test`

Por default el framework corre usando Google Chrome. Actualmente el framework solo soporta dos browsers, firefox y crhome.
Si se desea correr en firefox simplemente usamos el siguiente comando

`mvn clean test -DBROWSER=firefox`
