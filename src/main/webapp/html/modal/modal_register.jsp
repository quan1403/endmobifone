<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

<link rel="stylesheet" href="css/style.css">
<div class="modal-dialog" role="document">
    <div class="modal-content">
        <div class="modal-body">
            <div class="row">
                <div class="form offset-md-6 col-md-6">
                    <h3 class="color-theme with-line"><b>Mẫu đăng ký sử dụng dịch vụ</b></h3>
                    <p>Cảm ơn Quý khách đã quan tâm tới giải pháp của MobiFone!
                        </br></br>
                        Xin mời Quý khách điền thông tin theo mẫu dưới đây, chúng tôi sẽ liên hệ lại trong vòng 24
                        giờ.</p>
                    <%--                        <script data-b24-form="inline/20/eoeyn9" data-skip-moving="true">--%>
                    <%--              (function(w,d,u){var s=d.createElement('script');s.async=true;s.src=u+'?'+(Date.now()/180000|0);var h=d.getElementsByTagName('script')[0];h.parentNode.insertBefore(s,h);})(window,document,'https://sale.mobifone5.vn/upload/crm/form/loader_20_eoeyn9.js');--%>
                    <%--            </script>--%>
                    <div class="wrapper" style="background-image: url('images/bg-registration-form-1.jpg');">
                        <div class="inner">
                            <div class="image-holder">
                                <img src="images/registration-form-1.jpg" alt="">
                            </div>
                            <form name="myForm" action="/customer?action=register" method="post" >
                                <div class="form-group" >
                                    <label for="nameCompany">Tên Công ty <span style="color: red;" id="errorNameCompany">(*)</span></label>
                                    <input type="text" onblur="checkNameCompany();" name="nameCompany" class="form-control" id="nameCompany" />

                                </div>
                                <div class="form-group" >
                                    <label for="fullName">Họ và tên <span style="color: red;" id="errorFullName">(*)</span></label>
                                    <input type="text" onblur="checkFullName();" name="fullName" class="form-control" id="fullName" />

                                </div>
                                <div class="form-group" >
                                    <label for="phoneNumber">Phone <span style="color: red;" id="errorPhoneNumber">(*)</span></label>
                                    <input type="text" onblur="checkPhoneNumber();" name="phoneNumber" class="form-control" id="phoneNumber" />

                                </div>
<%--                                <div class="form-group">--%>
<%--                                   --%>
<%--                                </div>--%>
                                <div class="form-group" >
                                    <label for="email">Email <span style="color: red;" id="errorEmail">(*)</span></label>
                                    <input type="text" onblur="checkEmail();" name="email" class="form-control" id="email" />

                                </div>
                                <div class="form-group">

                                    <select   name="product" id="option-product" class="form-control">
                                        <option  value="" disabled selected>Sản phẩm quan tâm</option>
<%--                                        <option value="MobiFone Smart Sales">MobiFone Smart Sales</option>--%>
<%--                                        <option value="MobiFone Smart Office">MobiFone Smart Office</option>--%>
<%--                                        <option value="MobiFone Voice Brandname">MobiFone Voice Brandname</option>--%>
<%--                                        <option value="MobiFone SIP Trunk">MobiFone SIP Trunk</option>--%>
<%--                                        <option value="MobiFone eKYC">MobiFone eKYC</option>--%>
                                        <option  value= "MobiFone Invoice">MobiFone Invoice</option>
                                        <option  value="MobiFone Econtract">MobiFone Econtract</option>
                                        <option value="3C (Cloud Contact Center)">3C (Cloud Contact Center)</option>
                                        <option value="MobiCA">MobiCA</option>

<%--                                        <option value="mTracker">mTracker</option>--%>
<%--                                        <option value="Giải pháp quản lý thông tin Nguồn thông minh">Giải pháp quản lý thông tin Nguồn thông minh</option>--%>
<%--                                        <option value="AI Social Monitoring">AI Social Monitoring</option>--%>
<%--                                        <option value="Truyền thanh thông minh">Truyền thanh thông minh</option>--%>
<%--                                        <option value="Hệ thống quản lý tài liệu điện tử">Hệ thống quản lý tài liệu điện tử</option>--%>
<%--                                        <option value="Hệ thống Cổng thông tin điện tử">Hệ thống Cổng thông tin điện tử</option>--%>
<%--                                        <option value="Hệ thống cơ sở dữ liệu thông tin KT – XH">Hệ thống cơ sở dữ liệu thông tin KT – XH</option>--%>
<%--                                        <option value="Hệ thống Giám sát điện thoại viên">Hệ thống Giám sát điện thoại viên</option>--%>
<%--                                        <option value="Giải pháp phần mềm một cửa điện tử liên thông e-Gate">Giải pháp phần mềm một cửa điện tử liên thông e-Gate</option>--%>
<%--                                        <option value="MobiFone BMCC gateway">MobiFone BMCC gateway</option>--%>
<%--                                        <option value="MobiFone Smart Travel">MobiFone Smart Travel</option>--%>
<%--                                        <option value="MobiFone Spam Call Prevention">MobiFone Spam Call Prevention</option>--%>
<%--                                        <option value="mAI Call Center">mAI Call Center</option>--%>
<%--                                        <option value="MOBIFONE.AI – Trợ lý ảo">MOBIFONE.AI – Trợ lý ảo</option>--%>
<%--                                        <option value="AI Camera">AI Camera</option>--%>
<%--                                        <option value="AIOCR">AIOCR</option>--%>
<%--                                        <option value="Lưu trữ số hóa điện tử tập trung trên nền tảng Big Data">Lưu trữ số hóa điện tử tập trung trên nền tảng Big Data</option>--%>
<%--                                        <option value="Nền tảng tích hợp, chia sẻ dữ liệu cấp Bộ, cấp tỉnh">Nền tảng tích hợp, chia sẻ dữ liệu cấp Bộ, cấp tỉnh</option>--%>
<%--                                        <option value="Cổng dịch vụ công mức độ 3, 4">Cổng dịch vụ công mức độ 3, 4</option>--%>
<%--                                        <option value="Hệ thống Quản lý cán bộ công chức, viên chức">Hệ thống Quản lý cán bộ công chức, viên chức</option>--%>
                                    </select>

                                </div>
                                <tr>
                                    <td><button type="submit"  data-toggle="modal"  class="btn btn-success" >Đăng ký ngay</button></td>
                                   <td> <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button></td>
                            </form>
                        </div>
                    </div>
