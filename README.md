# Assegnamento 1 Ollari Ischimji Dmitri matricola:305353

## Sviluppare in java un ecommerce per la vendita di prodotti elettronici.

## Prodotti
definiti da:
- nome prodotto
- codice prodotto (univoco)
- nome produttore
- prezzo

## 3 categorie di utenti
1. Utente admin (solo uno)
2. Utenti worker 
   1. gestione degli ordini
   2. spedizione degli ordini
   3. gestione magazzino
3. Utente normale
   1. aggiunge cose al carrello
   2. compra

Tutti gli utenti hanno username e password per accedere al sistema.

Prevista funzione per permettere all'utente di registrarsi.

## Utente normale loggato
1. ricerca prodotti
   1. per nome
   2. per fornitore
   3. per min e max
   4. misto dei tre precedenti
2. acquistare prodotti

## Utente worker loggato
1. spedire i prodotti ai clienti
2. rimpiazzare i prodotti venduti in magazzino

## Utente admin
1. credenziali hardcoded
2. assegna le credenziali agli utenti
3. aggiunge o rimuove dei tipi di prodotto

## Principali funzioni
1. Il sistema prende in carico l'ordine del cliente
2. un dipendente invia i prodotti di un ordine, la quantità in magazzino vengono aggiornate automaticamente
    - se la giacenza diveta nulla per qualche prodotto, il sistema manda una lista di prodotti da acquistare ad un'impiegato
3. all'arrivo dei nuovi prodotti, un dipendente aggiorna le quantità dei prodotti
4. **interazioni mediante console**


Il codice dovrà essere formattato utilizzando un unico stile di codifica e commentando gli “elementi”
del codice non privati con javadoc. I commenti e i nomi degli elementi del codice dovranno essere
preferibilmente scritti in lingua inglese.
Il progetto dovrà essere consegnato tramite il “compito” Elly “assegnamento 1”. La consegna dovrà
essere unica per ogni gruppo e dovrà essere un file compresso contenente: un breve manuale con una
descrizione utile per installare e utilizzare il sistema (il manuale dovrà come prima cosa indicare gli
autori del progetto), le dipendenze da librerie esterne (con le informazioni per includerle nel progetto),
il codice sorgente e il javadoc del progetto.
