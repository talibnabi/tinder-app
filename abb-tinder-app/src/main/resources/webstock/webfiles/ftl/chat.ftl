<!DOCTYPE html>
<html>
<head>
    <title>Chat</title>
    <link rel="stylesheet" href="/webstock/webfiles/chat_files/bootstrap.min.css">
    <script src="/webstock/webfiles/chat_files/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/webstock/webfiles/chat_files/jquery.mCustomScrollbar.min.css">
    <script type="text/javascript" src="/webstock/webfiles/chat_files/jquery.mCustomScrollbar.min.js"></script>
    <link rel="stylesheet" href="/webstock/webfiles/chat_files/style.css">
    <script type="text/javascript" src="/webstock/webfiles/chat_files/main.js"></script>
    <link rel="stylesheet" href="/webstock/webfiles/chat_files/all.css">

</head>

<body>

<div class="logout">
    <div class="newrow">
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/list/';"> Liked Users
            </button>
        </div>
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/like';"> Matching Page
            </button>
        </div>
        <div class="newcolumn">
            <button type="button" class="btn btn-outline-warning btn-block"
                    onclick="window.location.href = '/logout';"> Logout
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
                            <img src=${receiverPic.picURL} class="rounded-circle user_img">
                        </div>
                        <div class="user_info">
                            <span>Chat with ${receiverPic.name} </span>
                        </div>
                    </div>
                </div>
                <div class="card-body msg_card_body">
                    <#list messages as message>
                        <#if message.from == sender>
                            <div class="combinedSend">
                                <div class="msg_cotainer_send">
                                    ${message.content}
                                    <span class="msg_time_send" style="width: 100px; text-align: right">${message.dateString}</span>
                                </div>
                                <div class="img_cont_msg">
                                    <img src=${senderPic.picURL} class="rounded-circle user_img_msg">
                                </div>
                            </div>
                        <#else>
                            <div class="combinedReceive" style="margin-bottom:1.5rem">
                                <div class="img_cont_msg">
                                    <img src=${receiverPic.picURL} class="rounded-circle user_img_msg">
                                </div>
                                <div class="msg_cotainer">
                                    ${message.content}
                                    <span class="msg_time" style="width: 100px; text-align: left">${message.dateString}</span>
                                </div>
                            </div>
                        </#if>
                    </#list>
                </div>
                <div class="card-footer">
                    <div class="input-group">
                        <form method="post" style="width: 100%">
                            <input type="text" name="message" class="form-control type_msg" placeholder="Type your message..." autocomplete="off">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
