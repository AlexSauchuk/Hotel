<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/style.css" media="screen" type="text/css" />
    <script src="js/prefixfree.min.js"></script>
</head>
<body>
<br/>
<a href="test.jsp" >Back to Main page</a>
<br/>
<header>
    <h2>Нет аккаунта?</h2>
    <a class="h2" href="#" id="form-switch">Регистрация!</a>
</header>

<form action = "servletRegistration" method = "POST">
    <div class="front-sign-in">
        <input type="text" name="login" placeholder="Логин">
        <input type="password" name="password" placeholder="Пароль">
        <input class="signin-submit" type="submit" value="ВОЙТИ">
    </div>
    <div class="back-sign-up">
        <input type="text" placeholder="Имя">
        <input type="text" placeholder="Email">
        <input class="signup-submit" type="submit" value="Регистрация">
    </div>
</form>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script src="js/index.js"></script>
</body>
</html>