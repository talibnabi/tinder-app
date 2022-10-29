<!doctype html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" href="/webstock/webfiles/images/logo.png" type="image/png">
    <title>MatchMe Here</title>

    <link rel="stylesheet" href="/webstock/webfiles/css/bootstrap.css">
    <link rel="stylesheet" href="/webstock/webfiles/vendors/linericon/style.css">
    <link rel="stylesheet" href="/webstock/webfiles/css/font-awesome.min.css">
    <link rel="stylesheet" href="/webstock/webfiles/css/styler.css">

</head>
<body>
<section class="profile_area">
    <div class="container">
        <form method="post">
            <div class="profile_inner p_50">
                <div class="row">
                    <div class="col-lg-5">
                        <img class="img-fluid" src=${likedPeople.picURL} alt="" alt="">
                    </div>
                    <div class="col-lg-7">
                        <div class="personal_text">
                            <h3>${likedPeople.name}</h3>
                            <h4>Java Backend Developer</h4>
                            <div class="mini_container">
                                <ul class="list basic_info" style="padding-top: 15px; padding-bottom: 15px">
                                    <h5>Personal Information:</h5>
                                    <li><a><i class="lnr lnr-calendar-full"></i> ${likedPeople.age} years old</a></li>
                                    <li><a><i class="lnr lnr-envelope"></i> ${likedPeople.email}</a></li>
                                    <li><a><i class="lnr lnr-phone-handset"></i> (+994 51) 831 21 65</a></li>
                                    <li><a><i class="lnr lnr-home"></i> Baku, Azerbaijan</a></li>
                                </ul>
                            </div>

                            <ul class="list personal_social">
                                <div class="col-12">
                                    <button type="submit" name="like" value='true'
                                            class="btn btn-outline-success btn-block"><span
                                                class="fa fa-heart"></span> Like
                                    </button>
                                </div>
                                <br>
                                <div class="col-12" style="padding-bottom: 30px">
                                    <button type="submit" name="like" value='false'
                                            class="btn btn-outline-danger btn-block"><span
                                                class="fa fa-times"></span> Dislike
                                    </button>
                                </div>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <!--new one-->
            <div class="profile_inner p_0">
                <div class="row">
                    <div class="col-12 col-lg-6" style="padding-bottom: 30px">
                        <button type="button" class="btn btn-outline-warning btn-block"
                                onclick="window.location.href = '/chat/';"> My Messages
                        </button>
                    </div>
                    <div class="col-12 col-lg-6" style="padding-bottom: 30px">
                        <button type="button" class="btn btn-outline-warning btn-block"
                                onclick="window.location.href = '/list/';"> Liked Users
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
</body>
</html>