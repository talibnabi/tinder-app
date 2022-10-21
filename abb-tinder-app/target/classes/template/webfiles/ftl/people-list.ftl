<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/template/webfiles/images/logo.png">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <link href="/template/webfiles/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link rel="stylesheet" href="/template/webfiles/css/styled.css">
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
    <div class="row" >
        <form method="post">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title" style="text-align: center; font-size: 24px; -webkit-text-stroke: 1px lightblue; color: #000000">User List</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <tbody>
                            <#list likedPeople as person>
                            <tr>
                                <td width="10">
                                    <div class="avatar-img">
                                        <img class="img-circle" src=${person.picURL} />  
                                    </div>
                                </td>
                                <td class="align-middle">
                                    <small class="minitext">Full Name</small><br>
                                    <p class="normaltext">${person.name} ${person.surname}</p>
                                </td>
                                <td class="align-middle" style="padding-left: 100px">
                                    <small class="minitext">Age</small><br>
                                    <p class="normaltext">${person.age}</p>
                                </td>
                                <td  class="align-middle" style="padding-left: 100px">
                                    <small class="minitext">E-mail</small><br>
                                    <p class="normaltext">${person.email}</p>
                                </td>
                                <td  class="align-middle" style="padding-left: 100px">
                                <button type="submit" name="email" value='${person.email}' class="btn btn-outline-warning btn-block"
                                              > Chat
                                </button>
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