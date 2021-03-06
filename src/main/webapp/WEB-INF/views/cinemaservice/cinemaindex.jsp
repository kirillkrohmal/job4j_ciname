<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <title>Сервис - Кинотеатр</title>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
    function addRowAndPlace() {
        window.location.href = '/cinema/payment'
    }


    /* function addRowAndPlace() {
         var name = $('#usr').val();

         $.ajax({
             type: 'GET',
             url: 'http://localhost:8080/cinema/view',
             data: 'name=' + $('#usr').val(),
             dataType: 'text'
         }).done(function (data) {
             $('tablename tr:last').after('<tr><td>' + name + '</td></tr>');
         }).fail(function (err) {
             alert(err);
         });
     }*/

</script>

<div class="container">
    <div class="row pt-3">
        <h4>
            Бронирование места на сеанс
        </h4>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th style="width: 120px;">Ряд / Место</th>
                <th>1</th>
                <th>2</th>
                <th>3</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th>1</th>
                <td><input type="radio" name="place" value="11"> занято место. Ряд 1, Место 1</td>
                <td><input type="radio" name="place" value="11"> занято место. Ряд 1, Место 2</td>
                <td><input type="radio" name="place" value="11"> Ряд 1, Место 3</td>
            </tr>
            <tr>
                <th>2</th>
                <td><input type="radio" name="place" value="11"> занято место. Ряд 2, Место 1</td>
                <td><input type="radio" name="place" value="11"> Ряд 2, Место 2</td>
                <td><input type="radio" name="place" value="11"> Ряд 2, Место 3</td>
            </tr>
            <tr>
                <th>3</th>
                <td><input type="radio" name="place" value="11"> Ряд 3, Место 1</td>
                <td><input type="radio" name="place" value="11"> Ряд 3, Место 2</td>
                <td><input type="radio" name="place" value="11"> занято место. Ряд 3, Место 3</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="row float-right">
        <button type="button" class="btn btn-success" onclick="addRowAndPlace()">Оплатить</button>
    </div>
</div>
</body>
</html>