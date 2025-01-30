# JUnit och Maven

## Maven kräver en viss mappstruktur

I vårt fall (det är rekommenderat att lyfta ut våra interface till egen mapp):

oob_lab1/
|- src/
|   | - main/
|   |   | - java/
|   |   |   | - main.java
|   |   |   | - cars/
|   |   |   |   | - Car.java
|   |   |   |   | - Saab95.java
|   |   |   |   | - Volvo240.java
|   |   |   | - interfaces/
|   |   |   |   | - Vehicle.java
|   |   |   |   | - Movable.java
|   | - test/
|       | - java/
|       |   | - cars/
|       |   |   | - Saab95Test.java
|       |   |   | - Volvo240Test.java
|- pom.xml
|- README.md

## Hur köra/testa?
### Kompilera 
javac -d out -sourcepath src/main/java src/main/java/main.java

(för att eventuellt säkerställa strukturen javac -d out -sourcepath src/main/java src/main/java/interfaces/*.java src/main/java/cars/*.java src/main/java/Main.java)

### Kör
java -cp out Main

### Testa med Maven
mvn test, alternativt mvn clean test

## Viktiga funktioner i JUnit

### Annotationer: JUnit använder annotationer för att identifiera testmetoder och styra testkörningen.

- @Test: Markerar en metod som ett testfall.

- @BeforeEach: Körs före varje test, används för att förbereda testmiljön.

- @AfterEach: Körs efter varje test, används för att rensa upp.

- @BeforeAll: Körs en gång före alla tester i klassen, används för att initiera gemensamma resurser.

- @AfterAll: Körs en gång efter alla tester, används för att frigöra gemensamma resurser.

- @Disabled: Hoppar över ett test.

### Assertioner: JUnit tillhandahåller metoder för att jämföra förväntade och faktiska resultat.

- assertEquals(expected, actual): Kontrollerar att två värden är lika, och tillåter kommenatar. Ger möjlighet vi double/loat att testa dessas felmarginal (sparas inte helt korrekt i minnet)

- assertTrue(condition): Kontrollerar att ett villkor är sant.

- assertFalse(condition): Kontrollerar att ett villkor är falskt.

- assertNotNull(object): Kontrollerar att ett objekt inte är null.

- assertThrows(Exception.class, executable): Kontrollerar att ett undantag kastas.

