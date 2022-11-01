<!DOCTYPE html>
<html>
<head>
    <title>MESSAGES</title>
    <link rel="stylesheet" href="/template/webfiles/chat_files/bootstrap.min.css">
    <script src="/template/webfiles/chat_files/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/template/webfiles/chat_files/jquery.mCustomScrollbar.min.css">
    <script type="text/javascript" src="/template/webfiles/chat_files/jquery.mCustomScrollbar.min.js"></script>
    <link rel="stylesheet" href="/template/webfiles/chat_files/style.css">
    <script type="text/javascript" src="/template/webfiles/chat_files/main.js"></script>
    <link rel="stylesheet" href="/template/webfiles/chat_files/all.css">

</head>

<body>

<div class="logout">
    <div class="newrow">
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/list/';"> LIKED USERS
            </button>
        </div>
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/like';"> ESSENTIAL PAGE
            </button>
        </div>
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/logout';"> LOGOUT
            </button>
        </div>
    </div>
</div>

<div class="container-fluid h-100">
    <div class="row justify-content-center h-100">
        <div class="col-md-8 col-xl-6 chat">
            <div class="card">
                <div class="card-header msg_head">
                    <div class="d-flex bd-highlight combinedHeader">
                        <div class="img_cont">
                            <img src=${receiverPic.picURL} alt="photo" class="float-left">
                        </div>
                        <div class="user_info">
                            <span>CHAT WITH---> ${receiverPic.name}  ${receiverPic.surname} </span>
                        </div>
                    </div>
                </div>
                <div class="card-body msg_card_body">
                    <#list messages as message>
                        <#if message.from == sender>
                            <div class="combinedSend">
                                <div class="msg_cotainer_send">
                                    ${message.messageMaintenance}
                                </div>
                                <div class="img_cont_msg">
                                    <img src=${senderPic.picURL} alt="photo" class="float-left">
                                </div>
                            </div>
                        <#else>
                            <div class="combinedReceive" style="margin-bottom:1.5rem">
                                <div class="img_cont_msg">
                                    <img src=${receiverPic.picURL} alt="photo" class="float-left">
                                </div>
                                <div class="msg_cotainer">
                                    ${message.messageMaintenance}
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
                <div class="card-footer">
                    <div class="input-group">
                        <form method="post" style="width: 100%">
                            <input type="text" name="message" class="form-control type_msg"
                                   placeholder="Send your message..." autocomplete="off">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
