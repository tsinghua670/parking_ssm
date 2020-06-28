<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<!-- 页面端权限控制    authentication代表的是当前认证对象，可以获取当前认证对象信息，例 如用户名

					 	显示当前登录用户的名称-->
					<security:authentication property="principal.username"/>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>

			<security:authorize access="hasRole('ADMIN')">

			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/user/findAll.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/cars/findAll.do?page=1&pageSize=4">
						<i class="fa fa-circle-o"></i> 车辆管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/drivers/findAll.do?page=1&pageSize=4">
							<i class="fa fa-circle-o"></i> 驾驶员管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/notice/findAll.do?page=1&pageSize=4">
						<i class="fa fa-circle-o"></i> 公告管理
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 访问日志
					</a></li>
				</ul></li>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/seats/findAll.do?page=1&pageSize=4">
							<i class="fa fa-circle-o"></i> 车位管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/seats/findAllByNull.do?page=1&pageSize=4">
						<i class="fa fa-circle-o"></i> 登记使用车位
					</a></li>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 已登记信息管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/orders/findMoney.do"> <i
							class="fa fa-circle-o"></i> 收入统计
					</a></li>

				</ul></li>

			</security:authorize>


			<security:authorize access="hasRole('USER')">
			<!-- 普通用户使用页面 -->
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
				<span>基础功能</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/user/findUserByName.do">
						<i class="fa fa-circle-o"></i> 个人信息
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/seats/findAllByNull.do?page=1&pageSize=4">
						<i class="fa fa-circle-o"></i> 预定车位
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/orders/findordersByusername.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 已预定车位
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/notice/findAllNotice.do?page=1&pageSize=4"> <i
							class="fa fa-circle-o"></i> 公告
					</a></li>


				</ul></li>

			</security:authorize>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>