<%--                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">--%>
<%--                        Launch demo modal--%>
<%--                    </button>--%>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    ...
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary">Save changes</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
                    <script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');

                    </script>
                    <script defer
                            src="https://static.cloudflareinsights.com/beacon.min.js/vaafb692b2aea4879b33c060e79fe94621666317369993"
                            integrity="sha512-0ahDYl866UMhKuYcW078ScMalXqtFJggm7TmlUtp0UlD4eQk0Ixfnm5ykXKvGJNFjLMoortdseTfsRT8oCfgGA=="
                            data-cf-beacon='{"rayId":"78ad71bccde0045b","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2022.11.3","si":100}'
                            crossorigin="anonymous"></script>

                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
     function checkNameCompany(){
		 	var nameCompany = document.getElementById('nameCompany').value;
			var errorNameCompany = document.getElementById('errorNameCompany');
		var regexNameCompany= /^[A-Za-z0-9'\.\-\s\,]*$/;

		 	if (nameCompany == '' || nameCompany == null) {
				errorNameCompany.innerHTML = "Tên công ty không được để trống!";
		 	}else if(!regexNameCompany.test(nameCompany)){
				errorNameCompany.innerHTML = "Tên công ty không hợp lệ!";
		 	}else{
		 		errorNameCompany.innerHTML = '';
		 		return nameCompany;
			}
		 }


	function checkFullName(){
		 	var fullName= document.getElementById('fullName').value;
			var errorFullName = document.getElementById('errorFullName');
		    var regexFullName= /^[^\d+]*[\d+]{0}[^\d+]*$/;

		 	if (fullName == '' || fullName == null) {
				errorFullName.innerHTML = "Họ tên không được để trống!";
		 	}else if(!regexFullName.test(fullName)){
				errorFullName.innerHTML = "Họ tên không hợp lệ!";
		 	}else{
		 		errorFullName.innerHTML = '';
		 		return fullName;
			}
		 }

	function checkPhoneNumber(){
		 	var phoneNumber = document.getElementById('phoneNumber').value;
			var errorPhoneNumber = document.getElementById('errorPhoneNumber');
			var regexPhoneNumber = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;

		    if (phoneNumber == '' || phoneNumber == null) {
				errorPhoneNumber.innerHTML = "Số điện thoại không được để trống!";
			}else if(!regexPhoneNumber.test(phoneNumber)){
				errorPhoneNumber.innerHTML = "SĐT không hợp lệ!";
				return false;
			}else{
				errorPhoneNumber.innerHTML = '';
			}

		 }
    function checkEmail(){
	        var email = document.getElementById('email').value;
			var errorEmail = document.getElementById('errorEmail');
			var regexEmail = /[A-Z0-9._%+-]+@[A-Z0-9-]+.+.[A-Z]{2,4}/igm;

			if (email == '' || email == null) {
				errorEmail.innerHTML = "Email không được để trống!";
			}else if(!regexEmail.test(email)){
				errorEmail.innerHTML = "Email không hợp lệ!";
				email = '';
			}else{
				errorEmail.innerHTML = '';
			}


			}

</script>
<%--<script>--%>
<%--    function getCurrentURL() {--%>
<%--        return window.location.href--%>
<%--    }--%>
<%--    const url = getCurrentURL()--%>
<%--    let lastIndexDashUrl = url.lastIndexOf("/");--%>
<%--    let currentPage= url.slice(lastIndexDashUrl + 1, url.length);--%>

<%--    if (currentPage === "3c.jsp") {--%>
<%--        $("#product-option").val('3C (Cloud Contact Center)')--%>
<%--    }--%>
<%--    if(currentPage ==="mobica.jsp"){--%>
<%--      $("#product-option").val('MobiCA')--%>
<%--    }--%>
<%--    if(currentPage ==="mobifone-invoice.jsp")--%>
<%--        {--%>
<%--      $("#product-option").val('MobiFone Invoice')--%>
<%--    }--%>
<%--    if(currentPage ==="mobifone-econtract.jsp"){--%>
<%--      $("#product-option").val('MobiFone Econtract')--%>
<%--    }--%>


<%--</script>--%>
