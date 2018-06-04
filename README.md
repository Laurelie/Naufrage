# Naufrage
Projet Java

BUT : survivre sur une ile deserte

-------------------------------------

	ACTION : energie

seDeplacer : -5
combattre : -8
fuir/ignorer : -5

fabriquer : -15 
miner : -10
couperarbre : -10
pecher : -5 
cueillir : -5

	LIEU

Mer
Plage (Crabe + Poissons)
Foret (Ours + Lapin)
Montagne (Chamois)

	CHASSABLE : nom, poids, rapportAlimentaire, sante, degatRecu

Lapin, 25, 15, 2, -3
Ours, 100, 50, 80, -25
Crabe, 15, 10, 1, -7
Chamois, 50, 30, 50, -15
Indigène, 700, -30, 60, -20

	FRUITS: nom, poids, rapportAlimentaire

Baie, 3 ,-5
Pomme, 5, 7
Cerise, 5, 5

	POISSONS: nom, poids, rapportAlimentaire, degat

Dorade, 30, 25, -10
Saumon, 20, 20, 0
Sardine, 20, 15, 0
Poisson Chat, 20, 13, 0

	RESSOURCES : nom, poids

Bouteille, 8
LunettesCassees, 5
Coquillage, 2
Bois, 100
Pierre, 50
Fil, 1

	ARME : nom, dégats, précision, fabrication, poids

Poings : 3, 0.85, 0, 0
Lance : 10, 0.5, 2xBois - 1xPierre, 300
Hache : 20, 0.7, 3xBois - 5xPierre, 400

	CONSTRUCTION : ressource

Feu : 5xBois - 2xSilex
Bateau : 20xBois - 5xFil
Camp : 10xBois
CanneAPeche : 2xBois - 1xFil
Lit : 15xBois - 2xFil
