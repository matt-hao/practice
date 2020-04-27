<%--
  Created by IntelliJ IDEA.
  User: Mario
  Date: 2015/9/7
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <!--设置编码格式-->
    <meta charset="utf-8">

    <!--让ie浏览器运行最新的渲染模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <!-- 为了确保适当的绘制和触屏缩放,在移动设备浏览器上，通过为视口（viewport）设置 meta 属性为 user-scalable=no 可以禁用其缩放（zooming）功能 -->
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">

    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!-- 让部分国产浏览器默认采用高速模式渲染页面 -->
    <meta name="renderer" content="webkit">

    <title>注册</title>
    <!-- Bootstrap -->
    <link href="../../../bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-color: #3BB878">
<%@ include file="../common/topBar.jsp" %>
<div class="container">
    <div class="jumbotron text-center" style="background-color: #3BB878;color: #FFFFFF;margin-top: 12%">
        <h1>Join Us , You Are Welcome</h1>

        <p>we are superMarios</p>
    </div>

    <div class="col-md-7">
        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner " role="listbox">
                <div class="item active">
                    <img src="../../../image/slide1.jpg" alt="...">

                    <div class="carousel-caption">
                        we are superMario...
                    </div>
                </div>
                <div class="item">
                    <img src="../../../image/slide2.jpg" alt="...">

                    <div class="carousel-caption">
                        we love superMario...
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>

        </div>
    </div>

    <div class="col-md-4 col-md-offset-1">
        <!--form-->
        <form role="form" id="addUser" action="<%=basepath%>v/user/saveUser" method="post">

            <div class="alert alert-success" style="display: none;"></div>

            <div class="form-group form-group-lg">
                <input type="email" class="form-control" name="email" id="email" placeholder="请输入邮箱地址"/>
                <span class="tips"></span>
            </div>

            <div class="form-group form-group-lg">
                <input type="text" class="form-control" name="name" id="name" placeholder="请输入名字"/>
            </div>

            <div class="form-group form-group-lg">
                <input type="password" class="form-control" name="password" id="password" placeholder="输入密码"/>
            </div>

            <div class="form-group form-group-lg">
                <input type="password" class="form-control" name="comfirmPassword"
                       placeholder="确认密码"/>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-block btn-info">Submit</button>
            </div>

            <div class="form-group">
                <button type="button" class="btn btn-lg" aria-label="Left Align">
                    <span class="glyphicon glyphicon-object-align-right" aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-lg" aria-label="Left Align">
                    <span class="glyphicon glyphicon-apple" aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-lg" aria-label="Left Align">
                    <span class="glyphicon glyphicon-apple" aria-hidden="true"></span>
                </button>
            </div>
        </form>
        <!--form-->
    </div>
</div>
<%@include file="../common/footBar.jsp" %>
<script type="text/javascript" src="../../../bootstrap/js/bootstrapValidator.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#addUser')
                .bootstrapValidator({
                    message: 'This value is not valid',
                    //live: 'submitted',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    },
                    fields: {
                        email: {
                            validators: {
                                notEmpty: {
                                    message: '输入邮箱不能为空'
                                },
                                emailAddress: {
                                    message: '输入邮箱格式不正确'
                                },
                                remote: {
                                    url: '<%=basepath%>v/user/validateEmail',
                                    data: function (validator, $field, value) {
                                        return {
                                            email: validator.getFieldElements('email').val()
                                        };
                                    },
                                    valid: false,
                                    message: '该邮箱地址已存在',
                                    available: false
                                }
                            }
                        },
                        name: {
                            message: 'The username is not valid',
                            validators: {
                                notEmpty: {
                                    message: '输入姓名不能为空'
                                },
                                stringLength: {
                                    min: 1,
                                    max: 10,
                                    message: '姓名长度为1~10个字符之间'
                                },
                                remote: {
                                    url: '<%=basepath%>v/user/validateName',
                                    data: function (validator, $field, value) {
                                        return {
                                            email: validator.getFieldElements('name').val()
                                        };
                                    },
                                    valid: false,
                                    message: '该姓名已被注册',
                                    available: false
                                }
                                /*regexp: {
                                 regexp: '/^[a-zA-Z0-9_\.]+$/',
                                 message: 'The username can only consist of alphabetical, number, dot and underscore'
                                 }*/
                            }
                        },

                        password: {
                            validators: {
                                notEmpty: {
                                    message: '输入密码不能为空'
                                },
                                stringLength: {
                                    min: 6,
                                    max: 30,
                                    message: '密码长度需要在6~30个字符之间'
                                }
                            }
                        },
                        comfirmPassword: {
                            validators: {
                                notEmpty: {
                                    message: '确认密码不能为空'
                                },
                                identical: {
                                    field: 'password',
                                    message: '两次密码输入不一致'
                                }
                            }
                        }
                    }
                })
    });
</script>
</body>
</html>
