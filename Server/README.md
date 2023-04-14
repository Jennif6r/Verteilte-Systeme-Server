# Verteilte Systeme Server
Dieses Repo stellt die Serverkomponente des Projektes für die Vorlesung Verteilte Systeme dar.
Die Client Komponente ist [hier](https://github.com/Jennif6r/Verteilte-Systeme-Client) zu finden. 
Ein Server kann mit mehreren Clients interagieren.

## Einrichtung bzw. Installation des Servers
1. Das Repo clonen
2. in der Klasse `Publisher` im Verzeichnis `src.main.java.services`die IP-Adresse unter der der Server erreichbar sein soll eintragen
3. zum eigentlichen Starten des Servers gibt es zwei Möglichkeiten. 
    * die Klasse Publisher starten 
    * mit Maven eine jar Datei erzeugen und diese Ausführen
    
## Beschreibung der Aufgabenstellung des Projekts
Beschreibung: Eine Java-Anwendung, die Bestellungen von hungrigen Informatikern aufnimmt und zusammenfügt.
              Eine Schnittstelle stellt die zusammengefügte Bestellung bereit, diese darf nur einmal erzeugt werden.

Anforderung: Frontend(Auswahl verschiedener Produkte) , Backend (speichern der Bestellungen und zu einer Bestellung zusammen fügen, Schnittstellen (für Erhalt der Gesamtbestellung und optional für das Erstellen einer Rechnung). Mehrere Bestellungen gleichzeitig möglich. Benachrichtigung, wenn Kriterien erfüllt sind. 