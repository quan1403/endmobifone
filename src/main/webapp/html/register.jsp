<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="../html/css/register.css">
<script src="../html/js/register.js"></script>
<!------ Include the above in your HEAD tag ---------->

<form action="/Register"  method="post" >
    <div class="container-fluid">
        <div class="row">
            <div class="well center-block">
                <div class="well-header">
                    <h3 class="text-center text-success"> Register Here! </h3>
                    <hr>
                </div>


                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </div>
                                <input type="text" placeholder="Full Name" name="fullName" class="form-control">

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-12 col-md-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </div>
                                <input type="text" placeholder="UserName" name="userName" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </div>
                                <input type="password" minlength="8" maxlength="20" placeholder="Password" name="passWord" class="form-control">
                            </div>
                        </div>
                    </div>
                </div>


                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="glyphicon glyphicon-lock"></i>
                                    </div>
                                    <input type="password" minlength="8" maxlength="20" placeholder="confirm password" name="repassWord" class="form-control">
                                </div>
                            </div>
                        </div>
                    </div>

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-phone"></i>
                                </div>
                                <input type="number" minlength="10" maxlength="12" class="form-control" name="phoneNumber" placeholder="Mobile No.">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                </div>
                                <input type="email" class="form-control" name="email" placeholder="E-Mail">
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <div class="form-group">
                            <div class="input-group">
                                <div class="input-group-addon">
                                    <i class="glyphicon glyphicon-envelope"></i>
                                </div>
                                <input type="text" class="form-control" name="role" value="user">
                            </div>
                        </div>
                    </div>
                </div>

<%--                <div class="row">--%>
<%--                    <div class="col-md-12 col-xs-12 col-sm-12">--%>
<%--                        <div class="form-group">--%>
<%--                            <div class="input-group">--%>
<%--                                <div class="input-group-addon">--%>
<%--                                    <i class="glyphicon glyphicon-list-alt"></i>--%>
<%--                                </div>--%>
<%--                                <textarea class="form-control" name="txtadd" placeholder="Address"></textarea>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row">--%>
<%--                    <div class="col-md-12 col-xs-12 col-sm-12">--%>
<%--                        <div class="form-group">--%>
<%--                            <div class="input-group">--%>
<%--                                <div class="input-group-addon">--%>
<%--                                    <i class="glyphicon glyphicon-calendar"></i>--%>
<%--                                </div>--%>
<%--                                <input type="date" name="dob" placeholder="Date Of Birth" class="form-control" id="datepicker">--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <div class="row widget">
                    <div class="col-md-12 col-xs-12 col-sm-12">
                        <button class="btn btn-warning btn-block"> Submit </button>
                    </div>
                </div>



            </div>
        </div>
    </div>



</form>
