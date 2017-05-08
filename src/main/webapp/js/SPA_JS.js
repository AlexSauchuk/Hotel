/**
 * Created by SK on 30.04.2017.
 */

(function($,window){

    var pageHandlers = {};

    var currentPageName = "contentMain";
    var $currentPage = null;

    function show(pageName,param) {
        var $page = $("section#" + pageName);
        if( $page.length == 0 ) {
            console.warn("section with id=%s not found!",pageName);
            return;
        }
        var ph = pageHandlers[pageName];
        if( ph ) {
            var that = $page.length > 0 ? $page[0] : null;
            var r = ph.call(that , param);
            if( typeof r == "function" ) { // it returns the function that's used for view rendering
                if(!$page.is("[no-ctl-cache]"))
                    pageHandlers[pageName] = r;
                r.call(that, param); // call that rendering function
            }
        }

        if(currentPageName) {

            $(document.body).removeClass(currentPageName);
            $(".nav a[href='#"+currentPageName+"']")[0].classList.remove('current');

            if(currentPageName=='contentBooking') {
                var booking = document.getElementById("idBookingA");
                booking.removeAttribute('href');
            }

            if($currentPage) {
                $currentPage[0].style.display = "none";
            }
        }
        $(document.body).addClass(currentPageName = pageName);
        if($currentPage = $page) {
            $currentPage[0].style.display = "block";
            $(document).title = currentPageName;
            $(".nav a[href='#"+currentPageName+"']")[0].classList.add('current');
        }


    }


    function app(pageName,param) {

        if(pageName=='undefined')
            pageName = currentPageName;
        
        var $page = $(document.body).find("section#" + pageName);

        var src = $page.attr("src");
        if( src && $page.find(">:first-child").length == 0) {
            $.get(src, "html") // it has src and is empty - load it
                .done(function(html){ currentPage = pageName; $page.html(html); show(pageName,param); })
                .fail(function(){ $page.html("failed to get:" + src); });
        } else
            show(pageName,param);
    }

    // Registration of page's handler function - scope initializer and controller
    app.page = function(pageName, handler) { pageHandlers[pageName] = handler; };
    // Function to get page's html, shall return jQuery's promise. Can be overriden.
    app.get = function(src,$page,pageName) { return $.get(src, "html"); };

    function onhashchange()
    {
        var hash = location.hash || ("#" + $("section[default]").attr('id'));


        var re = /#([-0-9A-Za-z]+)(\:(.+))?/;
        var match = re.exec(hash);
        hash = match[1];
        var param = match[3];

        app(hash,param); // navigate to the page
    }

    $(window).on("hashchange", onhashchange );
    window.app = app; // setup the app as global object

    window.setTimeout( function() { $(onhashchange); } );

})(jQuery,this);