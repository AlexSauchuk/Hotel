<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>SignIn</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <script src="js/main/main.js" type="text/javascript"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>
    <script src="js/maxheight.js" type="text/javascript"></script>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="css/styleSignIn.css">

    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <!--[if lt IE 7]>
    <link href="ie_style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="ie_png.js"></script>
    <script type="text/javascript">
        ie_png.fix('.png, #header .row-2, #header .nav li a, #content, .gallery li');
    </script>
    <![endif]-->
</head>
<body id="page4" onload="new ElementMaxHeight();">
<div id="main">
    <!-- header -->
    <div id="header" class="small">
        <div class="row-1">
            <div class="wrapper">
                <div class="logo">
                    <h1><a href="main.jsp">Бобруйск</a></h1>
                    <em>Отель</em>
                    <strong>Настоящая роскошь</strong>
                </div>
                <div class="phones">
                    +375(29)179-07-46
                </div>
            </div>
        </div>
        <div class="row-2 alt">
            <div class="indent">
                <div class="header-box-small">
                    <div class="inner">
                        <ul class="nav">
                            <li><a href="main.jsp">Главная</a></li>
                            <li><a href="services.jsp">Услуги</a></li>
                            <li><a href="gallery.jsp">Галерея</a></li>
                            <li><a href="testimonials.jsp">Отзывы</a></li>
                            <li><a href="booking.jsp">Бронирование</a></li>
                            <li><a href="signin.jsp" id="idEntryA" data-toggle="modal" data-target="#myModalUpdate" >Вход</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content -->
    <div id="content">
        <div class="login-form" id="idEntry">
            <div class="bs-docs-example">
                <div class="tabbable">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#lA" data-toggle="tab">Sign In</a></li>
                        <li><a href="#lB" data-toggle="tab">Sign Up</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="lA">
                            <div id="myFormIn">
                                <div class="group">
                                    <label for="emailIn" class="label">Email</label>
                                    <input id="emailIn" type="text" class="input">
                                </div>
                                <div class="group">
                                    <label for="passIn" class="label">Пароль</label>
                                    <input id="passIn" type="password" class="input" data-type="password">
                                </div>
                                <div class="group">
                                    <input type="submit" class="button" onclick="validateForm()" value="Sign In">
                                </div>
                                <div class="hr">

                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="lB">
                            <form id="myFormUp" onsubmit="return validateForm();">
                                <div class="group">
                                    <label for="login" class="label">Логин</label>
                                    <input id="login" type="text" class="input">
                                </div>
                                <div class="group">
                                    <label for="emailUp" class="label">Email</label>
                                    <input id="emailUp" type="text" class="input">
                                </div>
                                <div class="group">
                                    <label for="passUp" class="label">Пароль</label>
                                    <input id="passUp" type="password" class="input" data-type="password">
                                </div>
                                <div class="group">
                                    <label for="phone" class="label">Телефон</label>
                                    <input id="phone" type="text" class="input">
                                </div>
                                <div class="group">
                                    <input id="sex" type="checkbox" class="check" checked>
                                    <label for="sex"><span class="icon"></span>Мужчина</label>
                                </div>
                                <div class="group">
                                    <input id="check" type="checkbox" class="check" checked>
                                    <label for="check"><span class="icon"></span>Запомнить меня</label>
                                </div>
                                <div class="group">
                                    <input type="submit" class="button" value="Sign Up">
                                </div>
                                <div class="hr"></div>
                            </form>
                        </div>
                        <p></p>
                    </div>
                    <p></p>
                </div>
                <p></p>
            </div>
        </div>

    </div>
    </div>
    <!-- footer -->
    <div id="footer" style="width: 976px;margin: auto">
        <ul class="nav nav-pills" style="align:center;">
            <li><a href="main.jsp">Главная</a></li>
            <li><a href="services.jsp">Услуги</a></li>
            <li><a href="gallery.jsp">Галерея</a></li>
            <li><a href="testimonials.jsp">Отзывы</a></li>
            <li><a href="booking.jsp">Бронирование</a></li>
            <li><a href="signin.jsp">Вход</a></li>
        </ul>
        <div class="wrapper">
            <div class="fleft">Copyright (c) 2017 Бобруйск Отель</div>
        </div>
    </div>
</div>
</body>
</html>