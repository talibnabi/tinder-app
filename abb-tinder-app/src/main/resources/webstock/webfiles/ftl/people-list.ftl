<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/webstock/webfiles/images/logo.png">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="/webstock/webfiles/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/webstock/webfiles/css/styled.css">
</head>
<body>

<div class="logout">
    <div class="newrow">
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

<div class="container">
    <div class="row">
        <form method="post">
            <div class="col-8 offset-2">
                <div class="panel panel-default user_panel">
                    <div class="panel-heading">
                        <h3 class="panel-title"
                            style="text-align: center; font-size: 24px; -webkit-text-stroke: 1px #ffffff; color: #332e2e">
                            User List</h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-container">
                            <table class="table-users table" border="0">
                                <tbody>
                                <#list likedPeople as user>
                                    <tr>
                                        <td width="10">
                                            <div class="avatar-img">
                                                <img class="img-circle" style="width:550%;" src=${user.picURL}/>
                                            </div>
                                        </td>
                                        <td class="align-middle">
                                            ${user.name} ${user.surname}
                                        </td>
                                        <td class="align-middle" style="padding-left: 100px">
                                            ${user.age}
                                        </td>
                                        <td class="align-middle" style="padding-left: 100px">
                                            ${user.email}
                                        </td>
                                        <td class="align-middle" style="padding-left: 100px">
                                            <button type="submit" name="email" value='${user.email}'
                                                    class="btn btn-outline-warning btn-block">Chat
                                            </button>
                                        </td>
                                    </tr>

                                    <tr onclick="location.href='/chat/${user.getId()}'" class="bg-danger">
                                        <td>
                                            <div class="avatar-img">
                                                <img class="img-circle" src="${user.getName()}"/>
                                            </div>
                                        </td>
                                        <td class="align-middle">
                                            ${user.getUsername()}
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>