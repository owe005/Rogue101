# Svar på spørsmål

*I denne filen legger du inn svar på spørsmålene som stilles i oppgaveteksten, eventuelt kommentarer og informasjon om kreative løsninger*

## Kommentarer
(Eventuelle kommentarer på oppgaven eller koden her).

## Spørsmål

## Oppgave 1 - Abstrakte Ting

### 1.1) 

1. Current HP. Næmlig det at interfacet skal vise hvor mye health spilleren har. Det er greit å vite om man nærmer seg slutten på spillet.
2. Missing HP, hvor mye spilleren evt. har tapt ved å bli skadet i spillet, slik får man en idé om man plutselig har tapt veldig mye liv veldig fort, da blir man nok mer forsiktig.
3. Maks HP, ved hensyn til hvor mye liv spilleren har tapt, hvor mye HP spilleren hadde hatt om spilleren hadde fullt liv. Veldig greit med en slik måte for da vet man om det er nødvendig å angripe(spise) en gulrot til, eller om det vil resultere i ingenting.
4. Navn/id til et item, for å lett kunne vite hva som er hva.
5. Størrelsen til et item, altså hvor mye plass et item tar.

### 1.2) 
1. Det første er at Iitem.java abstraherer hvor mye HP et item har før det dør/ødelegges. 
2. Andre er at den abstraherer maks HP til et item.
3. Navn til et item
4. Symbol til et item
5. Størrelsen til et item


### 1.3)
1. Carrot::handleDamage() for at gulrøtter skal miste HP når de blir spist av en rabbit. Carrot::handleDamage() blir called når rabbit spiser gulrot, da går HP til gulroten ned med hensyn til hvor mye kaninen spiste.
2. Den implementerer også currentHealthPoints ved at man kan calle getCurrentHealthPoints så den returnerer HP.
3. Også navn til gulroten implementeres også. Man kan calle getShortName for å returnere "carrot", eller getLongName for å returnere "juicy carrot".
4. En egenskap ved gulroten som implementeres som også er ved en ekte gulrot er navnet.
5. Alderen til gulroten implementeres ikke, selv om det er en egenskap til en ekte gulrot.

### 1.4)
Amulet, Carrot, Dust, Player, Rabbit, Wall

### 1.5
Gold class er lagd.

## Oppgave 2 - The Rabbit

### 2.1)
IActor utvider Iitem interfacet, ved å legge til getDamage(), og getAttack(). Dermed når f.eks. Portal class implementerer IActor vil den få tilgang til den utvidete coden som IActor extender.

### 2.2)
I DoTurn(); i Rabbit.java henter den først de ulike retningene den kan velge mellom, også bruker den Shuffle() metoden for å randomize rekkefølgen av arraylisten, possibleMoves.get(0) henter første string. F.eks. (1,2,3,4,5) blir shufflet til (3,1,5,4,2) get(0) vil da være = 3. Mens neste gang vil den kanskje bli shufflet til en annen rekkefølge. Istedenfor tall i eksemplet mitt blir det retninger, North, East etc.

### 2.3)
Her har jeg gjort det sånn at den går igjennom de ulike retningene man kan gå, og returner en liste med GridDirection.

### 2.4)
Jeg brukte game.containsItem fra IGameView.java til å sjekke om det er en gulrot i nærheten av kaninen (en celle) så vil den gå dit, hvis det ikke er en gulrot der. Gjør den et tilfeldig move.

## Oppgave 3 - Objektfabrikken

### 3.1)
@ representerer player-objektet, mens . representerer dust-objektet (i spillet vil dette feltet være mørkt, og vil bli "lyst" når man f.eks plukker opp dust.

### 3.2)
Ettersom det er flere klasser som antar at symbolet er x så vil det, når du endrer symbolet ikke funke, for da forventes det en ting, mens de får noe annet. 

************* WIP WIP WIP *************


### 3.3)
Gjort. Den viser nå G symbolet for Gold på kartet. Mulig jeg kommer til å endre dette til en gull-emoji når jeg utvider programmet.

## Oppgave 4 - Et smartere kart

### 4.1)
getNeighbourhood er implementert.

### 4.2)
Gjort.

### 4.3)
Collections.sort fra oppgaveteksten sorterer nearbyloc og returner sorterte lokasjoner.


### 4.4)
WIP

## Oppgave 5

### 5.1)
For å gjøre dette så fjerner man // comment på 	VisualizeRabbitStrategy.launch(args); og setter	RogueApplication.launch(args); i et comment.
Her går kaninen tilfeldig rundt til den går tom for energi og dør. Da vil det være naturlig og gjøre den smartere så den finner en måte å komme seg til gulrotene, uten å måtte rett ved siden av den.

### 5.2)
directionTo er implementert i Location.java, og Rabbit.java bruker hjelpemetoden getDirectionTo. Den fungerer ikke helt, da rabbiten går til en gulrot, spiser den og blir sittende fast i en loop.

### 5.3)
En måte for Rabbits til å ikke spise alle gulrotene hele tiden, men la kaniner som ikke har fått spist og dør snart få lov istedenfor til å spise gulrotene.

## Oppgave 6

### 6.1)
Her bruker jeg en ArrayList som et inventory. Når spilleren plukker opp et item fra kartet så legges det til i ArrayListen. Spilleren kan holde på uendelig mange objects (for now), items fjernes fra mappet når de plukkes opp.

### 6.2)
Spilleren bruker ArrayListen fra 6.1 (Inventory) og bruker inventory.remove(0) for å fjerne item fra inventory. Deretter brukes metoden game.drop for å plassere objektet på bakken der spilleren står.

### 6.3)
Jeg har valgt å loope over det som er i Inventory og deretter display message til spilleren om det han holder.

## Fri oppgave (Oppg. 7)

### EKSTRA KOMMENTAR
Hvis du som retter bestemmer deg for å prøve å vinne spillet,
det er veldig veldig vanskelig. Det er veldig mye luck involved, ved at uansett hvilken path du velger, så kan du dø like lett.


### Plan
Planen er og utvide programmet så det er flere ting som skjer. Edderkoppene gjør f.eks. ingenting i utgangspunktet (bortsettfra å se stilig ut :)) Så da blir det:
1. Gi edderkoppene en funksjon i spillet, ved at de kan gjøre damage.

