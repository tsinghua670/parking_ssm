<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>数据 - AdminLTE2定制版</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">

    <!-- Tell the browser to be responsive to screen width -->
    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">


    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- 页面头部 /-->
    <!-- 导航侧栏 -->
    <jsp:include page="aside.jsp"></jsp:include>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">

        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                车位预订 <small>订单表单</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                        class="fa fa-dashboard"></i> 首页</a></li>
                <li><a
                        href="${pageContext.request.contextPath}/orders/findAll.do">订单生成</a></li>
                <li class="active">订单表单</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!--车位信息/--> <!--车辆信息-->
        <div class="panel panel-default">
            <div class="panel-heading">车位信息</div>
            <div class="row data-type">

                <div class="col-md-2 title">车位编号</div>
                <div class="col-md-4 data text">${seats.seatNum }</div>

                <div class="col-md-2 title">车位区域</div>
                <div class="col-md-4 data text">${seats.seatSection}</div>

                <div class="col-md-2 title">车位状态</div>
                <div class="col-md-4 data text">${seats.seatStateStr}</div>

                <div class="col-md-2 title">车位类型</div>
                <div class="col-md-4 data text">${seats.seatTag}</div>

                <div class="col-md-2 title">车位大小</div>
                <div class="col-md-4 data text">${seats.seatSizeStr}</div>

                <div class="col-md-2 title">车位价格/小时</div>
                <div class="col-md-4 data text">${seats.seatPrice}</div>

            </div>
        </div>

        <form action="${pageContext.request.contextPath}/orders/addOrders.do"
              method="post">

            <input type="hidden" name="seatId" value="${seats.id}">

            <!-- 正文区域 -->
            <section class="content"> <!--产品信息-->

                <div class="panel panel-default">
                    <div class="panel-heading">添加车辆信息</div>
                    <div class="row data-type">

                        <div class="col-md-2 title">车牌号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="carNum"
                                   placeholder="车牌号" value="">
                        </div>
                        <div class="col-md-2 title">车辆品牌</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="carBrand"
                                   placeholder="车辆品牌" value="">
                        </div>
                        <div class="col-md-2 title">车辆型号</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="carModel"
                                   placeholder="车辆型号" value="">
                        </div>
                        <div class="col-md-2 title">描述</div>
                        <div class="col-md-4 data">
                            <input type="text" class="form-control" name="desces"
                                   placeholder="描述" value="">
                        </div>

                    </div>
                </div>
                <!--订单信息/--> <!--工具栏-->
                <!-- 正文区域 -->
                <section class="content"> <!--驾驶员信息-->

                    <div class="panel panel-default">
                        <div class="panel-heading">添加驾驶员信息</div>
                        <div class="row data-type">

                            <div class="col-md-2 title">姓名</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="driverName"
                                       placeholder="姓名" value="">
                            </div>
                            <div class="col-md-2 title">身份证号</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="idCard"
                                       placeholder="身份证号" value="">
                            </div>
                            <div class="col-md-2 title">性别</div>
                            <div class="col-md-4 data">
                                <select class="form-control select2" style="width: 100%"
                                        name="sex">
                                    <option value="0" selected="selected">女</option>
                                    <option value="1">男</option>
                                </select>
                            </div>
                            <div class="col-md-2 title">电话号码</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="phoneNum"
                                       placeholder="电话号码" value="">
                            </div>
                            <div class="col-md-2 title">描述</div>
                            <div class="col-md-4 data">
                                <input type="text" class="form-control" name="desces"
                                       placeholder="描述" value="">
                            </div>

                        </div>
                    </div>
                    <!--驾驶员信息/-->

                    <section class="content"> <!--订单信息-->
                        <div class="panel panel-default">
                            <div class="panel-heading">添加订单信息（目前仅支持其他支付方式，即现场支付）</div>
                            <div class="row data-type">

                                <div class="col-md-2 title">出库时间</div>
                                <div class="col-md-4 data">
                                    <div class="input-group date">
                                        <div class="input-group-addon">
                                            <i class="fa fa-calendar"></i>
                                        </div>
                                        <input type="text" class="form-control pull-right" id="dateTimePicker" name="outTime">
                                    </div>
                                </div>

                                <div class="col-md-2 title">支付方式</div>
                                <div class="col-md-4 data text">
                                    <select class="form-control" style="width: 100%" name="payType">
                                        <option value="0">支付宝</option>
                                        <option value="1">微信</option>
                                        <option value="2" selected>其它</option>
                                    </select>
                                </div>


                                <div class="col-md-2 title rowHeight2x">其他信息</div>
                                <div class="col-md-10 data rowHeight2x">
						<textarea class="form-control" rows="3" placeholder="其他信息" name="desces">
                            ${orders.desces}
                        </textarea>
                                </div>

                            </div>
                        </div>
                        <!--订单信息/-->


                    <div class="box-tools text-center">
                    <button type="submit" class="btn bg-maroon">提交预订</button>
                    <button type="button" class="btn bg-default"
                            onclick="history.back(-1);">返回</button>
                </div>
                <!--工具栏/--> </section>
            <!-- 正文区域 /-->
        </form>
    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a
                href="http://www.itcast.cn">研究院研发部</a>.
        </strong> All rights reserved. </footer>
    <!-- 底部导航 /-->

</div>


<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<script>
    $(document).ready(function() {

        // datetime picker
        $('#dateTimePicker').datetimepicker({
            format: "yyyy-mm-dd  hh:ii:ss",
            autoclose: true,
            todayBtn: true,
            language: 'zh-CN'
        });

        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale : 'zh-CN'
        });
    });

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }
</script>


</body>

</html>