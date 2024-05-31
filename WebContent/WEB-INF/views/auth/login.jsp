<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
    <!--================================
            START LOGIN AREA
    =================================-->
    <script type="text/javascript">
    	window.onload = function(){
    		var result = '${result}';
    		var msg = '${msg}';
    		
    		
    		if(result != ''){ //0000은 정상
    		<!--	alert(msg); -->
    			alert(msg);
    			window.location.href = '/pf/auth/loginPage.do';//성공하든 실패하든 무조건 리다이랙트되야됨
    		}
    	}
    </script>
    <section class="login_area section--padding2">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <form action="/pf/auth/login.do" method = "post">
                        <div class="cardify login">
                            <div class="login--header">
                                <h3>Welcome Back</h3>
                                <p>You can sign in with your userid</p>
                            </div>
                            <!-- end .login_header -->

                            <div class="login--form">
                                <div class="form-group">
                                    <label for="user_name">Id</label>
                                    <input id="user_name" name="memberId" type="text" class="text_field" placeholder="Enter your userId...">
                                </div>

                                <div class="form-group">
                                    <label for="pass">Password</label>
                                    <input id="pass" type="text" name="passwd" class="text_field" placeholder="Enter your password...">
                                </div>

                                <div class="form-group">
                                    <div class="custom_checkbox">
                                        <input type="checkbox" id="ch2">
                                        <label for="ch2">
                                            <span class="shadow_checkbox"></span>
                                            <span class="label_text">Remember me</span>
                                        </label>
                                    </div>
                                </div>

                                <button class="btn btn--md btn--round" type="submit">Login Now</button>

                                <div class="login_assist">
                                    <p class="recover">Lost your
                                        <a href="<c:url value='/auth/recoverPassPage.do'/>">username</a> or
                                        <a href="<c:url value='/auth/recoverPassPage.do'/>">password</a>?</p>
                                    <p class="signup">Don't have an
                                        <a href="<c:url value='/auth/joinPage.do'/>">account</a>?</p>
                                </div>
                            </div>
                            <!-- end .login--form -->
                        </div>
                        <!-- end .cardify -->
                    </form>
                </div>
                <!-- end .col-md-6 -->
            </div>
            <!-- end .row -->
        </div>
        <!-- end .container -->
    </section>
    <!--================================
            END LOGIN AREA
    =================================-->
