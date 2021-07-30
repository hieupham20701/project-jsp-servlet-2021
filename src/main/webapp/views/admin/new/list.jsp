
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file= "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
	<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row" >
                <div class="col-xs-12">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								 <table class="table table-bordered">
								    <thead>
								      <tr>
								        <th>Tên bài viết</th>
								        <th>Mô tả ngắn</th>
								      </tr>
								    </thead>
								    <tbody>
								    	<c:forEach var="a" items="${model.listResult}">
									      <tr>
									        <td>${a.title}</td>
									        <td>${a.shortDescription}</td>
									      </tr>
										</c:forEach>
								    </tbody>
								  </table>
<!-- 	 <ul class="pagination" id="pagination"></ul>-->
							</div>
						</div>
					</div>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->
<!-- <script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 10,
            visiblePages: 5,
			startPage: 1,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script> -->
</body>
</html>