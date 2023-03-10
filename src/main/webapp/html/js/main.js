jQuery(document).ready(function($) {


    var windowwidth = $( window ).width();
    if(windowwidth >= 769){
        $("div.holder_news").jPages({
            containerID: "listAll_news",
            perPage: 6,
            first       : false,
            previous    : "span.arrowPrev",
            next        : "span.arrowNext",
            last        : false
          });
    }else{
        $("div.holder_news").jPages({
            containerID: "listAll_news",
            perPage: 1,
            first       : false,
            previous    : "span.arrowPrev",
            next        : "span.arrowNext",
            last        : false
          });
    }
    $('.searchpost li:nth-child(2)').on('mouseover',function(){
        $('.searchpost li:nth-child(1)').addClass('active');
        $('.searchpost ul li:nth-child(1)').append(" <p class='m-0'></p>")
    });
    $(document).delegate('.searchpost ul li:nth-child(1) p', 'click', function(){
        $('.searchpost ul li:nth-child(1)').removeClass('active');
        $('.searchpost ul li:nth-child(1) p').remove();
    });

    $('.slider').flickity({
        draggable: true,
        wrapAround: true,
        autoPlay: 10000,
        cellAlign: 'center',
        adaptiveHeight: true,
    });
// 	$('.careerJob .listing').flickity({
// 		initialIndex: 1,
// 		draggable: true,
//             wrapAround: true,
//             autoPlay: false,
// 		pageDots: false,
// 	});
// 	$("div.holderRecruitment").jPages({
//         containerID: "new_listing",
//         perPage: 4,
//     });
    setTimeout(function() {
        $('.loader').addClass('inactive');
    }, 1000);

    if ($(window).width() < 640) {
        $('.m-slider').flickity({
            draggable: true,
            wrapAround: true,
            autoPlay: false,
            cellAlign: 'center',
        });
        $('.menu-prd .toggler').click(function() {
            $('.menu-prd').not(this).removeClass('active');
            $(this).parent().toggleClass('active');
        });

    }

    $('#menu-toggle').click(function() {
        $('body').toggleClass('menu--on');
        $(this).toggleClass('open');
    });

    // circle carousel

    if ($(window).width() > 640) {
        $(document).ready(function() {

            // new WOW().init();
            $('#about').fullpage({
                anchors: ['1', '2', '3', '4', '5', '6', '7', '8'],
                afterLoad: function(anchorLink, index) {
                    var loadedSection = $(this);
                    // if ($('.section').hasClass('active')) {
                    //     $(this).addClass('delay');
                    // } else {
                    //     $(this).removeClass('delay');
                    // };
                    $('.main-menu li').removeClass('active');
                    $('.main-menu li').eq(index - 1).addClass('active');
                    // var href = $('#main-menu li').eq(index - 1).find('a').attr('href');
                    // console.log(href)
                    // history.pushState(null, null, href);
                    // if(index == 1){
                    //     $('#logo').hide('fast');
                    // }

                    // if(index != 1){
                    //     $('#logo').show('fast');
                    // }

                    // if(index == 8){
                    //     $.fn.fullpage.setAutoScrolling(false);
                    //     $.fn.fullpage.setFitToSection(false);
                    // }
                    if (index == 3) {}
                    if (index == 5) {} else {
                        // $.fn.fullpage.setAutoScrolling(true);
                    }
                }
            });

            $(document).on('click', '.moveTo', function() {
                var page_target = $(this).attr('target');

                $.fn.fullpage.moveTo(page_target);
            });

            $('.xl-slider').flickity({
                draggable: true,
                wrapAround: true,
                autoPlay: 10000,
                cellAlign: 'center',
                adaptiveHeight: true,
            });
        });

        $('#to-top').click(function() {
            $.fn.fullpage.moveTo(1);
        });

        // $(document).on('click', '.menu-item', function() {
        //     var page_target = $(this).attr('target');
        //     $.fn.fullpage.moveTo(page_target);
        // });
    }


});
