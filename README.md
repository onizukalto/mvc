# mvc
Projet MVC Java

Pour compiler toutes les classes et et les placer dans un dossier build voici la commande à entrer :
javac -d build -sourcepath src src/Main.java

Ensuite, pour exécuter il faut faire :
java -cp build Main

Si vous souhaitez supprimer tous les fichiers .class afin de recompiler le programme, voici la commande à entrer depuis le dossier MVC :
find . -name "*.class" -delete