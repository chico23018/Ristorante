<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Al Pomo d'oro</title>
  <link rel="shortcut icon" href="sources/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
    integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw=="
    crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.min.css"
    integrity="sha512-ztsAq/T5Mif7onFaDEa5wsi2yyDn5ygdVwSSQ4iok5BPJQGYz1CoXWZSA7OgwGWrxrSrbF0K85PD5uLpimu4eQ=="
    crossorigin="anonymous">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:wght@300;400;700;900&display=swap">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins&display=swap">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/flickity/2.2.1/flickity.pkgd.min.js"
    integrity="sha512-Nx/M3T/fWprNarYOrnl+gfWZ25YlZtSNmhjHeC0+2gCtyAdDFXqaORJBj1dC427zt3z/HwkUpPX+cxzonjUgrA=="
    crossorigin="anonymous"></script>

    <link rel="stylesheet" href="style.css">

</head>

<body>

  <div class="header">
    <div class="logo">
      <img src="sources/logo.png" alt="">
    </div>
    <ul class="menu flex-text">
      <li><a href="#Servizi">Servizi</a></li>
      <li><a href="#Tariffario">Tariffe</a></li>
      <li><a href="#Chi-siamo">Chi siamo</a></li>
      <li><a href="#Contatti">Contatti</a></li>
    </ul>
    <div class="hamburger">
      <span></span>
      <span></span>
      <span></span>
    </div>
  </div>

  <div class="hero">
    <div class="hero__content reveal">
      <p class="intro-text">Servizio Taxi</p>
      <h1 class="big-text">Al Pomo d'oro</h1>
      <a href="tel:+393487678837" class="button">Prenota ora</a>
    </div>
    <video autoplay muted loop id="video-back">
      <source src="sources/video-back.mp4" type="video/mp4">
    </video>
  </div>

  <!--  <h2 class="carousel-title mt-2">Mete imperdibili</h2>  -->
  <div class="main-carousel med-text" data-flickity='{ "cellAlign": "left", "contain": true }'>
    <div class="carousel-cell">
      <div class="carousel-cell__content zoom tw intro-text-2" style="background-image: url('sources/taormina.png');">
        Taormina
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content zoom tw intro-text-2"
        style="background-image: url('sources/etna\ rigugio.png');">
        Etna
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content zoom tw intro-text-2" style="background-image: url('sources/palermo.png');">
        Palermo
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content zoom tw intro-text-2"
        style="background-image: url('sources/valle\ dei\ templi.png');">
        Agrigento
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content zoom tw intro-text-2" style="background-image: url('sources/acitrezza.png');">
        Acitrezza
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content tw intro-text-2" style="background-image: url('sources/augusta.png');">
        Augusta
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content tw intro-text-2" style="background-image: url('sources/siracusa.png');">
        Siracusa
      </div>
    </div>
    <div class="carousel-cell">
      <div class="carousel-cell__content tw intro-text-2" style="background-image: url('sources/cefalu.png');">
        Cefalù
      </div>
    </div>
  </div>

  <div class="grid" id="Chi-siamo">
    <div class="col reveal">
      <h3 class="intro-text-3"><br />Chi siamo?</h3>
    </div>
    <div class="col reveal">
      <p class="mt-2 mt-sma-0">Benvenuti nel mondo del viaggio senza complicazioni, dove l'efficienza incontra il
        comfort e la convenienza. Il nostro servizio taxi è progettato per offrirvi un'esperienza di viaggio
        ineguagliabile, sia che siate in viaggio d'affari o in una rilassante fuga di piacere.
        Immaginate di essere accolti da conducenti professionisti, cortesi e sempre pronti ad andare incontro alle
        vostre esigenze. Dimenticate lo stress del parcheggio o l'ansia di perdere il vostro volo con il nostro
        servizio, siamo al vostro servizio per garantire che arriviate a destinazione in tempo e con tranquillità.
        La prenotazione non potrebbe essere più semplice. Con il nostro sistema di prenotazione online intuitivo, potete
        prenotare il vostro taxi in pochi semplici passaggi. Se preferite parlare con una persona reale, il nostro team
        dedicato è a vostra disposizione per assistervi con la prenotazione telefonica.</p>
    </div>
  </div>

  <footer class="footer mt-3" id="Contatti">
    <div class="grid2">

      <div class="col reveal">
        <h4 class="flex-text2 tw">Contatti</h4>
        <p class="normal-text tw">
          <img src="sources/cornetta_telefonica.png" alt="icona" style="vertical-align: middle;">
          <a href="tel:+393487678837">+39 348 7678837</a>
        </p>
        <p class="normal-text tw">
          <img src="sources/mail.png" alt="icona" style="vertical-align: middle;">
          <a href="mailto:nome.cognome@mail.it" style="font-size: 16px">nome.cognome@mail.it</a>
        </p>
      </div>

      <div class="col reveal">
        <h4 class="flex-text2 tw">Social</h4>
        <p class="normal-text tw">
          <img src="sources/insta.png" alt="icona" style="vertical-align: middle;">
          <a href="" style="font-size: 16px">@nome_instagram</a>
        </p>
        <br />
        <p class="normal-text tw">
          <img src="sources/facebook.png" alt="icona" style="vertical-align: middle; margin-right: 20px;">
          <a href="" style="font-size: 16px">nome_facebook</a>
        </p>
      </div>

      <div class="col reveal">
        <h4 class="flex-text2 tw">Orari servizio</h4>
        <p class="pw">24 ore su 24</p>
        <br />
        <p class="pw">7 giorni su 7</p>
      </div>

      <div class="col reveal">
        <h4 class="flex-text2 tw">Partita IVA</h4>
        <p class="pw">ci pensa </p>
      </div>

    </div>
  </footer>

  <!--JQuery alla fine del body poichè alcuni sono bloccanti-->
  <script src="js/script.js"></script>

</body>

</html>