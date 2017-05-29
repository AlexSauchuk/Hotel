<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Main</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/SPA_JS.js"></script>
    <script type="text/javascript" src="js/main/main.js"></script>
    <script src="js/formScript.js" type="text/javascript"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/styleSignIn.css">
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script src="js/maxheight.js" type="text/javascript"></script>
    <!--[if lt IE 7]>
    <link href="ie_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="ie_png.js"></script>
    <script type="text/javascript">
        ie_png.fix('.png, #header .row-2, #header .nav li a, #content, .gallery li');
    </script>
    <![endif]-->
</head>
<body class="contentMain" onload="new ElementMaxHeight();">
<div id="main">
    <!— header —>
    <div id="header">
        <div class="row-1">
            <div class="wrapper">
                <div class="logo">
                    <h1><a href="main.jsp">Бобруйск</a></h1>
                    <em>Отель</em>
                    <strong>Настоящая роскошь</strong>
                </div>
                <div>
                    <div class="phones">
                        +375(29)179-07-46
                        <br>
                        <div id="idAdminRef" style="display: none">
                            <a href="/servlet?page=admin.jsp&action=ADMIN_START">Администратор</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="row-2">
            <div class="indent">
                <!— header-box begin —>
                <div class="header-box">
                    <div class="inner">
                        <ul class="nav">
                            <li><a href="#contentMain" class="current">Главная</a></li>
                            <li><a href="#contentServices" id="idServicesA">Услуги</a></li>
                            <li><a href="#contentGallery">Галерея</a></li>
                            <li><a href="#contentTestimonials">Отзывы</a></li>
                            <li><a id="idBookingA">Бронирование</a></li>
                            <li><a href="#entry" click="" id="idEntryA">Вход</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="content">
        <section id=contentMain class="container" src="/templates/pages/main/contentMain.html"></section>
        <section id=contentBooking class="container" src="/templates/pages/booking/contentBooking.html"></section>
        <section id=contentGallery class="container" src="/templates/pages/gallery/contentGallery.html"></section>
        <section id=contentServices class="container" src="/templates/pages/services/contentServices.html"></section>
        <section id=entry class="container" src="/templates/pages/signin/entry.html"></section>
        <section id=contentTestimonials class="container" src="/templates/pages/testimonials/contentTestimonials.html"></section>
    </div>
    <div id="footer" style="width: 976px;margin: auto">
        <ul class="nav nav-pills" style="align:center;">
            <li><a href="#contentMain" class="current">Главная</a></li>
            <li><a href="#contentServices">Услуги</a></li>
            <li><a href="#contentGallery">Галерея</a></li>
            <li><a href="#contentTestimonials">Отзывы</a></li>
            <li><a href="#contentBooking">Бронирование</a></li>
            <li><a href="#entry">Вход</a></li>
        </ul>
        <div class="wrapper">
            <div class="fleft">Copyright (c) 2017 Бобруйск Отель</div>
        </div>
    </div>
</div>
</body>
</html>