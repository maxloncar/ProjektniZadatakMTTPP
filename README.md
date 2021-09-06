# ProjektniZadatakMTTPP - testing web shop
Projektni zadatak iz kolegija "Metode i tehnike testiranja programske podrške"

Na osnovu metoda i tehnika upoznatih tijekom izvođenja laboratorijskih vježbi, 
izrađen je okvir za automatsko testiranje programke podrške u kojem se testirala web 
stranica HGSpot-a (https://www.hgshop.hr/).

Korišteni alati su JAVA JDK Development Kit, IntelliJ Community Edition IDE te ChromeDriver
za Google Chrome web preglednik (engl. *browser*). Unutar IntelliJ IDE-a je izrađen Maven projekt
koristeći Selenium i TestNG ovisnosti.

Napisano je 5 testnih slučajeva koristeći programski jezik JAVA, a za svaki slučaj je stvorena
testna klasa (FirstTest, SecondTest, ThirdTest, FourthTest, FifthTest). Elemente se najčešće
pronalazilo pomoću svojstva *xpath*, *wait* naredba se realizirala pomoću klase **WebDriverWait**,
a web elementi pomoću sučelja **WebElement**. Prije početka testova (metoda **setupTest()**), 
pomoću *driver*-a se povećava (engl. *maximize*) prozor i pristupa navedenom URL-u. Svaki od testova
završava gašenjem *driver*-a unutar **teardownTest()** metode. URL-ovi i telefonski brojevi se uspoređuju 
pomoću klase **Assert** i metode **assertEquals()**. Pomicanja, odnosno *scrollanje* je realizirano pomoću 
**JavascriptExecutor** sučelja.

### FirstTest

U prvom testnom slučaju naziva FirstTest, testira se prijava korisnika na svoj profil unosom e-maila
i šifre (korisnik je već registriran). Test se izvršava unutar metode **logInTest()**.
Za početak je korištena eksplicitna *wait* naredba pomoću koje WebDriver čeka dok se određeni uvjet 
ne dogodi prije nego nastavi s izvršavanjem daljnjeg koda. U ovom slučaju se čekalo da element 
**Prijava** bude vidljiv na navigacijskoj traci u gornjem desnom kutu. Klikom na **Prijava**, otvara 
se prozor unutar kojega se unosi vlastiti e-mail i šifra pomoću naredbe **sendKeys**. Nakon toga se 
označava *checkbox* **Zapamti me** i klikne na gumb **PRIJAVI SE**. Na kraju usporedbom URL-ova 
provjerava se jesu li očekivani i stvarni URL jednaki. Stvarni URL se dobiva pomoću naredbe 
**getCurrentUrl()**. Nakon što se test izvrši, unutar konzole se ispisuje trenutni URL.

### SecondTest

U drugom testnom slučaju naziva SecondTest, testira se dodavanje proizvoda u kolica za kupovinu.
Test se izvršava unutar metode **addToShoppingCartTest()**.
Za početak je također korištena eksplicitna **wait** naredba pomoću koje WebDriver čeka da kategorija
**RAČUNALA** bude vidljiva na navigacijskoj traci. Klikom na kategoriju **RAČUNALA**, otvara se mali
izbornik u kojem se biraju **RAČUNALA ZA KUĆNU PRIMJENU**. Nakon toga je potrebno pomaknuti se prema
dolje (engl. *scroll down*) kako bi se mogao odabrati element za dodati u kolica. *Scrollanje* je
realizirano pomoću **JavascriptExecutor** sučelja kojim se pomaklo za 300 pixela prema dolje. Kod
proizvoda kojeg se želi staviti u kolica za kupovinu, klikne se na gumb **KUPI**. U ovom slučaju
se kupuje stolno računalo. Također postoji eksplicitna *waitForBuy* naredba kojom WebDriver čeka 
da gumb bude vidljiv. Klikom na gumb **KUPI**, iskače novi prozor unutar kojega je moguće povećati 
količinu proizvoda te odabrati opciju **Nastavi kupovinu** ili **Završi kupovinu**. Odabire se opcija 
**Završi kupovinu** te na kraju uspoređuju URL-ovi. Usporedbom URL-ova provjerava se jesu li očekivani 
i stvarni URL jednaki. Stvarni URL se dobiva pomoću naredbe **getCurrentUrl()**. Nakon što se test 
izvrši, unutar konzole se ispisuje trenutni URL.

### ThirdTest

U trećem testnom slučaju naziva ThirdTest, testira se dodavanje više proizvoda u kolica za kupovinu
(u ovom slučaju se dodavaju 2 proizvoda). Test se izvršava unutar metode **addTwoItemsToShoppingCartTest()**.
Za početak je također korištena eksplicitna **wait** naredba pomoću koje WebDriver čeka da kategorija
**RAČUNALA** bude vidljiva na navigacijskoj traci. Klikom na kategoriju **RAČUNALA**, otvara se mali 
izbornik u kojem se biraju **RAČUNALA ZA KUĆNU PRIMJENU**. Nakon toga je potrebno pomaknuti se prema 
dolje (engl. *scroll down*) kako bi se mogao odabrati element za dodati u kolica. *Scrollanje* je 
realizirano pomoću **JavascriptExecutor** sučelja kojim se pomiče za 300 pixela prema dolje. Kod 
proizvoda kojeg se želi staviti u kolica za kupovinu, klikne se na gumb **KUPI**. U ovom slučaju se 
kupuje stolno računalo. Također postoji eksplicitna *waitForBuy* naredba kojom WebDriver čeka da gumb 
bude vidljiv. Klikom na gumb **KUPI**, iskače novi prozor unutar kojega je moguće povećati količinu 
proizvoda te odabrati opciju **Nastavi kupovinu** ili **Završi kupovinu**. Odabire se opcija **Nastavi 
kupovinu** te se ponovno mora *scrollati*, ovoga puta 300 pixela prema gore. Zatim se na navigacijskoj 
traci klikne na **GAMING** nakon čega se otvori mali izbornik u kojem se bira kategorija **IGRE**. 
Nakon toga se odabire video igra te klikom na gumb **KUPI** ponovno iskače novi prozor unutar kojega 
je moguće povećati količinu proizvoda te odabrati opciju **Nastavi kupovinu** ili **Završi kupovinu**.
Odabire se opcija **Završi kupovinu** te na kraju uspoređuju URL-ovi. Usporedbom URL-ova provjerava se 
jesu li očekivani i stvarni URL jednaki. Stvarni URL se dobiva pomoću naredbe **getCurrentUrl()**.
Nakon što se test izvrši, unutar konzole se ispisuje trenutni 
URL.

### FourthTest

U četvrtom testnom slučaju naziva FourthTest, testira se dodavanje i brisanje proizvoda u/iz kolica za 
kupovinu. Test se izvršava unutar metode **addRemoveItemsInShoppingCartTest()**. Za početak je također 
korištena eksplicitna **wait** naredba pomoću koje WebDriver čeka da kategorija **RAČUNALA** bude 
vidljiva na navigacijskoj traci. Klikom na kategoriju **RAČUNALA**, otvara se mali izbornik u kojem se 
biraju **RAČUNALA ZA KUĆNU PRIMJENU**. Nakon toga je potrebno pomaknuti se prema dolje (engl. *scroll 
down*) kako bi se mogao odabrati element za dodati u kolica. *Scrollanje* je realizirano pomoću 
**JavascriptExecutor** sučelja kojim se pomiče za 300 pixela prema dolje. Kod proizvoda kojeg se želi 
staviti u kolica za kupovinu, klikne se na gumb **KUPI**. U ovom slučaju se kupuje stolno računalo. 
Također postoji eksplicitna *waitForBuy* naredba kojom WebDriver čeka da gumb bude vidljiv. Klikom na 
gumb **KUPI**, iskače novi prozor unutar kojega je moguće povećati količinu proizvoda te odabrati 
opciju **Nastavi kupovinu** ili **Završi kupovinu**. Odabire se opcija **Nastavi kupovinu** te se 
ponovno mora *scrollati*, ovoga puta 300 pixela prema gore. Zatim se na navigacijskoj traci klikne na 
**GAMING** nakon čega se otvori mali izbornik u kojem se bira kategorija **IGRE**. Nakon toga se 
odabire video igra te klikom na gumb **KUPI** ponovno iskače novi prozor unutar kojega je moguće 
povećati količinu proizvoda te odabrati opciju **Nastavi kupovinu** ili **Završi kupovinu**. Odabire
se opcija **Završi kupovinu** te se dobiva pogled na sadržaj kolica za kupovinu. Klikom na znak **X**
se briše proizvod iz kolica za kupovinu, no prije toga naredbom *waitToRemove* WebDriver čeka da se
pojavi sami znak. Nakon toga se ponovno *scrolla* za 300 pixela prema dolje kako bi se moglo kliknuti
na gumb **Sljedeći**. Na kraju se uspoređuju URL-ovi. Usporedbom URL-ova provjerava se jesu li 
očekivani i stvarni URL jednaki. Stvarni URL se dobiva pomoću naredbe **getCurrentUrl()**. Nakon što 
se test izvrši, unutar konzole se ispisuje trenutni URL.

### FifthTest

U petom testnom slučaju naziva FifthTest, testira se promjena podataka profila korisnika. Test se
izvršava unutar metode **changeProfileDataTest()**. Za početak je također korištena naredba *wait*
pomoću koje WebDriver čeka da element **Prijava** bude vidljiv kako bi se moglo kliknuti na njega.
Klikom na **Prijava**, otvara se prozor unutar kojega se unosi vlastiti e-mail i šifra. Nakon toga 
se označava *checkbox* **Zapamti me** i klikne na gumb **PRIJAVI SE**. Zatim postoji eksplicitna
*waitForProfile* naredba kojom WebDriver čeka da kategorija **Profil** bude vidljiva za kliknuti.
Klikom na kategoriju **Profil**, otvara se prozor unutar kojega se nalaze osnovni podaci korisnika.
Klikom na gumb **PROMIJENI PROFIL**, otvara se prozor unutar kojega se mogu promijeniti osnovni
podaci korisnika. Klikom na polje za unos telefonskog broja, naredbom **clear()** se čisti polje i
naredbom **sendKeys()** se šalje određeni telefonski broj. Zatim se *scrolluje* prema dolje za 500 
pixela i klikne na dugme **Spremi nove podatke**. Na kraju se uspoređuju telefonski brojevi.
Usporedbom telefonskog broja provjerava se jesu li očekivani i stvarni telefonski broj jednaki,
odnosno je li se vrijednost telefonskog broja promijenila. Stvarni telefonski broj se dobije tako 
što se s web elementom dohvaća vrijednost pomoću naredbe **getAttribute()** koja kao parametar 
prima *value*. Nakon što se test izvrši, unutar konzole se ispisuje trenutni telefonski broj.

### TestNG.xml

Osim ovakvog načina testiranja, moguće je web stranicu testirati pomoću ručno konfigurirane datoteke
**TestNG.xml**. Takav način testiranja je moguće pokrenuti pritiskom na opciju *Run* ili iz komadne
linije sa sljedećom naredbom:
```
$mvn test   (Ctrl + Enter)
```

Budući da je korišten *maven-surefire-plugin*, tijekom izvršavanja testova se stvaraju izvješća o
izvršenim testovima na sljedećoj lokaciji:
```
../<project_folder>/target/surefire-reports/index.html
```
