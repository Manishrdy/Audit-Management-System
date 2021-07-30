<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session Expired</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <style>

        body {
            background: #D8D8D8;
        }

        * {
        box-sizing: border-box;
        }

        html {
        font-family: "Muli", sans-serif;
        background: #D8D8D8;
        color: #333;
        text-rendering: optimizeLegibility;
        }

        pre {
        font-size: 12px;
        padding: 10px;
        background: white;
        border: solid 1px #777;
        }

        table {
        border-collapse: collapse;
        border-spacing: 0px;
        border: 1px solid #666;
        }

        td, th {
        padding: 0.25rem 0.5rem;
        border: 1px solid #666;
        }

        .mod_scale_fluid h1 {
        font-size: 1.2961572031rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h1 {
            font-size: calc(4.3792407416vw - 0.346058075rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h1 {
            font-size: 3.1573345183rem;
        }
        }
        .mod_scale_fluid h2 {
        font-size: 1.214767763rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h2 {
            font-size: calc(2.7148829976vw + 0.1966866389rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h2 {
            font-size: 2.368593037rem;
        }
        }
        .mod_scale_fluid h3 {
        font-size: 1.138489rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h3 {
            font-size: calc(1.5021176471vw + 0.5751948824rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h3 {
            font-size: 1.776889rem;
        }
        }
        .mod_scale_fluid h4 {
        font-size: 1.067rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h4 {
            font-size: calc(0.6258823529vw + 0.8322941176rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h4 {
            font-size: 1.333rem;
        }
        }
        .mod_scale_fluid h5 {
        font-size: 1rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h5 {
            font-size: calc(0vw + 1rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h5 {
            font-size: 1rem;
        }
        }
        .mod_scale_fluid h6 {
        font-size: 0.9372071228rem;
        }
        @media screen and (min-width: 37.5rem) {
        .mod_scale_fluid h6 {
            font-size: calc(-0.4400460609vw + 1.1022243956rem);
        }
        }
        @media screen and (min-width: 80rem) {
        .mod_scale_fluid h6 {
            font-size: 0.7501875469rem;
        }
        }

        body {
        /* width: 80%; */
        margin: 0 auto;
        }

        h1, h2, h3, h4, h5, h6 {
        padding: 0;
        margin: 0.5rem 0;
        line-height: 1.5;
        }
    </style>
</head>
<body>
    <div class="text-center container mt-4">
		<img src="https://www.rhinocarhire.com/CorporateSite/media/Drive-Smart/Dash-Symbols/warning_symbol_in_red.png" width="72" height="72"/>
		<h1>Session Expired !</h1>
		<a href="loginPage" class="btn btn-success">Login Again</a>
	</div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
</body>
</html>