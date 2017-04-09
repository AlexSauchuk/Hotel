<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <script type="text/javascript" src=js/formScript.js></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="Content-Style-Type" content="text/css"/>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/layout.css" rel="stylesheet" type="text/css"/>
    <script src="js/maxheight.js" type="text/javascript"></script>
    <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans:600'>
    <link rel="stylesheet" href="css/styleSignIn.css">
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
                    <h1><a href="index.html">Бобруйск</a></h1>
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
                            <li><a href="index.jsp">Главная</a></li>
                            <li><a href="services.jsp">Услуги</a></li>
                            <li><a href="gallery.jsp">Галерея</a></li>
                            <li><a href="testimonials.jsp">Отзывы</a></li>
                            <li><a href="booking.jsp">Бронирование</a></li>
                            <li><a href="signin.jsp" class="current">Вход</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- content -->
    <div id="content">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                <div class="login-form">

                    <div class="sign-in-htm">
                        <form id="myForm" onsubmit="return validateForm();">
                            <div class="group">
                                <label for="pass" class="label">Email</label>
                                <input id="email" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Пароль</label>
                                <input id="password" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <input type="submit" class="button" value="Sign In">
                            </div>
                            <div class="hr"></div><!--
							<div class="foot-lnk">
								<a href="#forgot">Забыли пароль?</a>
							</div>-->
                        </form>
                    </div>
                    <div class="sign-up-htm">
                        <form id="myForm" onsubmit="return validateForm();">
                            <div class="group">
                                <label for="user" class="label">Логин</label>
                                <input id="login" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="user" class="label">Email</label>
                                <input id="email" type="text" class="input">
                            </div>
                            <div class="group">
                                <label for="pass" class="label">Пароль</label>
                                <input id="password" type="password" class="input" data-type="password">
                            </div>
                            <div class="group">
                                <label for="user" class="label">Телефон</label>
                                <input id="phone" type="text" class="input">
                            </div>
                            <div class="group">
                                <input id="sex" type="checkbox" class="check" checked>
                                <label for="check"><span class="icon"></span>Мужчина</label>
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
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div id="footer">
        <ul class="nav">
            <li><a href="index.jsp">Главная</a></li>
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