Title : PocMan
Author : Lesmanne Maëlle  
Alamichel Louise  
Fares Jean-Marc

# PocMan

##0 - Introduction

La seconde partie du module Info215 se concentre sur l'apprentissage par renfocrement, qui, à la différence de l'apprentissage supervisé, nous permet de créer un agent conscient du monde dans lequel il évolue, sans connaitre de stratégies a priori. Ce système d'intelligence artificielle convient parfaitement dans le cadre du développement d'un jeu vidéo.
Ainsi, comme propoé par le sujet, nous allons écrire un algorithme d'apprentissage par renfocrement ayant pour but de maitriser un jeu PacMan sans connaissances autres que l'environnement.

[Présentation du plan de l'étude]

##1 - Implémentation de l'intelligence artificielle
###A - Attributs et Constructeurs

###B - Mise à jour de la fonction Q

##2 - Résultats de simulation
###A - Paramètres


###B - Données
Pour contrôler le progrès de l'apprentissage, nous avons reccueilli le nombre de morts, de récompenses et de murs rencontrés. Nous avons fait le choix de faire jouer dix millions de parties à notre programme et sauver les indicatuers toutes les conq mille parties ; on peut alors tracer un graphique des trois grandeurs en fonction du nombre de parties.
Afin de visualiser ces données, depuis notre programme principal, on les écrit dans un fichier "[nom\_de\_methode].pltdt" ; ensuite, on écrit un script Python qui cherche les différents fichiers de données possibles et les affiche à l'aide de la librairie Matplotlib.
On obtient les graphiques suivants :  

![Fig. #: Random play](/Users/al1nk/Documents/Developer/Java/pocman/output/none.png)
![Fig. #: SARSA Learning](/Users/al1nk/Documents/Developer/Java/pocman/output/SARSA.png)
![Fig. #: Q-Learning](/Users/al1nk/Documents/Developer/Java/pocman/output/QLearning.png)

###C - Analyse

##3 - Conclusion