2. Gi mer liv til objekt. Gull, Amulet og Player er veldig kjedelig med G, A, @. Dermed bruke samme måte som gulroten fikk sin emoji til å legge til dette i spillet.

3. Legge til flere objekt. Forskjellige typer våpen man kan plukke opp, kanskje en pistol? Det vil nok bli komplisert å få den til å faktisk skyte, men den kan gjøre at du gjør mer damage hvis du holder en pistol.

4. Final boss som guarder portalen? (EDIT: det ble 2, en ved amuleten og en ved portalen).

5. Bomber som skader spilleren.

6. Støtte for moderne WASD bruk.

### Utførelse
Jeg opprettet en ny class for en pistol. Akkurat nå er det tre stk på kartet.

Fikset emojis til de ulike objektene ved å endre EmojiFactory.java

2 FinalBosses er implementert foran Amulet og Portal. Disse actors vil angripe spilleren hvis han er i nærheten, hvis ikke går de bare rundt tilfeldig til spilleren enten vinner, eller dør.

Spiders har blitt endret til å bare gå etter spilleren. Du kan ikke angripe de tilbake, så spillet har nå blitt en slags "get to the end without dying" spill. Du blir insta-killet av Finalbosses(2) og spiders gjør ca. 10 dmg til spilleren hver gang de angriper.

Jeg opprettet også en ny class som er veldig lik FinalBoss ved at det er VELDIG MANGE bomber rundt kartet. Disse bombene gjør 25 damage til spilleren. Hvis du er i nærheten av bombene så vil de angripe, hvis ikke går de tilfeldig rundt til de møter på deg. De angriper bare spilleren.
Finalboss angriper bare spilleren.
Spiders angriper bare spilleren.
Rabbits angriper gulroter, og edderkopper, så for å gi rabbits en funksjon så skal de hjelpe deg å "cleare" ut alle edderkoppene for å la deg vinne spillet.

Jeg har betydelig fjernet antallet rabbits og økt antallet carrots. Dette gjorde jeg fordi rabbits vinner spillet alt for lett for deg hvis det er veldig mange.

Støtte for WASD er implementert, du kan velge selv om du vil bruke WASD eller piltastene. For å plukke opp bruker man + og -. Veldig enkelt. Testene er også endret så de kjører.

### Flere utvidelser
I senere tid endret jeg også emoji til Gold til Bitcoin :)

Jeg har fjernet veldig mye dust da jeg mener det var en litt irriterende ting ved at hele kartet var fylt. Men, det er dust igjen, og nå har dust en funksjon ved at edderkopper og bomber kan hjemme seg under dust så man ikke ser de.


### SPILL INFORMASJON
Målet er å komme seg til amuletten, og deretter til portalen uten å dø. Hvis du dør må du prøve på nytt.

Edderkopper, Bomber og 2 Monstre vil prøve å stoppe deg, det er ikke vits å angripe de. Du kan ikke skade de.
Det er meningen du skal unngå de og komme deg i mål.

Kaninene vil prioritere å spise gulroter for å holde seg selv i live, deretter vil de drepe edderkopper for å holde deg i live.

På veien kan du plukke opp gull (i form av Bitcoin ;)).
Du kan også plukke opp en pistol, den har ingen funksjon men kanskje den har det i fremtiden?

NB! Vær forsiktig med Dust, det kan være enemies som har gjemt seg under der.

That's it. Høres enkelt ut? Bare å gi det et forsøk, jeg har bare klart det én gang selv og jeg prøvde en del ganger under kodingen.

Hvis du klarer det,
Prøv igjen men prøv å samle Bitcoins, alle sammen, deretter vinn spillet.